/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animales;

/**
 *
 * @author rcerrato
 */
public class Animales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Animal a;
    Carnivoro c;
    Herbivoro h;
    a=new Animal("aaaaa",1);
    c=new Carnivoro("ccccc",5,50);
    h=new Herbivoro("hhhhh",3,"heno");
    System.out.println(a.toString());
    System.out.println(c.toString());
    System.out.println(h.toString());
    
    }
}
