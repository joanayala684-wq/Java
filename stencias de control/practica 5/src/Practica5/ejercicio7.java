package Practica5;

import java.util.Scanner;

public class ejercicio7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
	    double numero;
	    double media;
	    double  suma = 0, cont = 0 ;
	    do {
	    	System.out.println("introduce un numero");
	    	numero=sc.nextDouble();  
	    	if (numero >= 0) {
	    	suma+= numero;
	    	cont++;}
	    }while (numero >=0 );
	    media= suma/cont;
	    System.out.println("la media es de " + media);
	}

}
