package Practica6;

import java.util.Scanner;

public class ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		boolean pregunta;
		double numentrada =0, recaudaciontotal=0, grupo =0;
		double numadultos, numniños, mayor = 0;
		do {
			System.out.println("introduce la cantidad de adultos");
			numadultos=sc.nextInt();
			System.out.println("introduce la cantidad de niños");
			numniños=sc.nextInt();
			System.out.println("van a ser entradas reducidas");
			pregunta=sc.nextBoolean();
			if (pregunta ==true)
				grupo= (numadultos*2) + (numniños*1.2);
			else 
				if (pregunta ==false)
				grupo=  (numadultos*3) + (numniños*2);
				else 
					System.out.println("error, caracter invalido");
			numentrada=numadultos +numniños;
			if (mayor<numentrada)
				mayor=numentrada;
			System.out.println("el total a pagar del grupo es de " + grupo);
			recaudaciontotal+=grupo;
		}while (recaudaciontotal <100);
		System.out.println("se han recaudado mas de 100 euros, la recaudacion es de " +recaudaciontotal);
		System.out.println("el mayor numero de netradas compradas por un grupo es " +mayor);
		
	}

}
