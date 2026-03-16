package arrays_matrices;

import java.util.Random;
import java.util.Scanner;

public class ejer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Programa que genera una matriz unidad cuadrada de dimensión dada.*/
		Scanner sc=new Scanner(System.in);
		int num=0;
		System.out.println("introduce la dimension que quiers darle a la matriz");
		num=sc.nextInt();
		int matriz[][] = new int[num][num];
		for(int f=0; f<num; f++) {
			for(int c=0; c<num; c++) {
				if(f==c) {
					matriz[f][c]=1;}
					else {
						matriz[f][c]=0;
					}
				}
			}
		

		for(int f=0; f<num; f++) {
			for(int c=0; c<num; c++) {
				System.out.print("\t"+matriz[f][c]);
			}
			System.out.println();

		}
	}

}
