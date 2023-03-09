/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package week02_nextobject;

/**
 *
 * @author jana.vitvarova
 */
public class FractionApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Zadej 1. zlomek:");
        Fraction f1 = new Fraction(1,2);
        System.out.println("Zadej 2. zlomek:");
        Fraction f2 = new Fraction(3,4);
        System.out.println("Součet:");
        System.out.println(FractionTools.add(f1, f2));
        
        
    }
    
}
