package Frutas;

import java.util.Scanner;

import Garaje.Garaje;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int opcion, val = 0;
		do {
			System.out.println("introduce el valor del array");
			val = sc.nextInt();
			if (val < 0 || val > 10) {
				System.out.println("debes introducir un numero positivo y debe ser de maximo 20 espacios");
			}
		} while (val < 0 || val > 10);
		Frutas fruta[] = new Frutas[val];

		System.out.println("beneficio total:" + Frutas.getBeneficioTotal());
		int cont = 0;
		do {

			System.out.println("\n--- MENÚ GESTIÓN FRUTAS ---");
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
			switch (opcion) {
			case 1:
				cont = crearCargamento(sc, val, fruta);
				break;
			case 2:
				for (int i = 0; i < cont; i++) {
					System.out.println(fruta[i].toString());
				}
				break;
			case 3:
				String nombre;
				System.out.println("que cargamento de fruta quieres rebajar");
				nombre = sc.nextLine();
				System.out.println("introduce el porcentaje de rebja");
				double por = sc.nextDouble();
				for (int i = 0; i < cont; i++) {
					if ((fruta[i]).getNombre().equalsIgnoreCase(nombre)) {
						fruta[i].rebajar(por);
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
					if ((fruta[i]).getNombre().equalsIgnoreCase(nombre)) {
						double importe = fruta[i].vender(kilos);
						if (importe != 0) {
							break;
						}
					}
				}

				break;
			case 5:
				System.out.println("beneficio total:" + Frutas.getBeneficioTotal());
				break;
			case 6:
				int i = 0;
				for (i = 0; i < cont; i++) {
					if ((fruta[i].getNumkg()) == 0) {
						for (int j = 1; j < cont - 1; j++) {
							fruta[j] = fruta[j + 1];
						}
						fruta[cont - 1] = null;
						cont--;
						break;
					}
				}

				if (i == cont)
					System.out.println("no hay ningun caragamento vacio");
				break;

			case 7:
				for (i = 0; i < cont; i++) {
					if ((fruta[i].getNumkg()) == 0) {
						for (int j = 1; j < cont - 1; j++) {
							fruta[j] = fruta[j + 1];
						}
						fruta[cont - 1] = null;
						cont--;
						i--;//para inspeccionar la celda que acabo de rellenar con la siguiente 
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

	public static int crearCargamento(Scanner sc, int val, Frutas[] fruta) {
		String nombre;
		String procedencia;
		double kilos;
		double coste;
		double venta;
		boolean seguir = true;
		int cont = 0;

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
		if (cont < 10) {
			fruta[cont] = new Frutas(nombre, procedencia, kilos, coste, venta);
			cont++;
		} else {
			System.out.println("no se ha podido dar de alta el cargamento");
		}
		return cont;

	}

}
