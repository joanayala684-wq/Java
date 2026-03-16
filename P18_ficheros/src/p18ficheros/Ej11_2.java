package p18ficheros;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;

public class Ej11_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cont = 1;
		byte c;
		Path entrada = Paths.get("entrada.txt");
		Path salida1 = Paths.get("salida1.txt");
		Path salida2 = Paths.get("salida2.txt");

		InputStream istream = null;
		OutputStream ostream1 = null, ostream2 = null;

		try {
			istream = Files.newInputStream(entrada);
			ostream1 = Files.newOutputStream(salida1);
			ostream2 = Files.newOutputStream(salida2);

			while ((c = (byte) istream.read()) != -1) {
				if (cont % 2 == 1)
					ostream1.write(c);
				else
					ostream2.write(c);
				cont++;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (istream != null)
					istream.close();
				if (ostream1 != null)
					ostream1.close();
				if (ostream2 != null)
					ostream2.close();
			} catch (IOException e) {
				System.out.println("Error cerrando ficheros");
			}
		}
	}

}
