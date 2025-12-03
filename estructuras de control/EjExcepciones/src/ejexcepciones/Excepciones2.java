package ejexcepciones;

import java.util.*;
public class Excepciones2 {
	
	// Programa que lee dos números y calcula su división.
	// Controla mediante excepciones que no se anote un dato no numérico
	// y que no se divida por cero.
	// Usando funciones
	
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero1=0,numero2=0,div=0;
		
		boolean correcto=false;
		
		do{
			numero1=leerInt();
			System.out.println("Número leido:"+numero1);
			
			numero2=leerInt();
			System.out.println("Número leido:"+numero2);
			
			try{
				div=dividir(numero1,numero2);
				System.out.println("La división es:"+div);
				correcto=true;
			}catch(ArithmeticException e){
				System.out.println("Vuelva a anotar los números:");
				
			}
		}while(!correcto);
		
		
	}
	
	static int leerInt(){
		
	boolean correcto=false;
	int numero=0;
	while(!correcto) {
		
		try {
			System.out.println("Anota numero:");
			numero=sc.nextInt();
			correcto=true;
		}catch(InputMismatchException e) {
			sc.nextLine();
			System.out.println("Formato incorrecto");
			
		}
	}
	return numero;

}
	
	static public int dividir(int a,int b){
	
	try {
		int div=a/b;
		return div;
	}catch(ArithmeticException e) {
		System.out.println("No se puede dividir por cero");
		throw e;
	}
}
}

