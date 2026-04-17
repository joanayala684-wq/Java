/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package EjemploHerencia;


public class Main {
	public static void main(String[] st){

		// En el mismo array puedo mezclar Jefes y Empleados
		Empleado plantilla[] = new Empleado[3];
		plantilla[0]=new Jefe("Félix Muñoz",200000,2,"Estefanía Sanz");
		plantilla[1]=new Empleado("Amaya Uriarte",100000,1);
		plantilla[2]=new Empleado("Luis Ricote",120000,2);

		int i;
		for(i=0; i<3; i++)
			// Ejecuta el método toString del Jefe o del Empleado dependiendo
			// de la clase a la que pertenezca el objeto guardado en  plantilla[i]
			System.out.println(plantilla[i].toString());
		for(i=0; i<3; i++)
			// Ejecuta el método del Jefe o el del Empleado dependiendo
			// de la clase a la que pertenezca el objeto guardado en plantilla[i]
			plantilla[i].aumentoSalario(5);

		for(i=0; i<3; i++)
			// Ejecuta el método toString del Jefe o del Empleado dependiendo
			// de la clase a la que pertenezca el objeto guardado en  plantilla[i]
			System.out.println(plantilla[i].toString());
		
		

		}
	
	 
}
