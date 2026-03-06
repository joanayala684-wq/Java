package practica;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ejercicio9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String carpeta;
		Charset charset = Charset.forName("UTF-8");
		System.out.println("introduce el nombre de la carpeta");
		carpeta = sc.nextLine();
		Path carp = Paths.get(carpeta);

		if (Files.exists(carp)) {
			System.out.println("no existe en la carpeta");
		} else {
			if (Files.isDirectory(carp))
				System.out.println("no es una carpeta");
			else {
				try {
					DirectoryStream<Path> stream = Files.newDirectoryStream(carp);
					for (Path path : stream) {
						if (Files.isRegularFile(path)) {
							System.out.println(path.getFileName().toString());
							// muestro el contenido de path
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
