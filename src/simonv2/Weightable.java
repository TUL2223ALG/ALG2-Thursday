package simonv2;

/**
 * @author marts
 */
public interface Weightable<T> {
    double getWeight();
    int compareTo(T other);
}