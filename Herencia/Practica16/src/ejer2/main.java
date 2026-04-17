package ejer2;

import java.util.ArrayList;
import utilidades.GestionFicheros; // Importas tu nueva utilidad
import java.util.Scanner;

import ejer1.Libro;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Una universidad tiene los siguientes tipos de alumnos: los extranjeros, los
		 * de curso puente, y el resto. Para todos los alumnos guardamos: nombre,
		 * apellidos, curso, e importe de la matricula. los extranjeros pagan el 15% más
		 * de tasas y nos interesa saber su país de origen, también nos interesa saber
		 * la carrera de procedencia de los alumnos de curso puente. Codificar una
		 * jerarquía de clases adecuada. Crear un array con alumnos de distintos tipos y
		 * luego mostrar la información de cada uno de ellos llamando al método
		 * toString.
		 */
		ArrayList<String> datosBrutos = GestionFicheros.leerLineas("alumnos.txt");
		Scanner sc = new Scanner(System.in);
		ArrayList<Alumno> alumnos = new ArrayList<>();

		for (String linea : datosBrutos) {
			String[] v = linea.split(";");
			String tipo = v[0];
			String nom = v[1];
			String ape = v[2];
			String cur = v[3];
			double precio = Double.parseDouble(v[4]);

			if (tipo.equalsIgnoreCase("Extranjero")) {
				String extra = v[5];
				alumnos.add(new Extranjero(nom, ape, cur, precio, extra));
			} else if (tipo.equalsIgnoreCase("Puente")) {
				String extra = v[5];
				alumnos.add(new Puente(nom, ape, cur, precio, extra));
			} else if (tipo.equalsIgnoreCase("Alumno") || tipo.equalsIgnoreCase("Normal")) {
				String extra = v[5];
				alumnos.add(new Alumno(nom, ape, cur, precio));
			}
		}
		for (Alumno a : alumnos) {
			System.out.println(a.toString());
		}
	}
	

}
