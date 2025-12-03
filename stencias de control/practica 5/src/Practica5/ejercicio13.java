package Practica5;

import java.util.Scanner;

public class ejercicio13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int numero = 0, resta= 0;
		System.out.println("introduce un numero");
		numero=sc.nextInt();
		System.out.println("los numeros anteriores a el son ");
		for(int i = numero - 1; i >= 0; i-- ) 
		System.out.println(i);
	}

}
