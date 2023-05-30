/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rychly;

import java.util.ArrayList;

/**
 *
 * @author tomas.rychly
 */
public class MoleculeSame implements Weightable {

    private ArrayList<Element> molecules; //JV stacil 1 Element a pocet
    
    public MoleculeSame(Element el, int amount) {
          ArrayList<Element> mol = new ArrayList<>();
          for (int i = 0; i < amount; i++) {
           mol.add(el);
        }
        this.molecules = mol;
    }
    
    
    
    @Override
    public double getWeight() { //JV tu stacilo nasobenie
        int total = 0;
        for (int i = 0; i < molecules.size(); i++) {
            total += molecules.get(i).getAtomWeight();
        }
        return total;
    }
    

}
