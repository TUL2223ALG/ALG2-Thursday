package week03_arrayobjects;

import java.util.Scanner;

public class NShapeApp {

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
