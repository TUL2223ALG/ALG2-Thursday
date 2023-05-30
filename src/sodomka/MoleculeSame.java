/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sodomka;

/**
 *
 * @author jan.sodomka
 */
public class MoleculeSame implements Weightable<MoleculeSame> {

    Element element;
    int numberOfEl;
    double moleculeWeight;

    public MoleculeSame(Element element, int numberOfEl) {
        this.element = element;
        this.numberOfEl = numberOfEl;
        this.moleculeWeight = element.getWeight() * numberOfEl;
    }

    public Element getElement() {
        return element;
    }
    //JV gettry davaji smysl, ale aplikace potrebuje pouze setYear
    public void setElement(Element element) {
        this.element = element;
    }

    public int getNumberOfEl() {
        return numberOfEl;
    }

    public void setNumberOfEl(int numberOfEl) {
        this.numberOfEl = numberOfEl;
    }

    public void setMoleculeWeight(double moleculeWeight) {
        this.moleculeWeight = moleculeWeight;
    }

    @Override
    public double getWeight() {
        return moleculeWeight;
    }

    @Override
    public int compareTo(MoleculeSame other) {
        return Double.compare(moleculeWeight, other.getWeight());
    }

}
