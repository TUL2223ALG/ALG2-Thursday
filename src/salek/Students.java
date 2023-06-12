/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package salek;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;

/**
 *
 * @author ul
 */
public class Students {

    private static List<Student> students;

    private static final String FILE_SEPARATOR = System.getProperty("file.separator");
    private static final String FILE_PATH = "data" + FILE_SEPARATOR + "ALG1-ulohy-01022023.csv";

    public Students() {
        students = new ArrayList<>();
    }

    public static boolean loadFromFile(String filename) throws IllegalArgumentException {
        //JV kody piste obecneji, kdyz pristi rok stahnu soubor ze Stagu, bude stejna struktura, ale muze byt jiny pocet uloh a jiny minimalni pocet bodu
        
        /*
            prvni radka ma 53 udaju a budu ji ignorovat
            v souboru je 51 udaju oddelenych carkou, z toho prvni tri jsou jmeno, prijmeni, username a posledni nejaky zakodovany datum
            takze po prvnich trech udajich nasleduje 47 udaju o bodu z uloh, to zn. index 3-50, 51 je datum
         */
        students.clear();
        try (BufferedReader br = new BufferedReader(new FileReader("data" + FILE_SEPARATOR + filename))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                //System.out.println(data.length);
                //System.out.println("Debug: rozdeluji radek podle carek");
                
                //JV po kazdem nacteni radku, se ptate jestli ma 51 delku, to je neefektivní, 
                //staci 1 radek preskocit pomoci br.readLine() preď cyklem, které si nikam neulozite 
                if (data.length == 51) {
                    //System.out.println("Debug: jsme v podmince 51");
                    String name = data[0].strip();
                    String surname = data[1].strip();
                    String username = data[2].strip();
                    int[] points = new int[47];
                    for (int i = 0; i < points.length; i++) {
                        //JV trochu zamotané zpracovaní, stacilo
                        //pokud obsahuje -, point[i] = 0
                        //jinak, point[i] = xInteger.parseInt(data[i+3])

                        //System.out.println("Debug: Nacitame do pole na indexu " + i);
                        if (!data[i+3].contains("-")) { //nedari se mi zkonstruovat funkcni regularni vyraz
                            points[i] = Integer.parseInt(data[i+3].replaceAll("[^0-9 ]", ""));
                            //System.out.println(points[i]);
                        } else{
                            points[i] = 0;
                        }
                    }
                    //System.out.println("Debug: Jsme mimo for");
                    String divnyDatum = data[50].strip();
                    
                    //vytvori objekt
                    Student newStudent = new Student(name, surname, username, points, divnyDatum);
                    
                    //prida ho do arrayListu
                    students.add(newStudent);
                }
            }
        } catch (Exception e) { //JV pod Exception spadá mnoho výjimek, nemusí to značit jen problém se souborem
            throw new IllegalArgumentException("Soubor neexistuje");
        }

        return true;
    }
    
    public static boolean addStudent(Student student){
        students.add(student);
        
        return true;
    }
    
    public static List<Student> getStudents(){
        return students; //JV vracejte defenzivni kopii, jinak porusujete enkapsulaci - zakladni princip OOP a kdokoli Vam muze Vas list studentu menit
    }
    
    public static boolean sortBySurname(){
        Comparator<Student> surnameComparator = Comparator.comparing(Student::getSurname);
        
        Collections.sort(students, surnameComparator);
                
        return true; //JV proc tato metoda vraci boolean?
    }

}
