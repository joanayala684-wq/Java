package ejercicio13;

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
import java.util.ArrayList;
import java.util.Scanner;

public class ejercicio13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 13. Programa que lee de teclado un fichero de texto con la información de
		 * varios alumnos. En cada línea separada por comas, aparece el nombre, primer
		 * apellido, nota (double) y fecha de nacimiento de cada alumno. Con los alumnos
		 * leídos crea un ArrayList, luego lo ordena por nota de mayor a menor.
		 */
		DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		Scanner sc = new Scanner(System.in);
		String palabra;
		LocalDate fecha = null;
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		boolean encontrado = false;
		Path file = Paths.get("entrada.txt");
		Charset charset = Charset.forName("UTF-8");
		BufferedReader reader = null;
		try {
			// Creamos un BuffereReader de java.io
			reader = Files.newBufferedReader(file, charset);

			String line = null;

			while ((line = reader.readLine()) != null) {
				String[] partes = line.split(",");
				double nota;
				nota = Double.parseDouble(partes[2]);
				try {
					fecha = LocalDate.parse(partes[3], patron);
				} catch (Exception e) {
					System.out.println("formato de fecha incorrecto");
				}
				Alumno a = new Alumno(partes[0].trim(), partes[1].trim(), nota, fecha);
				int pos = 0;
				pos = clasificar(a, alumnos);
				alumnos.add(pos, a);
				alumnos.toString();
			}
			for (Alumno a : alumnos) {
				System.out.println(alumnos);
			}

		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		} finally {

			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}

	public static int clasificar(Alumno a, ArrayList<Alumno> alumnos) {
		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getNota() < a.getNota()) {
				return i;
			}
		}
		return alumnos.size();
	}

}
