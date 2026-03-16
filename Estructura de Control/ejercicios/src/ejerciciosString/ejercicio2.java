package ejerciciosString;

import java.util.Scanner;

public class ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Programa que lee nombres de ciudades europeas y cuenta cuantas empiezan
		por una letra introducida por teclado*/
		char letra,seguir;
		String cadena;
		int cont=0;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce letra:");
		letra=sc.nextLine().charAt(0);
		letra=Character.toUpperCase(letra);
		
		do {
			System.out.println("Introduce una ciudad:");
			cadena=sc.nextLine();
			cadena=cadena.toUpperCase();
			if (cadena.charAt(0)==letra)
				cont++;
			System.out.println("Desea introducir otra ciudad");
			seguir=sc.nextLine().charAt(0);
			seguir=Character.toUpperCase(seguir);
			
		}while(seguir=='S');
		
		System.out.println("Total ciudades que empiezan por "+ letra+" :"+cont);
	}

}
