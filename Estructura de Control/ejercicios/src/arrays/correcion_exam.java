package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class correcion_exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double positivas []=new double [10];
		double negativas []=new double [10];
		double temperatura;
		int contp=0, contn=0;
		Scanner sc=new Scanner (System.in);
		
		for(int i=1; i<=10; i++) {
			System.out.println("anota la temperatura");
			temperatura=sc.nextDouble();
			if(temperatura>=0){
				positivas[contp]=temperatura;
				contp++;
			}
			else {
				negativas[contn]=temperatura;
				contn++;
			}
		}
		Arrays.sort(positivas, 0, contp);
			System.out.println("las temperturas positivas son");
			for (int i=0; i <contp;i++) {
				System.out.println(positivas[i]);}
		Arrays.sort(positivas, 0, contp);
				System.out.println("las temperturas negativas son");
				for (int i=0; i <contn;i++) {
					System.out.println(negativas[i]);	
		}
				
		System.out.println("introduce temperatura a buscar ");
		temperatura=sc.nextDouble();
		if(temperatura>=0) {
			if(buscar(negativas, contn, temperatura) !=-1)
				System.out.println("la temepratura esta en el array de negativos");
			else
				System.out.println("temperatura no encontrada");
					
		}
		if(temperatura>=0) {
			if(buscar(positivas, contp, temperatura) !=-1)
				System.out.println("la temepratura esta en el array de posituvas");
			else
				System.out.println("temperatura no encontrada");
					
		}
		
		
		
	}
	public static int buscar(double temp[], int tam, double t) {
		for(int i=0; i<tam; i++)
			if(temp[i]==t)
				return i;
		return -1;
		
	}

}
