package simonv2;
/**
 *
 * @author martin.simon
 */
public class Element implements Weightable<Element> {
    private String nazev;
    private String symbol;
    private int protonCislo;
    private double relAtomHmot;
    private int rokObjeveni;
     /**
     * constructor with command
     */
    public Element(String prikaz){
        String[] parts = prikaz.split(",");
        if(parts.length >= 4){
            this.nazev = parts[0];
            this.symbol = parts[1];
            this.protonCislo = Integer.parseInt(parts[2]);
            this.relAtomHmot = Double.parseDouble(parts[3]);
            if(parts.length == 5){
                this.rokObjeveni = Integer.parseInt(parts[4]);
            }else{
                this.rokObjeveni = -1; //stejné jak v C
            }
        }else{
            System.out.println("Příkaz byl zadán špatně");
        }
    }
    /**
     * constructor with params
     */
    public Element(String nazev, String symbol, int protCislo, double relHmot) {
        this.nazev = nazev;
        this.symbol = symbol;
        this.protonCislo = protCislo;
        this.relAtomHmot = relHmot;
        this.rokObjeveni = -1; //stejné jak v C
    }
    /**
     * constructor with year
     */
     public Element(String nazev, String symbol, int protCislo, double relHmot, int rok) {
        this.nazev = nazev;
        this.symbol = symbol;
        this.protonCislo = protCislo;
        this.relAtomHmot = relHmot;
        this.rokObjeveni = rok;
    }

    public void setRokObjeveni(int rokObjeveni) {
        if(rokObjeveni==-1){
            this.rokObjeveni = rokObjeveni;
        } 
    }

    @Override
    public double getWeight() {
        return relAtomHmot;
    }

    @Override
    public int compareTo(Element other) {
        return Double.compare(relAtomHmot, other.getWeight());
    }

    @Override
    public String toString() {
        if(rokObjeveni == -1){
            return "Element{" + "nazev=" + nazev + ", symbol=" + symbol + ", protonCislo=" + protonCislo + ", relAtomHmot=" + relAtomHmot+'}';
        }else{
            return "Element{" + "nazev=" + nazev + ", symbol=" + symbol + ", protonCislo=" + protonCislo + ", relAtomHmot=" + relAtomHmot + ", rokObjeveni=" + rokObjeveni + '}';
        }
    }
    
    public String getNazev() {
        return nazev;
    }

    public String getSymbol() {
        return symbol;
    }
    public int getRokObjeveni() {
        return rokObjeveni;
    }
    
}    

    

