/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sodomka;

/**
 *
 * @author jan.sodomka
 */
public class Element implements Weightable<Element> {
    //JV encapsulace, data maji byt privatni
    String name;
    String symbol;
    int protNumber;
    double atomWeight;
    int year;

    public Element(String name, String symbol, int protNumber, double atomWeight) {
        this.name = name;
        this.symbol = symbol;
        this.protNumber = protNumber;
        this.atomWeight = atomWeight;
    }

    public Element(String name, String symbol, int protNumber, double atomWeight, int year) {
        this.name = name;
        this.symbol = symbol;
        this.protNumber = protNumber;
        this.atomWeight = atomWeight;
        this.year = year;
    }

    public Element(String retezec) {
        String[] pole = retezec.split(",");
        this.name = pole[0];
        this.symbol = pole[1];
        this.protNumber = Integer.parseInt(pole[2]);
        this.atomWeight = Double.parseDouble(pole[3]);
    }

    public void setYear(int year) { //JV propagovat info vys
        if (year != 0) {
            this.year = year;
        }
    }

    @Override
    public double getWeight() {
        return atomWeight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getProtNumber() {
        return protNumber;
    }

    public void setProtNumber(int protNumber) {
        this.protNumber = protNumber;
    }

    public void setAtomWeight(double atomWeight) {
        this.atomWeight = atomWeight;
    }

    public int getYear() {
        return year;
    }

    @Override //JV nevytvarejte vlastni rozhrani pro compareTo, nebude pak fungovat napr. s Collections.sort()
    public int compareTo(Element other) {
        return Double.compare(atomWeight, other.getWeight());
    }

    @Override
    public String toString() {
        if (year != 0) {
            return name + ", " + symbol + ", " + protNumber + ", " + atomWeight + ", " + year;
        } else {
            return name + ", " + symbol + ", " + protNumber + ", " + atomWeight;
        }
    }
}
