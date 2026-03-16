package practica;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ejercicio7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Programa que cuenta los caracteres de un archivo */
		Path entrada = Paths.get("entrada.txt");
		InputStream istream = null;
		int cont = 0;
		
		int c;//variable para guardar cada caracter
		try {
			//vamos leyendo el archivo caracter por caracter 
			istream = Files.newInputStream(entrada);
			//leemos el archivo hasta que este vacio (al estar vacio nos devolveria -1)
			while ((c = istream.read()) != -1) {
				//incrementamos el cont por cada caracter leido
				cont++;
			}
		} catch (IOException io) {
			System.err.println(io);
		}
		System.out.println("el numero de caracteres del fichero es " + cont);
	}
}
