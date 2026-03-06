package arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ejer9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Leed 10 notas en un array, validando que sean correctas (entre 0 y 9), si una nota es
		incorrecta se vuelve a pedir hasta que sea correcta.
		Leed a continuación otra nota, y copiad en un segundo array las notas superiores a la
		leída. 
		Descartad las notas repetidas al pasarlas al segundo array. (2 ptos)
		Ordenad el array de menor a mayor. (1 pto)*/
		Scanner sc=new Scanner(System.in);
		int notas[]=new int [10];
		int superiores[]=new int [10];
		int cont=0;
		boolean correcto=false;
		for(int i=0; i<notas.length;i++) {
			correcto=false;
			
			do {
				System.out.println("introduce una nota del 0 al 9");
				notas[i]=sc.nextInt();
				if(notas[i]<0 || notas[i] >9) {
					System.out.println("el valor introducido no es valido");
					System.out.println("la nota debe estar comprendida del 0 al 9");}
					else 
						correcto=true;
				}while(!correcto);
		}
		int nota_corte=0;
		for(int i=0; i<notas.length;i++) {
			boolean guardado=false;
			int nota_actual=notas[i];
			if(nota_corte<nota_actual) {
				for (int k = 0; k < cont; k++) {
					if (nota_actual == superiores[k]) {
						guardado = true;
							break;
								}}
						if (!guardado) {
							superiores[cont] = nota_actual;
							cont++;}
					if(nota_actual>nota_corte) {
						nota_corte=nota_actual;
							}
						
						}
						
	}
	Arrays.sort(notas);
	for(int i=0; i<notas.length; i++) {
		System.out.println("las notas introducidas son: " + notas[i]);
	}
	
	Arrays.sort(superiores, 0, cont);
	for(int i=0; i<cont; i++) {
		System.out.println("las mejores notas son: " + superiores[i]);
	}

}

}
