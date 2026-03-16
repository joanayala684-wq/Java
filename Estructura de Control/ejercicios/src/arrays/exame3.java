package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class exame3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Leed de teclado 2 arrays de 5 números. Decid: a. Qué números están en los dos
		 * arrays. 
		 * Eliminar suspensos: Crea una función que reciba un array y "elimine" (o
		 * ignore) las notas menores a 5 al pasarlas a un array final de "Excelencia".
		 * Salida: Muestra por pantalla:
		 * El array de notas comunes ordenado de menor a mayor.
		 * El array de "Excelencia" ordenado de mayor a menor.
		 */
		Scanner sc = new Scanner(System.in);
		int lista1[] = new int[5];
		int lista2[] = new int[5];
		int lista3[] = new int[5];
		int excelencia_order[] = new int[5];
		int coincidencias[] = new int[5];
		int solo1[] = new int[5];
		int cont = 0;
		boolean encontrado = false;
		System.out.println("primera lista ");
		lista1 = leerarray(sc);
		System.out.println("segunda lista ");
		lista2 = leerarray(sc);
		/* dentro del la lista uno se busca las coincidencias con la lsita2 */
		int num_coincidencias = EncontrarCoincidencia(lista1, lista2, lista3);

		System.out.println("Números en ambos arrays: ");
		for (int i = 0; i < num_coincidencias; i++) {
			coincidencias[i] = lista3[i];
		}
		Arrays.sort(coincidencias);
		for (int i = 0; i < num_coincidencias; i++) {
			System.out.println(coincidencias[i] + " ");
		}
		int excelencia[] = new int[num_coincidencias];
		int contador = filtrarExcelencia(lista3, excelencia, num_coincidencias);

		Arrays.sort(excelencia);
		for (int i = contador - 1; i >= 0; i--) {
			System.out.println(excelencia[i] + " ");
		}
		/* b. Qué números aparecen sólo en el primer array */
		int contb = 0;
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
					}
				}
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

	public static int[] leerarray(Scanner sc) {
		int lista[] = new int[5];
		int temp = 0;
		for (int i = 0; i < lista.length; i++) {
			boolean correcto = false;
			do {
				System.out.println("introduce un numero del 0 al 9");
				temp = sc.nextInt();
				if (temp < 0 || temp > 9) {
					System.out.println("el numero debe estra entre 0 y 9");
					break;
				} else
					lista[i] = temp;
				correcto = true;

			} while (!correcto);
		}
		return lista;
	}

	public static int EncontrarCoincidencia(int[] lista1, int[] lista2, int[] lista3) {
		int tope = 0;
		for (int i = 0; i < lista1.length; i++) {
			int actual = lista1[i];
			boolean encontrado = false;
			for (int j = 0; j < lista2.length; j++) {
				if (actual == lista2[j]) {
					encontrado = true;
					break;
				}

			}
			if (encontrado) {
				boolean guardado = false;
				for (int k = 0; k < tope; k++) {
					if (actual == lista3[k]) {
						guardado = true;
						break;
					}
				}
				if (!guardado) {
					lista3[tope] = actual;
					tope++;
				}
			}

		}
		return tope;
	}

	public static int filtrarExcelencia(int[] lista3, int[] excelencia, int num_coincidencias) {
		int cont = 0;
		for (int k = 0; k < num_coincidencias; k++) {
			if (lista3[k] < 5) {

			} else {
				excelencia[cont] = lista3[k];
				cont++;
			}
		}
		return cont;
	}
}
