package Practica5;

import java.util.Scanner;

public class ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc=new Scanner(System.in);
		    int numero, contador = 0;
		    do {
		    	System.out.println("introduce un numero");
		    	numero=sc.nextInt();
		    	if (numero >= 0) {
		    		contador++;}
		    }while (numero >= 0);
		    System.out.println("se han inmtroducido" + contador + "numeros");
	}

}
