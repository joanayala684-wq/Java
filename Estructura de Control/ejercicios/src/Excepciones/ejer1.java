package Excepciones;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ejer1 {
	static Scanner sc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Haced una función que lee un double, controlando que no anoten letras
		//usando excepciones.
		double numero=0;
		sc=new Scanner (System.in);
		sc.useLocale(Locale.ENGLISH);
		numero=leerDouble();
		System.out.println("el numero leido es"+numero);
		
	}	
	public static double leerDouble() {
		double num=0;
		boolean correcto=false;
		do {
		try {
			System.out.println("anota un numero");
			num=sc.nextDouble();
			correcto=true;
		}catch(InputMismatchException e) {
			sc.nextLine();//limpiamos buffert
			System.out.println("Formato incorrecto");
			}
		}while(!correcto);
	return num;}

}
	