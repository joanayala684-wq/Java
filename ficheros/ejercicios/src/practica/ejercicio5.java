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
		Scanner sc = new Scanner(System.in);
		String ruta = null, nombre = null, letra;
		boolean procedimiento=false;

		System.out.println("introduce la ruta");
		ruta = sc.nextLine();
		Path fichero = Paths.get(ruta);
		
		if(!Files.isDirectory(fichero) && !Files.exists(fichero)) {
			System.out.println("error");
			
		}
		else {
			try {
				Files.delete(fichero);
			} catch (DirectoryNotEmptyException e) {
				System.out.println("la carpeta tiene contenido, desea borrarla?");
				procedimiento=sc.nextBoolean();
				if (procedimiento) {
				try {
					DirectoryStream<Path> stream = Files.newDirectoryStream(fichero);
					for (Path path : stream) {
						Files.delete(path);
					}
					Files.delete(fichero);
					System.out.println("carpeta borrada con exito");
				} catch (IOException e1) {
					System.out.println(e.getMessage());
				}}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
