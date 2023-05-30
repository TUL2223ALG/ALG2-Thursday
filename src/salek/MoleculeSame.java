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
public class MoleculeSame implements Weightable {
    private String name = "";
    private String symbol = "";
    private int count = 0;
    private ArrayList<Element> elements; //JV stacil Element a pocet
    
    public MoleculeSame(){
        this.elements = new ArrayList<>();
    }
    
    public boolean addElement(Element element){
        
        if (count == 0) {
            name = element.getName();
            symbol = element.getSymbol();
        } else if (!element.getName().matches(name)){
            return false;
        }
        
        elements.add(element);
        count += 1;
        return true;
    }
    
    public String getNameOfElement(){
        return name;
    }
    
    public String getSymbolOfElement(){
        return symbol;
    }
    
    public int getNumberOfElements(){
        return count;
    }
    
    public ArrayList<Element> getElements(){
        return elements;
    }
    
    @Override
    public double getWeight(){
        double totalWeight = 0;
        for (Element element : elements) {
            totalWeight += element.getWeight();
        }
        return totalWeight;
    }
}
