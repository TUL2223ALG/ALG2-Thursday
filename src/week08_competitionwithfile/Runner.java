package week08_competitionwithfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Runner implements Comparable<Runner>{
    private String name;
    private String raceName;
    private int racerNumber;
    private double startTime;
    private double finishTime;
    
    //public static int number=1;

    public Runner(String name) {
        this.name = name;
        //this.racerNumber=number;
        //number++;
    }
    
    public Runner(String name, int racerNumber){
        this.name = name;
        this.racerNumber=racerNumber;
    }
    
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name=" + name + ", " + 
               "startTime=" + startTime + ", " +
               "finishTime=" + finishTime + ", " +
               "runningTime=" + calculateTime();
    }
    public double calculateTime() {
        return finishTime - startTime;
    }

    public double getStartTime() {
        return startTime;
    }

    public double getFinishTime() {
        return finishTime;
    }
    
    public void setRaceName(String raceName){
        this.raceName = raceName;
    }
    
    public void setStartTime(double startTime){
        this.startTime = startTime;
    }

    public void setFinishTime(double finishTime) {
        this.finishTime = finishTime;
    }
    
    public static Runner loadFromFile(BufferedReader br) throws IOException {
        String radek = br.readLine();
        if (radek == null) { //konec souboru
            return null;
        }
        String[] dataStr = radek.split(" ");
        int runnerNumber = Integer.parseInt(dataStr[0]);
        String name = dataStr[1];
        Runner bezec = new Runner(name, runnerNumber);
        return bezec;
    }
    
    public void saveToFileNames(BufferedWriter bw) throws IOException {
        String vypis = racerNumber+" "+name;
        bw.write(vypis);
        bw.newLine();
    }
    
    public void saveToFileTimes(BufferedWriter bw) throws IOException {
        String vypis = racerNumber+" "+finishTime;
        bw.write(vypis);
        bw.newLine();
    }
    
    @Override
    public int compareTo(Runner o) {
       //return this.calculateTime() - o.calculateTime(); //int
       return Double.compare(this.calculateTime() , o.calculateTime()); //double
    }
}
