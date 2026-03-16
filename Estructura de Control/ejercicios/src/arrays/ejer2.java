package arrays;

import java.util.Scanner;

public class ejer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Leed 5 números en un array, sólo dejad introducir cada número si es positivo, si no
lo es volved a pedirlo hasta que lo sea. Después recorred el array y mostrad sus
cuadrados.*/
		Scanner sc=new Scanner(System.in);
		int numeros[]=new int[5];

		System.out.println("Introduce 5 numeros:");
		for (int i =0; i < numeros.length; i++) {
			do {
			System.out.println("numeros " + i+ ":");
			numeros[i]=sc.nextInt();
			
			if(numeros[i] <0 ) 
				System.out.println("solo se admiten numeros positivos");
		
			}while(numeros[i]<0);

		}
		for(int i =0; i <numeros.length; i++) {
		int cuadrado= numeros[i]*numeros[i];
		System.out.println("el cuadrado de " +numeros[i] + " es: " + cuadrado);}
	}

}
