package p18ficheros;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ej4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce ruta:");
		String ruta = sc.nextLine();

		Path carpeta = Paths.get(ruta);

		if (!Files.exists(carpeta))
			System.out.println("No existe la carpeta");
		else {
			if (!Files.isDirectory(carpeta))
				System.out.println("No es una carpeta");
			else {
				// Recorro la carpeta

				DirectoryStream<Path> stream;
				try {
					stream = Files.newDirectoryStream(carpeta);

					for (Path path : stream) {
						if (!Files.isDirectory(path))
							Files.delete(path);
					}
					stream.close();
					Files.delete(carpeta);
				} catch (DirectoryNotEmptyException x) {
					System.err.format("%sEl directorio no está vacío\n", carpeta);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}

			}
		}

	}

}
