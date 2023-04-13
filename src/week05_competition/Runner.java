package week05_competition;

public class Runner implements Comparable<Runner>{
    private String name;
    private String raceName;
    private double startTime;
    private double finishTime;

    public Runner(String name) {
        this.name = name;
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

    @Override
    public int compareTo(Runner o) {
       //return this.calculateTime() - o.calculateTime(); //int
       return Double.compare(this.calculateTime() , o.calculateTime()); //double
    }
}
