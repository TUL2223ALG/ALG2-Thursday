package week01_firstobject;

public class PointApp {

    public static void main(String[] args) {
        double xA = 4;
        double yA = 3;
        double xB = 2;
        double yB = 1;
        
        //Point pointA = new Point(); //existuje defaultne v kayde tride
        Point pointA = new Point(xA, yA);
        System.out.println(pointA.distance());
    
        Point point0 = new Point();
        System.out.println(point0.distance());
        
        Point pointB = new Point(xB, yB);
        System.out.println(pointB.distance());
        
        System.out.println(pointA); //automaticky se vola toString
        //pointA.x = 7;
        System.out.println(pointA.getX());
    }   
    
    
}
