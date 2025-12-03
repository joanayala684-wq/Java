package Strings;

import java.util.Scanner;

public class ejer8 {
/*Programa que dadas dos cadenas nos dice si la menor está contenida en la
mayor y si es así nos dice la posición en la cual la ha encontrado.*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in); 
		String cadenamayor, cadenacorta;
		int posicion;
		do{
			System.out.println("introduce una cadena larga");
			cadenamayor=sc.nextLine();
			System.out.println("introduce una cadena pequeña");
			cadenacorta=sc.nextLine();
			posicion=Radar(cadenamayor, cadenacorta);
			System.out.println("la posicion en la que se encuentra la cadena corat es " +posicion);
		}while(cadenamayor.length()<cadenacorta.length());
	}
	public static int Radar (String cadena1, String cadena2) {
		int busca;
		busca=cadena1.indexOf(cadena2, 0);
		return busca;
		
	}
}
