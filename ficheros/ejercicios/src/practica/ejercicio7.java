package practica;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ejercicio7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path entrada = Paths.get("entrada.txt");
		InputStream istream = null;
		int cont = 0;
		int c;
		try {

			istream = Files.newInputStream(entrada);
			while ((c = istream.read()) != -1) {
				cont++;
			}
		} catch (IOException io) {
			System.err.println(io);
		}
		System.out.println("el numero de caracteres del fichero es " +cont);
	}
}
