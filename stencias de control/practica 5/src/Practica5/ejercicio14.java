package Practica5;

import java.util.Scanner;

public class ejercicio14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int numero = 0;
		System.out.println("introduce un numero");
		numero=sc.nextInt();
		System.out.println("los numeros pares anteriores a el son ");
		for(int i = numero - 1; i >= 0; i-- ) 
			if (i %2== 0)
			System.out.println(i);
	}

}
