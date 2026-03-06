package practica;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ejercicio14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 14. Programa que elimina una palabra introducida por teclado de un fichero.
		 * El nombre del fichero de entrada y el de salida se introducen por teclado y
		 * no pueden coincidir.
		 */
		Scanner sc = new Scanner(System.in);
		boolean encontrado = false;
		Path file = Paths.get("entrada.txt");
		Path fileOut = Paths.get("copiado.txt");
		Charset charset = Charset.forName("UTF-8");
		BufferedReader reader = null;
		BufferedWriter writer = null;
		String palabra;

		System.out.println("introduce una palabra para eliminar");
		palabra = sc.nextLine();
		try {
			// Creamos un BuffereReader de java.io
			reader = Files.newBufferedReader(file, charset);
			writer = Files.newBufferedWriter(fileOut, charset, CREATE, WRITE);
			String line = null;
			while ((line = reader.readLine()) != null) {
				// System.out.println(line);
				if (line.indexOf(palabra) != -1) {
					System.out.println("palabra encontrada");
					encontrado = true;
				}
			}

		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		} finally {

			if (reader != null) {
				try {
					reader.close();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}
}
