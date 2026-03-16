package practica;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ejercicio10 {

	/**
	 * @descrition Clase que nos permite leer un archivo byte a byte de forma
	 *             secuencial sin buffer
	 */

	public static void main(String[] args) {
		Path entrada = Paths.get("origen.txt");
		Path salida = Paths.get("destino.txt");
		// Array de bytes para leer todos los bytes del archivo
		InputStream istream = null;//lo usamos para leer
		OutputStream ostream = null;//lo usamos para escribir
		int c;
		try {
			// InputStream y OutputStream de java.io nos permiten trabajar byte a byte
			// Los generamos de forma eficiente utilizando java.nio
			istream = Files.newInputStream(entrada);
			ostream = Files.newOutputStream(salida);
			//leemos byte a byte

			while ((c = istream.read()) != -1) {
				//verificamos que el caracter no sea una vocal
				if (c != 'a' || c != 'A' || c != 'E' || c != 'e' || c != 'i' || c != 'I' || c != 'O' || c != 'o'
						|| c != 'u' || c != 'U') {
					//si no es una vocal la escribimos en el archivo
					ostream.write(c);
				}

			}
			//debemos cerrar ambos para no saturar el sistema
			istream.close();
			ostream.close();
		} catch (IOException io) {
			System.err.println(io);
		}
	}

}
