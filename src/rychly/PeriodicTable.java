/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rychly;

import java.util.ArrayList;

/**
 *
 * @author tomas.rychly
 */
public class PeriodicTable {
     private ArrayList<Element> tabulka;
    
    public PeriodicTable(){
        this.tabulka = new ArrayList<>();
    }
    
    public void addElement(String nazev, String symbol, int protCislo, double relHmot){
        Element temp = new Element(nazev,symbol,protCislo,relHmot);
        tabulka.add(temp);
    }
     public void addElement(String nazev, String symbol, int protCislo, double relHmot,int rok){
        Element temp = new Element(nazev,symbol,protCislo,relHmot,rok);
        tabulka.add(temp);
    }
     public void addElement(Element a){
         tabulka.add(a);
     }
    public int getSize(){
        return tabulka.size();
    }
    public Element getElement(int i){
        return tabulka.get(i);
    }
    
}
