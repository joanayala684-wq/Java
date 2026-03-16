package practica;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class extra1 {

	public static void main(String[] args) {
		/*
		 * 1. Programa que lee dos rutas dos directorios distintos y muestra por
		 * pantalla el nombre de los archivos que están repetidos en ambos directorios.
		 * Según se vaya mostrando el nombre de cada archivo repetido se le da la opción
		 * al usuario de borrar el archivo del primer directorio, del segundo o ninguno.
		 */
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String ruta = null, nombre = null;

		System.out.println("introduce la ruta");
		ruta = sc.nextLine();
		System.out.println("introduce el nombre del fichero");
		nombre = sc.nextLine();
		Path carp1 = Paths.get(ruta + "/" + nombre);
		System.out.println("introduce la ruta");
		ruta = sc.nextLine();
		System.out.println("introduce el nombre del fichero");
		nombre = sc.nextLine();
		Path carp2 = Paths.get(ruta + "/" + nombre);
		// verificamos que ambos sean directorios
		if (!Files.isDirectory(carp1) || !Files.isDirectory(carp2)) {
			System.out.println("error");
			return;
		} else {
			try {
				// verificamos que sean carpetas distintas
				if (Files.isSameFile(carp1, carp2)) {
					System.out.println("debe introdicir dos directorios distintos");
					return;
				} else {
					// abrimos la primera carpeta y la cerramos al finalizar
					try (DirectoryStream<Path> stream1 = Files.newDirectoryStream(carp1)) {
						// vamos revisando cada archivo en el directorio, uno por uno
						for (Path archivoA : stream1) {
							// se verifica que sea un archivo comun
							if (Files.isRegularFile(archivoA)) {
								String name = archivoA.getFileName().toString();
								// Construimos la ruta del mismo archivo pero en la SEGUNDA carpeta
								// .resolve() es como "concatenar" rutas

								Path archivoB = carp2.resolve(name);
								// Si ese archivo existe en la carpeta B, está repetido!

								if (Files.exists(archivoB)) {
									System.out.println("\nArchivo repetido encontrado: " + nombre);
									System.out.println("¿Qué deseas hacer?");
									System.out.println("1. Borrar del primer directorio (" + carp1.getFileName() + ")");
									System.out
											.println("2. Borrar del segundo directorio (" + carp2.getFileName() + ")");
									System.out.println("3. No hacer nada");

									String opcion = sc.nextLine();

									switch (opcion) {
									case "1":
										Files.delete(archivoA);
										System.out.println("Borrado de dir1.");
										break;
									case "2":
										Files.delete(archivoB);
										System.out.println("Borrado de dir2.");
										break;
									default:
										System.out.println("No se ha borrado nada.");
										break;
									}
								}
							}
						}

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}