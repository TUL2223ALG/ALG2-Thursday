/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package week08_competitionwithfile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import p07.osoby.dat.Osoba;
/**
 *
 * @author jana.vitvarova
 */
public class CompetitionWithFilesApp {
    private static File file = null;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        //BufferedReader br = new BufferedReader(new FileReader(file))
        
        //file = new File("C:\Users\jana.vitvarova\Documents\NetBeansProjects\2223ALG2-Thursday\data\registrace.txt");
        RaceScoreboard board = new RaceScoreboard("Jiz50", 900);
        file = new File("data" + System.getProperty("file.separator") + "registrace.txt"); //file = new File("data\\registrace.txt");
           board.loadRegistration(file);
           System.out.println(board.displayRunners());
    }
    
}
