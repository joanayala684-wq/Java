package p18ficheros;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class Ej10 {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Anota el nombre del archivo al que le voy a quitar las vocales:");
		String nombre=sc.nextLine();
		Path entrada = Paths.get(nombre);
		Path salida = Paths.get(nombre+"sin");
		
		InputStream istream=null;
		OutputStream ostream=null;
		int c;
		try {
			//InputStream y OutputStream de java.io nos permiten trabajar byte a byte
			//Los generamos de forma eficiente utilizando java.nio
			istream = Files.newInputStream(entrada);
			ostream = Files.newOutputStream(salida);
			while ((c = istream.read()) != -1) {
				int otro=Character.toUpperCase(c);
				if (otro!='A' && otro!='E' && otro!='I' && otro!='O' && otro!='U')
					ostream.write(c);
				//System.out.println(c);
			}
			istream.close();
			ostream.close();
		} catch (IOException io) {
			System.err.println(io);
		}
	}

}
