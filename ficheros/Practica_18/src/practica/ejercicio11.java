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
		/*
		 * Una pequeña empresa ha ideado un método para que sus archivos viajen por la
		 * red sin que nadie pueda acceder a sus datos. Para ello cada vez que va a
		 * enviar uno de ellos lo transforma en dos archivos, que son los que envía, de
		 * la siguiente manera: Fichero: Estimado señor ....... 
		 * F1: Etmd eo 
		 * F2: siaosñr
		 */
		Path entrada = Paths.get("entrada.txt");
		Path salidaA = Paths.get("salida1.txt");
		Path salidaB = Paths.get("salida2.txt");
		// Array de bytes para leer todos los bytes del archivo
		InputStream istream = null;//lee
		OutputStream astream = null;//escribe
		OutputStream bstream = null;//escribe
		int c;
		int cont = 1;
		try {
			// InputStream y OutputStream de java.io nos permiten trabajar byte a byte
			// Los generamos de forma eficiente utilizando java.nio
			istream = Files.newInputStream(entrada);
			astream = Files.newOutputStream(salidaA);
			bstream = Files.newOutputStream(salidaB);
			// Escribimos todos los bytes en el archivo salida
			// Despu�s de ejecutar comprobar que es igual a entrada
			while ((c = istream.read()) != -1) {
			
				/*usamos un contador. cuando el contador tenga un numero impar escribe en a, 
				cuando sea impar escribe en b*/
				if (cont % 2 != 0) {

					astream.write(c);

				} else {
					bstream.write(c);

				}
				//al finalizar de leer un byte incrementamos el contador 
				cont++;

			}
			//cerramos todo al finalizar 
			istream.close();
			astream.close();
			bstream.close();
		} catch (IOException io) {
			System.err.println(io);
		}

	}

}
