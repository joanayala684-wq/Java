package Practica6;

import java.util.Scanner;

public class ejercicio7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long numero;
		int cifras=0;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Anota número:");
		numero=sc.nextLong();
		
		while(numero>0) {
			numero=numero/10;
			cifras++;
		}
		System.out.println("El número de cifras es:"+cifras);
	 
	}

}
