package StringsCorregidos;

import java.util.Scanner;

public class ejer8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String una, dos = null;
		int posicion;
		Scanner sc=new Scanner(System.in);
		System.out.println("introduce una cadena");
		una=sc.nextLine();
		if(una.length()<dos.length())
			posicion=dos.indexOf(una);
		else
			posicion=una.indexOf(dos);
		if(posicion==-1)
			System.out.println("la cadena no esta incluida");
		else
			System.out.println("cadena encontrada en la posicion" +posicion);
		
		
	}

}
