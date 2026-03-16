package practica;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class extra2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Programa que recibe como entrada un directorio y cambia el nombre de todos
		 * los ficheros poniendo la 1a letra en mayúsculas.
		 */
		Scanner sc = new Scanner(System.in);
		String ruta = null, nombre = null;

		System.out.println("introduce la ruta");
		ruta = sc.nextLine();
		System.out.println("introduce el nombre del fichero");
		nombre = sc.nextLine();
		Path carp1 = Paths.get(ruta + "/" + nombre);
		// verificamos que ambos sean directorios
		if (!Files.isDirectory(carp1))
			return;
		 else {
			try {
					// abrimos la primera carpeta y la cerramos al finalizar
					try (DirectoryStream<Path> stream = Files.newDirectoryStream(carp1)) {
						// vamos revisandada archivo en el directorio, uno por uno
						for (Path path : stream) {
							String nombreAntiguo= path.getFileName().toString();
							String nombreNuevo=Capitalizar(nombreAntiguo);
							// Creamos la ruta completa de DESTINO (Carpeta + Nuevo Nombre)
					        Path destino = path.resolveSibling(nombreNuevo);
							//para mover el cambio de nombre a la carpeta de destino
					
							try {
								//se pone -move, -delete en un try especifico por si acaso xddd
								Files.move(path, destino);
							} catch (Exception e) {
								System.out.println("No se pudo renombrar: " + nombreAntiguo);
							}
						}
							
					

					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						}

	}

	public static String Capitalizar(String texto) {
		//verificamos que el ombre no este vacio ni sea null
		if (texto == null || texto.isEmpty())
			return texto;
		return texto.substring(0, 1).toUpperCase() + texto.substring(1, texto.length());
	}
}
