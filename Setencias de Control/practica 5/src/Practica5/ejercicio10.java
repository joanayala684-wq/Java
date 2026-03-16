package Practica5;

import java.util.Scanner;

public class ejercicio10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int nota;
		int reprobado = 0, aprobado = 0, notable = 0, sobresaliente = 0;
		do {
			System.out.println("introduce una nota ");
			nota=sc.nextInt();
			if (nota < 0 || nota > 10) {
				System.out.println("error de caracter" );}
			else 
				if ( nota > 0 &&nota <= 4)
					reprobado++;
				else
					if (nota >= 5 && nota <=6)
						aprobado++;
					else
						if (nota > 6 && nota <=8)
							notable++;
						else
							if (nota >= 9 && nota <=10)
								sobresaliente++;
		}while (nota != -1);
		System.out.println("el numero de reprobados es de " + reprobado);
		System.out.println("el numero de aprobados es de " + aprobado);
		System.out.println("el numero de notables es de " + notable);
		System.out.println("el numero de sobresalientes es de " + sobresaliente);
	}

}
