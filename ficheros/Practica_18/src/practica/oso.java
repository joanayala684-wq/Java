package practica;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class oso {

	/**
	 * @descrition Clase que nos permite leer un archivo byte a byte de forma
	 *             secuencial sin buffer
	 */

	public static void main(String[] args) {
		Path entrada = Paths.get("osoconmensaje");
		Path salida = Paths.get("destino.txt");
		// Array de bytes para leer todos los bytes del archivo
		InputStream istream = null;
		OutputStream ostream = null;
		boolean detectadoPrimerMayor = false;
		boolean empezarAEscribir = false;
		int c;
		try {
			// InputStream y OutputStream de java.io nos permiten trabajar byte a byte
			// Los generamos de forma eficiente utilizando java.nio
			istream = Files.newInputStream(entrada);
			ostream = Files.newOutputStream(salida);
			while ((c = istream.read()) != -1) {
				if (empezarAEscribir) {
					ostream.write(c);
				} else {
					if (c == '>') {
						if (detectadoPrimerMayor) {
							empezarAEscribir = true;
						} else {
							detectadoPrimerMayor = true;
						}
					} else {
						detectadoPrimerMayor = false;
					}

				}
			}
			System.out.println("Proceso finalizado. Revisa mensaje_oculto.txt");
			istream.close();
			ostream.close();
		} catch (IOException io) {
			System.err.println(io);
		}
	}

}
