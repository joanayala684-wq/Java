package p18ficheros;

import static java.nio.file.StandardOpenOption.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @descrition Clase que arbe un archivo en forma secuencial, con stream y
 *             buffer para leer las l�neas del archivo
 * 
 */
public class Ej13_2 {

	public static void main(String[] args) throws IOException {
		double nota;
		LocalDate fecha;
		ArrayList<Alumno> lista=new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Anota el nombre del archivo:");
		String nombre = sc.nextLine();
		Path entrada = Paths.get(nombre);

		Charset charset = Charset.forName("UTF-8");
		BufferedReader reader = null;

		try {
			// Creamos un BuffereReader de java.io
			reader = Files.newBufferedReader(entrada, charset);

			String line = null;
			while ((line = reader.readLine()) != null) {
				String resultado[] = line.split(",");
				try {
					nota = Double.parseDouble(resultado[2]);
				} catch (NumberFormatException e) {
					System.out.println("Formato incorrecto de la nota, leemos siguiente");
					continue;
				}
				try {
				fecha=LocalDate.parse(resultado[3]);
				}catch(DateTimeParseException e) {
					System.out.println("Formato fecha incorrecto, leemos otro alumno");
					continue;
				}
				lista.add(new Alumno(resultado[0],resultado[1],nota,fecha));
				
			}
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		} finally {

			if (reader != null) {
				reader.close();
			}
			
		Iterator<Alumno> it=lista.iterator();
		while(it.hasNext())
			System.out.println(it.next().toString());
			
		Collections.sort(lista);
		
		System.out.println("Ordenada:");
		
		for(Alumno al:lista) {
			System.out.println(al);
		}
			
		}
	}

}
