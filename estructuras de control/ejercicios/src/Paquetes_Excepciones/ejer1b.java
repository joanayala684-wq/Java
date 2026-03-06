package Paquetes_Excepciones;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class ejer1b {
	static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1. Lee dos fechas de teclado en formato dd/mm/aa, de manera que la primera
		 * sea menor que la segunda. Controla con excepciones que la fecha sea correcta.
		 * Haz una función que reciba las dos fechas y si son del mismo mes retorna los
		 * días que hay entre ambas, si no retorna los meses que hay entre ambas.
		 */
		sc = new Scanner(System.in);
		LocalDate fecha1 = null, fecha2 = null;
		String fecha1S, fecha2S;
		int diff = 0;
		boolean correcto = false;
		DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd/MM/yy");
		
			do {
				System.out.println("introduce una fecha");
				try {
					fecha1S = sc.nextLine();
					fecha1 = LocalDate.parse(fecha1S, patron);
					correcto = true;
				} catch (DateTimeParseException e) {
					// TODO Auto-generated catch block
					System.out.println("introduce una fecha valida");

				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					System.out.println("introduce una fecha valida");
		
				}
			} while (!correcto);
			correcto = false;
			do {
				System.out.println("introduce una fecha");
				try {
					fecha2S = sc.nextLine();
					fecha2 = LocalDate.parse(fecha2S, patron);
					if (fecha1.isBefore(fecha2)) {
	                    correcto = true; 
					} else {
						System.out.println("Error: La primera fecha debe ser anterior a la segunda.");}
          
				} catch (DateTimeParseException e) {
					// TODO Auto-generated catch block
					System.out.println("introduce una fecha valida");
				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					System.out.println("introduce una fecha valida");
				}
				if (fecha1.isBefore(fecha2)) {
                    correcto = true; 
                
		} while (!correcto);

		diff = CalcularTiempo(fecha1, fecha2);
	
	}

	public static int CalcularTiempo(LocalDate fecha1, LocalDate fecha2) {
		DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd/MM/yy");
		long tiempo = 0;
		if (fecha1.getMonth() == fecha2.getMonth() && fecha1.getYear() == fecha2.getYear()) {
			tiempo = Math.abs(ChronoUnit.DAYS.between(fecha1, fecha2));
			System.out.println("la diferencia tiempo es de "+ tiempo +"dias");
			return (int) tiempo;}
		else 
			if(fecha1.getYear() == fecha2.getYear()){
			tiempo = Math.abs(ChronoUnit.MONTHS.between(fecha1, fecha2));
			System.out.println("la diferencia tiempo es de "+ tiempo +"meses");
			return (int) tiempo;}
		else	{
			tiempo = Math.abs(ChronoUnit.YEARS.between(fecha1, fecha2));
			System.out.println("la diferencia tiempo es de "+ tiempo +"años");
			return (int) tiempo;}
				
	
	}


}