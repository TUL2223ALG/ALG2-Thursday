/*
 * Copyright (C) 2023 Jirina Kralovcova
 * This program is part of Java programing education. 
 * You can use it as you need to learn Java. 
 */
package p07.osoby.apps;

import p07.osoby.dat.Osoba;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Jirina
 */
public class OsobySouborTextovy {

    private static final Scanner sc = new Scanner(System.in);
    private static File file = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        boolean konecProgramu = false;
        try{
            do {
                vypisMenu();
                int volba = nactiVolbu();
                try{
                    konecProgramu = obsluzVolbu(volba);
                }catch(FileNotFoundException e){
                    System.out.println("Soubor nenalezen, zadej znovu");
                }
            } while (!konecProgramu);
        }catch(IOException e){
            System.out.println("Problem se vstupno-vystupni operaci" + e.getMessage());
        }
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
        // chybi osetreni
        // se souborem zadane cesty musi byt mozne pracovat
        // pokud soubor neexistuje - musi byt vytvoritelny apod.
        // toto zde neni osetreno
        file = f;
    }

    private static void pridatOsobu() throws IOException {
        // musi byt spravne zadan soubor
        System.out.println("");
        System.out.println("Data dalsi osoby");
        System.out.println("Zadej cislo, jmeno, prijmeni a vysku osoby");
        System.out.println("Jednotlive udaje oddel mezerou/tabulatorem/entrem");
        Osoba os = new Osoba(sc.nextInt(), sc.next(), sc.next(), sc.nextDouble());
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            os.saveToFile(bw);
        }
    }

    private static void vypsatOsoby() throws IOException {
        // musi byt spravne zadan a vytvoren prislusny soubor
        int pocet = 0;
        System.out.println("");
        System.out.println("Data osob nactena ze souboru");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            boolean konecSoub = false;
            while (!konecSoub) {
                Osoba os = Osoba.loadFromFile(br);
                if (os == null) {
                    break; //konecSoub = true 
                }
                pocet++;
                System.out.format("%d. %s %n", pocet, os.toStringFmt());
            }
        }
        System.out.println("Celkem nactena data " + pocet + " osob");
    }

}
