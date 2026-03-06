package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ejer5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Queremos llevar las ventas de 6 comerciales. Primero anota el nombre de los
		 * comerciales. Después, mientras lo desee el usuario lee el nombre de comercial
		 * y las unidades vendidas por éste y acumúlalas. Al finalizar muestra por cada
		 * comercial el número de ventas realizadas.
		 */
		Scanner sc = new Scanner(System.in);
		String nombres[] = new String[6];
		String nombre = null;
		int totalventas[] = new int[6];
		int ventas=0;
		boolean correcto=false;
		System.out.println("Introduce 6 nombres:");
		for (int i = 0; i < nombres.length; i++) {
			System.out.println("nombre" + i + ":");
			nombres[i] = sc.nextLine();
		}
		Arrays.sort(nombres);
		do {
			System.out.println("introduce el nombre del  vendedor");
			nombre = sc.nextLine();
			correcto=false;
			if(nombre.equalsIgnoreCase("fin")) {
				break;
			}
			for (int i = 0; i < nombres.length; i++) {
				if (nombre.equalsIgnoreCase(nombres[i])) {
					System.out.println("introduce el numero de ventas del comerciante");
					ventas=sc.nextInt();
					totalventas[i] += ventas;
					sc.nextLine();
					correcto=true;
					break;
					}
			}
			if(correcto==false)
			System.out.println("el nombre que has introducido es invalido, vuelve ha intentarlo");
			
			} while (!nombre.equalsIgnoreCase("fin") );
		
		for (int i = 0; i < nombres.length; i++) {
			System.out.println("vendedor:"+ nombres[i] +" ventas: "+ totalventas[i]);
		}

	}

}
