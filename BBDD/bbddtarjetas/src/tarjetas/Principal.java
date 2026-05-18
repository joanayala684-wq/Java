package tarjetas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import bbdd.BD_Tarjetas;
import modelos.*;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DateTimeFormatter patron = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		Scanner sc = new Scanner(System.in);
		int opc = 0;

		BD_Tarjetas bd = new BD_Tarjetas("mysql-properties.xml");

		do {
			System.out.println("\n" + "=".repeat(30));
			System.out.println("   SISTEMA DE GESTIÓN BANCARIA");
		    System.out.println("=".repeat(30));
		    System.out.println("0. Registrar nuevo movimiento");
		    System.out.println("1. Alta tarjeta (Crédito) desde DNI");
		    System.out.println("2. Alta tarjeta (Débito) desde Cuenta");
		    System.out.println("3. Pago con tarjeta (Débito)");
		    System.out.println("4. Pago con tarjeta (Crédito)");
		    System.out.println("5. Liquidación mensual (Cargar crédito a cuenta)");
		    System.out.println("6. Consultar cuentas por nombre de titular");
		    System.out.println("7. Procesar archivo de movimientos (Lote)");
		    System.out.println("11. Salir");
		    System.out.println("-".repeat(30));
		    System.out.print("Seleccione una opción: ");

			try {
				opc = sc.nextInt();

			}

			catch (InputMismatchException e) {
				System.out.println("Debes introducir n�mero 1-5");
				opc = 0;
			}

			sc.nextLine();

			String contraseña;
			switch (opc) {
			case 0:
				System.out.println("\n\nALTA MOVIMIENTO");
				System.out.println("Anota número de tarjeta:");
				int numTarjeta = sc.nextInt();
				sc.nextLine();
				System.out.println("Anota importe del movimiento:");
				double importe = sc.nextDouble();

				Movimiento mi = new Movimiento(numTarjeta, importe);
				try {
					int filas = bd.añadir_Movimiento(mi);
					if (filas == 0)
						System.out.println("No se ha dado de alta el movimiento. Avise a sistemas");
					else
						System.out.println("Moviento dado de alta");
				} catch (ErrorBaseDatos e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage() + " Avise a sistemas");
				}

				break;
			case 1:
				System.out.println("introduce el dni del titular");
				String dniBusca = sc.nextLine();
				if (!dniBusca.matches("[0-9]{8}[A-Z]")) {
					System.out.println("introduce un dni valido");
				}
				try {
					ArrayList<Cuenta> cuentas = bd.buscarCuenta1(dniBusca);
					if (cuentas.isEmpty()) {
						System.out.println("no se ha encontrado cuentas");

					} else {
						int cont = 0;
						System.out.println("cuentas asociadas");
						for (Cuenta c : cuentas) {
							cont++;
							System.out.println(cont + "." + c.toString());
						}
						int pos;
						do {
							System.out.println("introduce la posicion de la cuenta");
							pos = sc.nextInt();
						} while (pos < 0 || pos > cuentas.size());
						pos--;
						sc.nextLine();
						System.out.println("introduce el titular de la tarjeta");
						String titular = sc.nextLine();
						System.out.println("introduce el limite de la tarjeta ");
						double limite = sc.nextDouble();

						sc.nextLine();
						String clave;
						do {
							System.out.println("Introduce clave de 4 dígitos:");
							clave = sc.nextLine();
						} while (!clave.matches("[0-9]{4}"));

						Tarjeta t = new Tarjeta(cuentas.get(pos).getNumero(), titular, limite, clave);
						try {
							int filas = bd.altaTarjeta(t);
							if (filas == 0)
								System.out.println("No se ha dado de alta el movimiento. Avise a sistemas");
							else
								System.out.println("Moviento dado de alta");
						} catch (ErrorBaseDatos e) {
							// TODO Auto-generated catch block
							System.out.println(e.getMessage() + " Avise a sistemas");
						}
					}

				} catch (ErrorBaseDatos e) {
					System.out.println(e.getMessage() + " Avise a sistemas");

				}
				break;
			/**
			 * Dar de alta una tarjeta de débito. El número de tarjeta será uno más que el
			 * número más alto hasta el momento. Se pide la cuenta y se comprueba que la
			 * cuenta anotada exista. La fecha de caducidad será de 6 meses después de la
			 * fecha actual. El límite es 0. El resto de datos se pide por teclado.
			 **/
			case 2:// alta tarjeta de debito

				System.out.println("introduce el numero de cuenta");
				int numCuenta = sc.nextInt();

				try {
					Cuenta c = bd.buscarCuenta(numCuenta);

				} catch (ErrorBaseDatos e) {
					System.out.println(e.getMessage());
				}
				sc.nextLine();
				System.out.println("introduce el titular de la tarjeta");
				String titular = sc.nextLine();
				String clave;
				do {
					System.out.println("introduce la clave ");
					clave = sc.nextLine();
					if (!clave.matches("[0-9]{4}")) {
						System.out.println("introduce una clave valida");
					}
				} while (!clave.matches("[0-9]{4}"));
				Tarjeta t = new Tarjeta(numCuenta, titular, clave);
				try {
					int filas = bd.altaTarjeta(t);
					if (filas == 0)
						System.out.println("No se ha dado de alta el movimiento. Avise a sistemas");
					else
						System.out.println("Moviento dado de alta");
				} catch (ErrorBaseDatos e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage() + " Avise a sistemas");
				}

				break;
			case 3:

				System.out.println("anota el numero de la tarjeta");
				int numT = sc.nextInt();

				Tarjeta tar = null;
				try {
					tar = bd.buscarTarjeta(numT);
				} catch (ErrorBaseDatos e) {
					System.out.println(e.getMessage());
				}
				sc.nextLine();
				if (tar == null) {
					System.out.println("no existe una tarjeta con ese numeo");
				} else {
					do {
						System.out.println("introduce la contraseña");
						contraseña = sc.nextLine();
						if (!contraseña.equals(tar.getClave())) {
							System.out.println("Contraseña incorrecta. Inténtalo de nuevo.");
						}
					} while (!(contraseña.trim()).equals(tar.getClave()));
					System.out.println("introduce el importe");
					importe = sc.nextDouble();

					try {
						Cuenta c = bd.buscarCuenta(tar.getCuenta());
						int filas = bd.modificarSaldo(c, importe);
						if (filas == 0)
							System.out.println("No se ha dado de alta el movimiento. Avise a sistemas");
						else
							System.out.println("Moviento dado de alta");
					} catch (ErrorBaseDatos e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage() + " Avise a sistemas");
					}

				}
				break;
			case 4:
				System.out.println("anota el numero de la tarjeta");
				numT = sc.nextInt();

				tar = null;
				try {
					tar = bd.buscarTarjeta(numT);
				} catch (ErrorBaseDatos e) {
					System.out.println(e.getMessage());
				}
				sc.nextLine();
				if (tar == null) {
					System.out.println("no existe una tarjeta con ese numeo");
				} else {

					do {
						System.out.println("introduce la contraseña");
						contraseña = sc.nextLine();
						if (!contraseña.equals(tar.getClave())) {
							System.out.println("Contraseña incorrecta. Inténtalo de nuevo.");
						}
					} while (!(contraseña.trim()).equals(tar.getClave()));
					System.out.println("introduce el importe");
					importe = sc.nextDouble();
					if (tar.getTipo().equals("C") && tar.isBloqueado() == false && importe <= tar.getLimite()) {

						Cuenta c = null;
						try {
							c = bd.darCuenta(numT);

							mi = new Movimiento(numT, false, importe, LocalDate.now());
							int filas = bd.añadir_Movimiento(mi);
							if (filas == 0)
								System.out.println("No se ha dado de alta el movimiento. Avise a sistemas");
							else
								System.out.println("Moviento dado de alta");

						} catch (ErrorBaseDatos e) {
							System.out.println(e.getMessage() + " Avise a sistemas");
						}
					}

				}

				break;

			case 5:
				System.out.println("introduce el numero de la tarjeta");
				numT = sc.nextInt();
				try {
					Cuenta c = bd.darCuenta(numT);
					importe = 0;

					importe = bd.calcularCargo(numT);

					int filas = bd.modificarSaldo(c, importe);
					if (filas == 0)
						System.out.println("No se ha modificado el importe. Avise a sistemas");
					else
						System.out.println("Moviento dado de alta");

				} catch (ErrorBaseDatos e) {
					System.out.println(e.getMessage() + " Avise a sistemas");
					
				}
				try {
				int filas=bd.modificarCarga(numT);
				if (filas == 0)
					System.out.println("No se ha modificado el importe. Avise a sistemas");
				else
					System.out.println("Moviento dado de alta");

			} catch (ErrorBaseDatos e) {
				System.out.println(e.getMessage() + " Avise a sistemas");
				
			}
				break;
			case 6:
				System.out.println("introduce el nombre del titular");
				String nombre = sc.nextLine();
				try {
					ArrayList<Tarjeta> tarjetas = bd.buscarTitular(nombre);
					if (tarjetas.isEmpty()) {
						System.out.println("no se ha encontrado movimientos");

					} else {
						int cont = 0;
						System.out.println("movimientos asociados");
						for (Tarjeta t1 : tarjetas) {
							Cuenta c = bd.darCuenta(t1.getNumero());
							System.out.println(c.toString());
						}
					}
				} catch (ErrorBaseDatos e) {
					System.out.println(e.getMessage() + " Avise a sistemas");

				}
				break;
			case 7:
				ArrayList<Movimiento> movimientos = new ArrayList<>();

				Path file = Paths.get("movimientos");
				Path log = Paths.get("log.txt");
				Charset charset = Charset.forName("UTF-8");

				String line = null;
				int cont = 0;

				try (BufferedReader reader = Files.newBufferedReader(file, charset);
						BufferedWriter writer = Files.newBufferedWriter(log, charset)) {
					while ((line = reader.readLine()) != null) {
						cont++;
						String[] partes = line.split(",");
						if (partes.length != 4) {
							writer.write(cont + ". Número incorrecto de campos");
						} else {
							try {
								int numTar = Integer.parseInt(partes[0]);
								boolean cargado = Boolean.parseBoolean(partes[1]);
								double imp = Double.parseDouble(partes[2]);
								LocalDate fecha = LocalDate.parse(partes[3], patron);
								movimientos.add(new Movimiento(numTar, cargado, imp, fecha));

							} catch (DateTimeParseException e) {
								writer.write(cont + ". Formato fecha incorrecto ---" + line + "\n");
							} catch (NumberFormatException e) {
								System.out.println("la nota no es un numero");
								writer.write(cont + ". Numero no valido---" + line + "\n");

							}

						}

					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					bd.altaMovimientos(movimientos);
				} catch (ErrorBaseDatos e) {
					System.out.println(e.getMessage());
				}
				break;
			default:
				System.out.println("Opción incorrecta");
			}

		} while (opc != 11);

	}

}
