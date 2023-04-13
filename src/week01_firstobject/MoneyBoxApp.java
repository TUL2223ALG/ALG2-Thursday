package week01_firstobject;

public class MoneyBoxApp {

    public static void main(String[] args) {

        Moneybox Alice = new Moneybox ("Alice", 5, 2);
        Moneybox Bob = new Moneybox ("Bob");
        Bob.add1Crown(); //opakovat
        Bob.add2Crown();
        Bob.addCrowns(5, 10);
        System.out.printf("Alice má %d korun\n", Alice.sum());
        System.out.printf("Bob má %d korun\n", Bob.sum());
        
        Alice.status();
        Bob.status();
        
        int gift = 39;
        
        if (Alice.canBuy(gift)) {
            System.out.println("Alice může koupit dárek");
        }
        else {System.out.println("Alice nemůže koupit dárek");}    
        
        if (Bob.canBuy(gift)) {
            System.out.println("Bob může koupit dárek");
        }
        else {System.out.println("Bob nemůže koupit dárek");}
        
        if (Alice.sum()>Bob.sum()) {
            System.out.println("Alice má víc korun");
        }
        else {System.out.println("Bob má víc korun");}
        
        Alice.addCrowns(Bob.getnumberOf1Crowns(), Bob.getnumberOf2Crowns());
        Bob.delete();
        
        Alice.status();
        Bob.status(); 
    }
}
