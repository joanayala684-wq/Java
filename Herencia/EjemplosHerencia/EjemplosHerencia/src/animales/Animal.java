/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package animales;


public class Animal {
    private String nombre;
    private int edad;
    
	public Animal(String n,int e){
	    nombre=n;
	    edad=e;
	}

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   public String toString (){
       return "Nombre: "+ nombre + "\nEdad: "+ edad;
   }
    
}
