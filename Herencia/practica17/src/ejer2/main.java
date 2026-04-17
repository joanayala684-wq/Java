package ejer2;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*Crear un interfaz Caducable, que tenga dos métodos, uno que diga si algo ha
	caducado y otro que nos diga cuántos días quedan para que algo caduque.
	Haced dos clases una Carnet y otra Medicamento. Añadid los atributos
	necesarios a cada clase. Las dos clases tienen algo en común, implementan el
	interfaz Caducable. Codificad un Main con un container que dentro tenga
	medicamentos y carnets, decid cuáles de ellos han caducado y de los que no
	han caducado, cuántos días les quedan para caducar.*/
		
		Scanner sc=new Scanner(System.in);
		LinkedList<Caducable > listaProductos = new LinkedList<>();
		listaProductos.add(new Medicamento("Ibuprofeno", LocalDate.of(2023, 5, 20))); // Caducado
	    listaProductos.add(new Medicamento("Paracetamol", LocalDate.now().plusMonths(6))); // Vigente
	    listaProductos.add(new Carnet("Juan Pérez", "50485848C",LocalDate.of(2026, 12, 31))); // Vigente
	    listaProductos.add(new Carnet("Marta Gómez","49876568J", LocalDate.now().minusDays(10))); // Caducado
		
	    
	    for (Caducable item : listaProductos) {
	    	System.out.println(item.toString());
	    	if (item.isCaducado()) {
	    		System.out.println("ha caducado");}
	    		else {
	    			int dias =item.diasRestantes();
	    			System.out.println("estado VIGENTE, quedan"+ dias+"dias");
	    		}
	    	}
	    
	}

}
