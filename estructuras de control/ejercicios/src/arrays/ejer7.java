package arrays;

import java.util.Scanner;

public class ejer7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Leed de teclado 2 arrays de 5 números. Decid: a. Qué números están en los dos
		 * arrays. .
		 */
		Scanner sc = new Scanner(System.in);
		int lista1[] = new int[5];
		int lista2[] = new int[5];
		int coincidencias[] = new int[5];
		int solo1[] = new int[5];
		int cont = 0;
		boolean encontrado = false;
		System.out.println("primera lista ");
		for (int i = 0; i < lista1.length; i++) {
			System.out.println("introduce un numero del 0 al 9");
			lista1[i] = sc.nextInt();
		}
		System.out.println("segunda lista ");
		for (int i = 0; i < lista1.length; i++) {
			System.out.println("introduce un numero del 0 al 9");
			lista2[i] = sc.nextInt();
		}
		/*dentro del la lista uno se busca las coincidencias con la lsita2*/
		for (int i = 0; i < lista1.length; i++) {
			int numactual = lista1[i];/*se designa para poder comparar dentro de toda la lista2*/
			encontrado = false;
			for (int j = 0; j < lista2.length; j++) {
				if (numactual == lista2[j]) {
					encontrado = true;/*ha sido encontrado en la lista2*/
					break;/*salimos ya que ta no es necesario seguir viendo el resto del array*/
				}
			}

			if (encontrado) {/*debemos verfificar que el numero encontrado no se a guardado ya*/
				boolean guardado = false;
				for (int k = 0; k < cont; k++) {/*revisamos nuestro bucle */
					if (numactual == coincidencias[k]) {
						guardado = true;
						break;/*si ya ha sido guardado salimos del mismo*/
				}}
				if (!guardado) {/*al no estar en nuestra lista debemos guardadrlo*/
					coincidencias[cont] = numactual;
					cont++;/*incrementamos para señalar el numerpo de casilla en el que deberia ir la suiguinete coincidencia*/
				}
			
		
		}
		}
		System.out.println("Números en ambos arrays: ");
		for (int i = 0; i < cont; i++) {
			System.out.println(coincidencias[i] + " ");
		}
		/* b. Qué números aparecen sólo en el primer array */
		int contb=0;
		for (int i = 0; i < lista1.length; i++) {
			int numactual = lista1[i];
			encontrado = false;
			for (int j = 0; j < lista2.length; j++) {
				if (numactual == lista2[j]) {
					encontrado = true;
					break;
				}
			}
			if (!encontrado) {
				boolean guardado = false;
				for (int k = 0; k < contb; k++) {
					if (numactual == solo1[k]) {
						guardado = true;
						break;
				}}
				if (!guardado) {
					solo1[contb] = numactual;
					contb++;
				}
			}
		
		}
		
		System.out.println("Números en solo el primer array arrays: ");
		for (int i = 0; i < contb; i++) {
			System.out.println(solo1[i] + " ");
		}
	}
	
}
