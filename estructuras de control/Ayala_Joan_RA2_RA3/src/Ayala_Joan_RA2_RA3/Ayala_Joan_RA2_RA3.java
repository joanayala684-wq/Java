package Ayala_Joan_RA2_RA3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.Scanner;

public class Ayala_Joan_RA2_RA3 {
	static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Ayala_Joan_RA2_RA3
		sc = new Scanner(System.in);
		boolean cod_correcto = false;
		String cod_emple = null;
		Random r=new Random();
		LocalTime hora1 = null, hora2 = null;
		do {
			System.out.println("introduce el codigo del empleado");
			cod_emple = sc.nextLine();
			try {
				cod_correcto = ValidarCodEmple(cod_emple);
			} catch (NumFueraRangoException e) {
				System.out.println(e.getMessage());
			} catch (NullPointerException e) {
				System.out.println("introduce algun valor para el codigo emple");
			}

		} while (!cod_correcto);
		int semana = 0;
		int horas_trabajadas = 0, minutos_trabajados;
		int total_incidencias = 0;
		int horae=r.nextInt(4)+7;
		int hors=r.nextInt(4)+15;
		for (int i = 1; i <= 5; i++) {
			boolean correcto = false;
			do {
				System.out.println("introduce tu hora de entrada");
				String hora1S = sc.nextLine();
				
				try {
					hora1 = LocalTime.parse(hora1S);
					correcto = true;
				} catch (DateTimeParseException e) {
					System.out.println("error al introducir la hora, vuelve a intentarlo");
				}
			} while (correcto == false);

			do {
				System.out.println("introduce la otra hora");
				String hora2S = sc.nextLine();
				try {
					hora2 = LocalTime.parse(hora2S);
					if (hora2.isBefore(hora1)) {
						System.out.println("la hora de salida debe ser posterior a la de entrada");
					} else {
						correcto = true;
					}
				} catch (DateTimeParseException e) {
					System.out.println("error al introducir la hora, vuelve a intentarlo");
					correcto = false;

				}

			} while (!correcto);
			try {
				horas_trabajadas = CalcularHoras(hora1, hora2, cod_emple);
				semana += horas_trabajadas;
			} catch (Ayala_JoanException e) {

				System.out.println(e.getMessage());
				total_incidencias++;
				horas_trabajadas=360/60;
				semana += 360;
			}
			System.out.println("las horas trabajadas hoy son " + horas_trabajadas);

		}
		horas_trabajadas = semana / 60;
		minutos_trabajados = semana % 60;
		System.out.println("el total de horas trabajadas en la semana es:" + horas_trabajadas + ":" + minutos_trabajados);
		System.out.println("eñl total de incidencias registradas es " + total_incidencias);

	}

	public static boolean ValidarCodEmple(String cod_emple) throws NumFueraRangoException {

		String depart, numeros;
		depart = cod_emple.substring(0, 3);
		
		if (cod_emple.length() != 6 && cod_emple.length() != 7) {
			return false;
		}
		if (cod_emple.length() == 6) {
			String patron = "^[A-Za-z]{3}[0-9]{3}$";
			numeros = cod_emple.substring(3, 6);
			if (!cod_emple.matches(patron)) {
				return false;
			}

			int numero = Integer.parseInt(numeros);
			if (numero <= 100 || numero >= 500) {
				throw new NumFueraRangoException("el numero de empleado debe estar comprendido entre 100 y 500");
			}
		}
		if (cod_emple.length() == 7) {
			String patron = "^[A-Za-z]{3}[0][0-9]{3}$";
			numeros = cod_emple.substring(4, 7);
			if (!cod_emple.matches(patron)) {
				return false;
			}
			int numero = Integer.parseInt(numeros);
			if (numero <= 100 || numero >= 500) {
				throw new NumFueraRangoException("el numero de empleado debe estar comprendido entre 0100 y 0500");
			}
		}

		return true;

	}

	public static int CalcularHoras(LocalTime hora1, LocalTime hora2, String cod_emple) throws Ayala_JoanException {
		
		long diferenciaMinutos = (int) Math.abs(ChronoUnit.MINUTES.between(hora1, hora2));
		String depart = null;
		depart = cod_emple.substring(0, 3);
		assert (depart.equalsIgnoreCase("mkt") || depart.equalsIgnoreCase("des") || depart.equalsIgnoreCase("rrh")): "los unicos departamentos validos son: MKT, DES, RHH";
		
		LocalTime entrada = null, salida = null;
		if (depart.equalsIgnoreCase("MKT")) {
			entrada = LocalTime.of(10, 00);
			salida = LocalTime.of(18, 00);
		}
		if (depart.equalsIgnoreCase("DES")) {
			entrada = LocalTime.of(8, 30);
			salida = LocalTime.of(16, 00);
		}
		if (depart.equalsIgnoreCase("RRHH")) {
			entrada = LocalTime.of(9, 00);
			salida = LocalTime.of(16, 30);
		}
		if (hora1.isAfter(entrada) || hora2.isBefore(salida)) {
			throw new Ayala_JoanException("se ha producido una incidencia");

		}
		return (int) diferenciaMinutos;

	}

}
