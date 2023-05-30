/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rychly;

/**
 *
 * @author tomas.rychly
 */
public class PeriodicTableTest {
    public static void main(String[] args) {
        PeriodicTable tab = new PeriodicTable();
        Element el1 =new Element("vodik","h",1,1.01);
        Element el2 =new Element("kyslik","o",8,16.00);
        Element el3 =new Element("chlor","cl",17,35.45);
        tab.addElement(el1);
        tab.addElement(el2);
        tab.addElement(el3);
        for (int i = 0; i < tab.getSize(); i++) {
            System.out.println(tab.getElement(i).toString());
        }
        
      
        MoleculeSame h2 = new MoleculeSame(el1,2);
        System.out.println(h2.getWeight());
        MoleculeSame o3 = new MoleculeSame(el2,3);
        
        
        
    }
}
