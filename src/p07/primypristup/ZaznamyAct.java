/*
 * Copyright (C) 2022 Jirina
 * This program is part of Java programing education. 
 * You can use it as you need to learn Java. 
 */
package jk.p145.primypristup;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Jirina
 */
public class ZaznamyAct {

    private static File souborDat = null;
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Collection a;
        Set s;
        int volba;
        boolean konecProgramu = false;

        do {
            vypisMenu();
            volba = nacteniVolby();
            // kontextove menu
            // neprovadet volby 2 a dalsi v pripade, ze souborZaznamu == null
            switch (volba) {
                case 0:
                    konecProgramu = true;
                    break;
                case 1:
                    zadaniJmenoSouboru();
                    break;
                case 2:
                    pridaniZaznamu();
                    break;
                case 3:
                    vypisVsechZaznamu();
                    break;
                default:
                    System.out.println("Chybne zadana volba");
            }
        } while (!konecProgramu);
    }

    /**
     * Kontextove menu
     */
    private static void vypisMenu() {
        System.out.println("");
        System.out.println("1. Zadani souboru");
        if (souborDat != null) {
            System.out.println("2. Pridani zaznamu");
            // pokud soubor existuje
            System.out.println("3. Vypis zaznamu");
        }
        System.out.println("0. Konec programu");

    }

    private static int nacteniVolby() {
        int volba = -1;
        System.out.print("Zadej zvolenou polozku menu: ");
        try {
            volba = sc.nextInt();
        } catch (InputMismatchException e) {
            // neplatna volba
            volba = -1;
        } finally {
            sc.nextLine();
        }
        return volba;
    }

    private static void zadaniJmenoSouboru() throws IOException {
        System.out.println("");
        System.out.print("Zadej jmeno souboru: ");
        String jm = sc.nextLine();
        // testovani existence cesty k souboru apod., pokud cesta existuje
        File cestaKSouboru = new File(jm).getCanonicalFile();
        try {
            if (cestaKSouboru.isFile()) {
                souborDat = cestaKSouboru;
                System.out.println("Zadany soubor existuje");
            } else if (cestaKSouboru.getParentFile().isDirectory()) {
                cestaKSouboru.createNewFile();
                souborDat = cestaKSouboru;
                System.out.println("Vytvoren novy soubor");
            }
        } finally {
            if (souborDat == null) {
                System.out.println("Soubor neexistuje, nebylo mozne jej vytvorit");
                System.out.println("Cesta neexistuje, nebo neni mozne zapisovat do adresare apod.");
            }
        }
    }

    private static void pridaniZaznamu() throws IOException {
        System.out.println("");
        System.out.println("Pridani jednoho zaznamu do souboru");
        System.out.print("Zadej id a value: ");
        Zaznam data = new Zaznam(sc.nextShort(), sc.nextFloat());

    }

    private static void vypisVsechZaznamu() throws IOException {
        System.out.println("");
        System.out.println("V souboru jsou tato data");

    }

}
