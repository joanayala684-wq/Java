package wallapop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import modelos.*;
import bbdd.BD_Gestion_Vuelos;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DateTimeFormatter patron = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		Scanner sc = new Scanner(System.in);

		BD_Gestion_Vuelos bd = new BD_Gestion_Vuelos("mysql-properties.xml");
		Pasajero p = null;
		String pas;
		boolean valido = false;
		do {
			do {
				System.out.println("introduce el numero de pasaporte");
				pas = sc.nextLine();
				if (!pas.matches("[0-9]{8}[A-Z]")) {
					System.out.println("formato de pasaporte incorrecto. Vuelve a intentarlo");
				}
			} while (!pas.matches("[0-9]{8}[A-Z]"));
			try {
				p = bd.buscarUsu(pas);
				if (p != null) {
					valido = true;
				}
			} catch (ErrorBaseDatos e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}

		} while (!valido);
		ArrayList<Vuelo> destinosDisponibles= new ArrayList<Vuelo>();
		do {
		System.out.println("introduce el destino");
		String destino=sc.nextLine();
		System.out.println("introduce el importe maximo");
		double importe=sc.nextDouble();
		sc.nextLine();
		try {
			destinosDisponibles=bd.filtrarVuelos(destino, importe);
			
			
		} catch (ErrorBaseDatos e) {
			System.out.println(e.getMessage());
		}
		if(destinosDisponibles.isEmpty()) {
			System.out.println("no se ha encontradom ningun vuelo con esos criteriso. Vuelve a intentarlo");
		}
		
		}while(destinosDisponibles.size()==0);
		int cont=0;
		
		for (Vuelo v: destinosDisponibles) {
			cont++;
			System.out.println(cont+ "."+v.toString());
		}
		cont--;
		int pos = 0;
		do {
			System.out.println("introduce la posicion del vuelo que deseas");
			pos=sc.nextInt();
		}while(pos > destinosDisponibles.size() || pos < 0 );
		pos--;
		Vuelo v=destinosDisponibles.get(pos);
		
		try {
			int filas = bd.altaReserva(v, p);
			if (filas == 0)
				System.out.println("No se ha vendido el articulo. Avise a sistemas");
			else {
				System.out.println("Anuncio eliminado correctamente");
				
			}
		} catch (ErrorBaseDatos e) {
			System.out.println(e.getMessage() + " Avise a sistemas");
		}
		if(v.getAsientos_libres()==0) {
			System.out.println("lo sentimos no se puede realizar la reserva. No hay asientos libres");
		}
		else {
			try {
			int filas = bd.modificarAsientos(v.getCodigo_vuelo());
			if (filas == 0)
				System.out.println("No se ha vendido el articulo. Avise a sistemas");
			else {
				System.out.println("Reserva insertada correctamente");
				
			}
		} catch (ErrorBaseDatos e) {
			System.out.println(e.getMessage() + " Avise a sistemas");
		}
			if((v.getAsientos_libres()-1)==0) {
				try {
				int filas = bd.borrarVuelo(v.getCodigo_vuelo());
				if (filas == 0)
					System.out.println("No se ha vendido el articulo. Avise a sistemas");
				else {
					System.out.println("Reserva insertada correctamente");
					
				}
			} catch (ErrorBaseDatos e) {
				System.out.println(e.getMessage() + " Avise a sistemas");
			}
			}
			try {
				int filas = bd.modificarPuntos(p);
				if (filas == 0)
					System.out.println("No se ha vendido el articulo. Avise a sistemas");
				else {
					System.out.println("Reserva insertada correctamente");
					
				}
			} catch (ErrorBaseDatos e) {
				System.out.println(e.getMessage() + " Avise a sistemas");
			}
		}
		System.out.println(v.toString());
		System.out.println(p.toString());

	}

}
