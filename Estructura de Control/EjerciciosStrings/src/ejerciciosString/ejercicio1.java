package ejerciciosString;

import java.util.Scanner;

public class ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cadena;
		final String terminar="FIN";
		Scanner sc=new Scanner(System.in);
		/*
		do {
			System.out.println("Anota una cadena:");
			cadena=sc.nextLine();
			if (cadena.equalsIgnoreCase(terminar)==false)
				System.out.println(cadena.toUpperCase());
		}while(!cadena.equalsIgnoreCase(terminar));
		*/
		do {
			System.out.println("Anota una cadena:");
			cadena=sc.nextLine();
			if (cadena.compareToIgnoreCase(terminar)!=0)
				System.out.println(cadena.toUpperCase());
		}while(cadena.compareToIgnoreCase(terminar)!=0);
		
	}

}
