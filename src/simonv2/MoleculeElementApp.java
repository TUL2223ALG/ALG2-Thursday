package simonv2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author martin.simon
 */
public class MoleculeElementApp {
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
        PeriodicTable tabulka = new PeriodicTable();
        boolean end = false;
        String command;
        ArrayList<MoleculeSame> molekuly = new ArrayList<MoleculeSame>();
        
        //loading file
        try{
            tabulka.loadFromFile();
        }catch(Exception e){
            e.printStackTrace(); //debug
            System.err.println("Nepodařilo se načíst soubor");
        }
        
        while(!end){
            command = sc.next();
            String[] parts = command.split(" ");
            if(parts[0].equals("konec")){
                end = true;
                break;
            }
            for(int i = 0; i<tabulka.getSize();i++){
                Element temp = tabulka.getElement(i);
                boolean nalezeno = false;
                if(parts[0].equals(temp.getSymbol())){
                    MoleculeSame temp_mol = new MoleculeSame();
                    nalezeno = true;
                    if(parts.length == 1){
                        //pro jeden parametr např. H
                        temp_mol.addElement(temp);
                    }else{
                        //pro 2 parametry např. H 2
                        temp_mol.addElements(temp,Integer.parseInt(parts[1]));
                    }
                    molekuly.add(temp_mol);
                }
                if(!nalezeno){
                    System.out.println("Prvek nebyl nalezen");
                }else{
                    System.out.println("Relativní atomová hmotnost zadané sloučeniny je: "+temp_mol.getWeight());
                }
                
            }
        }
        save(molekuly);
    }
    
    public static void save(ArrayList<MoleculeSame> molekuly){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Zadejte název výstupního binárního souboru: ");
        String filename = scanner.nextLine();

        File outputFile = new File("./data/"+filename);
        if (outputFile.exists()) {
            System.out.print("Soubor již existuje. Chcete ho přepsat? (ano/ne): ");
            String overwrite = scanner.nextLine();
            if (overwrite.equalsIgnoreCase("ne")) {
                outputFile = new File("./data/"+filename+"_copy");
            }
        }
        System.out.println("Vytvářím soubor:"+outputFile);
         

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            
            objectOutputStream.writeObject(molekuly);
            
            objectOutputStream.close();
            fileOutputStream.close();
            
            System.out.println("Binární soubor " + filename + " byl úspěšně vytvořen.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
