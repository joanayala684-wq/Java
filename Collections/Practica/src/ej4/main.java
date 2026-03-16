package ej4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opc = 0, pos = 0;
		String nombre;
		double nota;
		HashMap<String, Integer> alumno = new HashMap<String, Integer>();

		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		do {
			System.out.println("1- alta ");
			System.out.println("2. Modificar ");
			System.out.println("3. sustituir alumno");
			System.out.println("4. borrar");
			System.out.println("5- buscar");
			System.out.println("6- fin ");
			opc = sc.nextInt();
			sc.nextLine();
			switch (opc) {
			case 1:
				do {
					System.out.println("introduce el noombre");
					nombre = sc.nextLine();
					if (alumno.containsKey(nombre)) {
						System.out.println("error, el alumno ya esta matriculado, vulve a intentarlo");
					}
				} while (alumno.containsKey(nombre));
				System.out.println("introduce una nota");
				nota = sc.nextDouble();
				alumno.put(nombre, (int) nota);
				sc.nextLine();
				break;
			case 2:
				do {
					System.out.println("introduce el noombre");
					nombre = sc.nextLine();
					if (alumno.containsKey(nombre)) {
						System.out.println("error, el alumno ya esta matriculado, vulve a intentarlo");
					}
				} while (alumno.containsKey(nombre));

				alumno.remove(nombre);
				System.out.println("introduce la nueva nota");
				nota = sc.nextDouble();
				alumno.put(nombre, (int) nota);
				sc.nextLine();

				break;
			case 3:
				String nuevo;
				do {
					System.out.println("introduce el noombre");
					nombre = sc.nextLine();
					if (alumno.containsKey(nombre)) {
						System.out.println("error, el alumno ya esta matriculado, vulve a intentarlo");
					}
				} while (alumno.containsKey(nombre));
				System.out.println("introduce el nuevo nombre");
				nuevo = sc.nextLine();
				System.out.println("introduce la nueva nota");
				nota = sc.nextDouble();
				
				alumno.put(nuevo, (int) nota);
				sc.nextLine();

				break;
			case 4:
				do {
					System.out.println("introduce el noombre");
					nombre = sc.nextLine();
					if (alumno.containsKey(nombre)) {
						System.out.println("error, el alumno ya esta matriculado, vulve a intentarlo");
					}
				} while (alumno.containsKey(nombre));
				alumno.remove(nombre);

				break;
			case 5:
				System.out.println("introduce nombre del alumno");
				nombre = sc.nextLine();
				if (!alumno.containsKey(nombre)) {
					System.out.println("el alumno no se encuentra matriculado en el centro");
				} else {
					System.out.println("los datos de " + nombre + "son:" + alumno.get(nombre));
				}
				break;
			}

		} while (opc != 6);

	}

}
