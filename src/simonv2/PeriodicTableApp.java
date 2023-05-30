package simonv2;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author martin.simon
 */
public class PeriodicTableApp {
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException{
        PeriodicTable tabulka = new PeriodicTable();
        
        //loading file
        try{
            tabulka.loadFromFile();
        }catch(Exception e){
            e.printStackTrace(); //debug
            System.err.println("Nepodařilo se načíst soubor");
        }
        
        tabulka.getTop10();
        int yearNow = LocaleDateTime.now().getYear();
        Element oldest = tabulka.getOldest();
        
        System.out.println("Nejstarší prvek "+oldest.getNazev()+" a byl nalezen před: "+(yearNow-oldest.getRokObjeveni()));
        
        
        
        
        
        
        
        
    }
}
