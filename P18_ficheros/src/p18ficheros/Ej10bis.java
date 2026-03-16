package p18ficheros;
import static java.nio.file.StandardOpenOption.*;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @descrition Clase que arbre un archivo en forma secuencial, con stream y
 *             buffer para leer las l�neas del archivo
 * 
 */
public class Ej10bis {

	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Anota el nombre del archivo al que le voy a quitar las vocales:");
		String nombre=sc.nextLine();
		Path entrada = Paths.get(nombre);
		Path salida = Paths.get(nombre+"sin");
		
		Charset charset = Charset.forName("UTF-8");
		BufferedReader reader = null;
		BufferedWriter writer = null;

		try {
			// Creamos un BuffereReader de java.io
			reader = Files.newBufferedReader(entrada, charset);
			writer = Files.newBufferedWriter(salida, charset,CREATE,WRITE,TRUNCATE_EXISTING);
			String line = null;
			while ((line = reader.readLine()) != null) {
				line=line.replaceAll("[aeiouAEIOU]", "");
				writer.write(line);
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		} finally {

			if (reader != null) {
				reader.close();
			}
			if (writer != null) {
				writer.close();
			}
		}
	}

}
