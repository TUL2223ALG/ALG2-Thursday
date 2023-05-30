/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sodomka;

import java.util.ArrayList;

/**
 *
 * @author jan.sodomka
 */
public class PeriodicTableTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PeriodicTable table = new PeriodicTable();
        ArrayList<Element> pTable = table.PeriodicTable();

        Element H = new Element("Vodik", "H", 1, 1.01);
        Element O = new Element("Kyslik", "O", 8, 16.00);
        Element Cl = new Element("Chlor", "Cl", 17, 35.45);

        Cl.setYear(1774);

        table.addElement(H);
        table.addElement(O);
        table.addElement(Cl);

        for (int i = 0; i < pTable.size(); i++) {
            for (int j = i; j < pTable.size(); j++) {
                if (pTable.get(i).getProtNumber() > pTable.get(j).getProtNumber()) {
                    Element temp = pTable.get(i);
                    pTable.set(i, pTable.get(j));
                    pTable.set(j, temp);
                }

            }

        }
        for (Element element : pTable) {
            element.toString();
            System.out.println(element);
        }
        
        MoleculeSame H2 = new MoleculeSame (H, 2);
        MoleculeSame O3 = new MoleculeSame (O, 3);
        
        System.out.println("H2: "+H2.getWeight());
        System.out.println("O3: "+O3.getWeight());
    }

}
