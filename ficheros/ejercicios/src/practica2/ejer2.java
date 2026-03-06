package practica2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ejer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String ruta, nombre;

		System.out.println("introduce la ruta");
		ruta = sc.nextLine();
		System.out.println("introduce el nombre");
		nombre = sc.nextLine();
		Path fich = Paths.get(ruta + "/" + nombre);

		System.out.println("introduce la ruta");
		ruta = sc.nextLine();
		System.out.println("introduce el nombre");
		nombre = sc.nextLine();
		Path fich2 = Paths.get(ruta + "/" + nombre);
		boolean proceder = false;
		if (!Files.exists(fich)) {
			System.out.println("error ");
		} else {
			if (!Files.exists(fich2)) {
				System.out.println("lo copiaremos");
				try {
					Files.copy(fich, fich2);
				} catch (IOException e) {
					System.out.println("error al copiar" + e.getMessage());
				}

			} else {
				System.out.println("debes confirmar ");
				proceder = sc.nextBoolean();
				if (proceder) {
					System.out.println("lo copiaremos");
					try {
						Files.copy(fich, fich2);
					} catch (IOException e) {
						System.out.println("error al copiar" + e.getMessage());
					}
				} else {
					System.out.println("no se ha podido copiar");
				}
			}
		}

	}

}
