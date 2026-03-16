package ejercicio13;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class ejercicio13 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		 * 13. Programa que lee de teclado un fichero de texto con la información de
		 * varios alumnos. En cada línea separada por comas, aparece el nombre, primer
		 * apellido, nota (double) y fecha de nacimiento de cada alumno. Con los alumnos
		 * leídos crea un LinkeList, luego lo ordena por nota de mayor a menor.
		 */
		DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		int cont = 0;
		double nota = 0;
		Scanner sc = new Scanner(System.in);
		String palabra;
		LocalDate fecha = null;
		LinkedList<Alumno> lista = new LinkedList<>();
		boolean encontrado = false;
		Path file = Paths.get("entrada.txt");
		Path log = Paths.get("log.txt");
		Charset charset = Charset.forName("UTF-8");
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
			// Creamos un BuffereReader de java.io
			reader = Files.newBufferedReader(file, charset);
			//le damos los atributos de crear, escribir y adjuntar lo que escribe al final del archivo
			writer = Files.newBufferedWriter(log, charset, CREATE, WRITE, APPEND);

			String line = null;

			while ((line = reader.readLine()) != null) {
				//usamos un contador para poder señalar las lineas de errores

				cont++;
				//creamos un array de String que es basicamente la liena leida partida por comas
				String[] partes = line.split(",");
				//verificamos que la liena tenga los 5 datos que necesitamos

				if (partes.length != 4) {
					writer.write(cont + ". Número incorrecto de campos");

				} else {
					try {
						//como tenemos los datos en String debemos parsear nota a double
						nota = Double.parseDouble(partes[2]);
						//y fecha a LocalDate
						fecha = LocalDate.parse(partes[3], patron);
						//creamos el objecto llamando a los indices de nuestro array
						Alumno a = new Alumno(partes[0].trim(), partes[1].trim(), nota, fecha);
						int pos = 0;
						//usamos la funcion buscar para obtener la posicion en la que pondremos el objecto
						pos = buscar(lista, nota);
						//añadimos a nuestro Link el objecto
						lista.add(pos, a);
						
						//controlamos que la fecha tenga el formato adecuado
					} catch (DateTimeParseException e) {
						writer.write(cont + ". Formato fecha incorrecto ---" + line + "\n");
						//controlamos que la nota sea un numero valido
					} catch (NumberFormatException e) {
						System.out.println("la nota no es un numero");
						writer.write(cont + ". Numero no valido---" + line + "\n");

					}
				}

			}
			//la usamos para que el programa no pete por problemas de configuracion del archivo
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
			//cerramos reader and writer
		} finally {

			if (reader != null) {
				reader.close();
			}
			if (writer != null) {
				writer.close();
			}
//creamos la herramienta iterator para poder recorrer el LInkList
			Iterator<Alumno> it = lista.iterator();
			//el bucle seguira hasta que se encientre un objecto delante del actual
			System.out.println("Ordenada:");
			while (it.hasNext())
				//imprime la informacion del objecto
				System.out.println(it.next().toString());
//
			

		}
	}

	/*
	 * iterator es una herramineta que recorre el conjunto de los objectos que tenemos en nuestra clase es por
	 * eso que no necesitamos un for. Necesitamos tener creado el toString en
	 * nuestra clase el iteractor empieza antes del primer elemento it.hasNext:
	 * pregunta si hay un objecto delante de el it.next :salta al siguiente objecto
	 * en la lista
	 * USAR ESTE EN EL EXAMEN
	 */
	public static int buscar(LinkedList<Alumno> lista, double nota) {
		int cont = 0;

		Iterator<Alumno> it = lista.iterator();
		// Se crea una herramienta para recorrer toda la lista
		while (it.hasNext()) {

			if (it.next().getNota() < nota)

				return cont;
			cont++;
		}
		return lista.size();

	}

	// funcion sin iteractor
	/*
	 * El objecto iteractor funciona como un for_each. Realmente lo que tiene este
	 * codigo detras es un iteractor cxamuflado por este tipo de for
	 */
	public static int buscar2(LinkedList<Alumno> lista, double nota) {
		int cont = 0;
		// Este for usa un Iterator internamente
		for (Alumno a : lista) {
			if (a.getNota() < nota) {
				return cont;
			}
			cont++;
		}
		return lista.size();
	}

//funcion con un for normal 
	public static int buscar3(LinkedList<Alumno> lista, double nota) {
		for (int cont = 0; cont < lista.size(); cont++)
			if (lista.get(cont).getNota() < nota)
				return cont;

		return lista.size();

	}

}
