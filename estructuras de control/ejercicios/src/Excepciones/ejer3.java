package Excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ejer3 {
	static Scanner sc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*Programa que lee números de teclado hasta anotar un 0 y calcula su media.
		Usa excepciones para que si el usuario se equivoca al introducir un número se
		muestre un error y se vuelva a pedir, también usa una excepción para controlar el cero*/	
		sc = new Scanner(System.in);
		double media;
		int numero, numeros=0;
		double media1=0, cont=0;
		do {
			System.out.println("introduce un numero");
			numero=sc.nextInt();
			cont++;
			try {
				numeros+=numero;
				media1=(double)numeros/cont;
			}catch(InputMismatchException e ) {
				System.out.println("formato incorrecto");
				numero=-1;
			}catch(ArithmeticException e) {
				System.out.println("no se puede dividir entre cero, retrasado");
			}
		}while(numero!=0);
		System.out.println("la media de los numeros es de " +media1+ "%");
	}

}
