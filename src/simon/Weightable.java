package simon;

/**
 * @author marts
 */
public interface Weightable<T> { 
    double getWeight();
    int compareTo(T other); //JV nevytvaret si vlastni interface pro porovnavani
}