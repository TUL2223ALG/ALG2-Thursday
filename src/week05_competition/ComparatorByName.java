package week05_competition;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Runner> {

    @Override
    public int compare(Runner o1, Runner o2) {
        return o1.getName().compareTo(o2.getName());
    }
    
}
