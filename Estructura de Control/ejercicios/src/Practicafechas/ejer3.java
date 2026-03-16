package Practicafechas;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ejer3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		LocalDate fecha=null, fechanueva;
		boolean correcto=false;
		int dias = 0;
		DateTimeFormatter patron=DateTimeFormatter.ofPattern("dd/MM/yy");
		/*do {
			System.out.println("introduce una fecha dd/MM/yy");
			String fechaS=sc.nextLine();
			try {
				fecha=LocalDate.parse(fechaS, patron);
				correcto=true;
			}catch (DateTimeParseException e){
				System.out.println("fecha incorrecta");
			}
			System.out.println("introduce un periodo de tiempo en dias ");
			dias=sc.nextInt();
			fechanueva=fecha.plusDays(dias);
			System.out.println("la fecha trascurridas" + dias+  "dias, es" + patron.format(fechanueva)); 
		}while(!correcto);*/
		do {
		try {
			System.out.println("introduce un dia");
			int dia=sc.nextInt();
			System.out.println("introduce un mes");
			int mes=sc.nextInt();
			System.out.println("introduce un año");
			int año=sc.nextInt();
			fecha=LocalDate.of(año, mes, dia);
		}catch(DateTimeException e) {
			System.out.println("fecha incorrecta");
		}catch(InputMismatchException e) {
			sc.nextLine();
			System.out.println("no se pueden introducir caracters");
			}
		}while(correcto==false);
		correcto=false;
		do {
		try {
			System.out.println("introduce un numero dde dias");
			dias=sc.nextInt();
			correcto=true;
		} catch (InputMismatchException e) {
			sc.nextLine();
			System.out.println("no se pueden introducir caracters");
			}
		}while(!correcto);
		System.out.println(fecha.plusDays(dias).format(patron));
	}
	}

