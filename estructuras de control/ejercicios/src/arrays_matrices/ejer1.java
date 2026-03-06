package arrays_matrices;

import java.util.Scanner;

public class ejer1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Leer una matriz de 5 filas y 4 columnas, mostrarla por pantalla y escribir el
		máximo y el mínimo.*/
		Scanner sc=new Scanner(System.in);
		final int filas=5, colum=4;
		int matriz[][] = new int[filas][colum];
		int maxm=0, minm=10;
		for(int f=0; f<filas; f++) {
			for(int c=0; c<colum; c++) {
				System.out.println("introduce un valor ");
				matriz[f][c]=sc.nextInt();
			}
		}

		for(int f=0; f<filas; f++) {
			for(int c=0; c<colum; c++) {
				System.out.print("\t"+matriz[f][c]);
			}
			System.out.println();
		}

		for(int f=0; f<filas; f++) {
			for(int c=0; c<colum; c++) {
				if(maxm<matriz[f][c])
					maxm=matriz[f][c];
				if(minm>matriz[f][c])
					minm=matriz[f][c];
			}

		}

		System.out.println("el valor mayor de la matriz es: " +maxm);

		System.out.println("el valor mayor de la matriz es: " +minm);
	}

}
