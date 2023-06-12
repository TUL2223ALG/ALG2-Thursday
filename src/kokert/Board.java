/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kokert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author jan.kokert
 */
public class Board {

    ArrayList<Student> board;
    String name;

    public Board(String name) {
        //ArrayList<Student> board = new ArrayList<Student>();
        this.board = new ArrayList<Student>();
        this.name = name;
    }

    public ArrayList<Student> getBoard() {
        ArrayList<Student> s = (ArrayList<Student>) board.clone();
        return s;
    }

    public String getName() {
        return name;
    }

    public void addStudent(String name, String surname, String stagName, int points, String zapocet) {
        Student s = new Student(name, surname, stagName, points, zapocet);
        board.add(s);
    }

    public void saveFromFile(File f) throws IOException { //JV je to load ne save
        String line;
        String text[];
        String name;
        String surname;
        String stagName;
        int points = 0;
        String zapocet = "Ne";
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                text = line.split(",");
                name = text[0];
                surname = text[1];
                stagName = text[2];
                //47 uloh
                for (int i = 3; i < 50; i++) { //JV nemelo by byt napevno
                    if (text[i].equals("-")) { //JV zbytecne, kdyz -, nic nedelam, nepricitam
                        points += Integer.parseInt(text[i].replaceAll("-", "0"));
                    } else {
                        points += Integer.parseInt(text[i]);
                    }
                }
                if (points >= 50) {
                    zapocet = "Ano";
                    this.addStudent(name, surname, stagName, points, zapocet);
                }
            }
        }
    }

    public ArrayList returnStudentsWithZapocet() {
        ArrayList<Student> s = this.getBoard();
        for (Student student : s) {
            if (student.getPoints() >= 50) {
                s.add(student);
            }
        }
        Collections.sort(s, new ComparatorBySurname());
        return s;
    }
    
    public ArrayList returnStudentsWithoutZapocet() {
        ArrayList<Student> s = this.getBoard();
        for (Student student : s) {
            if (student.getZapocet().equals("Ne")) { //druha moznost ziskani lidi bez zapoctu
                s.add(student);
            }
        }
        Collections.sort(s, new ComparatorBySurname());
        return s;
    }
    
    public ArrayList returnStudentsSortedByZapocetAndPoints() {
        ArrayList<Student> s = this.getBoard();
        Collections.sort(s);
        Collections.sort(s, new ComparatorByZapocet());
        return s;
    }
    
    public void saveToFile(File f) throws IOException {
        ArrayList<Student> s = returnStudentsWithZapocet();
        StringBuilder sb = new StringBuilder();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            for (Student student : s) {
                sb.append("osobní číslo: ").append(student.getStagName()).append(", jméno: ").append(student.getName()).append(", příjmení: ").append(student.getSurname()).append("\n");
            }
            bw.write(sb.toString());
        }
    }
    
    public void saveToBin(File f) throws IOException {
        //try (DataOutputStream out = new DataOutputStream(new FileOutputStream(f))) ... ukázka ukládání binárního souboru, nezbyl čas
        //out.writeUTF(), out.writeInt()
    }
}
