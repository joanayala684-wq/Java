package ej6;

import java.util.HashSet;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner sc=new Scanner(System.in);	
	HashSet<String> instrument = new HashSet<String>();
	String instrumento;
	do {
		System.out.println("introduce el instrumentos");
		instrumento=sc.nextLine();
		instrumento=instrumento.toUpperCase();
		if(instrumento.equalsIgnoreCase("fin")) {
			break;
		}
		if(instrument.contains(instrumento)) {
	    	System.out.println("tu instrumento esta en el cojunto");
	    }
		else {
			System.out.println("no esta en el cojunto");
			instrument.add(instrumento);
			instrumento=instrumento.toUpperCase();
		}
	}while(!instrumento.equalsIgnoreCase("fin"));
	
	}

}
