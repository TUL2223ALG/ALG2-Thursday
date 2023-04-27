package week08_competitionwithfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Runner implements Comparable<Runner>{
    private String name;
    private String raceName;
    private int racerNumber;
    private double startTime;
    private double finishTime;
    private Gender gender;
    private int yearOfBirth;
    private Category category;
    static int count = 0;
    
    //public static int number=1;
    public Runner (String name, int yearOfBirth, char gender){
        this.name = checkName(name);
        this.yearOfBirth = checkYear(yearOfBirth);
        if(gender == 'm'){
            this.gender = Gender.MALE;
        }else{
            this.gender = Gender.FEMALE;
        }
        this.category = Category.getInstance(this.gender, yearOfBirth);
        count++;
        this.racerNumber = count;
    }
    
    private int checkYear(int yearOfBirth){
        int nextYear = LocalDate.now().getYear()+1;
        if (!(yearOfBirth > 1903 && yearOfBirth < nextYear)){
            throw new IllegalArgumentException("Invalid year" + yearOfBirth 
                    +". Must be between 1903 and " + nextYear);
        }
        return yearOfBirth;
    }
    
    private String checkName(String name){
        if(!(name.matches("^[A-Z][a-z]*$"))){
            throw new IllegalArgumentException("Invalid name format ...");
        }
        return name;
    }
    
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
    
    public void setGender(Gender gender){
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "name=" + name + ", " + 
               "startTime=" + startTime + ", " +
               "finishTime=" + finishTime + ", " +
               "runningTime=" + calculateTime() + "," +
               "categorie=" + category.getDescription() + "," +
               "racer number=" + racerNumber;
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
        String[] dataStr = radek.split(" "); //regex "[,;]"
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
