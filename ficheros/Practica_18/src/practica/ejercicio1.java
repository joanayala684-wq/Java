package practica;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Haced un programa que lea por teclado el nombre de un fichero junto con la
		 * ruta en la que se encuentra y diga si existe o no. Si no existe mostrar un
		 * error. Si existe escribid una a una las distintas carpetas de su ruta (usad
		 * métodos de la clase Path) Ejemplo, si existe el archivo
		 * c:\prueba\ficheros\mio.txt que escriba: C:\ prueba ficheros mio.txt
		 */
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce ruta:");
		String ruta = sc.nextLine();
		System.out.println("Introduce nombre del fichero:");
		String nombre = sc.nextLine();
		Path fichero = Paths.get(ruta + "/" + nombre);
		int n = fichero.getNameCount();

		if (!Files.exists(fichero)) {
			System.out.println(" ese archivo no existe ");

		} else {
			for (int i = 0; i < n; i++) {
				System.out.println(fichero.getName(i));
			}
		}
	}

}
