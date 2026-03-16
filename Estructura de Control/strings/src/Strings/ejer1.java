package Strings;

import java.util.Scanner;

public class ejer1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String cadena;
		
		do {
			System.out.println("introduce una cadena");
			cadena=sc.nextLine();
		if (!cadena.equalsIgnoreCase("fin")) {
			String cadenaMayus=cadena.toUpperCase();
			System.out.println(cadenaMayus);
		}
		}while(!cadena.equalsIgnoreCase("fin"));
	}

}
