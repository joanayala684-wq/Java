package control2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Stream;

import control.Propietario;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*
		 * Leed el nombre de dos carpetas por teclado y mostrad el nombre de todos los
		 * archivos (no directorios) contenidos en las carpetas sin repetirlos. Ejemplo:
		 * Si tenemos dos directorios con los siguientes archivos: Directorio1: a1, a2,
		 * a3, b1, b2 Directorio2: a2, a3, a4, b1,b3 La salida sería:
		 * a1,a2,a3,a4,b1,b2,b3
		 */
		Scanner sc = new Scanner(System.in);
		String ruta = null, nombre = null;
		HashSet<String> ficheros = new HashSet<String>();

		System.out.println("introduce la ruta");
		ruta = sc.nextLine();

		Path directorio1 = Paths.get(ruta);
		System.out.println("introduce la ruta");
		ruta = sc.nextLine();
		Path directorio2 = Paths.get(ruta);
		if (!Files.isDirectory(directorio2) || !Files.isDirectory(directorio1)) {
			System.out.println("ambos deben ser directorios y existir ");
		} else {
			agregarNombres(ficheros, directorio1);
			agregarNombres(ficheros, directorio2);

		
		for (String nombreFichero : ficheros) {
			System.out.println(nombreFichero);
		}
		}
	}

	private static void agregarNombres(HashSet<String> ficheros, Path directorio1) {
		try {
			DirectoryStream<Path> stream = Files.newDirectoryStream(directorio1);
			for (Path path : stream) {
				if (Files.isRegularFile(path)) {
					ficheros.add(path.getFileName().toString());
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
