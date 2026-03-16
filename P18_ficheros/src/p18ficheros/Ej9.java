package p18ficheros;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ej9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String carpeta;
		Charset charset = Charset.forName("UTF-8");
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce nombre de la carpeta con su ruta:");
		carpeta = sc.nextLine();
		Path carp = Paths.get(carpeta);
		if (!Files.exists(carp))
			System.out.println("No existe esa carpeta");
		else {
			if (!Files.isDirectory(carp))
				System.out.println("No es una carpeta");
			else {

				try {
					DirectoryStream<Path> stream = Files.newDirectoryStream(carp);
					for (Path path : stream) {
						if (Files.isRegularFile(path)) {
							System.out.println("-----" +path.getFileName().toString()+"-----");
							//Muestro el contenido de path
							
							BufferedReader reader = Files.newBufferedReader(path, charset);
							String line = null;
							while ((line = reader.readLine()) != null) {
								System.out.println(line);
								
							}
							reader.close();
							
						}
					}
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}

			}
		}

	}

}
