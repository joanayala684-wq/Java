package Strings;

import java.util.Scanner;

public class ejer4 {
/*Programa que valida un DNI introducido por teclado. Utilizar una función para
validarlo*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String dni;
		boolean validarDni;
		System.out.println("introduce tu dni");
		dni=sc.nextLine();
		validarDni=validarDNI(dni);
		if(validarDni==true)
			System.out.println("todo ok");
		else 
			System.out.println("policiaaaaaa");
	}
	public static boolean validarDNI (String dni) {
		String numeros=dni.substring(0, dni.length()-1);
		String algoritmo="TRWAGMYFPDXBNJZSQVHLCK";
		String patron = "^[0-9]{1,8}[A-Z]$";
		 char letra;
		int resto, numero;
		if (!dni.matches(patron))
				return false;
		try {
			  numero=Integer.parseInt(dni.substring(0, 8));
			}catch(NumberFormatException e) {
				return false;
			}
		resto=numero % 23;
		letra=dni.charAt(dni.length()-1);//coger el ultimo caracter de una cadena
		if(algoritmo.charAt(resto)!=letra)
				return false;
	
		return true;
		
	}
}
