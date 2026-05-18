/*
 * agenda:  principal.
 */

package Cine;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

import bbdd.BD_Conector;
import modelos.*;
import bbdd.*;

public class Principal {

	public static void main(String[] args) throws IOException {
		int sala = 0;
		Scanner sc = new Scanner(System.in);

		BD_Cine bd = new BD_Cine("mysql-properties.xml");
		ArrayList<Sala> salas = null;
		ArrayList<Reserva> reservas = null;

		try {
			salas = bd.listarSalas();

			if (!salas.isEmpty()) {
				int cont = 0;
				for (Sala s : salas) {
					cont++;
					System.out.println(cont + "."+s.toString());
					System.out.println("Libres: " + s.getPlazas_ocupadas());
				}
			}
			int pos = 0;
			do {
				System.out.println("introduce la posicion de la sala");
				pos = sc.nextInt();
			} while (pos < 0 || pos > salas.size());
			pos--;
			sc.nextLine();
			System.out.println("anota el numero de entradas");
			int entradas = sc.nextInt();

			if (salas.get(pos).getPlazas_libres() < entradas) {
				
				throw new AsientosNoDisponible ("lo siento no hay butacas libres");
				
			} else {
				boolean ejecutado=false;
				Reserva r = null;
				Sala s= salas.get(pos);
				System.out.println("introduce un telefono para la reserva");
				int telefono = sc.nextInt();
				int precio = entradas * 10;
				int numSala = salas.get(pos).getSala();
				r = new Reserva(precio, entradas, numSala, telefono);
				try {
					int filas = bd.altaReserva(r);
					if (filas == 0)
						System.out.println("No se ha dado de alta el movimiento. Avise a sistemas");
					else {
						System.out.println("Reserva dada de alta");
						
						ejecutado=bd.modificarPlazasOcupadas(s, r);
						if(ejecutado) {
							System.out.println("se ha realizado la modificacion con exito");
							
						}
						else {
							System.out.println("no se ha realizado la modificacion");
							
						}
					}
				} catch (ErrorBaseDatos e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage() + " Avise a sistemas");
				}
				
			}
		} catch (ErrorBaseDatos e) {
			System.out.println(e.getMessage());
		} catch (AsientosNoDisponible e) {
			System.out.println(e.getMessage());
		}
	//recorriendo la bbdd mostrarr la pelicula con mas entradas vendidas
	//todas las reservas de esa pelicula 
		 HashMap<String, Integer> taquilla = new HashMap<String, Integer>();
		 String maxPeli = null;
		 int maxVenta=0;
		 try {
			taquilla=bd.taquilla();
			
			
			for (String pelicula : taquilla.keySet()) {
			    int total = taquilla.get(pelicula); 
			    System.out.println("Película: " + pelicula + " -> Total plazas: " + total);
			    if(total>maxVenta) {
			    	maxPeli=pelicula;
			    	maxVenta = total;
			    }
			}
		} catch (ErrorBaseDatos e) {
			System.out.println(e.getMessage() + " Avise a sistemas");
		}
		 System.out.println("la peli mas taquillera es "+ maxPeli + "con "+maxVenta+ " entradas vendidas");
		 try {
			reservas=bd.listarReservas(maxPeli);
		} catch (ErrorBaseDatos e) {
			System.out.println(e.getMessage());

		}
		
	}

}
