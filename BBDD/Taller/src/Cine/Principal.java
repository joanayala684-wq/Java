/*
 * agenda:  principal.
 */

package Cine;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

import modelos.*;
import bbdd.*;

public class Principal {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		LinkedList<Arreglo> arreglosPendientes = null;
		Cliente cl = null;
		Arreglo a = null;
		BD_Taller bd = new BD_Taller("mysql-properties.xml");
		double importe = 0;
		try {
			arreglosPendientes = bd.listarSalas();
		} catch (ErrorBaseDatos e) {
			System.out.println(e.getMessage());
		}
		for (Arreglo arr : arreglosPendientes) {
			System.out.println(a.toString());
		}
		String mat = null;
		if (!arreglosPendientes.isEmpty()) {

			boolean valido = false;
			do {
				System.out.println("introduce el numero de la matricula");
				mat = sc.nextLine();
				if (!mat.matches("^[0-9]{4}[A-Z]{3}")) {
					System.out.println("introduce una matricula valida");
				} else {
					if (arreglosPendientes.contains(mat)) {

						valido = true;
					} else {
						System.out.println("la matricula introducida no esta en la lista, vuelve a intentarlo");
					}
				}
				/*
				 * v// Creamos un objeto ficticio con la matrícula a buscar Arreglo
				 * plantillaBusqueda = new Arreglo(mat);
				 * 
				 * int indice = arreglosPendientes.indexOf(plantillaBusqueda);
				 * 
				 * 
				 */
			} while (!valido);

			try {
				for (Arreglo arr : arreglosPendientes) {
					if (arr.getMatricula().equals(mat)) {
						a = arr;
						break;
					}
				}
				cl = bd.buscarCliente(mat);
				importe = cl.pagar(a);
			} catch (ErrorBaseDatos e) {
				System.out.println(e.getMessage());

			}
			try {
				int filas = bd.modificarVisitas(cl);
			} catch (ErrorBaseDatos e) {
				System.out.println(e.getMessage());

			}
			try {
				int filas = bd.modificarArreglo(a, importe);
			} catch (ErrorBaseDatos e) {
				System.out.println(e.getMessage());
			}
			
				arreglosPendientes.remove(a);
				System.out.println("el arreglo se ha aeliminado de la lista");
			
		}

	}

	/*
	 * Arreglo plantillaBusqueda = new Arreglo(mat); int indice =
	 * arreglosPendientes.indexOf(plantillaBusqueda); 
	 * if (indice != -1) { // -1
	 * significa que no lo encontró 
	 * Arreglo a = arreglosPendientes.get(indice); 
	 * } 
	 * if (indice != -1) {
	 * arreglosPendientes.remove(indice);
	 * System.out.println("Arreglo eliminado mediante su índice."); }
	 */

}
