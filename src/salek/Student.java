/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package salek;

/**
 *
 * @author ul
 */
public class Student {

    private String name;
    private String surname;
    private String username;
    private int[] points;
    private String divnyCislo; //nepochopil jsem k cemu cislo slouzi, zda je to nejaky zakodovany datum? 
//JV nemusite si ukladat vsechno, jen to co potrebujete

    /*
    private int one;
    private int two;
    private int three;
    private int four;
    private int five;
    private int six;
    private int seven;
    private int eight;
    private int nine;
    private int ten;
    private int eleven;
    private int twelve;
    private int thirteen;
    private int fourteen;
    private int fifteen;
    private int seventeen;
    private int eighteen;
    private int nineteen;
    private int twenty;*/

    public Student(String name, String surname, String username, int[] points, String divnyCislo) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.points = points;
        this.divnyCislo = divnyCislo;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public int[] getPoints() {
        return points;
    }

    public String getDivnyCislo() {
        return divnyCislo;
    }

    public int getPointsInTotal() {
        int output = 0;
        for (int i = 0; i < points.length; i++) {
            output += points[i];
        }
        return output;
    }

    public boolean maNarokNaZapocet() {
        int totalPoints = getPointsInTotal();
        if (totalPoints >= 50) {
            return true;
        }
        return false;
    }
}
