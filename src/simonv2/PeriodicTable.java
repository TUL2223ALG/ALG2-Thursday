package simonv2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
/**
 *
 * @author martin.simon
 */
public class PeriodicTable{
    private ArrayList<Element> tabulka;
    
    public PeriodicTable(){
        this.tabulka = new ArrayList<>();
    }
    public void addElement(String prikaz){
        Element temp = new Element(prikaz);
        addElement(temp);
    }
    public void addElement(String nazev, String symbol, int protCislo, double relHmot){
        Element temp = new Element(nazev,symbol,protCislo,relHmot);
        addElement(temp);
    }
     public void addElement(String nazev, String symbol, int protCislo, double relHmot,int rok){
        Element temp = new Element(nazev,symbol,protCislo,relHmot,rok);
        addElement(temp);
    }
     public void addElement(Element a){
        tabulka.add(a);
     }
    public int getSize(){
        return tabulka.size();
    }
    public Element getElement(int i){
        return tabulka.get(i);
    }
    
    public void setRok(String nazev, int rok){
        for(int i = 0; i<tabulka.size();i++){
            Element temp = tabulka.get(i);
            if(temp.getNazev().equals(nazev)){
                temp.setRokObjeveni(rok);
                tabulka.set(i,temp);
            }
        }
    }
    
    
    public void loadFromFile() throws IOException{
        boolean end=false;
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("./data/prvky.csv"))) {
            // Ignorujeme první řádek s hlavičkou
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
            if(parts.length==5){
                Element temp = new Element(parts[0], parts[2], Integer.parseInt(parts[1]),Double.parseDouble(parts[3]));
                tabulka.add(temp);
                //JV v prvky.csv nebyl rok objeveni a bylo tam víc hodnot
            }else if(parts.length==6){
                Element temp = new Element(parts[0], parts[2], Integer.parseInt(parts[1]),Double.parseDouble(parts[3]), Integer.parseInt(parts[4]));
                tabulka.add(temp);
            }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
        
    public void loadFromTxt() throws IOException{
        File soubor = new File("./data/rokObjeveni.txt");
        try {
            Scanner scanner = new Scanner(soubor);
            while (scanner.hasNextLine()) {
                String radek = scanner.nextLine();
                String[] parts = radek.split(" ");

                if (parts.length == 4) {
                    String nazev = parts[0];
                    int rok = Integer.parseInt(parts[3]);
                    setRok(nazev,rok);
                }
            }
            scanner.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    
    public Element getOldest(){
        int oldest = LocaleDateTime.now().getYear();//mělo by fungovat
        Element result;
        for(Element temp : tabulka){
            if(temp.getRokObjeveni()<oldest && temp.getRokObjeveni() != -1){
                oldest = temp.getRokObjeveni();
                result = temp;
            }
        }
        return result;
    }
    //idk
    public void getTop10(){
        //Collections.sort(tabulka, Comparator.comparingDouble(Element::getWeight()));
        for (int i = 0; i<10;i++){
            Element temp = tabulka.get(i);
            System.out.println(i+1+". "+temp.toString());
        }
    }
}
