package practica;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Modifica el programa anterior para que sólo borre los ficheros que empiecen
		 * por una letra anotada desde teclado
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
							System.out.println(
									"introduce la letra por la que deben empezar los ficheros que quieres borrar");
							String letra = sc.nextLine();
							Path name = elemento.getFileName();
							if (name.startsWith(letra)) {
								Files.delete(elemento);
								System.out.println("borrado " + elemento.getFileName());
							} else {
								System.out.println("el fichero no empieza con la letra seleccionada");
							}
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
