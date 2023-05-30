/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salek;


/**
 *
 * @author david.salek
 */
public class Element implements Weightable {
    private String name = "";
    private String symbol = "";
    private int protonNumber;
    private double weight;
    private int yearOfDiscovery = 0;

    public Element(String input){
        
        String temp[] = input.split(",");
        
        this.name = temp[0];
        this.symbol = temp[1];
        this.protonNumber = Integer.parseInt(temp[2]);
        this.weight = Double.parseDouble(temp[3]);
    }
    
    public Element(String name, String symbol, int protonNumber, double weight){
        this.name = name;
        this.symbol = symbol;
        this.protonNumber = protonNumber;
        this.weight = weight;
    }
    
    public Element(String name, String symbol, int protonNumber, double weight, int yearOfDiscovery){
        this.name = name;
        this.symbol = symbol;
        this.protonNumber = protonNumber;
        this.weight = weight;
        this.yearOfDiscovery = yearOfDiscovery;
    }
    
    public String getName(){
        return name;
    }
    
    public String getSymbol(){
        return symbol;
    }
    
    public int getYearOfDiscovery(){
        return yearOfDiscovery;
    }
    
    public boolean setYearOfDiscovery(int yearOfDiscovery){
        if (this.yearOfDiscovery != 0) {
            return false;
        } else {
            this.yearOfDiscovery = yearOfDiscovery;
            return true;
        }
    }
    
    @Override
    public String toString(){
        if (yearOfDiscovery != 0) {
            return String.format("%s; %s; %d; %.2f; %s", name, symbol, protonNumber, weight, yearOfDiscovery);
        } else {
            return String.format("%s; %s; %d; %.2f", name, symbol, protonNumber, weight);
        }
    }
    
    @Override
    public double getWeight(){
        return weight;
    }
}
