package Excepciones;

import java.util.Scanner;

public class ejer4 {
	static Scanner sc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Modifica la función que valida el DNI para que dé error si los primeros
		caracteres no son dígitos usando NumberFormatException.*/
		sc = new Scanner(System.in);
		String dni="";
		do {
			System.out.println("introduce tu dni");
			dni=sc.nextLine();
			boolean verifica=validacionDni(dni);
			if (verifica)
				System.out.println("ok");
			else 
				System.out.println("poliiii");
		}while(dni.length()!=9);
		
	}
	public static boolean validacionDni(String dni) {
		
		 String numeros=dni.substring(0,8);
		 char letra=dni.charAt(dni.length()-1);
		 int numero;
		 letra=Character.toUpperCase(letra);
		 String algoritmo="TRWAGMYFPDXBNJZSQVHLCK";
		 String patron = "^[0-9]{1,8}[A-Z]$";
		 
		 if (!dni.matches(patron))
				return false;
		 try {
			  numero=Integer.parseInt(dni.substring(0, 8));
			}catch(NumberFormatException e) {
				return false;
			}
		 int resto=numero % 23;
			if(algoritmo.charAt(resto)!=letra)
				return false;
		 return true;
		}
}
