/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rychly;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tomas.rychly
 */
public class PeriodicTableApp {
    public static Scanner sc = new Scanner(System.in);
    private ArrayList<Element> list;
    private ArrayList<Element> dateList;

    public PeriodicTableApp() throws IOException{ //JV toto je jiz aplikace, objekt teto tridy se uz nema, kde vytvaret
        getData();
        setDate();
        ArrayList<Element> list = new ArrayList<>();
        ArrayList<Element> dateList = new ArrayList<>();
        this.list = list;
        this.dateList = dateList;
    }

    public ArrayList<Element> getList() {
        return list; //JV defenzivni kopie
    }

    public void setList(ArrayList<Element> list) {
        this.list = list;
    }

    public ArrayList<Element> getDateList() {
        return dateList;
    }

    public void setDateList(ArrayList<Element> dateList) {
        this.dateList = dateList;
    }
    File file = new File("./Data/prvky.csv");

    public void getData() throws IOException {

        try { //JV try with resources jinak neosetrujete zavirani streamu
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            //JV prvni radek (hlavicku) je potreba preskocit
            while((line = reader.readLine()) != null){
            String[] info = line.split(",");
            String name = info[0];
            String symbol = info[2];
            int cislo = Integer.parseInt(info[1]);
            double hmotnost = Double.parseDouble(info[3]);
            int date = 0;
            
            Element el = new Element(name,cislo,symbol,hmotnost);
                if (!list.contains(el)) {
                    list.add(el);
                }
            }
        } catch (FileNotFoundException ex) { //JV nestaci jen zalogovat
            Logger.getLogger(PeriodicTableApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void setDate() throws IOException{
     File file = new File("./Data/rokObjeveni.txt");
     try {
            BufferedReader reader = new BufferedReader(new FileReader(file)); //JV mel se pouzit Scanner
            String line;
            while((line = reader.readLine()) != null){
            String[] info = line.split(" ");
            String name = info[0];
            int year = Integer.parseInt(info[1]);
            Element el = new Element(name, year);
            dateList.add(el);
            
                for (int i = 0; i < list.size(); i++) {
                    for (int j = 0; j < dateList.size(); j++) {
                        if (list.get(i).getName().equals(dateList.get(j).getName())) {
                        list.get(i).setDate(dateList.get(j).getDate());
                    }
                    }
                    
                    
                }
            
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PeriodicTableApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean jePrvek(String input){
        for (int i = 0; i < list.size(); i++) {
          return  list.get(i).getSymbol().equals(input);
        }
        return false;
    }
    
    public Element najitPrvek(String input){
        for (int i = 0; i < list.size(); i++) {
            if (input.equals(list.get(i).getSymbol())) {
                Element el = list.get(i);
                return el;
            }
        }
        return null;
    }
    
    public Element getOldest(){
    return null; //todo
    }
    
    public String getHeaviest(){
       // Collections.sort(list,);
        
        for (int i = 0; i < 10; i++) {
          return list.get(i).toString();
        }
        return null;
    }
    
    // potrebne
    // comparator weight
    
    // comparator date
    
    
    
}

