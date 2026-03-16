package Strings;

import java.util.Scanner;

public class ejer9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String una, dos = null;
		int posicion, numero;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("introduce una cadena");
		una=sc.nextLine();
		System.out.println("introduce una cadena");
		dos=sc.nextLine();
		numero=MayorMenor(una, dos);
		System.out.println("el numero de veces que la cadena menor se encuentra en la mayor es de " +numero);
			}
	public static int MayorMenor (String una, String dos) {
		char posicion;
		String reemplazo;
		int contador=0;
		if(una.length()<dos.length()) {
			posicion=(char) dos.indexOf(una);
			una=una.replace((char) 0, posicion);
			
			contador++;
			System.out.println(una);}
		else {
			posicion=(char) una.indexOf(dos);
			dos=dos.replace((char) 0, posicion);
			contador++;
			System.out.println(dos);}
		if(posicion==-1)
			System.out.println("la cadena no esta incluida");
		
		return contador;
		

	}
}

