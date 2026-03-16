package Practica5;

import java.util.Scanner;

public class ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc=new Scanner(System.in);
		    int numero, cuadrado;
		    System.out.println("introduce un numero");
		    numero=sc.nextInt();
		    while (numero> 0) {
		    cuadrado= numero * numero;
		    System.out.println("el cuadrado del numero es:" + cuadrado);
		    System.out.println("introduce un numero");
		    numero=sc.nextInt();}
	}

}
