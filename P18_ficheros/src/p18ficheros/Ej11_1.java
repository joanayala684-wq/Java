package p18ficheros;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;

public class Ej11_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		byte c=0;
		Path entrada = Paths.get("entrada.txt");
		Path salida1 = Paths.get("salida1.txt");
		Path salida2 = Paths.get("salida2.txt");

		InputStream istream1 = null, istream2=null;
		OutputStream ostream = null;

		try {
			istream1 = Files.newInputStream(salida1);
			istream2 = Files.newInputStream(salida2);
			ostream = Files.newOutputStream(entrada);

			/*
			while (c!=-1) {
				c=(byte)istream1.read();
				if (c!=-1) {
					ostream.write(c);
					c=(byte)istream2.read();
					if (c!=-1)
						ostream.write(c);
				}
			}
			*/
			byte c1,c2;
			while((c1=(byte)istream1.read())!=-1 && (c2=(byte)istream2.read())!=-1) {
				ostream.write(c1);
				ostream.write(c2);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (istream1 != null)
					istream1.close();
				if (istream2 != null)
					istream2.close();
				if (ostream != null)
					ostream.close();
			} catch (IOException e) {
				System.out.println("Error cerrando ficheros");
			}
		}
	}

}
