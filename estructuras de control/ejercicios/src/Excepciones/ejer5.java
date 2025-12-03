package Excepciones;

import java.util.Scanner;

public class ejer5 {
	static Scanner sc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Realizar un programa que quiere calcular el total de emisiones de CO2 de varios
vehículos en una ciudad, terminad al anotar F. Hacer una función que reciba el
tipo de distintivo del vehículo (0,E,C,B) y los kms recorridos y devuelva las
emisiones de co2. Por cada km según el tipo de distintivo se producen las
siguientes emisiones:
0: cero
E: 0.001
C: 0.02
B: 0.05
Si la función recibe un distintivo que no es ninguno de los anteriores, devuelve
una excepción propia DistintivoErroneoException.*/
		sc = new Scanner(System.in);
		String tipocombustible = "";
		double emision;
		System.out.println("introduce el tipo de combustible que usas (0,E,C,B)");
		tipocombustible=sc.nextLine();
		while(tipocombustible.equalsIgnoreCase("f")); {
			
			System.out.println("introduce los kilomestros recorridos");
			double km=sc.nextDouble();
			try {
				emision=CalcularEmisiones(tipocombustible, km);
				System.out.println("el total de las emisiones es"+ emision);
			} catch (DistintivoErroneoException e) {

				System.out.println("introduce un dato valido");
			}
			System.out.println("introduce el tipo de combustible que usas (0,E,C,B)");
			tipocombustible=sc.nextLine();
		}
	}
public static double CalcularEmisiones(String tipocombustible, double km) throws DistintivoErroneoException {
	double emision = 0;
	final double cero=0, e= 0.001, c=0.02, b=0.05;
	tipocombustible=tipocombustible.toUpperCase();
	switch(tipocombustible) {
	case "0":
		emision=km*cero;
		break;
	case "E":
		emision=km*e;
		break;
	case "C":
		emision=km*c;
		break;
	case "B":
		emision=km*b;
		break;
	default:
		throw new DistintivoErroneoException("Distintivo incorrecto");
	
	}
	
	return emision;
	
}
}
