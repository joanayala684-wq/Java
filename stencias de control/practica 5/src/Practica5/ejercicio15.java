package Practica5;

import java.util.Scanner;

public class ejercicio15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int numero = 0;
		System.out.println("introduce un numero");
		numero=sc.nextInt();
		if (numero < 0 && numero > 10)
			System.out.println("el numero debe estar entre 0 y 10");
		else {
			System.out.println("la tabala de multiplicar del numero es");
		}
		for(int i = 1; i <= 10; i++) {
			System.out.println( numero + "x" + i + "=" + (numero * i));
		}
	}

}
