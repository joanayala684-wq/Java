package practica;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ejercicio11_invertido {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path entrada1 = Paths.get("salida1.txt");
		Path entrada2 = Paths.get("salida2.txt");
		Path salida = Paths.get("salida.txt");
		// Array de bytes para leer todos los bytes del archivo
		InputStream astream = null;
		InputStream bstream = null;
		OutputStream estream = null;
		int a, b;
		try {
			// InputStream y OutputStream de java.io nos permiten trabajar byte a byte
			// Los generamos de forma eficiente utilizando java.nio
			astream = Files.newInputStream(entrada1);
			bstream = Files.newInputStream(entrada2);
			estream = Files.newOutputStream(salida);

			while ((a = astream.read()) != -1 && (b = bstream.read()) != -1) {
				estream.write(a);
				estream.write(b);
			}
			astream.close();
			bstream.close();
			estream.close();
		} catch (IOException io) {
			System.err.println(io);
		}
	}
}
