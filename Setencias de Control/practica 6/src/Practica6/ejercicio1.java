package Practica6;

import java.util.Random;
import java.util.Scanner;

public class ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc=new Scanner(System.in);
		 Random random = new Random();
		 char aleatorio;
		 char primeraletra= 0;
		 
		 for (int i ; i< 50; i)
			 Scanner sc=new Scanner(System.in);
			int numero, digito;
			int numerotemporal = 0, numeroinvertido =0;
			System.out.println("introduce un numero");
			numero=sc.nextInt();
			numerotemporal=numero;
			while(numerotemporal !=0){
				
				digito= numerotemporal %10;
				numeroinvertido= numeroinvertido*10 + digito;
				numerotemporal=numerotemporal/10;
				System.out.println("el numero invertido es " + numeroinvertido);
		
	}

}
