package practica;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class extra4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Variar el anterior para que cuente las apariciones de una palabra en un
		 * fichero.
		 */
		Scanner sc = new Scanner(System.in);
		String palabra;
		boolean encontrado = false;
		Path file = Paths.get("entrada.txt");
		Charset charset = Charset.forName("UTF-8");
		BufferedReader reader = null;
		int cont = 0;

		System.out.println("introduce la palabra que quieres buscar");
		palabra = sc.nextLine();
		try {
			// Creamos un BuffereReader de java.io
			reader = Files.newBufferedReader(file, charset);
			String line = null;
			while ((line = reader.readLine()) != null) {
				// Dividimos la línea en palabras usando el espacio como tijera
			    String[] palabrasEnLinea = line.split(" ");
			    
			    for (String p : palabrasEnLinea) {
			        // Usamos .equals() porque comparamos Strings exactos
			        if (p.equalsIgnoreCase(palabra)) { 
			            cont++;
			            encontrado = true;
			        }
			    }
			}
			System.out.println("el numero de veces que sale " + palabra + "es de " + cont);
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		} finally {

			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (!encontrado) {
				System.out.println("no se ha encontrado la palabra");
			}
		}
	}

}
