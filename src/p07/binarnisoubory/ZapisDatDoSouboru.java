/*
 * Copyright (C) 2022 Jirina
 * This program is part of Java programing education. 
 * You can use it as you need to learn Java. 
 */
package alg2.p07.binarnisoubory;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author Jirina
 */
public class ZapisDatDoSouboru {

    private static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("Zadej jmeno souboru");
        String jmSoub = sc.nextLine();
        // zapis nekolika hodnot typu short a pak double
        int pocetShort = 3;
        int pocetDouble = 2;
        try (DataOutputStream dos = new DataOutputStream (
                new BufferedOutputStream(new FileOutputStream(jmSoub, true))) ) {
            // na zacatku souboru bude urcity pocet dvoubajtovych celych cisel 
            dos.writeInt(pocetShort);
            for (int i = 0; i < pocetShort; i++) {
                short cislo = (short) (Math.random() * 100 + 1);
                System.out.print(cislo + " ");
                dos.writeShort(cislo);
            }
            System.out.println("");
            // dale az do konce souboru budou realna cisla ve formatu typu double
            for (int i = 0; i < pocetDouble; i++) {
                double cislo = Math.random() * 200. - 100.;
                System.out.print(cislo + " ");
                dos.writeDouble(cislo);
            }
        }
        System.out.println("");
        System.out.println("");
        sc.nextLine();
        
    }

}
