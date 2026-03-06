package practica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class extra3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String palabra;
		boolean encontrado = false;
		Path file = Paths.get("entrada.txt");
		Charset charset = Charset.forName("UTF-8");
		BufferedReader reader = null;

		System.out.println("introduce la palabra que quieres buscar");
		palabra = sc.nextLine();
		try {
			// Creamos un BuffereReader de java.io
			reader = Files.newBufferedReader(file, charset);
			String line = null;
			while ((line = reader.readLine()) != null) {
				// System.out.println(line);
				if (line.indexOf(palabra) != -1) {
					System.out.println("palabra encontrada");
					encontrado = true;
					break;
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
			if (!encontrado) {
				System.out.println("no se ha encontrado la palabra");
			}
		}
	}

}
