package Practica5;

import java.util.Scanner;

public class ejercicio17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
	    double num1, num2;
	    double suma, resta, multiplicacion, division;
	    char operacion;
	    boolean pregunta;
	    do {
	    	System.out.println("quieres realizar una operacion");
	    	pregunta=sc.nextBoolean();
	    	sc.nextLine();
	    	System.out.println("bienvenido a la calculadora virtual, introduce el tipo de operacion que quieres reslizar");
	    	operacion=sc.nextLine().charAt(0);
	    	System.out.println("introduce un numero");
	    	num1=sc.nextDouble();
	    	System.out.println("introduce un numero");
	    	num2=sc.nextDouble();
	    	switch (operacion) {
	    	case 's':
	    	case 'S':
	    	suma = num1+num2;
	    	System.out.println("la suma de los numeros es" + suma);
	        break;
	    	case 'r':
	    	case 'R':
	    	resta = num1-num2;
		    	System.out.println("la suma de los numeros es" + resta);
	    	break;
	    	case 'm':
	    	case 'M':
	    	multiplicacion = num1*num2;
	    	System.out.println("la suma de los numeros es" + multiplicacion);
	    	break;
	    	case 'd':
	    	case 'D':
	    	division = num1/num2;
		    System.out.println("la suma de los numeros es" + division);
		    break;
	    	default:
	    		System.out.println("error de caracter");
	    	}
	    }while (pregunta != false );
	}

}
