/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kokert;

/**
 *
 * @author jan.kokert
 */
public class Student implements Comparable<Student>{
    private String name;
    private String surname;
    private String stagName;
    private int points;
    private String zapocet; //JV lepsi boolean

    public Student(String stagName, String name, String surname, int points, String zapocet) { //JV zapocet by si mela tato trida dopocitavat na zaklade bodu
        this.stagName = stagName;
        this.name = name;
        this.surname = surname;
        this.points = points;
        this.zapocet = zapocet;
    }

    public String getStagName() {
        return stagName;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getPoints() {
        return points;
    }

    public String getZapocet() {
        return zapocet;
    }
    
    /*public static boolean enoughPointsForZapocet(int points){
        if(points >= 50){
            return true;
        }
        return false;
    }*/
    
    @Override
    public String toString() {
        return "Osobní číslo    Jméno a příjmení    Celkem bodů     Zápočet\n"
                + "-----------------------------------------------------------------\n"
                + this.getStagName() + "    " + this.getName() + " " + this.getSurname() + "    " + this.getPoints() + "    " + this.getZapocet() + "\n\n";
    }

    @Override
    public int compareTo(Student o) {
        return o.getPoints()-this.getPoints();
    }
    
    
}
