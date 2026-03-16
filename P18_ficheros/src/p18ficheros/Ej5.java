package p18ficheros;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ej5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce ruta:");
		String ruta = sc.nextLine();
		
		Path fichero = Paths.get(ruta);
		

		if (!Files.exists(fichero))
			System.out.println("No existe el fichero");
		else {
			try {
			Files.delete(fichero);
			System.out.println("Fichero borrado con éxito");
			}
			catch(DirectoryNotEmptyException e) {
				System.out.println("La carpeta no está vacía, vamos a borrar sus archivos");
				try {
				DirectoryStream<Path> stream = Files.newDirectoryStream(fichero);
				for (Path path : stream) {
					if (Files.isRegularFile(path) ) {
						System.out.println("Borrando fichero:"+ path.getFileName());
						Files.delete(path);
					}
				}
				Files.delete(fichero);
				}catch(IOException e2) {
					System.out.println("Error borrando ficheros");
				}
			}
			catch(IOException e) {
				System.out.println("Error recorriendo carpeta");
			}
				
			}
		}
			
	}


