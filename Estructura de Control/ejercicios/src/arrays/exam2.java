package arrays;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class exam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int codigo[] = new int[12];
		int simplificado[] = new int[12];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < codigo.length; i++) {
			boolean correcto = false;
			do {
				try {
					System.out.println("introduce un valor del codigo");
					codigo[i] = sc.nextInt();
					correcto = true;
					
				} catch (InputMismatchException e) {
					System.out.println("el codigo debe contener solo numeros");
					sc.nextLine();
				}
				
			} while (!correcto);
		}
		int tope = 0;
		tope = limpiarDuplicados(codigo, simplificado);
		int limpio[] = new int[tope];
		for (int i = 0; i < tope; i++) {
		    limpio[i] = simplificado[i]; // Copia directa posición a posición
		}
		Arrays.sort(limpio);
		int usu=0;
		boolean correcto=false;
		do {
			try {
				System.out.println("introduce un valor del codigo");
				usu=sc.nextInt();
				correcto = true;
				
			} catch (InputMismatchException e) {
				System.out.println("el codigo debe contener solo numeros");
				sc.nextLine();
			}
			
		} while (!correcto);
		int pos=0;
		pos=busquedacodigo(limpio, usu);
		if(pos==-1) {
			System.out.println("lo sentimos el codigo no se enceuntra en la lista");
			
		}
		else {
			System.out.println("codigo encontrado en la posicion del array"+pos);
			System.out.println(limpio[pos]);
		}

	}

	public static int limpiarDuplicados(int codigo[], int simplificado[]) {
		int tope = 0;
		for (int i = 0; i < codigo.length; i++) {
			boolean existe = false;
			for (int j = 0; j < tope; j++) {
				if (codigo[i] == simplificado[j]) {
					existe = true;
					break;
				}

			}
			if (!existe) {
				simplificado[tope] = codigo[i];
				tope++;
			}

		}
		return tope;

	}
	public static int busquedacodigo(int limpio[], int usu) {
		
		for (int i = 0; i < limpio.length; i++) {
			if(usu==limpio[i]) {
				return i;}
		
	}
		return -1;

}}
