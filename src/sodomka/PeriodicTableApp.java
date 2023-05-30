/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sodomka;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author jan.sodomka
 */
public class PeriodicTableApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PeriodicTable table = new PeriodicTable();
        ArrayList<Element> pTable = table.PeriodicTable();

        table.loadElements("data\\prvky.csv");

        System.out.println("Oldest:");
        Element oldest = table.findOldest(pTable);
        System.out.println(oldest.toString());
        System.out.println("");
        System.out.println("Sorted by weight:");
        ArrayList<Element> sortedWeight = table.compareByWeight(pTable);
        for (int i = 0; i < 10; i++) {
            System.out.println(sortedWeight.get(i).toString());

        }
    }

}
