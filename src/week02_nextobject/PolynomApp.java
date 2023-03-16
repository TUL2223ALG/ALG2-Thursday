/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package week02_nextobject;

/**
 *
 * @author jana.vitvarova
 */
public class PolynomApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double[] coef = {2, 0, 4, -1};
        //Polynom p = new Polynom(coef);
        Polynom p = Polynom.getInstanceFromNormal(coef);
    }
    
}
