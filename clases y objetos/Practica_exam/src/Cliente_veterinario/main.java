package Cliente_veterinario;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Teatro.Representacion;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		CocheAYA citas[] = new CocheAYA[15];
		Scanner sc = new Scanner(System.in);
		String nombre = null, motivo, fechaS;
		LocalDateTime fecha = null;
		int cont = 0, opc;
		boolean correcto = false;
		do {
			System.out.println("Menu de opciones");
			System.out.println("1. Registrar cita");
			System.out.println("2. Modificar servicio");
			System.out.println("3. cancelar cita");
			System.out.println("4. resumen cita");
			opc = sc.nextInt();
			sc.nextLine();
			switch (opc) {
			case 1:
				if (cont == citas.length) {
					System.out.println("el array esta lleno");
					break;
				} else {
					System.out.println("nombre mascota");
					nombre = sc.nextLine();
					System.out.println("motivo");
					motivo = sc.nextLine();
					do {
						correcto = false;
						try {
							System.out.println("fecha");
							fechaS = sc.nextLine();
							fecha = LocalDateTime.parse(fechaS, patron);
							correcto = true;
						} catch (DateTimeException e) {
							System.out.println("formato de fecha incorrecto");
						}
					} while (!correcto);
					try {
						boolean verificar = verificar(fecha);
					} catch (FechaInvalidaException e) {
						System.out.println(e.getMessage());
					}
					citas[cont] = new CocheAYA(nombre, motivo, fecha);
					cont++;

				}
				break;
			case 2:
				if (cont == 0) {
					System.out.println("no tenemos ninguna cita guardada en el array");
					break;
				}
				int pos = buscarCita(citas, sc, cont);
				if (pos != -1) {
					nombre = citas[pos].getNombre();
					fecha = citas[pos].getFecha();

					System.out.println("introduce el servicio que quieres cambiar");
					motivo = sc.nextLine();
					// 3. SOBREESCRIBIMOS la posición con un objeto nuevo
					// El constructor de 'citaMedica' se encargará de generar el nuevo código
					// automáticamente con el nuevo motivo.
					citas[pos] = new CocheAYA(nombre, motivo, fecha);
				}
				break;

			case 3:
				if (cont == 0) {
					System.out.println("no tenemos ninguna cita guardada en el array");
					break;
				}
				// 1. Buscamos la posición mediante el código
				int posBorrar = buscarCita(citas, sc, cont);

				// Si buscarCita devuelve -1 es que no se encontró o el código era inválido
				if (posBorrar != -1) {
					// 2. Desplazamos los elementos a la izquierda para "tapar" el hueco
					// Empezamos desde la posición encontrada hasta el penúltimo elemento con datos
					for (int i = posBorrar; i < cont - 1; i++) {
						citas[i] = citas[i + 1];
					}

					// 3. Limpiamos la última posición que ahora está duplicada o sobra
					citas[cont - 1] = null;

					// 4. Decrementamos el contador de citas
					cont--;

					System.out.println(">> Cita cancelada y sistema actualizado.");
				} else {
					System.out.println(">> No se pudo realizar la cancel ación.");
				}

				break;

			case 4:
				if (cont == 0) {
					System.out.println("no tenemos ninguna cita guardada en el array");
					break;
				}
				for (int i = 0; i < cont; i++) {
					System.out.println(citas[i].toString());
				}
				break;
			/*
			 * case 4: System.out.println("\n--- LISTADO DE CITAS ---"); for(int i = 0; i <
			 * cont; i++) { // Usamos el patrón "dd/MM/yyyy HH:mm" que definiste en el main
			 * String fechaFormateada = citas[i].getFecha().format(patron);
			 * System.out.println("ID: " + citas[i].getCodigo() + " | Mascota: " +
			 * citas[i].getNombre() + " | Fecha: " + fechaFormateada); } break;
			 */

			case 5: // Insertar en posición específica
				if (cont == citas.length) {
					System.out.println("El array está lleno, no puedes insertar más.");
					break;
				}

				System.out.println("¿En qué posición quieres insertar? (0 a " + cont + ")");
				int posInsertar = sc.nextInt();
				sc.nextLine(); // Limpiar buffer

				if (posInsertar >= 0 && posInsertar <= cont) {
					// 1. Pedir los datos de la nueva cita
					System.out.println("Nombre mascota:");
					nombre = sc.nextLine();
					System.out.println("Motivo:");
					motivo = sc.nextLine();

					do {
						correcto = false;
						try {
							System.out.println("Fecha (dd/MM/yyyy HH:mm):");
							fechaS = sc.nextLine();
							fecha = LocalDateTime.parse(fechaS, patron);
							verificar(fecha); // Tu método de excepción
							correcto = true;
						} catch (DateTimeException e) {
							System.out.println("Formato incorrecto.");
						} catch (FechaInvalidaException e) {
							System.out.println(e.getMessage());
						}
					} while (!correcto);

					// 2. DESPLAZAMIENTO HACIA LA DERECHA
					// Empezamos desde el final (cont) hacia atrás hasta llegar a posInsertar
					for (int i = cont; i > posInsertar; i--) {
						citas[i] = citas[i - 1];
					}

					// 3. Insertar el nuevo objeto en el hueco creado
					citas[posInsertar] = new CocheAYA(nombre, motivo, fecha);

					// 4. Aumentar el contador global
					cont++;
					System.out.println("Cita insertada en la posición " + posInsertar);

				} else {
					System.out.println("Posición inválida.");
				}
				break;
			}
		} while (opc != 6);

	}

	private static int buscarCita(CocheAYA[] citas, Scanner sc, int cont) {
		String codigo;
		int pos = -1;
		do {
			System.out.println("introduce el codigo de la cita");
			codigo = sc.nextLine();
			String format = "^[A-z]{2}-[0-9]{4}$";
			if (!codigo.matches(format)) {
				System.out.println("codigo introducido incorrecto");
			}

			for (int i = 0; i < cont; i++) {
				if (codigo.equals(citas[i].getCodigo())) {
					pos = i;
					break;
				}
			}
			if (pos == -1) {
				System.out.println("codigo incorrecto, vuelve a intentarlo");
				break;
			}
		} while (pos == -1);
		return pos;

	}

	public static boolean verificar(LocalDateTime fecha) throws FechaInvalidaException {
		LocalDateTime hoy = LocalDateTime.now();
		if (fecha.isBefore(hoy)) {
			throw new FechaInvalidaException("la fecha mo puede ser anterior a la de hoy");
		}
		return true;
	}

}
