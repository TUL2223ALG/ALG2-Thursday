/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salek;

/**
 *
 * @author david.salek
 */
public class PeriodicTableTest {
    
    public static void main(String[] args){
        Element h = new Element("Vodik,H,1,1.01");
        Element o = new Element("Kyslik,O,8,16.00");
        Element cl = new Element("Chlor,Cl,17,35.45");
        
        Element te = new Element("Testium", "Te", 99, 19.84, 1984);
        System.out.println(te.getYearOfDiscovery());
        te.setYearOfDiscovery(1948);
        System.out.println(te.getYearOfDiscovery());
        
        PeriodicTable testable = new PeriodicTable();
        testable.addElement("Testium", "Te",99, 19.84);
        
        
        //vytvoreni nove tabulky prvku
        PeriodicTable table = new PeriodicTable();
        
        //pridani prvku
        table.addElement(h);
        table.addElement(o);
        //table.addElement("Kyslik,O,8,16.00");
        table.addElement(cl);
        
        //System.out.println(h.getYearOfDiscovery());
        //System.out.println(h);
        
        //nastaveni roku objeveni, pokud jeste nebyl nastaven
        System.out.println(cl.getYearOfDiscovery());
        if(cl.setYearOfDiscovery(1774)){
            System.out.println("Uspech");
        } else {
            System.out.println("Neuspech");
        }
        System.out.println(cl.getYearOfDiscovery());
        
        //vypis, bohuzel bez setrideni
        System.out.println("Vypis, bohuzel bez setrideni");
        for (Element element : table.getElements()) {
            System.out.printf("%s\n",element.toString());
        }
        
        //vytvoreni molekul
        MoleculeSame h2 = new MoleculeSame();
        h2.addElement(h);
        h2.addElement(h);
        
        MoleculeSame o3 = new MoleculeSame();
        o3.addElement(o);
        o3.addElement(o);
        o3.addElement(o);
        
        //vypis molekul
        System.out.printf("Molekula %s%s ma hmotnost %.2f\n", h2.getSymbolOfElement(), h2.getNumberOfElements(), h2.getWeight());
        System.out.printf("Molekula %s%s ma hmotnost %.2f\n", o3.getSymbolOfElement(), o3.getNumberOfElements(), o3.getWeight());
    }
    
    
}
