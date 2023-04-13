package week02_nextobject;

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
