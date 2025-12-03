package ejerciciosString;

import java.util.Scanner;

public class eje10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Una matrícula
b. Un nif
c. Un código postal que empiece por 28.
d. Un número de teléfono que puede empezar por 6, 7 ó 9.
e. Un código de usuario que puede tener de 5 a 10 caracteres, tiene que empezar
por letra y tener después letras y números.*/
		Scanner sc=new Scanner(System.in);
		String cadena;
		int opc;
		System.out.println("introduce una cadena");
		cadena=sc.nextLine();
		System.out.println("introduce el tipo de ");
		opc=sc.nextInt();
		switch(opc) {
		case 1 :
			if(cadena.matches("^[0-9][a-zA-Z]{3}$"))
				System.out.println("codigo correcto");
			else 
				System.out.println("codigo incorrecto");
			
			break;
		case 2:
			if(cadena.matches("[0-9]{4}[a-zA-Z]{3}$"))
				System.out.println("codigo correcto");
			else 
				System.out.println("codigo incorrecto");
			
			break;
		case 3:
			if(cadena.matches("28[0-9]{3}"))
				System.out.println("codigo correcto");
			else 
				System.out.println("codigo incorrecto");
			
			break;
		case 4:
			if(cadena.matches("^(6|7|8|9)[0-9]{8}$"))
				System.out.println("codigo correcto");
			else 
				System.out.println("codigo incorrecto");
			
			break;
		case 5:
			if(cadena.matches("^[a-zA-Z][0-9a-zA-Z]{4,9}$"))
				System.out.println("codigo correcto");
			else 
				System.out.println("codigo incorrecto");
			
			break;
	}

}
}