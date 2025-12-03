package Practica5;

import java.util.Scanner;

public class ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc=new Scanner(System.in);
		    int numero;
		    do {
		    	System.out.println("introduce un numero");
		    	numero=sc.nextInt();
		    	if (numero >= 1) {
		    		System.out.println("el numero es positivo");}
		    	else 
		    		if (numero < 0)
		    		System.out.println("el numero es negativo");
		    }while (numero != 0);
	}

}
