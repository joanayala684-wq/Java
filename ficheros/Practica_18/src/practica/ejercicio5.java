package practica;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Programa que acepta el nombre de una carpeta por teclado y permita borrarla ,
		 * tanto si está vacía como si no. Si no está vacía debe pedir confirmación.
		 * Dentro de la carpeta sólo tendremos archivos
		 */
		Scanner sc = new Scanner(System.in);
		String ruta = null, nombre = null, letra;
		boolean procedimiento = false;

		System.out.println("introduce la ruta");
		ruta = sc.nextLine();
		Path fichero = Paths.get(ruta);

		if (!Files.isDirectory(fichero) && !Files.exists(fichero)) {
			System.out.println("error");

		} else {
			try {
				// intentamos borrar la carpeta. Si esta vacia ok, si no nos da una excepcion
				Files.delete(fichero);
			} catch (DirectoryNotEmptyException e) {
				// al darse la exception gestionamos el borrado de la carpeta desde aqui
				System.out.println("la carpeta tiene contenido, desea borrarla?");
				procedimiento = sc.nextBoolean();
				if (procedimiento) {
					try {
						// abrimos la carpeta y vamos leyendo su contenido. Al finalizar, la cerramos
						DirectoryStream<Path> stream = Files.newDirectoryStream(fichero);
						// recorre cada elemento de la carpeta
						for (Path path : stream) {
							Files.delete(path);
						}
						// al finalizar de borrar el contenido, borramos la carpeta
						Files.delete(fichero);
						System.out.println("carpeta borrada con exito");
					} catch (IOException e1) {
						System.out.println(e.getMessage());
					}
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
