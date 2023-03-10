package week02_nextobject;

public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = checkDenominator(denominator);
        convertToBasicForm();
    }

    public Fraction(int numerator) {
        this(numerator, 1);
    }

    public Fraction(String strNumber) {
        // bylo by vhodne ověřit validitu stringu (matches)
        String[] splited = strNumber.split(" |/");
        numerator = Integer.parseInt(splited[0]);
        if (splited.length == 2) {
            denominator = checkDenominator(Integer.parseInt(splited[1]));
        } else {
            denominator = 1;
        }
        convertToBasicForm();
    }

    private void convertToBasicForm() {
        if (numerator == 0) {
            denominator = 1;
        } else {
            int gd = getGreatestDevisor(Math.abs(numerator), Math.abs(denominator));
            numerator = numerator / gd;
            denominator = denominator / gd;
            //udelat pred if-else
            if (numerator < 0 && denominator < 0) { // prik. -4/-2 aby bylo 4/2
                numerator = numerator / (-1);
                denominator = denominator / (-1);
            }
        }
    }
    
    private int checkDenominator(int denominator){
        if (denominator == 0) {
            throw new IllegalArgumentException("Jmenovatel nesmí být 0.");
        }
        return denominator;
    }

    public static int getGreatestDevisor(int a, int b) {
        if (a < 1 || b < 1) {
            throw new IllegalArgumentException("a or b is less than 1");
        }
        while (b != 0) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public double getDoubleValue() {
        return (double) numerator / denominator;
    }

    @Override
    public String toString() {
        if (denominator == 1) {
            return String.format("%d", numerator);
        } else {
            return String.format("%d/%d", numerator, denominator);
        }
    }

}
