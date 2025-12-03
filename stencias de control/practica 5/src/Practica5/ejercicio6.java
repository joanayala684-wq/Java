package Practica5;

import java.util.Scanner;

public class ejercicio6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
	    int numero;
	    int  suma = 0 ;
	    do {
	    	System.out.println("introduce un numero");
	    	numero=sc.nextInt();
	    	suma+= numero;
	    }while (numero != 0);
	    System.out.println("la suma de los numeros introducidos es " + suma );
	}

}
