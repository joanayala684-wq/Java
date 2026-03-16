package Practica5;

import java.util.Scanner;
import java.util.Random;

public class ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc=new Scanner(System.in);
		    int numero;
		    int min=1;
		    int max =10;
		    int aleatorio = (int) (Math.random() * (max - min +1)) + min;
		    do {
		    	System.out.println("introduce un numero");
		    	numero=sc.nextInt();
		    	if (numero > aleatorio) 
		    	System.out.println("cerca, introduce un numero menor");
		    	if (numero < aleatorio) 
			    	System.out.println("cerca, introduce un numero mayor");
		    }while (numero != aleatorio);
		    System.out.println(" el juego ha terminado " + aleatorio + "=" + numero);
	
	}

}
