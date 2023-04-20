package week08_competitionwithfile;

import week05_competition.*;

public class CompetitionApp {

    public static void main(String[] args) {
        int countR = 4;
        String Name1 = "A";
        String Name2 = "B";
        String Name3 = "C";
        String Name4 = "D";
        String RaceName = "Jiz50";
        double startTime = 900;
        double finishTime1 = 1230;
        double finishTime2 = 1215;
        double finishTime3 = 1310;
        double finishTime4 = 1250;
        RaceScoreboard Jiz = new RaceScoreboard(countR, RaceName, startTime);
        Runner A = new Runner(Name1);
        Jiz.addRacer(A);
        Jiz.addRacer(Name2);
        Jiz.addRacer(Name3);
        Jiz.addRacer(Name4);
        Jiz.setRunnersStartTime();
        Jiz.setRunnerFinishTime(finishTime1, Name1);
        Jiz.setRunnerFinishTime(finishTime2, Name2);
        Jiz.setRunnerFinishTime(finishTime3, Name3);
        Jiz.setRunnerFinishTime(finishTime4, Name4);
        System.out.println(Jiz.winner().getName());
        System.out.println("Setridene podle abecedy");
        System.out.println(Jiz.startList());
        System.out.println("Setridene podle casu behu");
        System.out.println(Jiz.results());
        
    }
    
}
