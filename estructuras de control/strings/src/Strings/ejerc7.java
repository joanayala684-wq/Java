package Strings;

import java.util.Scanner;

public class ejerc7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in); 
		/*Programa que lee una cadena y un carácter y cuenta el número de veces que
aparece dicho carácter en la cadena.*/
		String cadena, buscacaracter;
		char busca= ' ';
		System.out.println("introduce una cadena de texto");
		cadena=sc.nextLine();
		System.out.println("introduce el caracter que buscas");
		buscacaracter=sc.nextLine();
		if (cadena.length()>0) {
			busca=buscacaracter.charAt(0);
		}
		else {
			System.out.println("error, no introduciste ningun caracter");
		}
		int conteo=contarfrecuencia(cadena, busca);
		System.out.println("el caracter " + buscacaracter + "aparece" + conteo+ "veces");
	}
		public static int contarfrecuencia(String cadena, char  busca) {
			int contador=0;
			for(int i =0; i <cadena.length(); i++) {
				char actual= cadena.charAt(i);
				if(actual == busca) {
					contador++;
				}
			}
			return contador;
		}
}
