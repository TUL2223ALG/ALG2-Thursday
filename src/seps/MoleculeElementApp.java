/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seps;

/**
 *
 * @author jiri.seps
 */
import java.util.Scanner;
import java.util.Map;

public class MoleculeElementApp {

    public static void main(String[] args) {
        PeriodicTable periodicTable = new PeriodicTable();
        PeriodicTableApp.loadPeriodicTable(periodicTable, "prvky.csv");
        
        Map<String, Element> elementsMap = periodicTable.getElements();
        
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Zadejte prvek nebo molekulu ( 'H', 'H 2', 'Cl 4'), nebo 'konec' pro ukončení programu:");
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("konec")) {
                break;
            }

            String[] parts = input.split(" ");
            if(parts.length == 0) {
                continue;
            }

            Element element = elementsMap.get(parts[0]);
            if(element == null) {
                System.out.println("Prvek '" + parts[0] + "' nenalezen v periodické tabulce.");
                continue;
            }

            int moleculeCount = 1;
            if(parts.length > 1) {
                try {
                    moleculeCount = Integer.parseInt(parts[1]);
                } catch(NumberFormatException e) {
                    System.out.println("Invalidní počet molekul '" + parts[1] + "'. Musí být integer.");
                    continue;
                }
            }

            double weight = element.getWeight() * moleculeCount; //JV toto pocita MoleculeSame
            System.out.println("Relativní hmotnost: " + weight);
        }

        scanner.close();
    }
}