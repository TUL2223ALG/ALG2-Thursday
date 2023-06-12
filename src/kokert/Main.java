/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kokert;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jan.kokert
 */
public class Main {
    
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
        
        String FILE_SEPARATOR = System.getProperty("file.separator");
        String path = "Data" + FILE_SEPARATOR + "ALG1-ulohy-01022023.csv";
        File f = new File(path);
        Board board = new Board("myBoard");
        
        //try{
        boolean end = false;
        int choice;
        
        do{
            System.out.println("Vyberte volbu:");
            System.out.println("1. Načítání souboru");
            System.out.println("2. Přehled zápočtů");
            System.out.println("3. Nárok na zápočet studenta");
            System.out.println("4. Uložení dat");
            System.out.println("0. Ukončení programu");
            
            choice = sc.nextInt();
            
            switch(choice){
                case 1: receiveLoadFile(board, f); break;
                case 2: receiveZapocetInfo(board); break;
                case 0: end = true; break;
                default: System.out.println("Nesprávná volba. Vyber znovu.");
            }
        } while(!end);
        //} catch(IOException e){
            //System.out.println("Chyba");
        //}
    }
    
    public static void receiveLoadFile(Board board, File f) throws IOException{
        board.saveFromFile(f);
        System.out.println("Soubor se podařilo načíst.\n");
    }
    
    public static void receiveZapocetInfo(Board board){
        ArrayList<Student> s2 = board.returnStudentsSortedByZapocetAndPoints();
        //ArrayList<Student> s = board.returnStudentsWithZapocet();
        //ArrayList<Student> s3 = board.returnStudentsSortedByZapocetAndPoints();
        StringBuilder sb = new StringBuilder();
        for (Student student : s2) {
            sb.append(student.toString());
        }
        System.out.println(sb.toString());
    }
    
    public static void receiveSaveToFile(Board board, File f) throws IOException{
        //ArrayList<Student> s = board.saveToFile(f);
    }
    
    //JV chybi ulozeni do souboru
    //JV chybi vyhledani studenta
}
