package simon;

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
            System.err.println("Nepodařilo se načíst soubor"); //JV nepodarilo se nacist, ale pokracujete v hledani TOP10
        }
        
        tabulka.getTop10();
        
        
        
        
        
        
    }
}
