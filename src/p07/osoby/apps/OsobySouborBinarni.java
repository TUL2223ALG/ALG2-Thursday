package p07.osoby.apps;

/*
 * Copyright (C) 2023 Jirina Kralovcova
 * This program is part of Java programing education. 
 * You can use it as you need to learn Java. 
 */
import p07.osoby.dat.Osoba;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Jirina
 */
public class OsobySouborBinarni {

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
            konecProgramu = obsluzVolbu(volba);
        } while (!konecProgramu);
        System.out.println("Koncim ...");
    }

    private static void vypisMenu() {
        System.out.println("");
        System.out.println("Hlavni menu programu");
        System.out.println("1. Vybrat/zadat soubor");
        System.out.println("2. Zadat/pridat data dalsi osoby");
        System.out.println("3. Vypsat data osob");
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
        if (!f.isFile()){
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
        if (file == null) {
            System.out.println("Nutno nejdrive zadat/vybrat soubor");
            return;
        }
        System.out.println("");
        System.out.println("Data dalsi osoby");
        System.out.println("Zadej cislo, jmeno, prijmeni a vysku osoby");
        System.out.println("Jednotlive udaje oddel mezerou/tabulatorem/entrem");
        Osoba os = new Osoba(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble());
        // ulozeni dat do souboru
        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(file, true)))) {
            os.saveToFile(dos);
        }
    }

    private static void vypsatOsoby() throws IOException {
        if (file == null) {
            System.out.println("Nutno nejdrive zadat/vybrat soubor");
            return;
        }
        int pocet = 0;
        System.out.println("");
        System.out.println("Data osob nactena ze souboru");
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(new FileInputStream(file)))) {
            boolean konecSoub = false;
            while (!konecSoub) {
                Osoba os = Osoba.loadFromFile(dis);
                if (os == null) {
                    break;
                }
                pocet++;
                System.out.format("%d. %s %n", pocet, os.toStringFmt());
            }
        }
        System.out.println("Celkem nactena data " + pocet + " osob");
    }

}
