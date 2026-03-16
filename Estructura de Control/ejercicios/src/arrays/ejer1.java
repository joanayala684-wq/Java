package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ejer1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//Leed 10 números en un array. Una vez leídos todos recorred el array y mostrad los
		//que son pares, recorredlo de nuevo para mostrar los impares.//
		
	Scanner sc=new Scanner(System.in);
	int numeros[]=new int[10];
	System.out.println("Introduce 10 numeros:");
	for (int i =1 ; i <= numeros.length; i++) {
		System.out.println("numeros " + i + ":");
		numeros[i] = sc.nextInt();
	}
	System.out.println("pares");
	for (int i = 0; i < numeros.length; i++) {
		if (numeros[i] %2==0)
			System.out.println(numeros[i]);
	}
	System.out.println("impares");
	for (int i = 0; i < numeros.length; i++) {
		if (numeros[i] %2 !=0)
			System.out.println(numeros[i]);
	}
	}
}