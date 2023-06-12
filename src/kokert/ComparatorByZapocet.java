/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kokert;

import java.util.Comparator;

/**
 *
 * @author jan.kokert
 */
public class ComparatorByZapocet implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getZapocet().compareTo(o2.getZapocet());
    }
    
}