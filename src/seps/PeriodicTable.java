    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seps;

/**
 *
 * @author jiri.seps
 */

    import java.util.ArrayList;

    import java.util.List;

    public class PeriodicTable {
        private List<Element> elements;

        public PeriodicTable() {
            this.elements = new ArrayList<>();

        }

        public void addElement(String name, String symbol, int atomicNumber, double relativeAtomicMass){
            String elementString = name + ", " + symbol + ", " + atomicNumber + ", " + relativeAtomicMass;
            Element element = new Element(elementString);
            this.elements.add(element);

        }
        public Element getElements(String symbol) {
        for(Element element : elements) {
            if(element.getSymbol().equals(symbol)) {
                return element;
            }
        }
        return null;
        }
    }
