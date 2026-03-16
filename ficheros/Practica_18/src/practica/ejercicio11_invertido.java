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
		/*dado dos archivos de texto. Debemos alinear los bytes, para construir el archivo original*/
		Path entrada1 = Paths.get("salida1.txt");
		Path entrada2 = Paths.get("salida2.txt");
		Path salida = Paths.get("salida.txt");
		InputStream astream = null;//leer
		InputStream bstream = null;//leer
		OutputStream estream = null;//escribir
		int a, b;
		try {
			// InputStream y OutputStream de java.io nos permiten trabajar byte a byte
			// Los generamos de forma eficiente utilizando java.nio
			astream = Files.newInputStream(entrada1);
			bstream = Files.newInputStream(entrada2);
			estream = Files.newOutputStream(salida);
			//el bucle se detendra cuando ambos archivos no tengan ningun byte pendiente de leer

			while ((a = astream.read()) != -1 && (b = bstream.read()) != -1) {
				//primero agarramos el byte de a y lo escribimos
				estream.write(a);
				//luego el de b 
				estream.write(b);
			}
			//al finalizar cerramos todo
			astream.close();
			bstream.close();
			estream.close();
		} catch (IOException io) {
			System.err.println(io);
		}
	}
}
