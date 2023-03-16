/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package week03_arrayobjects;

import java.util.Scanner;
import week01_firstobject.Point;

/**
 *
 * @author jana.vitvarova
 */
public class NShapeApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        

        System.out.println("jak velky n-uhelnik ");
        int a = in.nextInt();
        NShape shape1 = new NShape(a);

        for (int i = 0; i < a; i++) {
            double x = in.nextDouble();
            double y = in.nextDouble();

            shape1.add(x, y);

        }

        System.out.println(shape1.calculatePerim());
        System.out.println(shape1.closestToOrigin());

    }

}
