/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week02_nextobject;

/**
 *
 * @author jana.vitvarova
 */
public final class FractionTools {
    private FractionTools(){}
    
    public static Fraction add(Fraction f1, Fraction f2) {
        int numerator = f1.getNumerator()*f2.getDenominator() + f1.getDenominator()*f2.getNumerator();
        int denominator = f1.getDenominator()*f2.getDenominator();
        return new Fraction(numerator, denominator);
    }
    
    public static Fraction reduce(Fraction f1, Fraction f2) {
        int numerator = f1.getNumerator()*f2.getDenominator() - f1.getDenominator()*f2.getNumerator();
        int denominator = f1.getDenominator()*f2.getDenominator();
        return new Fraction(numerator, denominator);
    }
    
    public static Fraction multiply(Fraction f1, Fraction f2) {
        int numerator = f1.getNumerator()*f2.getNumerator();
        int denominator = f1.getDenominator()*f2.getDenominator();
        return new Fraction(numerator, denominator);
    }
    
    public static Fraction devide(Fraction f1, Fraction f2) {
        int numerator = f1.getNumerator()*f2.getDenominator();
        int denominator = f1.getDenominator()*f2.getNumerator();
        return new Fraction(numerator, denominator);
    }
}
