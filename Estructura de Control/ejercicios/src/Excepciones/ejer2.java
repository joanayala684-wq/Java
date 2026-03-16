package Excepciones;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class ejer2 {
	static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Haced una función que lea una fecha en formato dd/mm/aa mientras sea
		 * incorrecta.
		 */
		sc = new Scanner(System.in);
		boolean correcto = false;
		LocalDate fecha = null;
		DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		do {
			correcto = validarFormat(fecha);
		} while (!correcto);
	}

	public static boolean validarFormat(LocalDate fecha) {
		DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		boolean correcto = false;
		do {
			System.out.println("introduce una fecha");
			String FechaNaci = sc.nextLine();
			try {
				java.time.LocalDate fechaNacimiento = LocalDate.parse(FechaNaci, patron);
				correcto = true;
			} catch (DateTimeParseException e) {
				System.out.println("error al introducir la fecha, vuelve a intentarlo");
			}
		} while (!correcto);
		return correcto;
	}
}
