package biblioteca;

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
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import modelos.*;
import bbdd.BD_Biblioteca;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DateTimeFormatter patron = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		Scanner sc = new Scanner(System.in);

		BD_Biblioteca bd = new BD_Biblioteca("mysql-properties.xml");
		int opc = 0;
		do {
			System.out.println("\n" + "=".repeat(90));

			System.out.println("ABRIENDO MENU ");
			System.out.println("1. Prestar libro");
			System.out.println("2. Añadir ejemplares");
			System.out.println("-1. Salir");
			System.out.println("\n" + "=".repeat(90));

			opc = sc.nextInt();
			sc.nextLine();
			switch (opc) {
			case 1:
				Usuario u = null;
				System.out.println("introducde el numero de usuario");
				int num = sc.nextInt();
				try {
					u = bd.buscarUsu(num);
				} catch (ErrorBaseDatos e) {
					System.out.println(e.getMessage());
				}
				if (u == null) {
					System.out.println("el usuario no existe");
					break;
				} else {
					System.out.println(u.toString());
				}
				ArrayList<Libro> librosPrestados = new ArrayList<Libro>();
				try {
					librosPrestados = bd.filtrarLibros(u);
				} catch (ErrorBaseDatos e) {
					System.out.println(e.getMessage());

				}
				if (!librosPrestados.isEmpty()) {
					for (Libro l : librosPrestados) {
						System.out.println(l.toString());
					}
				}
				if (u.getPenalizado() == 1) {
					System.out.println("el usuario esta penalizado. Fin del proceso");
					break;
				} else {
					String isbn = null;
					Libro l = null;
					do {
						System.out.println("introduce el isbn del libro");
						isbn = sc.nextLine();
						if (isbn.equalsIgnoreCase("salir")) {
							break;
						}
						try {
							l = bd.libroDisponible(isbn);

						} catch (ErrorBaseDatos e) {
							System.out.println(e.getMessage());

						}
						if (l != null) {
							break;
						}
					} while (!isbn.equalsIgnoreCase("salir"));
					try {
						int filas = bd.altaPrestamo(u, l);
						if (filas == 0)
							System.out.println("No se ha vendido el prestamo. Avise a sistemas");
						else {
							filas = bd.modificarUnidades(l);
							if (filas == 0)
								System.out.println("No se ha vendido el prestamo. Avise a sistemas");
							else
								System.out.println("se ha modificado las unidades prestadas con exito");
						}
					} catch (ErrorBaseDatos e) {
						System.out.println(e.getMessage() + " Avise a sistemas");
					}
				}

				break;
			case 2:
				HashSet<String> librosBiblio = new HashSet<String>();
				try {
					librosBiblio = bd.libros();
				} catch (ErrorBaseDatos e) {
					System.out.println(e.getMessage());

				}
				if (librosBiblio.size()>0) {
					String isbn = null;
					int unidades = 0;
					do {
						System.out.println("introduce el isbn");
						isbn = sc.nextLine();
						System.out.println("introduce el numero de unidades");
						unidades = sc.nextInt();
						if (librosBiblio.contains(isbn)) {
							int filas = 0;
							try {
								filas = bd.modificarUnidades2(isbn, unidades);
							} catch (ErrorBaseDatos e) {
								System.out.println(e.getMessage());

							}
							if (filas == 0)
								System.out.println("No se ha vendido el prestamo. Avise a sistemas");
							else {
								System.out.println("SE ha realizado la modificacion con exito");
							}
						} else {
							System.out.println("el isbn no es valido");
						}

					} while (!isbn.equalsIgnoreCase("salir"));
					int totalLibros=0;
					try {
						totalLibros=bd.totalLibros();
					} catch (ErrorBaseDatos e) {
						System.out.println(e.getMessage());

					}
					System.out.println("el numero total de ejemplares es" + totalLibros);
				}
				break;
			case -1:
				break;
			default:
				System.out.println("la opcion introducida no es valida");
			}
		} while (opc != -1);

	}

}
