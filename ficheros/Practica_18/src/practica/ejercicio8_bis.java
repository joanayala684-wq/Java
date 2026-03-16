package practica;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ejercicio8_bis {

	public static void main(String[] args) throws IOException {
		/*
		 * Programa que lee un archivo y cuenta las veces que se repite una letra
		 * anotada desde teclado. Lee byte a byte. Lo lee linea por linea
		 */
		Scanner sc=new Scanner(System.in);
		System.out.println("Anota nombre fichero:");
		String nombre=sc.nextLine();
		System.out.println("Introduce caracter que quieres contar:");
		char letra=sc.nextLine().charAt(0);
		Path entrada = Paths.get(nombre);
		
		Charset charset = Charset.forName("UTF-8");
		BufferedReader reader = null;
		int cont=0;

		try {
			// Creamos un BuffereReader de java.io
			reader = Files.newBufferedReader(entrada, charset);
			String line = null;
			while ((line = reader.readLine()) != null) {
				for(int i=0;i<line.length();i++)
					if (line.charAt(i)==letra)
						cont++;
			}
			System.out.println("El caracter "+letra+" aparece "+cont+" veces");
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		} finally {

			if (reader != null) {
				reader.close();
			}
		}
	}

}
