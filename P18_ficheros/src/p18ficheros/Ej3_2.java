package p18ficheros;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ej3_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce ruta:");
		String ruta = sc.nextLine();
		
		Path fichero = Paths.get(ruta);
		
		System.out.println("Introduce una letra:");
		String letra=sc.nextLine();

		if (!Files.exists(fichero))
			System.out.println("No existe el fichero");
		else {
			if (!Files.isDirectory(fichero))
				System.out.println("No es un directorio");
			else {
				try {
					DirectoryStream<Path> stream = Files.newDirectoryStream(fichero);
					for (Path path : stream) {
						if (Files.isRegularFile(path) && path.getFileName().toString().startsWith(letra)) {
							System.out.println("Borrando fichero:"+ path.getFileName());
							Files.delete(path);
						}
					}
				} catch (IOException e) {
					System.err.format("%s Error permisos\n",fichero.toString() );
				}

			}
		}
	}

}
