package ej2;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import ej1.Alumno;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		int opcion, val = 0;
		do {
			System.out.println("introduce el valor del array");
			val = sc.nextInt();
			if (val < 0 || val > 10) {
				System.out.println("debes introducir un numero positivo y debe ser de maximo 20 espacios");
			}
		} while (val < 0 || val > 10);

		ArrayList<Fruta> frutas = new ArrayList<Fruta>();

		System.out.println("beneficio total:" + Fruta.getBeneficioTotal());
		int cont = 0;
		do {

			System.out.println("\n--- MENÚ GESTIÓN +8FRUTAS ---");
			System.out.println("1. Dar de alta un cargamento,");
			System.out.println("2.Mostrar toda la información de todos los cargamentos.");
			System.out.println("3. Rebajar un cargamento.");
			System.out.println("4. Vender.");
			System.out.println("5.Mostrar el beneficio obtenido por el almacén.");
			System.out.println("6.Borrar el primer cargamento vacio");
			System.out.println("7.Borrar todos los cargamentos que tengan 0 kilos");
			System.out.println("0. salir.");
			System.out.print("Seleccione una opción: ");
			opcion = sc.nextInt();
			sc.nextLine();
			switch (opcion) {
			case 1:
				crearCargamento(sc, val, frutas);
				break;
			case 2:
				for (int i = 0; i < cont; i++) {
					System.out.println(frutas.toString());
				}
				break;
			case 3:
				String nombre;
				System.out.println("que cargamento de fruta quieres rebajar");
				nombre = sc.nextLine();
				System.out.println("introduce el porcentaje de rebja");
				double por = sc.nextDouble();
				for (int i = 0; i < cont; i++) {
					if (frutas.get(i).getNombre().equalsIgnoreCase(nombre)) {
						frutas.get(i).rebajar(por);
						break;
					}
				}
				break;
			case 4:
				System.out.println("que cargamento de fruta quieres rebajar");
				nombre = sc.nextLine();
				System.out.println("cuantos kilos seran");
				double kilos = sc.nextDouble();
				for (int i = 0; i < cont; i++) {
					if (frutas.get(i).getNombre().equalsIgnoreCase(nombre)) {
						double importe = frutas.get(i).vender(kilos);
						if (importe != 0) {
							break;
						}
					}
				}

				break;
			case 5:
				System.out.println("beneficio total:" + Fruta.getBeneficioTotal());
				break;
			case 6:
				int i = 0;
				for (i = 0; i < cont; i++) {
					if (frutas.get(i).getNumkg() == 0) {
						frutas.remove(i);
						break;
					}
				}

				if (i == cont)
					System.out.println("no hay ningun caragamento vacio");
				break;

			case 7:
				for (i = 0; i < cont; i++) {
					if (frutas.get(i).getNumkg() == 0) {
						frutas.remove(i);
					}
				}
				break;
			case 0:
				System.out.println("menu cerrado");
				break;
			default:
				System.out.println("opcion no valida");

			}

		} while (opcion != 0);

	}

	public static void crearCargamento(Scanner sc, int val, ArrayList<Fruta> frutas) {
		String nombre;
		String procedencia;
		double kilos;
		double coste;
		double venta;

		System.out.println("introduce el nombre");
		nombre = sc.nextLine();
		System.out.println("introduce procedencia");
		procedencia = sc.nextLine();
		System.out.println("introduce el numero de kilos que se tiene ");
		kilos = sc.nextDouble();
		System.out.println("introduce su precio de coste");
		coste = sc.nextDouble();
		System.out.println("introduce el precio de venta ");
		venta = sc.nextDouble();

		frutas.add(new Fruta(nombre, procedencia, kilos, coste, venta));

	}

}
