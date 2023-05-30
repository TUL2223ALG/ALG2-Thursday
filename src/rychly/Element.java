/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rychly;

/**
 *
 * @author tomas.rychly
 */
public class Element implements Weightable {

    private String name;
    private String symbol;
    private int protonNum;
    private double atomWeight;
    private int date;
    private int cislo;
    

    public Element(String name, String symbol, int protonNum, double atomWeight, int date) {
        this.name = name;
        this.symbol = symbol;
        this.protonNum = protonNum;
        this.atomWeight = atomWeight;
        this.date = 0;
    }

    public Element(String name, String symbol, int protonNum, double atomWeight) {
        this.name = name;
        this.symbol = symbol;
        this.protonNum = protonNum;
        this.atomWeight = atomWeight;
        this.date = 0;
    }
    
        public Element(String input) {
        String[] info = input.split(",");
        this.name = info[0];
        this.symbol = info[1];
        this.protonNum = Integer.parseInt(info[2]);
        this.atomWeight = Double.parseDouble(info[3]);
        this.date = 0;
    }

    Element(String name, int cislo, String symbol, double hmotnost) {
        this.name = name;
        this.symbol = symbol;
        this.cislo = cislo ;
        this.atomWeight = hmotnost;
        this.date = 0;
    }

    Element(String name, int year) {
        this.name = name;
        this.date = 0;
    }

    public void setDate(int date) { //JV jen pokud nebyl zadany
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public int getDate() {
        return date;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    
    
    public double getAtomWeight() {
        return atomWeight;
    }

    public Element addEl(String input) {
        String[] info = input.split(",");
        name = info[0];
        symbol = info[1];
        protonNum = Integer.parseInt(info[2]);
        atomWeight = Double.parseDouble(info[3]);
        date = 0;

        Element temp = new Element(name, symbol, protonNum, atomWeight, date);
        return temp;
    }

    @Override
    public double getWeight() {
        return getAtomWeight();
    }

    @Override
    public String toString() {
        if (date > 0) {
            return name + " " + symbol + " " + protonNum + " " + atomWeight + " " + date;
        }
        return name + " " + symbol + " " + protonNum + " " + atomWeight;

    }

}
