/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week01_firstobject;

/**
 *
 * @author jana.vitvarova
 */
public class Moneybox {

    private String owner = "";
    private int numberOf1Crowns = 0;
    private int numberOf2Crowns = 0;

    public Moneybox(String owner, int numberOf1Crowns, int numberOf2Crowns) {
        this.owner = owner;
        this.numberOf1Crowns = numberOf1Crowns;
        this.numberOf2Crowns = numberOf2Crowns;
    }
    
    public Moneybox(String owner){
        this(owner,0,0); //volani jineho konstruktora, musi byt na prvnim radku
        /*
        this.owner = owner;
        this.numberOf1Crowns = 0;
        this.numberOf2Crowns = 0;
        */
    }

    ;
    //private int coinSummary = 0;
    
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int sum() {
        return numberOf1Crowns + (numberOf2Crowns * 2);
    }

    public int getnumberOf1Crowns() {
        return numberOf1Crowns;
    }

    public int getnumberOf2Crowns() {
        return numberOf2Crowns;
    }

    public void add1Crown() {
        this.numberOf1Crowns++;
    }

    public void add2Crown() {
        this.numberOf2Crowns++;
    }

    public void addCrowns(int count1, int count2) {
        this.numberOf1Crowns += count1;
        this.numberOf2Crowns += count2;
    }

    public void delete() {
        this.numberOf1Crowns = 0;
        this.numberOf2Crowns = 0;
    }

    public String status() { //toString
        return String.format("%s má v pokladničce %d Kč - %d x 1Kč, %d x 2Kč \n", owner, sum(), numberOf1Crowns, numberOf2Crowns);
    }

    public boolean canBuy(int price) {
        return price <= sum();
    }
}
