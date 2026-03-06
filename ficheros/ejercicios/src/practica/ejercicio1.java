package practica;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
		
		System.out.println("Introduce ruta:");
		String ruta=sc.nextLine();
		System.out.println("Introduce nombre del fichero:");
		String nombre=sc.nextLine();
		Path fichero=Paths.get(ruta+"/"+nombre);
		int n = fichero.getNameCount();
		if (!Files.exists(fichero)) {
			System.out.println(" ese archivo no existe ");
			
		}
		else {
			for (int i=0; i < n; i++) {
				System.out.println(fichero.getName(i));
			}
		}
	}
	
}
