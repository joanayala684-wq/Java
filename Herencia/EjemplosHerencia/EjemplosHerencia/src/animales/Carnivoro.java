/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animales;

public class Carnivoro extends Animal{
    private double KgCarne;

    public Carnivoro(String n,int e,double kC){
        super(n,e);
        KgCarne=kC;        
    }
    
    @Override
    public String toString(){
       // String cadena=super.toString();
       // return cadena + "\nKg. Carne: "+ KgCarne;
        return "Carnivoro:" + super.toString() + "\nKg. Carne: "+ KgCarne;
    }
}
