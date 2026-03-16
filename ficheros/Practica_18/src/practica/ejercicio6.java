package practica;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ejercicio6 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Voluntario: Hacer el apartado anterior sin la suposición de que sólo habrá
		 * archivos, puede haber subdirectorios. (Usad recursión)
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
				Files.delete(fichero);
			} catch (DirectoryNotEmptyException e) {
				System.out.println("la carpeta tiene contenido, desea borrarla?");
				procedimiento = sc.nextBoolean();
				if (procedimiento) {
					try {
						borrarRecursivo(fichero);
					} catch (IOException e1) {
						System.out.println(e.getMessage());
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
//usamos una funcion recursiva (que se llama a si misma) para poder optimizar el procesode si 
	//lo que se lee es un subdirectorio(teniendo mas archivos dentro de el)
	private static void borrarRecursivo(Path fichero) throws IOException {

		if (Files.isDirectory(fichero)) {
			
			try (DirectoryStream<Path> stream = Files.newDirectoryStream(fichero)) {
				for (Path path : stream) {
					//llamamos a la misma funcion para que haga trabajo en bucle
					borrarRecursivo(path);
					//si es un subdirectorio loa brimos y vamos leyendo su contenido
				}
			}
			//al terminar borramos la carpeta
			Files.delete(fichero);
			System.out.println("carpeta borrada con exito");

		}
		else {
		//si era un archivo normal se borra y ya
		Files.delete(fichero);
	}}

}
