package practica;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class extra1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String ruta = null, nombre = null;

		System.out.println("introduce la ruta");
		ruta = sc.nextLine();
		System.out.println("introduce el nombre del fichero");
		nombre = sc.nextLine();
		Path fichero1 = Paths.get(ruta + "/" + nombre);
		System.out.println("introduce la ruta");
		ruta = sc.nextLine();
		System.out.println("introduce el nombre del fichero");
		nombre = sc.nextLine();
		Path fichero2 = Paths.get(ruta + "/" + nombre);
		if (!Files.isDirectory(fichero1) || !Files.isDirectory(fichero2)) {
			System.out.println("error");
			return;
		} else {
			try {
				if (Files.isSameFile(fichero1, fichero2)) {
					System.out.println("debe introdicir dos directorios distintos");
					return;
				} else {
					try (DirectoryStream<Path> stream1 = Files.newDirectoryStream(fichero1)) {
						for (Path archivoA : stream1) {
							if (Files.isRegularFile(fichero1)) {
								String name = archivoA.getFileName().toString();
								Path archivoB = fichero2.resolve(name);

								if (Files.exists(archivoB)) {
									if (Files.exists(archivoB)) {
										System.out.println("\nArchivo repetido encontrado: " + nombre);
										System.out.println("¿Qué deseas hacer?");
										System.out.println(
												"1. Borrar del primer directorio (" + fichero1.getFileName() + ")");
										System.out.println(
												"2. Borrar del segundo directorio (" + fichero2.getFileName() + ")");
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