package practica;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Programa que acepta el nombre de una carpeta por teclado y borra todos los
		 * ficheros que contiene (sólo ficheros)
		 */
		String ruta;
		Scanner sc = new Scanner(System.in);
		System.out.println("introduce la ruta de la carpeta");
		ruta = sc.nextLine();
		Path directorio = Paths.get(ruta);// crea la ruta

		// comprueba si el directorio existe y si es un directorio
		if (Files.exists(directorio) && Files.isDirectory(directorio)) {
			// Abre y cierra la carpeta al terminar
			try (Stream<Path> contenido = Files.list(directorio)) {
				// es como un for va mirando uno por uno
				contenido.forEach(elemento -> {
					// si el elemento es un fichero
					if (Files.isRegularFile(elemento)) {
						try {
							// si todo sale bien lo borra
							Files.delete(elemento);
							System.out.println("borrado " + elemento.getFileName());
							// entra en catch si otra app tiene abierta la carpeta
						} catch (IOException e) {
							System.err.println("error al borrar el archivo " + elemento.getFileName());
						}

					} else {
						// dejamos tranquilas a las carpetas
						System.out.println(" ignorado, es una carpeta" + elemento.getFileName());
					}
				});
				System.out.println("proceso de limpieza terminado");
			} catch (IOException e) {
				System.err.println("error al borrar el archivo ");
			}

		} else {
			System.out.println("error, la ruta no existe o no es una carpeta");
		}

	}

}
