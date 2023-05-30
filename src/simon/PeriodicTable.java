package simon;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
/**
 *
 * @author martin.simon
 */
public class PeriodicTable implements Years<PeriodicTable>{ //JV na compareTo si nevytvarejte vlastni rozhrani, to existujici metody (napr. Collections.sort) neznaji 
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
    
    
    public void loadFromFile() throws IOException{
        File file = new File("./data/prvky.csv"); //JV me by to byt vstupni parameter
        boolean end=false;
        
        //nevzpomenu si jak udělat BufferedReader
        BufferedReader br = new BufferedReader();
        while(!end){
            
            String line = br.readLine(); //načítání dalšího řádku ze ouboru
            
            
            //logika pro načítní ze souboru
            String[] parts = line.split(",");
            if(parts.length==5){
                Element temp = new Element(parts[0], parts[2], Integer.parseInt(parts[1]),Double.parseDouble(parts[3]));
                tabulka.add(temp);
            }else if(parts.length==6){
                Element temp = new Element(parts[0], parts[2], Integer.parseInt(parts[1]),Double.parseDouble(parts[3]), Integer.parseInt(parts[4]));
                tabulka.add(temp);
            }
        }
    }//TODO načítání
    
    
    public int getOldest(){
        LocalDateTime date = new LocaleDateTime(now);
        int oldest = date.getYear();
        for(Element temp : tabulka){
            if(temp.getRokObjeveni()<oldest && temp.getRokObjeveni() != -1){
                oldest = temp.getRokObjeveni();
            }
        }
        return oldest; //JV melo vratit najstarsi prvek, ne jenom rok
    }
    
    public void getTop10(){
        tabulka.sort(Years);
        for (int i = 0; i<10;i++){
            Element temp = tabulka.get(i);
            System.out.println(i+1+". "+temp.toString());
        }
    }
}
