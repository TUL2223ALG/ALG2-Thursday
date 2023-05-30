package simonv2;

/**
 *
 * @author marts
 */
public class PeriodicTableTest {
    
    
    public static void main(String[] args){
        PeriodicTable tabulka = new PeriodicTable();
        Element vodik = new Element("Vodik, H, 1, 1.01");
        Element kyslik = new Element("Kyslik", "O", 8, 16.00);
        Element chlor1 = new Element("Chlor", "Cl",17, 35.45);
        chlor1.setRokObjeveni(1774);
        //Element chlor2 = new Element("Chlor", "Cl",17, 35.45,1774);
        //tabulka.addElement("Vodik, H, 1, 1.01");
        //tabulka.addElement("Kyslik", "O", 8, 16.00);
        //tabulka.addElement("Chlor", "Cl",17, 35.45,1774);
        
        
        tabulka.addElement(vodik);
        tabulka.addElement(kyslik);
        tabulka.addElement(chlor1);
        //tabulka.addElement(chlor2);
        
        
        for(int i = 0; i<tabulka.getSize(); i++){
            System.out.println(tabulka.getElement(i).toString());
        }
        
        
        MoleculeSame h2 = new MoleculeSame();
        MoleculeSame o3 = new MoleculeSame();
        for(int i = 0; i<2;i++){
            h2.addElement(vodik);
        }
        System.out.println(h2.getWeight());
        for(int i = 0; i<3;i++){
            o3.addElement(kyslik);
        }
        System.out.println(o3.getWeight());
        
    }
    
}
