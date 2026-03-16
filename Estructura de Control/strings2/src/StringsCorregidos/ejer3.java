package StringsCorregidos;

import java.util.Scanner;

public class ejer3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String nombre = null;
		String apellido;
		String segundo = null;
		String continuar ="S";
		int duda, duda2;
		do{
			System.out.println("introduce tu nombre");
			nombre=sc.nextLine();
			System.out.println("introduce tu apellido");
			apellido=sc.nextLine();
			duda= apellido.length();
			if (apellido.length() <3) {
				System.out.println("introduce tu segundo apellido");
				segundo=sc.nextLine();
			} 
			String codigogenerado=codigo(nombre, apellido, segundo);
			System.out.println("el codigo generado es " + codigogenerado);		
							
			System.out.println("deseas generar otro codigo");
			continuar=sc.nextLine();
		}while(continuar.equalsIgnoreCase("S")); 
	}
	public static String codigo (String n, String a1, String a2 ) {
		String parteapellido;
		n=n.substring(0,1);
		if (a1.length() >=3)
			parteapellido=a1.substring(0,3);
			else
				if(a2.length() >= 3 )
					parteapellido=a2.substring(0,3);
				else 
					if(a1.length()>a2.length())
						parteapellido=a1.substring(0,3);
					else
						parteapellido=a2.substring(0,3);
		parteapellido = n+parteapellido;
		parteapellido=parteapellido.toUpperCase();
		return parteapellido;
		
	}
	
}
