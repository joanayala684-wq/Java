package p18ficheros;

import static java.nio.file.StandardOpenOption.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @descrition Clase que arbe un archivo en forma secuencial, con stream y
 *             buffer para leer las l�neas del archivo
 * 
 */
public class Ej13_1 {

	public static void main(String[] args) throws IOException {
		double nota;
		int cont = 0;
		LocalDate fecha;
		LinkedList<Alumno> lista = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Anota el nombre del archivo:");
		String nombre = sc.nextLine();
		Path entrada = Paths.get(nombre);

		Charset charset = Charset.forName("UTF-8");
		BufferedReader reader = null;
		BufferedWriter writer = null;

		try {
			// Creamos un BuffereReader de java.io
			reader = Files.newBufferedReader(entrada, charset);
			writer = Files.newBufferedWriter(Paths.get("errores.txt"), charset, CREATE, TRUNCATE_EXISTING, WRITE);

			String line = null;
			while ((line = reader.readLine()) != null) {
				cont++;
				String resultado[] = line.split(",");
				if (resultado.length != 4) {
					writer.write(cont + ". Número incorrecto de campos");
				} else {
					try {
						nota = Double.parseDouble(resultado[2]);
						fecha = LocalDate.parse(resultado[3]);
						int pos = buscar(lista, nota);
						lista.add(pos, new Alumno(resultado[0], resultado[1], nota, fecha));
					} catch (DateTimeParseException e) {
						writer.write(cont + ". Formato fecha incorrecto ---" + line + "\n");
					} catch (NumberFormatException e) {
						writer.write(cont + ". Formato incorrecto de la nota ---" + line + "\n");
					}
				}
			}

		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		} finally {

			if (reader != null) {
				reader.close();
			}
			if (writer != null) {
				writer.close();
			}

			Iterator<Alumno> it = lista.iterator();
			while (it.hasNext())
				System.out.println(it.next().toString());

			System.out.println("Ordenada:");

		}

	}

	public static int buscar(LinkedList<Alumno> lista, double nota) {
		int cont = 0;
		Iterator<Alumno> it = lista.iterator();
		while (it.hasNext()) {
			if (it.next().getNota() < nota)
				return cont;
			cont++;
		}
		return lista.size();

	}

	public static int buscar2(LinkedList<Alumno> lista, double nota) {
		for (int cont = 0; cont < lista.size(); cont++)
			if (lista.get(cont).getNota() < nota)
				return cont;

		return lista.size();

	}

}
