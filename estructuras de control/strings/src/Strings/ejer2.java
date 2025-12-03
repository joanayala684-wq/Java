package Strings;

import java.util.Scanner;

public class ejer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String pais;
		String letra;
		int cont=0;
		System.out.println("introduce una letra");
		letra=sc.nextLine();
		System.out.println("introduce un pais");
		pais=sc.nextLine();
		while(!pais.equalsIgnoreCase("fin")) { 
			
			if (pais.contains(letra));
			cont++;
			System.out.println("introduce un pais");
			pais=sc.nextLine();
		}
		System.out.println("el numero de paiese introducido que tienen la letra es" + cont);
	}

}
