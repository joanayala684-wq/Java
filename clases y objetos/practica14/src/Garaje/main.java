package Garaje;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double metros, precio = 0;
		int id, planta;
		boolean correcto = false;
		Garaje garaje[] = new Garaje[5];
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < garaje.length; i++) {

			System.out.println("introduce un id");
			id = sc.nextInt();
			System.out.println("introduce planta");
			planta = sc.nextInt();
			System.out.println("introduce metros");
			metros = sc.nextDouble();

			garaje[i] = new Garaje(id, planta, metros);

		}
		int opcion;
		do {
			// 2. Mostrar el menú
			System.out.println("\n--- MENÚ GESTIÓN GARAJE ---");
			System.out.println("1. Alquilar un garaje");
			System.out.println("2. Mostrar precio de alquiler");
			System.out.println("3. Mostrar garajes libres");
			System.out.println("4. Subir precio por porcentaje (%)");
			System.out.println("5. Mostrar beneficios totales");
			System.out.println("0. Salir");
			System.out.print("Seleccione una opción: ");
			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("introduce el id de tu garaje");
				id = sc.nextInt();
				int pos = buscarGaraje(garaje, id);
				if (pos == -1) {
					System.out.println("el garaje no existe");
				}

				if (garaje[pos].isAlquilado())

					System.out.println("el garaje ya esta alquilado ");
				else {
					double importeAlqui = garaje[pos].getContracto();
					System.out.println("vamos a procesar el alquiler de un año");
					if (importeAlqui == 0) {
						System.out.println("error alquilando,avisa a sistema");
					} else {
						System.out.println("el importe de su alquier es " + importeAlqui);
						garaje[pos].alquiler();
					}
				}
				break;
			case 2:
				System.out.println("introduce el id de tu garaje");
				id = sc.nextInt();
				pos = buscarGaraje(garaje, id);
				if (pos == -1) {
					System.out.println("el garaje no existe");
				} else {
					System.out.println("el precio de alquiler por año es de " + (12 * garaje[pos].getPrecio()));
				}
				break;
			case 3:
				for (int i = 0; i < garaje.length; i++) {
					if (garaje[i].isAlquilado()) {
						System.out.println("garaje disponible " + garaje[i]);
					}
				}
				break;
			case 4:
				System.out.println("introduce el id de tu garaje");
				id = sc.nextInt();
				pos = buscarGaraje(garaje, id);
				if (pos == -1) {
					System.out.println("el garaje no existe");
				} else {
					System.out.println("introduce el porcentaje que se va a subir");
					double porcentaje = sc.nextDouble();
					if (garaje[pos].isAlquilado()) {
						System.out.println("subida de precio exitosa");
						System.out.println("el precio de alquiler por año es de " + (12 * garaje[pos].getPrecio()));

					} else {
						System.out.println("no se puede realizar la subida de precio porque el garaje esta alquilado");
					}
				}
				break;
			case 5:
				System.out.println("El total de ganacias de la empresa es: " + Garaje.getTotalGanancias());
				break;
			case 0:
				System.out.println("menu cerrado");
				break;
			default:
				System.out.println("opcion no valida");
			}

		} while (opcion != 0);

	}

	public static int buscarGaraje(Garaje garaje[], int id) {
		for (int i = 0; i < garaje.length; i++) {
			if (garaje[i].getId() == id)
				return i;
		}
		return -1;

	}

}
