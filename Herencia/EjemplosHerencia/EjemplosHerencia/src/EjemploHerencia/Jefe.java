/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package EjemploHerencia;



// Clase derivada de Empleado



public class Jefe extends Empleado
{
	private String ayudante; // Sólo los Jefes tienen ayudante


	public Jefe(String n,double s, int a,String sec){
		super(n,s,a);  // En la primera línea del constructor
		ayudante=sec;
		}

	// Este método sólo lo tienen los Jefes
	public String getAyudante(){
		return ayudante;
		}

	// Este método redefine el método de Empleado mismo prototipo pero diferente contenido.
	public void aumentoSalario(double porcentaje){
		double bonus = 0.5 * antiguedad;
		salario+=(salario * (bonus+porcentaje))/100;
		}

	// Este método redefine el método toString de empleado.
	public String toString()
	{
		// Llamamos al método toString del empleado y le añadimos la información del jefe
		// en este caso el ayudante.
		String s= super.toString() + ",ayudante:" + ayudante;
		return s;
	}
	
}
