package ejer1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1. En una librería se guarda por cada libro: titulo, autor, editorial y
		 * precio. Hay libros normales y de texto. Estos tienen como información
		 * adicional el curso al que corresponden y además se les aplica un descuento
		 * entre el 0 y el 20%. Programa con un menú con las siguientes opciones: 1. Dar
		 * de alta libros en un ArrayList . 2. Listar todos los libros mostrando la
		 * información de cada uno. 3. Listar los libros que tienen un precio de salida
		 * menor que un precio introducido por teclado.
		 */
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Libro> libreria = new ArrayList<>();
		int opc = 0; 
		do {
			System.out.println("menu de opciones");
			System.out.println("1. Dar de alta libros en un ArrayList ");
			System.out.println(" 2. Listar todos los libros mostrando la información de cada uno. ");
			System.out.println(
					" Listar los libros que tienen un precio de salida  menor que un precio introducido por teclado ");
			opc = sc.nextInt();
			switch (opc) {
			case 1:
				System.out.println();
				libreria.add(new Libro("El Hobbit", "J,R Tolkie", "Alfaguera", 30));
				libreria.add(new Texto("Programacion", "Feliz Gomez", "Mac Grawn", 30, "DAW1", 10));
				break;
			case 2:
				Collections.sort(libreria);
				double precio = 0;
				Iterator<Libro> it = libreria.iterator();
				while (it.hasNext()) {
					Libro l = it.next();
					System.out.println(l);
				}
				break;
			case 3:
				System.out.println("introduce un precio");
				precio = sc.nextDouble();

				Iterator<Libro> p = libreria.iterator();
				while (p.hasNext()) {
					Libro l = p.next();
					if (l.getPrecio() < precio) {
						System.out.println(l);
					}

				}
				break;
			default:
				System.out.println("opcion no valida");
			}
		} while (opc != 0);

		System.out.println("A continuacion todos los cursos de los libros de texto de mi libreria");
		Iterator<Libro> cu = libreria.iterator();
		while (cu.hasNext()) {

			if (cu instanceof Texto) {
				Libro l = cu.next();
				if (cu.getClass().getSimpleName().equals("Texto "))
					System.out.println(((Texto) l).getCurso());
			}
		}

	}

}
