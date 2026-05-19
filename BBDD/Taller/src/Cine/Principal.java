
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
			System.out.println(arr.toString());
		}
		System.out.println("\n" + "=".repeat(30));
		System.out.println("arreglos ordenados");
		Collections.sort(arreglosPendientes);
		for (Arreglo arr : arreglosPendientes) {
			System.out.println(arr.toString());
		}
		System.out.println("\n" + "=".repeat(90));
		String mat = null;
		if (!arreglosPendientes.isEmpty()) {

			boolean valido = false;
			do {
				System.out.println("introduce el numero de la matricula");
				mat = sc.nextLine();
				if (!mat.matches("^[0-9]{4}[A-Z]{3}")) {
					System.out.println("introduce una matricula valida");
				} else {
					for (Arreglo arr : arreglosPendientes) {
						if (arr.getMatricula().equals(mat)) {
							a = arr;
							valido=true;
							break;
						}
					}
					if(!valido){
						System.out.println("la matricula introducida no esta en la lista, vuelve a intentarlo");
					}
				}

			} while (!valido);

			try {
				
				cl = bd.buscarCliente(mat);
				importe = cl.pagar(a);
				System.out.println("el importe a pagar es:"+importe);
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
			System.out.println("el arreglo se ha eliminado de la lista");

			try {
				Mecanico m = bd.contarArreglos2();
				if (m != null) {
					System.out.println("el mecanico con mas arreglos realizados es:");
					System.out.println(m.toString());
				} else {
					System.out.println("error");

				}
			} catch (ErrorBaseDatos e) {
				System.out.println(e.getMessage());

			}
			try {
				Arreglo arr = bd.arregloExpensive();
				if (arr != null) {
					System.out.println("el arreglo mas costoso es::");
					System.out.println(arr.toString());
				} else {
					System.out.println("error");
				}
			} catch (ErrorBaseDatos e) {
				System.out.println(e.getMessage());

			}

		}

	}

	/*
	 * 
	 * Arreglo plantillaBusqueda = new Arreglo(mat); int indice =
	 * arreglosPendientes.indexOf(plantillaBusqueda); if (indice != -1) { // -1
	 * significa que no lo encontró Arreglo a = arreglosPendientes.get(indice); } if
	 * (indice != -1) { arreglosPendientes.remove(indice);
	 * System.out.println("Arreglo eliminado mediante su índice."); }
	 */

}
