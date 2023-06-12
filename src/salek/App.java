/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package salek;

import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ul
 */
public class App {

    public static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Students data = new Students();

        boolean exit = false;
        int choice;

        //loop programu
        while (!exit) {
            printMenu();

            while (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.println("Neplatna volba, zkus to znovu:");
            }

            //System.out.println(choice);
            choice = sc.nextInt();
            sc.nextLine(); //sezere zbytek

            switch (choice) {
                case 1:
                    System.out.println("Zadejte nazev souboru ve slozce data (ALG1-ulohy-01022023.csv):");
                    String filename = sc.nextLine();
                    try {
                    //data.loadFromFile("ALG1-ulohy-01022023.csv"); // urychleni nacitani pro testovani
                    data.loadFromFile(filename);
                    System.out.println("Data byla uspesne nactena.");
                } catch (Exception e) {
                    System.out.println("" + e.getMessage());
                }
                /*
                    for (Student student : data.getStudents()) {
                        System.out.printf("%s, %s, %s, %d\n", student.getName(), student.getSurname(), student.getUsername(), student.getPointsInTotal());
                    }*/
                break;

                case 2:
                    printMenu2();
                    while (!sc.hasNextInt()) {
                        sc.nextLine();
                        System.out.println("Neplatna volba, zkus to znovu:");
                    }
                    int choice2 = sc.nextInt();
                    sc.nextLine();

                    //JV kod case dat do metod, inak je switch moc velky
                    switch (choice2) {
                        case 1:
                            if (data.getStudents().isEmpty()) {
                                System.out.println("Nejsou nactena data.");
                                break;
                            }
                            data.sortBySurname();
                            System.out.printf("%-20s %-30s %-15s %-10s\n", "Osobni cislo", "Jmeno a prijmeni", "Celkem bodu", "Zapocet");
                            System.out.println("---------------------------------------------------------------------------");
                            for (Student student : data.getStudents()) {
                                if (student.maNarokNaZapocet()) {
                                    System.out.printf("%-20s %-30s %-15d %-10s\n", student.getUsername(), student.getName() + " " + student.getSurname(), student.getPointsInTotal(), "ano");
                                }
                            }
                            break;
                        case 2:
                            //JV opakujici se kod z case 1, vhodne dat do metody
                            if (data.getStudents().isEmpty()) {
                                System.out.println("Nejsou nactena data.");
                                break;
                            }
                            data.sortBySurname();
                            System.out.printf("%-20s %-25s %-10s %-10s\n", "Osobni cislo", "Jmeno a prijmeni", "Celkem bodu", "Zapocet");
                            System.out.println("---------------------------------------------------------------------------");
                            for (Student student : data.getStudents()) {
                                if (!student.maNarokNaZapocet()) {
                                    System.out.printf("%-20s %-25s %-10d %-10s\n", student.getUsername(), student.getName() + " " + student.getSurname(), student.getPointsInTotal(), "ano");
                                }
                            }
                            break;
                        case 3:
                            if (data.getStudents().isEmpty()) {
                                System.out.println("Nejsou nactena data.");
                                break;
                            }
                            data.sortBySurname(); //JV melo byt setridene podle bodu
                            System.out.printf("%-20s %-25s %-10s %-10s\n", "Osobni cislo", "Jmeno a prijmeni", "Celkem bodu", "Zapocet");
                            System.out.println("---------------------------------------------------------------------------");
                            for (Student student : data.getStudents()) {
                                String zapocet = "ne";
                                if (student.maNarokNaZapocet()) {
                                    zapocet = "ano";
                                }
                                System.out.printf("%-20s %-25s %-10d %-10s\n", student.getUsername(), student.getName() + " " + student.getSurname(), student.getPointsInTotal(), zapocet);
                                
                            }
                        default:
                            System.out.println("Neplatna volba");
                            break;
                    }
                    break;
                case 3:
                    if (data.getStudents().isEmpty()) {
                        System.out.println("Nejsou nactena data.");
                        break;
                    }
                    System.out.println("Zadejte jmeno, prijmeni nebo username studenta:"); //JV melo byt zadane cele jmeno nebo osobni cislo
                    String input = sc.nextLine().strip();
                    boolean found = false;
                    for (Student student : data.getStudents()) {
                        if (student.getName().equals(input) || student.getSurname().equals(input) || student.getUsername().equals(input)) {
                            found = true;
                            String zapocet = "Nema narok na zapocet";
                            if (student.maNarokNaZapocet()) {
                                zapocet = "Ma narok na zapocet";
                            }
                            System.out.printf("%-20s %-25s %-5d %-20s\n", student.getUsername(), student.getName() + " " + student.getSurname(), student.getPointsInTotal(), zapocet);
                        }
                    }
                    if (!found) {
                        System.out.println("Zadny student nebyl nalezen.");
                    }

                    break;
                case 4:
                    System.out.println("Nestihl jsem omlouvam se"); //JV chybi ulozeni do souboru
                    break;
                case 0:
                    System.out.println("Program bude ukoncen");
                    exit = true;
                    break;
                default:
                    System.out.println("Neplatna volba");
                    break;
            }

        }

    }

    public static boolean printMenu() {
        System.out.println("---------ZAPOCET---------");
        System.out.println("1. nacitani souboru");
        System.out.println("2. prehled zapoctu");
        System.out.println("3. narok na zapocet u studenta");
        System.out.println("4. ulozeni dat");
        System.out.println("0. ukonceni programu");
        System.out.println("-------------------------");
        System.out.println("Vyberte volbu:");

        return true;
    }

    public static boolean printMenu2() {
        System.out.println("1. ma narok na zapocet podle prijmeni");
        System.out.println("2. nema narok na zapocet podle prijmeni");
        System.out.println("3. vsichni studenti podle ziskanych bodu");
        return true;
    }

}
