/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package EjemploHerencia;

// superclase

public class Empleado
{
	private String nombre;
	protected double salario;
	protected int antiguedad;


	public Empleado(String nom,double sal,int an){
		nombre=nom;
		salario=sal;
		antiguedad=an;
		}

	public String getNombre(){
		return nombre;
		}

	public double getSalario(){
		return salario;
		}

	public void aumentoSalario(double porcentaje){
		salario+= (salario*porcentaje)/100;
		}
	public String toString(){
		String s="\nNombre:"+nombre+",sueldo:"+
		       salario+",antiguedad:"+antiguedad;
		return s;
		}

}
