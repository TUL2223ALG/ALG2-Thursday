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
public class ZaznamyEdit {

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
            // neprovadet volby 2 a dalsi v pripade, ze souborZaznamu == null
            switch (volba) {
                case 0:
                    konecProgramu = true;
                    break;
                case 1:
                    zadaniJmenaSouboru();
                    break;
                case 2:
                    pridaniZaznamu();
                    break;
                case 3:
                    vypisVsechZaznamu();
                    break;
                case 4:
                    odstraneniZaznamu();
                    break;
                case 5:
                    zmenaDatZaznamu();
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
            System.out.println("4. Odstraneni zaznamu ");
            System.out.println("5. Zmena dat zaznamu");
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

    private static void zadaniJmenaSouboru() throws IOException {
        System.out.println("");
        System.out.print("Zadej jmeno souboru: ");
        String jm = sc.nextLine();
        // testovani existence cesty k souboru apod., pokud cesta existuje
        File cestaKSouboru = new File(jm).getCanonicalFile();
        try {
            if (cestaKSouboru.isFile()) {
                souborDat = cestaKSouboru;
                System.out.println("Soubor existuje");
            } else if (cestaKSouboru.getParentFile().isDirectory()) {
                cestaKSouboru.createNewFile();
                souborDat = cestaKSouboru;
                System.out.println("Vytvoren novy prazdny soubor");
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
        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(souborDat, true)))) {
            //try (RandomAccessFile dos = new RandomAccessFile(souborZaznamu, "rw")) {
            data.saveToFile(dos);
        }
    }

    private static void vypisVsechZaznamu() throws IOException {
        System.out.println("");
        System.out.println("V souboru jsou tato data");
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(new FileInputStream(souborDat)))) {
            //try (RandomAccessFile dis = new RandomAccessFile(souborZaznamu, "r")) {
            boolean konecSouboru = false;
            int poradi = 1;
            while (!konecSouboru) {
                try {
                    Zaznam data = Zaznam.loadFromFile(dis);;
                    System.out.format("%3d.  %s%n", poradi++, data);
                } catch (EOFException ex) {
                    konecSouboru = true;
                }
            }
        }
    }

    private static void odstraneniZaznamu() throws IOException {
        System.out.println("");
        System.out.println("Odstraneni zaznamu");
        System.out.print("Zadej poradi zaznamu");
        int poradi = sc.nextInt();
        // otevrit pro cteni i zapis
        try (RandomAccessFile raf = new RandomAccessFile(souborDat, "rw")) {
            raf.seek(raf.length() - Zaznam.DELKA_ZAZNAMU);
            Zaznam z = Zaznam.loadFromFile(raf);
            raf.seek((poradi - 1) * Zaznam.DELKA_ZAZNAMU);
            z.saveToFile(raf);
            raf.setLength(raf.length() - Zaznam.DELKA_ZAZNAMU);
        }
        
    }

    private static void zmenaDatZaznamu() throws IOException {
        System.out.println("");
        System.out.println("Zmena hodnoty prirazene ke konkretnimu id");
        System.out.print("Zadej id zaznamu: ");
        short id = sc.nextShort();
        
        // predpokladame unikatni id - prvni vyskyt
        try (RandomAccessFile raf = new RandomAccessFile(souborDat, "rw")) {
            boolean konec = false;
            while (!konec) {
               try {
                   Zaznam z = Zaznam.loadFromFile(raf);
                   if (z.getId() == id) {
                       System.out.println("Puvodni hodnota " + z.getValue());
                       System.out.print("zadej nova data ");
                       float data = sc.nextFloat();
                       System.out.println(z);
                       z.setValue(data);
                       System.out.println(z);
                       raf.seek(raf.getFilePointer() - Zaznam.DELKA_ZAZNAMU);
                       z.saveToFile(raf);
                       break;
                   }
               } catch (EOFException ex) {
                   konec = true;
               }
               
            }
        }
        
    }

}
