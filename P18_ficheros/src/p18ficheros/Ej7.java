package p18ficheros;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *  @descrition Clase que nos permite leer un archivo byte a byte de forma secuencial sin buffer
 */
public class Ej7 {
	
	public static void main(String[] args) {
		int cont=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Anota nombre fichero:");
		String nombre=sc.nextLine();
		System.out.println("Introduce caracter que quieres contar:");
		char letra=sc.nextLine().charAt(0);
		Path entrada = Paths.get(nombre);
		InputStream istream=null;
		
		int c;
		try {
			
			istream = Files.newInputStream(entrada);
			
			while ((c = istream.read()) != -1) {
				if (c==letra)
					cont++;
				
			}
			istream.close();
			System.out.println("Total "+letra +":"+cont);
		} catch (IOException io) {
			System.err.println(io);
		}
	}

}
