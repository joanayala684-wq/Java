package ej5;

import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> conteo = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		String nombre, nacionalidad;
		do {
			
			System.out.println("introduce la nacionalidad del alumno");
			nacionalidad=sc.nextLine();
			nacionalidad=nacionalidad.trim().toUpperCase();
			if(nacionalidad.equalsIgnoreCase("fin"))
				break;
			
			if(conteo.containsKey(nacionalidad)) {
				conteo.put(nacionalidad, conteo.get(nacionalidad)+1);
			}
			else {
				conteo.put(nacionalidad, 1);
			}
			 
			
		}while(!nacionalidad.equalsIgnoreCase("fin"));
		 for (String nacio : conteo.keySet()) {
	            System.out.println( nacio + " "+ conteo.get(nacionalidad) );
	        }
		}
	}


