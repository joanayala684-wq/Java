package Practica5;

import java.util.Scanner;

public class ejercicio8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		double salario, cont = 0;
		for (int i= 1; i <= 10 ; i++ ) {
		System.out.println("introduce un salario");
    	salario=sc.nextDouble();  
    	cont += salario;
		}
		System.out.println("la suma de los salarios introducidos es de " + cont);
	}

}
