package ejemplo;

import java.util.Scanner;

public class refactorizar {
	
	private static final int TAM = 20;
	private static final double PI = 3.14;
	private static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double n1=3,n2=5;
		double suma=n1+n2+PI;
		int notasP[]=new int [TAM];
		int notasB []=new int [TAM];
		leerNotas( notasP);
		leerNotas( notasB);
		EscribirArray(notasP);
		EscribirArray(notasB);
		String resultado = "Resultado:";
		System.out.println(resultado+suma);
		double r=n1-n2-PI;
		System.out.println(resultado+r);
		double p=n1*n2*PI;
		System.out.println(resultado+p);
		int num=6;
		boolean primo = EsPrimo(num);
	 
	        if (primo) {
	            System.out.println("Number is Prime");
	        } else {
	            System.out.println("Number is Not Prime");
	        }
}
	public static boolean EsPrimo(int w) {
		boolean z=true;
		for (int i=2;i<w;i++) {
	    	   if (w%i==0) 
	    		   z=false;
	    	   		return false;
	       }
		return true;
	}
	public static void EscribirArray(int[] notasP) {
		for (int i=0; i<TAM; i++) {
			System.out.println(notasP[i]);
		}
	}
	public static void leerNotas(int[] notasP) {
		for(int i=0; i<TAM; i++) {
			notasP[i]=sc.nextInt();
			}
	}
}
