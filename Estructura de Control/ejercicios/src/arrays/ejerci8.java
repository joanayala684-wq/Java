package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ejerci8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * codificar un programa que lea tantos enterod como deese el usuario(maximo) 20
		 * y los introduce en un array luego introducir un numero y buscarlo
		 * secuencialmente
		 */
		Scanner sc = new Scanner(System.in);
		final int TAM = 20;
		int numeros[] = new int[TAM];
		int cont = 0;
		String seguir = null;
		do {
			System.out.println("introduce un numero");
			numeros[cont] = sc.nextInt();
			cont++;
			if (cont < TAM) {
				System.out.println("deseas seguir?");
				seguir = sc.nextLine();
			}

		} while (cont < TAM && !seguir.equalsIgnoreCase("no"));

		for (int i = 0; i < cont; i++)
			System.out.println(numeros[i]);
		System.out.println("anota el numero que quieres buscar");
		int numero = sc.nextInt();

		int pos = buscar(numeros, numero, cont);
		if (pos == -1)
			System.out.println("no encontrado");
		else
			System.out.println("encontrado en la posicion;" + pos);
		
		int resultado[]=new int[cont];
		for(int i=0; i<cont ;i++)
			resultado[i]=numeros[i];
		System.out.println("array despues de ordenarlo");
		Arrays.sort(resultado);
		for (int i = 0; i < cont; i++)
			System.out.println(resultado[i]);
		/*Arrays.sort(numeross, 0, cont);
		for (int i = 0; i < cont; i++)
			System.out.println(numeros[i]);
		  */
	}

	public static int buscar(int numeros[], int num, int cont) {
		for (int i = 0; i < cont; i++) {
			if (numeros[i] == num)
				return i;
		}
		return -1;
	}
}
