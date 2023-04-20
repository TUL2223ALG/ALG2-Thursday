/*
 * Copyright (C) 2023 Jirina Kralovcova
 * This program is part of Java programing education. 
 * You can use it as you need to learn Java. 
 */
package alg2.p07.osoby.apps;

import alg2.p07.osoby.dat.OsobaFixLength;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Jirina
 */
public class OsobySouborPrimy {

    private static final Scanner sc = new Scanner(System.in);
    private static File file = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        boolean konecProgramu;
        do {
            vypisMenu();
            int volba = nactiVolbu();
            try {
                konecProgramu = obsluzVolbu(volba);
            } catch (UnsupportedOperationException ex) {
                System.out.println("Pozadovana operace neni doposud implementovana");
                konecProgramu = false;
            }
        } while (!konecProgramu);
        System.out.println("Koncim ...");
    }

    private static void vypisMenu() {
        System.out.println("");
        System.out.println("Hlavni menu programu");
        System.out.println("1. Vybrat/zadat soubor");
        System.out.println("2. Zadat/pridat data dalsi osoby");
        System.out.println("3. Vypsat data osob");
        System.out.println("4. Odstranit zaznam/data osoby");
        System.out.println("5. Editovat zaznam/data osoby");
        System.out.println("0. Konec programu");
    }

    private static int nactiVolbu() {
        int volba;
        try {
            volba = sc.nextInt();
        } catch (InputMismatchException ex) {
            volba = -1;
        } finally {
            sc.nextLine();
        }
        return volba;
    }

    private static boolean obsluzVolbu(int volba) throws IOException {
        switch (volba) {
            case 0:
                return true;
            case 1:
                vyberSouboru();
                break;
            case 2:
                pridatOsobu();
                break;
            case 3:
                vypsatOsoby();
                break;
            case 4:
                odstranitDataOsoby();
                break;
            case 5:
                upravitDataOsoby();
                break;
            default:
                System.out.println("Neznama volba");
        }
        return false;
    }

    private static void vyberSouboru() throws IOException {
        System.out.println("");
        System.out.println("Vyber souboru");
        System.out.println("Zadej cestu k souboru");
        String jmSoub = sc.nextLine();
        File f = new File(jmSoub);
        f = f.getAbsoluteFile().getCanonicalFile();
        file = f;
        if (!f.isFile()) {
            try (FileOutputStream fos = new FileOutputStream(f)) {
                // pouhe f.createNewFile() nefunguje spravne v pripade napr. adresare stejneho jmena
            } catch (Exception ex) {
                System.out.println("Nelze pracovat souborem zadanym cestou " + f.getPath());
                System.out.println("Zadany soubor na disku neexistuje, nelze jej vytvorit a otevrit pro zapis");
                ex.printStackTrace();
                file = null;
            }
        }
        if (file == null) {
            System.out.println("Soubor stale neni zadan");
        } else {
            System.out.println("Nadale je aktualni soubor (pracuji se souborem):");
            System.out.println("  " + file.getPath());
        }
    }

    private static void pridatOsobu() throws IOException {
        System.out.println("");
        System.out.println("Data dalsi osoby");
        System.out.println("Zadej cislo, jmeno, prijmeni a vysku osoby");
        System.out.println("Jednotlive udaje oddel mezerou/tabulatorem/entrem");
        OsobaFixLength os = new OsobaFixLength(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble());
        // ulozeni dat do souboru
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            raf.seek(raf.length());
            os.saveToFile(raf);
        }
    }

    private static void vypsatOsoby() throws IOException {
        int pocet = 0;
        System.out.println("Data osob nactena ze souboru");
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            boolean konecSoub = false;
            while (!konecSoub) {
                OsobaFixLength os = OsobaFixLength.loadFromFile(raf);
                if (os != null) {
                    pocet++;
                    System.out.format("%d. %s %n", pocet, os.toStringFmt());
                } else {
                    konecSoub = true;
                }
            }
        }
        System.out.println("Celkem nactena data " + pocet + " osob");
    }

    private static void odstranitDataOsoby() throws FileNotFoundException, IOException {
        System.out.println("");
        System.out.println("Odstraneni data jedne osoby");
        System.out.println("Zadej poradi osoby");
        int poradi = sc.nextInt();
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            raf.seek(raf.length() - OsobaFixLength.DELKA_ZAZNAMU_OSOBA);
            OsobaFixLength os = OsobaFixLength.loadFromFile(raf);
            raf.seek((poradi - 1) * OsobaFixLength.DELKA_ZAZNAMU_OSOBA);
            os.saveToFile(raf);
            raf.setLength(raf.length() - OsobaFixLength.DELKA_ZAZNAMU_OSOBA);
        }
    }

    private static void upravitDataOsoby() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
