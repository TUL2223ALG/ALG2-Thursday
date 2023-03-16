/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week02_nextobject;

import java.util.Arrays;

/**
 *
 * @author jana.vitvarova
 */
public class Polynom {
    private double[] coef; //obracene vsechny koeficienty 2x~3 +4x -1 [-1, 4, 0, 2] 
    
    private Polynom(double[] coef){
        this.coef = Arrays.copyOf(coef, coef.length);
    }
    
    //tovarni metody, factory methods
    public static Polynom getInstanceFromNormal(double[] coef){ //[2, 0, 4, -1]
        double temp;
        //radsi neprohazovat prijmo pole coef
        for(int i = 0; i < coef.length/2; i++){
            temp = coef[i];
            coef[i] = coef[coef.length - 1 -i];
            coef[coef.length - 1 -i] = temp;
        }
        return new Polynom(coef);
    }
    
    public static Polynom getInstanceFromReverted(double[] coef){ //[-1, 4, 0, 2]
        return new Polynom(coef);
    }
}
