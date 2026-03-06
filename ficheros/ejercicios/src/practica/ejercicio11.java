package practica;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ejercicio11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path entrada = Paths.get("entrada.txt");
		Path salidaA = Paths.get("salida1.txt");
		Path salidaB = Paths.get("salida2.txt");
		// Array de bytes para leer todos los bytes del archivo
		InputStream istream = null;
		OutputStream astream = null;
		OutputStream bstream = null;
		int c;
		int cont = 1;
		try {
			// InputStream y OutputStream de java.io nos permiten trabajar byte a byte
			// Los generamos de forma eficiente utilizando java.nio
			istream = Files.newInputStream(entrada);
			astream = Files.newOutputStream(salidaA);
			bstream = Files.newOutputStream(salidaB);
			while ((c = istream.read()) != -1) {
				// Escribimos todos los bytes en el archivo salida
				// Despu�s de ejecutar comprobar que es igual a entrada
				if (cont % 2 != 0) {
					astream.write(c);

				} else {
					bstream.write(c);

				}
				cont++;

			}
			istream.close();
			astream.close();
			bstream.close();
		} catch (IOException io) {
			System.err.println(io);
		}

	}

}
