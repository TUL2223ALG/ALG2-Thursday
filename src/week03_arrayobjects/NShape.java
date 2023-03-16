
package week03_arrayobjects;

import java.util.Arrays;
import week01_firstobject.Point;

public class NShape {
    private Point[] points;
    private int count = 0;
    
    public NShape(Point[] points){
        this.points = Arrays.copyOf(points, points.length);
    }
    
    public NShape(int n){
        points = new Point[n];
    }
    
    public boolean add(Point p){
        if(count < points.length){
            points[count] = p;
            count++;
            return true;
        }
        return false;
    }
    
    public boolean add(double x, double y){
        Point p = new Point(x, y);
        return add(p);
    }
    
    public double calculatePerim(){
        double sum = 0;
        for (int i = 0; i < count - 1; i++) {
           //sum += points[i].distanceFrom(points[i+1]);
           sum += distanceFromTo(points[i], points[i+1]);
        }
        sum += distanceFromTo(points[count -1], points[0]);
        return sum;
    }
    
    public static double distanceFromTo(Point to, Point from){
        return Math.hypot(to.getX() - from.getX(), to.getY() - from.getY());
    }
    
    public Point closestToOrigin(){
        Point min = points[0]; 
        for (int i = 0; i < count; i++) {
            if (min.distance() > points[i].distance()) {
                min = points[i];
            }
        }
        return min;
    }
}
