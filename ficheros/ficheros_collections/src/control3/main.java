package control3;

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
		 * archivos (no directorios) que sólo aparecen en una carpeta. Ejemplo: Si
		 * tenemos dos directorios con los siguientes archivos: Directorio1: a1, a2, a3,
		 * b1, b2 Directorio2: a2, a3, a4, b1, b3 La salida sería: a1,b2,a4,b3
		 */
		Scanner sc = new Scanner(System.in);
		String ruta = null, nombre = null;
		HashMap<String, Integer> sacos = new HashMap<String, Integer>();

		System.out.println("introduce la ruta");
		ruta = sc.nextLine();

		Path directorio1 = Paths.get(ruta);
		System.out.println("introduce la ruta");
		ruta = sc.nextLine();
		Path directorio2 = Paths.get(ruta);
		if (!Files.isDirectory(directorio2) || !Files.isDirectory(directorio1)) {
			System.out.println("ambos deben ser directorios y existir ");
			return;//salimos del programa si hay error
		} else {
			agregarNombres(sacos, directorio1);
			agregarNombres(sacos, directorio2);

			for (String nombreFichero : sacos.keySet()) {
			    if (sacos.get(nombreFichero) == 1) {
			        System.out.println(nombreFichero);
			    }
			}
		}
	}

	private static void agregarNombres(HashMap<String, Integer> sacos, Path directorio) {
	    try (DirectoryStream<Path> stream = Files.newDirectoryStream(directorio)) {
	        for (Path path : stream) {
	            if (Files.isRegularFile(path)) {
	                // IMPORTANTE: Extraer el nombre como String
	                String nombre = path.getFileName().toString();

	                if (sacos.containsKey(nombre)) {
	                    // Si ya existe, recuperamos el valor actual y sumamos 1
	                    int cuentaActual = sacos.get(nombre);
	                    sacos.put(nombre, cuentaActual + 1);
	                } else {
	                    // Si no existe, lo inicializamos en 1
	                    sacos.put(nombre, 1);
	                }
	            }
	        }
	    } catch (IOException e) {
	        System.out.println("Error al leer: " + e.getMessage());
	    }
	}
}
