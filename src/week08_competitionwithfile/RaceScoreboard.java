package week08_competitionwithfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import week05_competition.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

public class RaceScoreboard {

    private ArrayList<Runner> runners;
    private String Name;
    private double startTime;
    private int count;

    private static Comparator<Runner> COMPARATORBYNAME = (Runner o1, Runner o2) -> o1.getName().compareTo(o2.getName());

    public RaceScoreboard(int countR, String Name, double startTime) {
        this.runners = new ArrayList();
        this.Name = Name;
        this.startTime = startTime;
        this.count = 0;
    }

    public RaceScoreboard(String Name, double startTime) {
        this.Name = Name;
        this.startTime = startTime;
        this.count = 0;
    }

    public void loadRegistration(File f) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            Runner temp = null;
            //int pocet = 0;
            do {
                temp = Runner.loadFromFile(br);
                this.addRacer(temp);
                //    pocet++; //bude se pak muset odčíst 1
            } while (temp != null);
//
//            for (int i = 0; i < runners.length; i++) {
//                addRacer(Runner.loadFromFile(br)); //kdyz nactete znova, uz tam nic neni, museli by jste otevrit novy stream
//            }
//        }
        }
    }

    public void saveToFileNames(BufferedWriter bw) throws IOException {
        for (Runner runner : runners) {
            runner.saveToFileNames(bw);
        }
//        for (int i = 0; i < runners.length; i++) {
//            runners[i].saveToFileNames(bw);
//        }
    }

    public void saveToFileTimes(BufferedWriter bw) throws IOException {
        for (Runner runner : runners) {
            runner.saveToFileTimes(bw);
//        for (int i = 0; i < runners.length; i++) {
//            runners[i].saveToFileTimes(bw);
//        }
        }
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void addRacer(Runner r) {
        runners.add(r);
        //runners[count] = r;
        //count++;
    }

    public void addRacer(String name) {
        Runner r = new Runner(name);
        addRacer(r);
    }

    public Runner winner() {
        double winningTime = Double.MAX_VALUE;
        double temp;
        int winnerIndex = 0;
        Runner winner = null;
//        for (int i = 0; i < runners.length; i++) { //runners.size()
//            temp = runners[i].getFinishTime(); //runners.get(i).getFinishTime()
//            if(winningTime > temp){
//                winningTime=temp;
//                winnerIndex=i;
//            }
//        }
//        return runners[winnerIndex]; //runners.get(winnerIndex)
        for (Runner runner : runners) {
            temp = runner.getFinishTime();
            if (winningTime > temp) {
                winningTime = temp;
                winner = runner;
            }
        }
        return winner;
    }

    public void setRunnersStartTime() {
        for (Runner runner : runners) {
            runner.setStartTime(startTime);
        }
//        for (int i = 0; i < runners.length; i++) {
//            runners[i].setStartTime(startTime);
//        }
    }

    public void setRunnerFinishTime(double finishTime, String name) {
        for (Runner runner : runners) {
            if (runner.getName().equals(name)) {
                runner.setFinishTime(finishTime);
            }
        }
//        for (int i = 0; i < runners.length; i++) {
//            if(name.equals(runners[i].getName())){
//            runners[i].setFinishTime(finishTime);
//            }
//        }
    }

    public String startList() {
        Collections.sort(runners, new ComparatorByName());
        //Arrays.sort(runners, new ComparatorByName());
        return displayRunners();
    }

    public String startListv2() {
        Collections.sort(runners, new Comparator<Runner>() {
            //Arrays.sort(runners, new Comparator<Runner>() {
            @Override
            public int compare(Runner o1, Runner o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return displayRunners();
    }

    public String startListv3() {
        Collections.sort(runners, (Runner o1, Runner o2) -> o1.getName().compareTo(o2.getName()));
        //Arrays.sort(runners, (Runner o1, Runner o2) -> o1.getName().compareTo(o2.getName()));
        return displayRunners();
    }

    public String startListv4() {
        Collections.sort(runners, COMPARATORBYNAME);
        //Arrays.sort(runners, COMPARATORBYNAME);
        return displayRunners();
    }

    public String results() {
        Collections.sort(runners);
        //Arrays.sort(runners);
        return displayRunners();
    }

    public String displayRunners() {
        StringBuilder sb = new StringBuilder("");
        for (Runner runner : runners) {
            sb.append(runner).append("\n");
        }
        return sb.toString();
    }
}
