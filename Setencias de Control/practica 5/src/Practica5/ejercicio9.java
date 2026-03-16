package Practica5;

import java.util.Locale;
import java.util.Scanner;

public class ejercicio9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		double edad, estatura, edadmedia, estaturamedia;
		double edades = 0 , estaturas = 0, mayoredad = 0, massetenta = 0;
		for (int i = 1; i <= 5; i++) {
		System.out.println("introduce tu edad");
    	edad=sc.nextDouble();  
    	if ( edad >= 18) {
    		mayoredad++; 
    		edades += edad;}
    	else 
    		edades += edad;
    	System.out.println("introduce tu estatura");
    	estatura=sc.nextDouble();  
    	if (estatura >= 1.75) {
    		massetenta++; 
    		estaturas += estatura;}
    	else 
    		estaturas += estatura;
    	}
		estaturamedia = estaturas/5;
		edadmedia= edades/5 ;
		System.out.println("el numero de personas mayores de edad es de " + mayoredad);	
    	System.out.println("el numero de personas que miden mas de 1.75 es " + massetenta);
    	System.out.println("la edad media es de " + edadmedia);	
    	System.out.println("la estatura media es de " + estaturamedia);
		
	}
	}

