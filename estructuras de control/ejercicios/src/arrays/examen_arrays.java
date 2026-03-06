package arrays;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class examen_arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double listaPos[]=new double[10];
		double listaNeg[]=new double[10];
		int contPos=0 , contNeg=0, tope=10;
		for(int i=0; i<tope; i++) {
			boolean correcto=false;
			do {
				
				try {
					System.out.println("introduce el valor de la temperatura");
					double temp=sc.nextDouble();
					if(temp<0) {
						listaNeg[contNeg]=temp;
						contNeg++;
					}
					if(temp>=0) {
						listaPos[contPos]=temp;
						contPos++;
					}
					correcto=true;
				} catch (InputMismatchException e) {
					System.out.println("introduce un valor valido");
				}
				sc.nextLine();
			}while(!correcto);
			}
		Arrays.sort(listaPos, 0, contPos);
		Arrays.sort(listaNeg, 0, contNeg);
		System.out.println("introduce la temperatura que quieres buscar");
		double temp=sc.nextDouble();
		int ubicacion=buscarTem(listaPos, listaNeg, contNeg, contPos, temp);
		if(ubicacion==-1) {
			System.out.println("no se ha encontrado en ningun array");
		}
		else if(ubicacion==1) {
			System.out.println("esta en positivos");
			
		}
		else if(ubicacion==2) {
			System.out.println("esta en negativos");
		}
		
		
	}
	public static int buscarTem(double pos[], double neg[], double contNeg, double contPos, double temp) {
		int ubicacion=-1;
		for(int i=0; i<contPos; i++) {
			double actual=pos[i];
			if(actual==temp) {
				ubicacion=1;
				return ubicacion;
			}
		}
		for(int i=0; i<contNeg; i++) {
			double actual=neg[i];
			if(actual==temp) {
				ubicacion=2;
				return ubicacion;
			}
		}
		return ubicacion;
	}

}
