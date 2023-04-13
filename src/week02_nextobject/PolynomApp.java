package week02_nextobject;

public class PolynomApp {

    public static void main(String[] args) {
        double[] coef = {2, 0, 4, -1};
        //Polynom p = new Polynom(coef);
        Polynom p = Polynom.getInstanceFromNormal(coef);
    }
    
}
