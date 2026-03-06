package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ejer4 {
	/*
	 * Programa que lee 5 nombres de personas. Introducirlos en un array y
	 * ordenarlos alfabéticamente (usar método sort de la clase Arrays). Llevad otro
	 * array con el número de ventas de cada uno de ellos, inicialmente cero.
	 * Comprobar si otro nombre introducido después se encuentra entre esos 5.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String nombres[] = new String[5];
		int ventas[] = new int[5];
		int cont = 0;
		System.out.println("Introduce 5 nombres:");
		for (int i = 0; i < nombres.length; i++) {
			System.out.println("nombre" + i + ":");
			nombres[i] = sc.nextLine();
		}
		Arrays.sort(nombres);
		for (int i = 0; i < nombres.length; i++) {
			System.out.println("Vendedor: " + nombres[i] + " | Ventas: " + ventas[i]);
		}
		System.out.println("introduce el nombre de tu vendedor de confianza");
		String nombre = sc.nextLine();
		for (int i = 0; i < nombres.length; i++) {
			if (nombre.equalsIgnoreCase(nombres[i]))
				cont++;
			break;
		}
		if (cont == 0) {
			System.out.println("lamentablemente no contamos con nadie con ese nombre");
		}
		if (cont > 0) {
			System.out.println("su numero de contacto es ....");

		}
	}
}
