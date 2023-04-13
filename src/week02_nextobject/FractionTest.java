package week02_nextobject;

public class FractionTest {

    /**
     * Testy:
     * 15,10
     * 8,9
     * -14,21
     * -5,-6
     * -25,-15
     * 0,5
     * 5,0
     * "15/10"
     * "15 10"
     * 3
     * "3"
     * "12/1"
     */
    public static void main(String[] args) {
        Fraction fraction = new Fraction("12/1");
        System.out.println(fraction);
        System.out.println(fraction.getNumerator());
        System.out.println(fraction.getDenominator());
        System.out.println(fraction.getDoubleValue());
    }
    
}
