package arrays;

import java.util.Scanner;

public class ejer3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*  El usuario dice cuántos números va a leer, a continuación leemos la cantidad de
números indicada y los guardamos en un array. Decid cuántas veces se repite el
último número.*/
		Scanner sc=new Scanner(System.in);
		int num=0, ultimo =0, cont=0;
		System.out.println("introduce el numero de numeros que vas a leer");
		num=sc.nextInt();
		int numeros[]=new int[num];
		for (int i =0; i < numeros.length; i++) {
			System.out.print("Número " + i + ": ");
			numeros[i] = sc.nextInt();
			
			}
		ultimo=numeros[4];
		for(int i =0; i <numeros.length; i++) {
			if(numeros[i] == ultimo) {
				cont++;
			}
		
	}
		System.out.println("el numero de veces que se repite el ultimo:"+ ultimo +" numero es " +cont);

}}
