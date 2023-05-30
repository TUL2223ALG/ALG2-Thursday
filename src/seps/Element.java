        /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package seps;

/**
 *
 * @author jiri.seps
 */
public class Element implements Weightable {
    private String name;
    private String symbol;
    private int atomicNumber;
    private double relativeAtomicMass;
    private Integer yearOfDiscovery = null;

    //JV chybi základni konstruktory
    public Element(String csvElement) {
        String [] elementData = csvElement.split(", ");
        if (elementData.length != 4){
            throw new IllegalArgumentException("Invalidní formát");
            }
        this.name = elementData[0];
        this.symbol = elementData[1];
        this.atomicNumber = Integer.parseInt(elementData[2]);
        this.relativeAtomicMass = Double.parseDouble(elementData[3]);
    }

    public void setYearOfDiscovery(int year) {
        if(yearOfDiscovery != null) {
            throw new IllegalStateException("Rok nalezení byl již zadán.");
        }
        this.yearOfDiscovery = year;
    }
    public int getYearOfDiscovery() {
        return this.yearOfDiscovery;
    }
        
    public String getSymbol() {
        return this.symbol;
    }

    @Override
    public double getWeight() {
        return this.relativeAtomicMass;
    }

    @Override
    public String toString() {
        String result = this.name + ", " + this.symbol + ", " + this.atomicNumber + ", " + this.relativeAtomicMass;
        if(this.yearOfDiscovery != null) {
            result += ", " + this.yearOfDiscovery;
        }
        return result + ".";
    }
}


    
    
