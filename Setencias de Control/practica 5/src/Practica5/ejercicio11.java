package Practica5;

import java.util.Scanner;

public class ejercicio11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int numero;
		int pares = 0, impares = 0, nulo= 0;
		for (int i = 1; i <=4; i++) {
			System.out.println("introduce un numero");
			numero =sc.nextInt();
			if (numero == 0)
				nulo++;
			else
				if (numero % 2==0 ){
					pares++;}
				else 
					impares++;
		}
		System.out.println("el numero de numeros pares es de " + pares);
		System.out.println("el numero de numeros impares es de " + impares);
	}

}
