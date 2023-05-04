/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package week09_recursion;

import java.io.File;

/**
 *
 * @author jana.vitvarova
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        getFiles(new File("C:\\Users\\jana.vitvarova\\Documents\\NetBeansProjects\\ALG1Old\\ZAP1-utorok\\UALG1Petricek\\"), 0);
    }

    static void getFiles(File f, int od) {
        String o = "";
        for (int i = 0; i < od; i++) {
            o += "  ";
        }
        if (f.isFile()) {

            System.out.println(o + "-" + f.getName());
            return;
        }
        System.out.println(o + "-" + f.getName());
        File[] files_list = f.listFiles();
        for (File file : files_list) {
            getFiles(file, od+1);
            
            
        }
    }

}
