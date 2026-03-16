package arrays;

import java.util.Scanner;

public class ejerexam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		/*
		 * La cafetería del instituto quiere saber qué opiniones (del 1 al 5) le dan los
		 * alumnos a la comida.
		 * 
		 * Pide votos al usuario (máximo 20) hasta que decida parar (escribiendo "no").
		 * 
		 * Solo se aceptan notas del 1 al 5.
		 * 
		 * Acción A: Busca si alguien ha votado con un "1" (la peor nota) e indica en
		 * qué posición se encontró el primero.
		 * 
		 * Acción B: Usa un array de frecuencias para decir cuántos votos tiene cada
		 * nota.
		 * 
		 * Acción C: Muestra todos los votos introducidos ordenados de menor a mayor
		 * (sin huecos vacíos).
		 */

		double notas[] = new double[20];
		int cont=0;
		cont=leerOpi (notas, sc);
		for(int i=0; i<cont; i++) {
			System.out.println(notas[i]);
		}
		int posUno=buscaruno(notas, 1, cont);
		if(posUno == -1) {
			System.out.println("no hay ningun uno");
		}
		else {
			System.out.println("se ha encontrado el primer uno en la posisicion"+posUno);
		}

	}

	public static int leerOpi (double notas[], Scanner sc) {
		int cont=0;
			double temp=0;
			boolean correcto=false;
			String continuar="si";
			while (cont < notas.length && continuar.equalsIgnoreCase("si")) {
			do {
				try {
					System.out.println("da tu calificacion del 1 al 5");
					temp=sc.nextDouble();
					if(temp >=1 && temp<=5) {
						correcto=true;
					} else {
						System.out.println("error");
					}
				} catch (Exception e) {
					System.out.println("introduce un numero valido");
				}
				
				
			
			}while(!correcto);
			notas[cont]=temp;
			cont++;
			if (cont < notas.length) {
			System.out.println("quieres continuar?");
			continuar=sc.nextLine();}
		
			}
			
		
		return cont;
	}
	public static int buscaruno( double notas[], double valor, int tope) {
		for(int i=0; i<tope; i++) {
			if (notas[i] == valor) return i;
        }
        return -1;
	}

}
