package arrays;

import java.util.Scanner;

public class exam1 {
	/*Ejercicio 1: Gestión de Temperaturas
Este ejercicio se enfoca en el procesamiento estadístico y el filtrado de datos.

Lectura y Validación: Crea una función que lea 7 temperaturas (una para cada día de la semana) y las guarde en un array. Deben estar en un rango de -20 a 50 grados. Si no es válida, se pide de nuevo.

Cálculo de Media: Crea una función que reciba el array y devuelva la temperatura media.

Filtrado: Pide al usuario un "valor umbral". Copia en un segundo array todas las temperaturas que sean estrictamente superiores a esa media.

Extremos: Encuentra y muestra la temperatura máxima y la mínima del segundo array.*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double temperaturas[] = new double[7];
		double umbral[]=new double [7];
		double media, valorUmbral;
		int cont;
		rellenartemp(temperaturas, sc);
		
		System.out.println("Array rellenado con exito");
		media=CalcularMed(temperaturas);
		System.out.println("la media de las temperaturas de la semana es de "+media);
		System.out.println("introduce un valor umbral para el filtrado");
		valorUmbral=sc.nextDouble();
		System.out.println("las tempperaturas que superan el umbral son:");
		cont=filtrarValor(umbral, temperaturas,  valorUmbral);
		for (int i = 0; i < cont; i++) {
			System.out.println(umbral[i]);
		}
		double max=0, min=0;
		max=MaxTemp(umbral, cont);
		System.out.println("la maxima temperatura regustrada en el ultimo array es de "+ max);
		max=MinTemp(umbral, cont);
		System.out.println("la maxima temperatura regustrada en el ultimo array es de "+ min);
		
		
	}
	public static void rellenartemp(double[] temperaturas, Scanner sc) {
		for (int i = 0; i < temperaturas.length; i++) {
			double temp = 0;
			do {
				System.out.println("introduce la temperatura del dia dela semana, dia num: " + (i+1));
				temp = sc.nextDouble();
				if (temp < (-20) || temp > 50)
					System.out.println("temperatura fuera de nivel realista, vuelve a intertarlo");

			} while (temp < (-20) || temp > 50);
			temperaturas[i] = temp;
		}
	}
	public static double CalcularMed (double[] temperaturas) {
		double suma=0;
		for (int i = 0; i < temperaturas.length; i++) {
			suma+=temperaturas[i];
		}
		
		return suma/7;
		
	}
	public static int filtrarValor(double[] umbral, double[] temperaturas, double valorUmbral) {
		int cont=0;
		for (int i = 0; i < temperaturas.length; i++) {
			if(temperaturas[i]>valorUmbral) {
				umbral[cont]=temperaturas[i];
				cont++;
			}
			
		}
		return cont;
			
		
	}
	public static double MaxTemp(double[] umbral, int cont) {
		double valor_max=umbral[0];
		for (int i=1; i< cont; i++) {
			if(valor_max<umbral[i]) {
				valor_max=umbral[i];
				
			}
		}
		return valor_max;
	}
	public static double MinTemp(double[] umbral, int cont) {
		double valor_min=umbral[0];
		for (int i=1; i< cont; i++) {
			if(valor_min>umbral[i]) {
				valor_min=umbral[i];
				
			}
		}
		return valor_min;
	}
	


}
