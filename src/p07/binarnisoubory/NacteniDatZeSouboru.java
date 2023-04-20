/*
 * Copyright (C) 2022 Jirina
 * This program is part of Java programing education. 
 * You can use it as you need to learn Java. 
 */
package alg2.p07.binarnisoubory;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Jirina
 */
public class NacteniDatZeSouboru {
//    51 92 89 
//  -41.42416500933663 26.216892941780443 
//    
//    Cela cisla nactena ze souboru 
//[51, 92, 89]
//Realna cisla nactena ze souboru 
//  dalsi cislo  -41.42416500933663
//  dalsi cislo  26.216892941780443

    private static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("Zadej jmeno souboru");
        String jmSoub = sc.nextLine();

        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(jmSoub)))) {
            // na zacatku souboru bude urcity pocet dvoubajtovych celych cisel 
            int pocetShort = dis.readInt();
            short[] cisla = new short[pocetShort];
            for (int i = 0; i < pocetShort; i++) {
                cisla[i] = dis.readShort();
            }
            System.out.println("Cela cisla nactena ze souboru ");
            System.out.println(Arrays.toString(cisla));
            
            System.out.println("Realna cisla nactena ze souboru ");
            boolean konecSouboru = false;
            while (!konecSouboru) {
                try {
                    double cislo = dis.readDouble();
                    System.out.println("  dalsi cislo  " + cislo);
                } catch (EOFException ex) {
                    konecSouboru = true;
                }
            }
        }
    }
}
