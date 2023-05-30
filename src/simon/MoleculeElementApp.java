/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simon;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author martin.simon
 */
public class MoleculeElementApp {
    public static Scanner sc = new Scanner(System.in);
    //JV rozdelit na metody
    public static void main(String[] args) throws IOException {
        PeriodicTable tabulka = new PeriodicTable();
        boolean end = false;
        String command;
        
        //loading file
        try{
            tabulka.loadFromFile();
        }catch(Exception e){
            e.printStackTrace(); //debug
            System.err.println("Nepodařilo se načíst soubor");
        }
        
        while(!end){
            MoleculeSame molekuly = new MoleculeSame();
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
                    nalezeno = true;
                    if(parts.length == 1){
                        //pro jeden parametr např. H
                        molekuly.addElement(temp);
                    }else{
                        //pro 2 parametry např. H 2
                        molekuly.addElements(temp,Integer.parseInt(parts[1]));
                    }
                }
                if(!nalezeno){
                    System.out.println("Prvek nebyl nalezen");
                }else{
                    System.out.println("Relativní atomová hmotnost zadané sloučeniny je: "+molekuly.getWeight());
                }
            }
        }
        System.out.println("Zadejte název výstupního binárního souboru: ");
        File file;
        String bin_nazev = sc.next();
        if(){//pokud soubor existuje
            System.out.println("Soubor již existuje. Chcete jej přepsat? \n"+"a/n");
            String decission = sc.next();
            switch(decission){
                case "a" -> file = new File("./data/"+bin_nazev+".dat");
                case "n" -> file = new File("./data/"+bin_nazev+"_copy.dat");
                default -> System.out.println("Zadal jste něco špatně, soubor nebude uložen");
            }
        }
        
        
    }
    
}
