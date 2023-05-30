package simon;

import java.util.ArrayList;
/**
 *
 * @author martin.simon
 */
public class MoleculeSame implements Weightable<MoleculeSame> {//JV mela reprezentovat latku, ktera vznikne sloucenim vic stejnych prvku
    private ArrayList<Element> elements; //JV stacil Element a pocet

    public MoleculeSame() {
        this.elements = new ArrayList<>();
    }
    /**
     * adding created element
     */
    public void addElement(Element element) {
        elements.add(element);
    }
    /**
     * creates and adds element
     */
    public void addElement(String a){
        Element temp = new Element(a);
        addElement(temp);
    }
    /**
     * creates and adds element
     */
    public void addElement(String nazev, String symbol, int protCislo, double relHmot){
        Element temp = new Element(nazev,symbol,protCislo,relHmot);
        addElement(temp);
    }
    /**
     * creates and adds element
     */
    public void addElement(String nazev, String symbol, int protCislo, double relHmot, int rok){
        Element temp = new Element(nazev,symbol,protCislo,relHmot,rok);
        addElement(temp);
    }
    /**
     * gets array
     */
    public ArrayList<Element> getElements() {
        return elements; //JV defenzivni kopie
    }

    @Override
    public double getWeight() {
        double weightSum = 0.0;
        for (Element element : elements) {
            weightSum += element.getWeight();
        }
        return weightSum;
    }

    @Override
    public int compareTo(MoleculeSame other) {
        return Double.compare(getWeight(), other.getWeight());
    }
    
    public void addElements(Element a, int b){
        for(int i = 0;i<b;i++){
            addElement(a);
        }
    }
}
