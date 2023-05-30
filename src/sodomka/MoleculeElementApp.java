/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sodomka;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jan.sodomka
 */
public class MoleculeElementApp {

    /**
     * @param args the command line arguments
     */
    public static Scanner sc = new Scanner(System.in);
    //JV rozdelte main do metod
    public static void main(String[] args) {
        // TODO code application logic here

        PeriodicTable table = new PeriodicTable();
        ArrayList<Element> pTable = table.PeriodicTable();
        table.loadElements("data\\prvky.csv");
        String input;
        int chosen=0;
        double weight;
        String[] splited;
        String vypis="";
        String element;
        Element element1 = new Element("X", "X", 0, 0);
        int numberOfEl;
        int numberOfMol=0;
        boolean condition = true;

        while (condition) {
            input = sc.nextLine();
            if (input.equals("konec")) {
                System.out.println("Končím...");
                condition = false;
            //JV nasleduje hodne se opakujici kod, dát mimo if
            } else if (input.contains(" ")) {
                splited = input.split(" ");
                element = splited[0];
                numberOfEl = Integer.parseInt(splited[1]);
                for (Element elements : pTable) {
                    if (elements.getSymbol().equals(element)) {
                        element1 = elements;
                    }
                }
                MoleculeSame mol = new MoleculeSame(element1, numberOfEl);
                weight = mol.getWeight();
                System.out.println(weight);
                numberOfMol++;
                vypis = vypis + element1 + numberOfEl + weight;
            } else {
                for (Element elements : pTable) {
                    if (elements.getSymbol().equals(input)) {
                        element1 = elements;
                    }
                }
                weight = element1.getWeight();
                System.out.println(weight);
                numberOfMol++;
                vypis = vypis + element1 + weight;
            }
        }

        System.out.println("Zadejte název výstupního bin souboru:");
        String fileName = sc.nextLine();
        String[] fileNameSplited = fileName.split("\\.");
        File file = new File(fileName);
        if (file.exists()) {
            System.out.println("Soubor již existuje, chcete ho přepsat (zadejte 1) nebo vytvořit doplněnou kopii (zadejte 2)?");
            boolean condition1 = false;
            while (!condition1) {
                if (!sc.hasNextInt()) {
                    System.out.println("Zadejte celé číslo");
                } else {
                    chosen = sc.nextInt();
                    if (chosen != 1 && chosen != 2) {
                        System.out.println("Zadejte číslo 1 nebo 2");
                    } else {
                        condition1 = true;
                    }
                }
            }
        } 
        if(chosen == 2) {
            file = new File(fileNameSplited[0]+"_copy"+fileNameSplited[1]);
        try {
            file.createNewFile();
            } catch (IOException ex) {
                System.out.println("Chyba při tvoření souboru");;
            }
        }
        else if(chosen!=1){
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println("Chyba při tvoření souboru");;
            }
        }
        
        try (DataOutputStream dis = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))){
        dis.writeInt(chosen);
        dis.writeUTF(vypis);
        } catch (FileNotFoundException ex) {
            System.out.println("Soubor nenalezen");
        } catch (IOException ex) {
            System.out.println("Chyba při zápisu");
        }

    }

}
