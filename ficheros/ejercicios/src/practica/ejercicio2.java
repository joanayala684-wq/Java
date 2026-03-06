package practica;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class ejercicio2 {

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
		try {
			boolean proceder = true;
			if (!Files.exists(fichero1)) {
				System.out.println("el fichero1 no existe");
				return;
			}
			if (Files.exists(fichero2)) {
				System.out.println("el fichero2 ya existe desea sobreescribirlo true7false?");
				proceder = sc.nextBoolean();
			}
			if (proceder) {
				Files.copy(fichero1, fichero2, StandardCopyOption.REPLACE_EXISTING);
				System.out.println("Archivo copiado con éxito.");
			} else {
				System.out.println("operacion cancelada por el usuario");
			}

		} catch (IOException e) {
			System.out.println("error al copiar los archivos " + e.getMessage());
		}

	}

}
