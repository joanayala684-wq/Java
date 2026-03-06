package Teatro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Representacion teatro[] = new Representacion[10];
		final int VIP = 20, NORMI = 14;
		String titulo, fechaS;
		Random r = new Random();
		int opcion = 0, cont = 0, verificacion = 0;
		DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd/MM/yy");
		LocalDate fecha = null;

		do {
			System.out.println("--ABRIENDO MENU DE OPCIONES--");
			System.out.println("1. Dar de alta una representación");
			System.out.println("2. Ordenar las representaciones ");
			System.out.println("3. Mostrar la información de todas las representaciones que tengan entradas libres.");
			System.out.println("4. Comprar entradas");
			System.out.println("5. Mostrar el importe total recaudado");
			System.out.println("0. Salir");
			opcion = sc.nextInt();
			sc.nextLine();
			switch (opcion) {

			case 1:
				if (cont == teatro.length) {
					System.out.println("no hay mas espacio");
				} else {
					boolean correcto = false;
					System.out.println("rellena los campos de la presentacion  ");
					do {
						correcto = false;
						verificacion = 0;
						try {
							System.out.println("introduce la fecha (dd/MM/yy)");
							fechaS = sc.nextLine();
							fecha = LocalDate.parse(fechaS, patron);
							correcto = true;
						} catch (DateTimeParseException e) {
							System.out.println("formato de fecha incorrecto, vuelve a intentarlo");
							correcto = false;
						}
						System.out.println("introduce el titulo de la obra");
						titulo = sc.nextLine();

						// Condición corregida: sigue pidiendo si la fecha está mal O el título vacío
					} while (!correcto || titulo.isEmpty());

					for (int i = 0; i < cont; i++) {
						if (fecha.equals(teatro[i].getFecha())) {
							System.out.println("no es posible dar de alta la funcion porque ya hay otra ese dia");
							verificacion = -1;
							break;
						}
					}
					if (verificacion == 0) {
						teatro[cont] = new Representacion(titulo, fecha);
						cont++;
					}
				}
				break;
			case 2:
				Representacion temp;
				for (int i = 0; i < cont - 1; i++) {
					for (int j = 0; j < cont - i - 1; j++) {
						if (teatro[j].getFecha().isAfter(teatro[j + 1].getFecha())) {
							temp = teatro[j];
							teatro[j] = teatro[j + 1];
							teatro[j + 1] = temp;

						}
					}
				}
				for (int i = 0; i < cont; i++) {
					System.out.println(teatro[i].toString());
				}
				break;
			case 3:

				if (cont == 0) {
					System.out.println("no se ha dado de alta ninguna funcion por el momento");
				}
				for (int i = 0; i < cont; i++) {
					/*
					 * if(teatro[i].hayLibres()) { System.out.println(teatro[i].toString()); }
					 */
					if (teatro[i].getNormal() != 0 || teatro[i].getVips() != 0) {
						System.out.println(teatro[i].toString());
					} else {
						System.out.println("todas las entradas para las funciones estan agotadas");
					}
				}
				break;
			case 4:
				String cod;
				int pos = -1;
				do {
					System.out.println("introduce el codigo de la obra que quieres ver");
					cod = sc.nextLine();
					String format = "^[A-z]{3}-[0-9]{4}$";
					if (!cod.matches(format)) {
						System.out.println("codigo introducido incorrecto");
					}

					for (int i = 0; i < cont; i++) {
						if (cod.equals(teatro[i].getCodigo())) {
							pos = i;
							break;
						}
					}
					if (pos == -1) {
						System.out.println("codigo incorrecto, vuelve a intentarlo");
					}
				} while (pos == -1);
				int total, entradaVip, entradaNormal;
				do {
					entradaVip = r.nextInt(3) + 1;
					entradaNormal = r.nextInt(3) + 1;
					total = entradaVip + entradaNormal;
				} while (total > 5);
				double precio = teatro[pos].comprar(cod, cont, entradaVip, entradaNormal);

				if (precio > 0) {
					System.out.println("Has comprado " + entradaVip + " VIP y " + entradaNormal + " Normales.");

					// BUCLE PARA LAS VIP
					for (int i = 0; i < entradaVip; i++) {
						boolean exito = false;
						while (!exito) {
							System.out.println("Asiento VIP " + (i + 1) + ": Elija fila (0-2) y col (0-4)");
							int f = sc.nextInt();
							int c = sc.nextInt();
							exito = teatro[pos].ocuparAsientoIndividual(f, c, true);
							if (!exito)
								System.out.println("Asiento ocupado o fila no es VIP. Repite.");
						}
					}
					// BUCLE PARA LAS NORMALES
					for (int i = 0; i < entradaNormal; i++) {
						boolean exito = false;
						while (!exito) {
							System.out.println("Asiento Normal " + (i + 1) + ": Elija fila (3-7) y col (0-4)");
							int f = sc.nextInt();
							int c = sc.nextInt();
							exito = teatro[pos].ocuparAsientoIndividual(f, c, false);
							if (!exito)
								System.out.println("Asiento ocupado o fila no es Normal. Repite.");
						}
					}
				}

				break;
			case 5:
				System.out.println("el total recaudado del teatro es " + Representacion.getTotalRecaudado());
				break;
			case 0:
				System.out.println("menu finalizado, hasta pronto");
				break;

			default:
				System.out.println("opcion no valida, vuelve a intentarlo");

			}
		} while (opcion != 0);
	}

	public static int buscar(Representacion teatro[], int cont, String codigo) {
		int pos = -1;

		for (int i = 0; i < cont; i++) {
			if (codigo.equals(teatro[i].getCodigo())) {
				pos = i;
				break;
			}
		}
		return pos;

	}
}
