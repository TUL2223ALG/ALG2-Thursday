/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seps;

/**
 *
 * @author jiri.seps
 */
public class MoleculeSame implements Weightable {
    private Element element;
    private int quantity;
    
    public MoleculeSame(Element element, int quantity) {
        this.element = element;
        this.quantity = quantity;
    }
    
    @Override
    public double getWeight() {
        return this.element.getWeight() * this.quantity;
    }
}
