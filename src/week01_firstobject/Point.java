package week01_firstobject;

/**
 * Represents a point in 2D
 * @author 
 */
public class Point {
    //data - fields, attributes, clenske promenne, instancni promenne
    private double x;
    private double y;
    
    //private double[] coord = new double [2];
    
    //konstruktor - vytvari instanci, inicializuje
    public Point(double x, double y){
        this.x = x;
        this.y = y;
        //coord[0] = x;
    }
    
    //pretizeny konstruktor overloaded
    public Point(){
        
    }
    
    //getr
    public double getX(){
        return x;
    }
    /*
    //setr
    public void setX(double x){
        if(x > 0){
            this.x = x;
        }
    }*/
    //instancni metody, ktere pracuji nad daty
    public double distance(){
       //return Math.sqrt(x*x + y*y);
       return Math.hypot(x, y);
    }
    
    @Override
    public String toString(){
        return String.format("x = %.2f y = %.2f", x, y);
    }
}
