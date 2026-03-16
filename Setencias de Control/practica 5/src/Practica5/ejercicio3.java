package Practica5;

import java.util.Scanner;

public class ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc=new Scanner(System.in);
		    int numero;
		    do {
		    	System.out.println("introduce un numero");
		    	numero=sc.nextInt();
		    	if (numero%2== 0 && numero !=0) {
		    		System.out.println("el numero es par");}
		    	else 
		    		System.out.println("el numero es impar");
		    }while (numero != 0);
	}

}
