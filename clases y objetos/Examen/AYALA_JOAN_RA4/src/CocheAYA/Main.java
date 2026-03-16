package CocheAYA;

import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		LocalTime reserva = null, ahora = null;
		CocheAYA[] coches = new CocheAYA[10];
		int cont = 0;
		int opc = 0;
		String matricula;
		boolean correcto = false;
		String pregunta = "";

		do {
			if (cont == coches.length) {
				break;
			}
			do {
				correcto = false;
				System.out.println("introduce el numero de matricula del vehiculo ");
				matricula = sc.nextLine();
				String format = "^[0-9]{4}[A-Z]{3}$";
				if (matricula.matches(format)) {
					correcto = true;
					coches[cont] = new CocheAYA(matricula);
					cont++;
					System.out.println("Coche regustrado con exito");

				} else {
					System.out.println(" introducido incorrecto");
				}

			} while (!correcto);
			System.out.println("desea continuar ?");
			pregunta = sc.nextLine();
			if (cont < 2) {
				System.out.println("debe introducir al menos dos vehiculos");
			}
		} while (cont <= 2 || pregunta.equalsIgnoreCase("s"));
		// salgo del bucle cuando cont>=2

		do {
			System.out.println("\n--- MENU ALQUILER DE COCHES ELECTRICOS ---");

			System.out.println("1. Reservar vehiculo libre");
			System.out.println("2. Alquilar un vehiculo alquilado");
			System.out.println("3. Acabar el trayecto del vehiculo");
			System.out.println("4. Poner libres todos los vehiculos");
			System.out.println("0. Salir");
			System.out.print("Elige: ");
			opc = sc.nextInt();
			sc.nextLine();

			switch (opc) {
			case 1: // Reservar
				int pos = -1;
				for (int i = 0; i < cont; i++) {
					if (coches[i].getEstadoCoche() == 0) {
						System.out.println(coches[i].toString());
						System.out.println("la posicion del coches es de" + i);
					}
				}
				do {
					correcto = false;

					try {
						System.out.println("introduce la posicion del coches que quieres reservar");
						pos = sc.nextInt();
						if (pos > cont || pos < 0) {
							throw new NumeroNoEncontradoArrayException("debes introducir un numero valido");
						} else {
							correcto = true;
						}
					} catch (InputMismatchException e) {
						System.out.println("debes introducir un numero");
					} catch (NumeroNoEncontradoArrayException e) {
						System.out.println(e.getMessage());
					}

				} while (!correcto);
				String codigo = coches[pos].reservar();
				System.out.println("reserva exitosa");
				System.out.println("este es tu codigo de reserva" + codigo);

				break;

			case 2: // Alquilar

				matricula = validarMatricula(sc);
				pos = buscarMatricula(coches, matricula, cont);
				if (pos == -1) {
					System.out.println("vehiculo no encontrado, vuelve a intentarlo");
					break;
				} else {
					if (coches[pos].getEstadoCoche() != 1) {
						System.out.println("el coche no se encuentra reservado, por lo cual no se puede alquilar");
						break;
					} else {
						System.out.println("introduce el codigo de tu reserva");
						codigo = sc.nextLine();
						coches[pos].alquilar(codigo);
					}
				}
				break;

			case 3: // ESTACIONAR
				matricula = validarMatricula(sc);
				pos = buscarMatricula(coches, matricula, cont);
				if (pos == -1) {
					System.out.println("vehiculo no encontrado, vuelve a intentarlo");
					break;
				}
				if (coches[pos].getEstadoCoche() != 2) {
					System.out.println("el coche no se encuentra alquilado");
					break;
				} else {
					double importe = coches[pos].estacionar();
					System.out.println("el monto a pagar por el alquiler del coche es de " + importe);
				}
				break;

			case 4: // Penalizar Reserva
				ahora = LocalTime.now();
				for (int i = 0; i < cont; i++) {
					if (coches[i].getEstadoCoche() == 1) {
						coches[i].penalizarReserva(ahora);
						System.out.println(coches[i].getMatricula());
					}
				}

				break;

			case 0:
				System.out.println("Cerrando menu de opciones");
				break;

			default:
				System.out.println("Opción no válida.");
			}
		} while (opc != 0);

		System.out.println("*******************************************************************************");
		
		System.out.println("el total de vehiculos reservados es de: " + CocheAYA.getContReservados());
		System.out.println("el total de vehiculos reservados es de: " + CocheAYA.getContAlquilados());
	}

	private static String validarMatricula(Scanner sc) {
		String matricula;
		boolean correcto;
		do {
			correcto = false;
			System.out.println("introduce el numero de matricula del vehiculo ");
			matricula = sc.nextLine();
			String format = "^[0-9]{4}[A-Z]{3}$";
			if (!matricula.matches(format)) {
				System.out.println(" matricula introducida incorrecta");
			} else {
				correcto = true;
			}

		} while (!correcto);
		return matricula;
	}

	public static int buscarMatricula(CocheAYA[] coches, String matricula, int cont) {
		for (int i = 0; i < cont; i++) {
			if (coches[i].getMatricula().equalsIgnoreCase(matricula)) {
				return i;
			}
		}
		System.out.println("No encontrado.");
		return -1;
	}

}
