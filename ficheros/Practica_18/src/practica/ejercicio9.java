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
		/*
		 * Programa que lista los archivos de un directorio (sólo los archivos). Para
		 * cada archivo que puede leer, imprimirá su contenido en pantalla
		 */
		Scanner sc = new Scanner(System.in);
		String carpeta;
		//utlizado para leer los byte en formato UTF_8
		Charset charset = Charset.forName("UTF-8");
		System.out.println("introduce el nombre de la carpeta");
		carpeta = sc.nextLine();
		Path carp = Paths.get(carpeta);
	
		if (!Files.exists(carp)) {
			System.out.println("no existe en la carpeta");
		} else {
			if (!Files.isDirectory(carp))
				System.out.println("no es una carpeta");
			else {
				try {
					//abre la carpeta y al terminar la cierra
					DirectoryStream<Path> stream = Files.newDirectoryStream(carp);
					//mira el contenido de la acrepta uno por uno
					for (Path path : stream) {
						if (Files.isRegularFile(path)) {
							//agarramos el nombre de la caroeta y lo pasamos a string
							System.out.println(path.getFileName().toString());
							// muestro el contenido de path
							//para leer un archivo linea por linea
							BufferedReader reader = Files.newBufferedReader(path, charset);
							//declaramos line para ir capturando cada linea
							String line = null;
							//vamos leyendo el archivo hasta que line nos devuelva null(que no hay nada mas para leer xdd)
							while ((line = reader.readLine()) != null) {
								//imprimimos liena a linea el contenido del archivo
								System.out.println(line);
							}
							//cerramos buffer reader
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
