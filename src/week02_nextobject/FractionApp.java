package week02_nextobject;

public class FractionApp {

    public static void main(String[] args) {
        System.out.println("Zadej 1. zlomek:");
        Fraction f1 = new Fraction(1,2);
        System.out.println("Zadej 2. zlomek:");
        Fraction f2 = new Fraction(3,4);
        System.out.println("Součet:");
        System.out.println(FractionTools.add(f1, f2));

    }
}
