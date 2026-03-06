package practica2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ejer4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String ruta = null, nombre = null, letra;

		System.out.println("introduce la ruta");
		ruta = sc.nextLine();

		Path fichero = Paths.get(ruta);
		if (!Files.isDirectory(fichero) && !Files.exists(fichero)) {
			System.out.println("error ");
		} else {
			try {
				DirectoryStream<Path> stream = Files.newDirectoryStream(fichero);
				for (Path path : stream) {
					if (!Files.isDirectory(path)) {
						System.out.println("introduce una letra");
						letra = sc.nextLine();
						if ((path.getFileName().toString()).startsWith(letra)) {
							Files.delete(path);
						} else {
							System.out.println("error");
						}
					}
				}
				stream.close();
				Files.delete(fichero);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
