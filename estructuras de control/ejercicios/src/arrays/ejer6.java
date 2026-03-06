package arrays;

import java.util.Scanner;

public class ejer6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Leed números de teclado del 0 al 9 hasta que lo desee el usuario. Mostrad al
		 * finalizar cuántos números se han leído de cada uno. Usad un array de
		 * frecuencias.
		 */
		Scanner sc = new Scanner(System.in);
		int numeros[] = new int[10];
		String seguir = "no";
		int numero = 0;

		do {
			do {
					System.out.println("introduce un numero ");
					numero=sc.nextInt();
					sc.nextLine();
				if (numero < 0 || numero > 9) {
					System.out.println("el numero debe estar comprendido entre 0 y 9");
				}
			} while (numero < 0 || numero > 9);
			for (int i = 0; i < numeros.length; i++) {
				if (numero ==i) {
					numeros[i] = numeros[i] + 1;
				}
			}
			System.out.println("desea terminar?");
			seguir = sc.nextLine();
			if (seguir.equalsIgnoreCase("si")) {
				break;
			}
		} while (!seguir.equalsIgnoreCase("si"));
		
		for (int i = 0; i < numeros.length; i++) {
			System.out.println("numeros "+ i + " : "+numeros[i]);}
	}

}
