/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ej_personas;
import java.util.*;
/**
 *
 * @author rcerrato
 */
public class EjemClases1 {
    
    public static void main(String[] args) {
        // TODO code application logic here
    Persona miPersona1, miPersona2;
    Scanner sc=new Scanner(System.in);
    miPersona1=new Persona('H');
    miPersona2=new Persona('M',"22222B",43,3,false);
    //Pedir datos de persona por teclado
    Persona miPersona3;
    System.out.print("Introduce NIF: ");
    String nif=sc.nextLine();
    System.out.print("Introduce tu edad: ");
    int e=sc.nextInt();
    System.out.append("¿Cuantos hijos tienes? ");
    int nh=sc.nextInt();
    System.out.print("¿Estás casado?(C/S)");
    boolean C=sc.nextBoolean();
    System.out.print("Introduce sexo(H/M)" );
    char s=sc.nextLine().charAt(0);
    miPersona3=new Persona(s,nif,e,nh,C);
    
    System.out.println("La edad de la primera persona es:"+miPersona1.getEdad());
    if (miPersona3.casarse()==false)
        System.out.println("¡QUE YA ESTÁS CASADOOO!!!");
    else
        System.out.println("¡ENHORABUENAAA!!!!");
    miPersona3.tenerHijos(2);
    miPersona1.cumplirAnyos();
    System.out.println(miPersona1.toString());
    System.out.println(miPersona2.toString());
    System.out.println(miPersona3.toString());
    }
    
    
    
}
