package practica;
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
public class ejercicio10_bis {

	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Anota el nombre del archivo al que le voy a quitar las vocales:");
		String nombre=sc.nextLine();
		Path entrada = Paths.get(nombre);
		Path salida = Paths.get(nombre+"sin");
		
		Charset charset = Charset.forName("UTF-8");
		BufferedReader reader = null;//
		BufferedWriter writer = null;

		try {
			// Creamos un BuffereReader de java.io
			//este nos ayuda a leer liena a linea los archivos 
			reader = Files.newBufferedReader(entrada, charset);
			//debemos darle propiedades concretas a writer para que sepa que hacer en distintas circusntacias
			//en este casolo que hace es si no existe el archivo lo crea, escribe. Si el archivo existia, borra todo y empieza a escribir
			writer = Files.newBufferedWriter(salida, charset,CREATE,WRITE,TRUNCATE_EXISTING);
						String line = null;
			while ((line = reader.readLine()) != null) {
				//agarramos la linea y reemplaxamos todas las vocales por nada, literal las borramos xd
				line=line.replaceAll("[aeiouAEIOU]", "");
				writer.write(line);
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		} finally {
			//usamos finally para siempre cerrar reader y writer (super importante hacer esto)
			if (reader != null) {
				reader.close();
			}
			if (writer != null) {
				writer.close();
			}
		}
	}

}
