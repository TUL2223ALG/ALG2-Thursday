/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sodomka;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jan.sodomka
 */
public class PeriodicTable {

    public static Scanner sc = new Scanner(System.in);

    ArrayList<Element> table = new ArrayList<>(); //JV enkapsulace, data maji byt private

    public ArrayList<Element> PeriodicTable() {
        return table;
    }

    public void addElement(Element e) {
        table.add(e);
    }

    public ArrayList<Element> compareByWeight(ArrayList<Element> elements) { //JV pouzite existujuce metody na triedenie
        for (int i = 0; i < elements.size(); i++) {
            for (int j = i; j < elements.size(); j++) {
                if (elements.get(i).getWeight() > elements.get(j).getWeight()) {
                    Element temp = elements.get(i);
                    elements.set(i, elements.get(j));
                    elements.set(j, temp);
                }
            }
        }
        return elements;
    }

    public Element findOldest(ArrayList<Element> elements) {//JV nepotrebuje vstupni parametr, mela by pracovat nad table
        Element oldest = new Element("X", "X", 0, 0, 2023);
        for (int i = 1; i < elements.size(); i++) {
            if (oldest.getYear() > elements.get(i).getYear() && elements.get(i).getYear() != 0) {
                oldest = elements.get(i);
            }
        }
        return oldest;
    }

    public void loadElements(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            reader.readLine();
            ArrayList<String> elements = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] el = line.split(",");
                Element element = new Element(el[0], el[2], Integer.parseInt(el[1]), Double.parseDouble(el[3]));
                if (!elements.contains(element.getName())) {
                    addElement(element);
                    elements.add(element.getName());
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Soubor nenalezen.");; //JV pokud soubor neexistuje, vypisete hlasku, ale aplikace bude pokracovat
        } catch (IOException ex) {
            System.out.println("Došlo k chybě.");;
        }
    }

    public void loadYears(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) { //JV meli jste pouzit Scanner

            String line;
            reader.readLine();
            ArrayList<String> elements = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] el = line.split(",");
                Element element = new Element(el[0], el[2], Integer.parseInt(el[1]), Double.parseDouble(el[3]));
                if (!elements.contains(element.getName())) { //JV bylo potreba najit zadany prvek a nastavit mu rok 
                    addElement(element);
                    elements.add(element.getName());
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Soubor nenalezen.");;
        } catch (IOException ex) {
            System.out.println("Došlo k chybě.");;
        }
    }
}
