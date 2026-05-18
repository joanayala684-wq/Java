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

import bbdd.BD_Wallapop;
import modelos.*;


public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DateTimeFormatter patron = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		Scanner sc = new Scanner(System.in);
		int opc = 0;
		Usuario u = null;
		BD_Wallapop bd = new BD_Wallapop("mysql-properties.xml");
		String email;
		do {
			do {
				System.out.println("introduce tu email");
				email = sc.nextLine();
				if (email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-z]{2,}$")) {
					System.out.println("Email válido.");
				} else {
					System.out.println("Formato de email incorrecto.");
				}
			} while (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-z]{2,}$"));

			try {
				u = bd.buscarUsu(email);
			} catch (ErrorBaseDatos e) {
				System.out.println(e.getMessage());
			}
			if (u == null) {
				System.out.println("el usuario no esta dado de alta");
			} else {
				System.out.println("el usuario esta dado de alta ");
			}

		} while (u == null);
		ArrayList<Anuncio> anuncios = new ArrayList<>();
		HashSet<String> categorias = null;
		try {
			categorias = bd.listarCategorias();
		} catch (ErrorBaseDatos e) {
			System.out.println(e.getMessage());
		}
		do {
			String categoria;
			do {
				System.out.println("introduce la categoria que desea filtrar");
				categoria = sc.nextLine();
				if (!categorias.contains(categoria)) {
					System.out.println("la categoria no es valida");

				}
			} while (!categorias.contains(categoria));
			System.out.println("introduce el precio minimo ");
			double p1 = sc.nextDouble();
			System.out.println("introduce el precio maximo ");
			double p2 = sc.nextDouble();
			sc.nextLine();
			try {
				anuncios = bd.buscarCuenta1(categoria, p1, p2);
			} catch (ErrorBaseDatos e) {
				System.out.println(e.getMessage());
			}
			if (anuncios.isEmpty()) {
		        System.out.println("No hay anuncios con esos filtros. Inténtalo de nuevo.");
		    }
		} while (anuncios.isEmpty());
		int cont = 0;
		System.out.println("anuncios encontrados");
		for (Anuncio a : anuncios) {
			cont++;
			System.out.println(cont + "." + a.toString());

		}
		int pos;
		do {
			System.out.println("introdice la posicion de la cuenta");
			pos = sc.nextInt();

		} while (pos < 0 || pos > anuncios.size());
		pos--;
		Anuncio a = anuncios.get(pos);
		try {
			int filas = bd.venderAnuncio(a);
			if (filas == 0)
				System.out.println("No se ha vendido el articulo. Avise a sistemas");
			else {
				System.out.println("Anuncio eliminado correctamente");
				filas = bd.altaVendido(a, u);
				if (filas == 0)
					System.out.println("No se ha vendido el articul. Avise a sistemas");
				else
					System.out.println("Anuncio vendido dado de alta");
			}
		} catch (ErrorBaseDatos e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + " Avise a sistemas");
		}
		/*
		 * Tenemos un archivo con varios productos vendidos de los cuales hay que
		 * modificar el precio de venta ya que está erróneo en la base de datos,
		 * modificar todos los productos de la tabla de vendidos que estén en el archivo
		 * con el nuevo precio usando la manera más óptima (Nota: puede haber anuncios
		 * en el archivo que no existan en la bbdd) (3
		 */
		ArrayList<Vendido> modificar = new ArrayList<>();
		ArrayList<Anuncio> alta = new ArrayList<>();

		Path file = Paths.get("vendidos");
		Path log = Paths.get("log.txt");
		Charset charset = Charset.forName("UTF-8");

		String line = null;
		cont = 0;

		try (BufferedReader reader = Files.newBufferedReader(file, charset);
				BufferedWriter writer = Files.newBufferedWriter(log, charset)) {
			while ((line = reader.readLine()) != null) {
				cont++;
				String[] partes = line.split(",");
				if (partes.length != 5) {
					writer.write(cont + ". Número incorrecto de campos\n");
				}
				
				
				else {
					
					try {
						String codigo= partes[0];
						String mail= partes[1];
						double precio = Double.parseDouble(partes[2]);
						LocalDateTime fecha = LocalDateTime.parse(partes[3], patron);
						Vendido v= new Vendido(codigo, mail, precio, fecha);
						boolean encontrado= bd.buscarCodigo(v.getCodigo());
						if (!encontrado) {
							writer.write(cont + ". Codigo de producto no valido ---" + line + "\n");
						}
						else {
						modificar.add(v);}

					} catch (DateTimeParseException e) {
						writer.write(cont + ". Formato fecha incorrecto ---" + line + "\n");
					} catch (NumberFormatException e) {
						System.out.println("el precio no es un numero");
						writer.write(cont + ". Numero no valido---" + line + "\n");

					} catch (ErrorBaseDatos e) {
						System.out.println(e.getMessage());
					}
					
				}

			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		try {
			int filas = bd.modificarSaldo(modificar);
			if (filas == 0)
				System.out.println("No se ha modificado el precio de los articulos vendidos. Avise a sistemas");
			else 
				System.out.println("Modificacion realizada correctamente");
		} catch (ErrorBaseDatos e) {
			System.out.println(e.getMessage());
		}
	}

}
