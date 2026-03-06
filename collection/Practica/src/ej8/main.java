package ej8;

import java.util.HashMap;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String matricula, marca, modelo;
		int año, categoria;
		boolean correcto = false;

		HashMap<String, Automovil> automovil = new HashMap<String, Automovil>();
		Scanner sc = new Scanner(System.in);
		double importeAlqui = 0;

		for (int i = 0; i < automovil.size(); i++) {
			do {
				System.out.println("introduce una matricula");
				matricula = sc.nextLine();
				correcto = matricula.matches("[0-9]{4}[A-Z]{3}");
			} while (!correcto);
			System.out.println("introduce marca");
			marca = sc.nextLine();
			System.out.println("introduce modelo");
			modelo = sc.nextLine();
			System.out.println("Año de compra");
			año = sc.nextInt();
			System.out.println("categoria 1/2");
			categoria = sc.nextInt();
			sc.nextLine();
			Automovil nuevoCoche = new Automovil(matricula, modelo, marca, año, categoria);
			automovil.put(matricula, nuevoCoche);
		}
		int opc = 0;
		do {
			System.out.println("1. alquilar, 2 devolver, 3.");
			opc = sc.nextInt();
			switch (opc) {
			case 1:
				System.out.println("introduce matricula");
				matricula = sc.nextLine();

				if (!automovil.containsKey(matricula)) {
					System.out.println("el coche no se encuentra en almacen");
				} else {
					if (automovil.get(matricula).isAlquilado())
						System.out.println("ya esta alquilado");
					else {
						System.out.println("por cuantos dias vas a alquilarlo?");
						int dias = sc.nextInt();
						sc.nextLine();
						importeAlqui = automovil.get(matricula).alquiler(dias);
						if (importeAlqui == 0)
							System.out.println("error alquilando,avisa a sistema");
						System.out.println("el importe de su alquier es " + importeAlqui);
					}
				}
				break;
			case 2:
				System.out.println("introduce matricula");
				matricula = sc.nextLine();
				if (!automovil.containsKey(matricula)) {
					System.out.println("el coche no se encuentra en almacen");
				} else {
					if (!automovil.get(matricula).isAlquilado())
						System.out.println("no esta alquilado, no se puede devolver");
					else {
						automovil.get(matricula).devolver();
						System.out.println("el coche se ha devuleto con exito");
					}
				}
				break;
			case 3:
				System.out.println("introduce matricula");
				matricula = sc.nextLine();
				if (!automovil.containsKey(matricula)) {
					System.out.println("el coche no se encuentra en almacen");
				} else
					System.out.println(automovil.get(matricula).toString());
				break;
			case 4:
				for (Automovil a : automovil.values()) {
                    System.out.println(a.toString());
                }
				break;
			case 5:
				System.out.println("fin del programa");
				System.out.println("total vehiculos alquilados" + Automovil.getContAlquileres());
				System.out.println("total ganancias" + Automovil.getGananciasTotalesEmpresa());
				break;
			default:
				System.out.println("opcion incorrecta");
			}
		} while (opc != 5);

	}

}
