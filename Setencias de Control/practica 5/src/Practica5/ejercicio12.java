package Practica5;

import java.util.Scanner;

public class ejercicio12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int nota, aprobado = 0 , reprobado = 0;
		for (int i = 1; i <=10; i++) {
			System.out.println("introduce una nota");
			nota=sc.nextInt();
			if (nota >= 0 && nota <= 10 )
				if (nota <=4)
					reprobado++;
				else 
					if (nota >=5)
						aprobado++;
		}
		System.out.println("el numero de aprobados en la clase es de:" + aprobado);
		System.out.println("el numero de reprobados en la clase es de:" + reprobado);
	}

}
