/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seps;

/**
 *
 * @author jiri.seps
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PeriodicTableApp {
    public static void main(String[] args) {
        PeriodicTable periodicTable = new PeriodicTable();
        loadPeriodicTable(periodicTable, "prvky.csv");
    }

    public static void loadPeriodicTable(PeriodicTable periodicTable, String filePath) {
        Map<String, Element> elementsMap = new HashMap<>();

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if(data.length < 4) {
                    continue;
                }
                String elementString = data[0] + ", " + data[2] + ", " + data[1] + ", " + data[3];
                if(elementsMap.containsKey(data[2])) {
                    continue;
                }
                Element element = new Element(elementString);
                elementsMap.put(data[2], element);
                periodicTable.addElement(data[0], data[2], Integer.parseInt(data[1]), Double.parseDouble(data[3]));
            }
        } catch (IOException e) { //JV nestaci jen vypsat stacktrace, info uzivateli a ukoncit aplikaci 
            e.printStackTrace();
        }
        //JV idealne jako 2 metody
        try(Scanner scanner = new Scanner(new FileReader("rokObjeveni.txt"))) {
            scanner.nextLine();
            while(scanner.hasNext()) {
                String symbol = scanner.next();
                scanner.next();
                scanner.next();
                String yearString = scanner.next();
                if(!yearString.equals("N") && elementsMap.containsKey(symbol)) {
                    elementsMap.get(symbol).setYearOfDiscovery(Integer.parseInt(yearString));
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

        List<Element> elementsList = new ArrayList<>(elementsMap.values());
        //JV pouzite koncepty, ktere jsme nebrali, je potreba jim rozumet
        elementsList.sort(Comparator.comparing(Element::getWeight).reversed());
        System.out.println("Prvních 10 prvků s nejvyšší relativní atomovou hmotností:");
        for(int i = 0; i < 10 && i < elementsList.size(); i++) {
            System.out.println(elementsList.get(i));
        }

        elementsList.stream()
                .filter(e -> e.getYearOfDiscovery() != 0)
                .min(Comparator.comparing(Element::getYearOfDiscovery))
                .ifPresent(e -> {
                    System.out.println("\nNejstarší nalezený prvek:");
                    System.out.println(e);
                    System.out.println("Nalezeno před " + (2023 - e.getYearOfDiscovery()) + " lety.");
                });                
            }
        }
