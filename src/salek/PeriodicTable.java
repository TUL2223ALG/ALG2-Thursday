/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salek;
import java.util.ArrayList;

/**
 *
 * @author david.salek
 */
public class PeriodicTable {
    
    private ArrayList<Element> elements;
    
    
    public PeriodicTable(){
        this.elements = new ArrayList<>();
    }
    
    public void addElement(String name, String symbol, int protonNumber, double weight){
        Element newOne = new Element(name, symbol, protonNumber, weight);
        elements.add(newOne);
    }
    public void addElement(Element element){
        elements.add(element);
    }
    
    
    public void addElement(String name, String symbol, int protonNumber, double weight, int yearOfDiscovery){
        Element newOne = new Element(name, symbol, protonNumber, weight, yearOfDiscovery);
        elements.add(newOne);
    }
    
    public ArrayList<Element> getElements(){
        return elements; //JV defenzivni kopie
    }
    
    /*
    public ArrayList<Element> getElementsSorted(){
        return elements.sort();
    }
    */
    
    public int getNumberOfElements(){
        return elements.size();
    }
}
