package Practica6;

import java.util.Scanner;

public class ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int sumatotal= 0, cero = 0;
		int numero1, numero2;
		do {
			System.out.println("introduce un numero");
			numero1=sc.nextInt();
			System.out.println("introduce un numero");
			numero2=sc.nextInt();
			if (numero1==0 || numero2 ==0)
				cero++;
			sumatotal= sumatotal + numero1 +numero2;
		}while(sumatotal<100);
		System.out.println("la suma total de los numeros es de" +sumatotal);
		if (cero != 0)
		System.out.println("ha habido" + cero+ "ceros");
	}

}
