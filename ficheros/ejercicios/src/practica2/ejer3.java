package practica2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class ejer3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String ruta = null, nombre = null;

		System.out.println("introduce la ruta");
		ruta = sc.nextLine();
		
		Path fichero = Paths.get(ruta);
		if(!Files.isDirectory(fichero) && !Files.exists(fichero)) {
			System.out.println("error ");
		} else {
			try {
				DirectoryStream<Path> stream = Files.newDirectoryStream(fichero);
				for(Path path : stream) {
					if(!Files.isDirectory(path)) {
						Files.delete(path);
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
