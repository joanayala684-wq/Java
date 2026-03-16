package Practica6;

import java.util.Scanner;

public class ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		double sala, numentrada = 0;
		int masentradas= 0, salatop=0, sala1 = 0, sala2= 0;
		double numentrada1= 0, numentrada2=0, totalvendidas=0;
		do {
			System.out.println("introducir el numero de sala");
			sala=sc.nextInt();
			if (sala == 1) {
				sala1++;
			    System.out.println("introducir el numero de entrada que desea");
			    numentrada=sc.nextDouble();
			    numentrada1+=numentrada;}
			else
				if (sala ==  2) {
					sala2++;
					System.out.println("introducir el numero de entrada que desea");
					numentrada=sc.nextDouble();
					numentrada2+=numentrada;}
				else
					if (sala != 0 || sala != 1 || sala != 2)
					System.out.println("introducir un caracter valido");
			if (numentrada > 10)
				masentradas++;
			totalvendidas = numentrada1 + numentrada2;
		}while (sala != 0);
		System.out.println("el numro total de entradas vendidas es de" +totalvendidas);
		if (numentrada1>numentrada2)
			System.out.println("la sala con mas entradas vendidas es la 1");
		else 
			if (numentrada1<numentrada2)
			System.out.println("la sala con mas entradas vendidas es la 2");
		if (masentradas > 0)
			System.out.println("alguien ha comprado mas de 10 entradas");
	}

}
