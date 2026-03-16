package control4;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.ClosedDirectoryStreamException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Tenemos en una carpeta varios ficheros de texto cuyo nombre es el de una
		 * asignatura , en cada uno de ellos se guarda la siguiente información en cada
		 * línea: dni, nombre, apellido,nota separados por comas. Haced un programa con
		 * un menú que realice las siguientes operaciones: - Leed el nombre de una
		 * asignatura por teclado, si existe, cread un arrayList con los alumnos que
		 * hayan aprobado. - Dado el dni de un alumno mostrad sus notas en todas las
		 * asignaturas. - Ha habido un error en las calificaciones de una asignatura.
		 * Cread un nuevo fichero ordenado por notas de mayor a menor, en el que se ha
		 * sumado un punto a cada nota. Sustituir el antiguo fichero por el nuevo.
		 */
		Scanner sc = new Scanner(System.in);
		ArrayList<Alumno> lista_alumnos = new ArrayList<Alumno>();
		boolean encontrado = false;
		Path carpeta = Paths.get("carpeta");
		Path log = Paths.get("log.txt");
		Charset charset = Charset.forName("UTF-8");
		BufferedReader reader = null;
		BufferedWriter writer = null;
		HashMap<String, Alumno> alumnos = new HashMap<>();
		if (!Files.exists(carpeta) && !Files.isDirectory(carpeta)) {
			System.out.println("no existe en la carpeta");

		} else {
			try {
				DirectoryStream<Path> stream = Files.newDirectoryStream(carpeta);
				writer = Files.newBufferedWriter(log, charset, CREATE, WRITE, APPEND);
				for (Path path : stream) {
					
				}

			} catch (IOException e) {
			}
		}

	}

}
