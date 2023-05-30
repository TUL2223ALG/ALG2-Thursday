/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rychly;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author tomas.rychly
 */
public class MoleculeElementApp {
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
        String input = null;
        PeriodicTableApp table = new PeriodicTableApp();
        
        
        System.out.println("zadejete pouze nazev vystupniho sobuoru");
        System.out.println("format");
        String name = sc.nextLine();
        File file = new File("./Data" + name + ".dat");
        if (file.exists()) {
            System.out.println("soubor jiz existuje chcete ho prepsat ?");
            System.out.println("1 > ano | 2 > ne");
            int answer = sc.nextInt();
            if (answer == 1) {
                 
                 System.out.println("soubor prepsan");
            }else if (answer == 2) {
                name = name + "_copy.dat";
                File f = new File("./Data" + name);
                f.createNewFile();
            }
        
        }
        
        while(!input.equals("konec")){
            System.out.println("vytvor prvek");
            input = sc.nextLine();
            String[] val = input.split(" ");
            String symbol = val[0];
            int amount = Integer.parseInt(val[1]);
            if (val[1] == null && table.jePrvek(symbol)) {
               Element el = table.najitPrvek(symbol);
                System.out.println(el.getWeight());
            }else{
               Element el = table.najitPrvek(symbol);
               MoleculeSame mo = new MoleculeSame(el,amount);
               System.out.println(mo.getWeight());
            }
        }
        
        
        
    }
}
