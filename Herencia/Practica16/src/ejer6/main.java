package ejer6;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws SocioYaExistenteException, SocioNoEnGymException {
		// TODO Auto-generated method stub
		/*
		 * 1. En un gimnasio hay dos tipos de socios, los socios “preferentes” y el
		 * resto. De todos ellos se guarda el nombre, apellidos , teléfono , fecha de
		 * nacimiento ( controlar con una excepción que es correcta) . Todos tienen un
		 * código de socio que lo calcula el programa de forma automática, el código de
		 * los socios “preferentes” empieza por P y a continuación tiene el número de
		 * socios de dicho tipo y el resto empieza por N y a continuación tiene el
		 * número de socios de dicho tipo. Los socios “preferentes” pagan una cuota
		 * mensual de 10 euros y además 2 euros cada vez que van al gimnasio. El resto
		 * de socios pagan cada vez que van al gimnasio según el tiempo que permanezcan
		 * en él: Si están menos de 30 segundos 6 euros, hasta 1 minuto 9 euros, de 1
		 * minuto en adelante 12 euros. Se pide hacer un programa, con un menú que
		 * permita realizar las siguientes opciones: a. Dar de alta a un
		 * socio(preguntando de qué tipo). Se produce una excepción si el socio ya está
		 * dado de alta. b. Entrada del socio en el gimnasio. Se anota el código de
		 * socio, se comprueba que no está actualmente en el gimnasio. Codificar el
		 * método entrarGimnasio. Se recoge la hora de entrada. c. Salida del socio del
		 * gimnasio. Se anota el código de socio, si no está se lanza una excepción .
		 * Codificar el método salirGimnasio . Se recoge la hora de salida y se calcula
		 * el tiempo que ha estado en el gimnasio y el importe a pagar. d. Mostrar la
		 * información de todos los socios, incluido cuantas veces ha acudido cada socio
		 * al gimnasio y el tiempo total que ha estado en el gimnasio. e. Cobrar a todos
		 * los socios una mensualidad mostrando por pantalla el importe a pagar por cada
		 * uno de ellos (a los que estén actualmente en el gimnasio no se les cobra la
		 * sesión actual). Se hace un descuento del 20% a los mayores de 60 años. Poner
		 * a 0 el importe a pagar por cada socio y el tiempo de estancia en el gimnasio.
		 **/
		Scanner sc = new Scanner(System.in);
		String nombre, apellido, telefono, fecha;
		LocalDate fechaNac = null;
		HashSet<String> socios = new HashSet<String>();
		DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd/MM/yy");
		LinkedList<Socio> listaSocios = new LinkedList<>();

		int opc, tipo;
		do {
			System.out.println("bienevenido al menu de opciones");
			System.out.println("1. Dar de alta socio");
			System.out.println("2. Entrada del socio en el gimnasio");
			System.out.println("3. Salida del socio en el gimnasio");
			System.out.println("4- Mostrar la info de todos los socios");
			System.out.println("5. Cobrarr mensualidad");
			System.out.println("0. Salir");
			opc = sc.nextInt();
			switch (opc) {
			case 1:
				System.out.println("introduce el nombre ");
				nombre = sc.nextLine();
				System.out.println("introduce el apellido ");
				apellido = sc.nextLine();
				System.out.println("introduce el telefono ");
				telefono = sc.nextLine();

				boolean correcto = false;
				do {
					System.out.println("introduce la fecha de nacimiento ");
					fecha = sc.nextLine();

					try {
						fechaNac = LocalDate.parse(fecha, patron);
						correcto = true;

					} catch (DateTimeParseException e) {
						// TODO Auto-generated catch block
						System.out.println("fecha incorrecta");
					}
				} while (!correcto);
				String socio = nombre.toUpperCase() + " " + apellido.toUpperCase();
				if (!socios.contains(socio)) {
					socios.add(socio);
				} else {
					throw new SocioYaExistenteException("el socio señalado ya se encuentra registrado");
				}
				System.out.println("seleccione el tipo de registro 1. Normal 2. Preferencial");
				tipo = sc.nextInt();
				if (tipo == 1) {

				} else if (tipo == 2) {

				} else {
					System.out.println("el tipo seleccionado no es valido");
				}
				break;
			case 2:
				System.out.println("introduce tu numero de socio por favor ");
				String numSocio = sc.nextLine();
				for (Socio s : listaSocios) {
					String idActual = "";

					if (s instanceof Preferente) {
						idActual = ((Preferente) s).getNumSocio(); // Cast a la hija VIP
					} else if (s instanceof Normal) {
						idActual = ((Normal) s).getNumSocio(); // Cast a la hija Estandar
					}

					if (idActual.equals(numSocio)) {
						System.out.println("Encontrado!");
						s.entrarGimnasio();
						break;
					}
				}

				break;
			case 3:
				boolean encontrado=false;
				double importe=0;
				System.out.println("introduce tu numero de socio por favor ");
				numSocio = sc.nextLine();
				for (Socio s : listaSocios) {
					String idActual = "";

					if (s instanceof Preferente) {
						idActual = ((Preferente) s).getNumSocio(); // Cast a la hija VIP
					} else if (s instanceof Normal) {
						idActual = ((Normal) s).getNumSocio(); // Cast a la hija Estandar
					}

					if (idActual.equals(numSocio)) {
						System.out.println("Encontrado!");
						importe=s.salirGimnasio();
						System.out.println("el importe es de " + importe);
						encontrado=true;
						break;
					}
				}
				if (!encontrado) {
					throw new SocioNoEnGymException("El socio indicado no se encuntra en el establecimiento");
				}
				

				break;
			case 4:
				for (Socio s : listaSocios) {
			        System.out.println(s.toString());
			        System.out.println("Visitas: " + s.getNumAcudido());
			        System.out.println("Tiempo total (seg): " + s.getHorasTotales());
			    }
				break;
			case 5:/*
			    System.out.println("--- PROCESO DE COBRO MENSUAL ---");
			    for (Socio s : listaSocios) {
			        // 1. Calculamos la cuota base según el tipo de socio
			        double importeTotal = s.calcularCuotaMensual(); 
			        
			        // 2. Cálculo de edad para el descuento del 20%
			        int edad = java.time.Period.between(s.getFechaNac(), LocalDate.now()).getYears();
			        
			        if (edad > 60) {
			            System.out.print("[Aplicando desc. 60+] ");
			            importeTotal *= 0.8; // Descuento del 20%
			        }

			        // 3. Mostrar información del cobro
			        System.out.printf("Socio: %s (%s) - Total a cobrar: %.2f€ %n", 
			            s.getNombre(), s.getNumSocio(), importeTotal);

			        // 4. Resetear valores según el enunciado
			        s.setTiempoTotalAcumulado(0);
			        s.setImporteAcumulado(0);
			        // Nota: El enunciado dice poner a 0 el importe y el tiempo, 
			        // pero no las visitas totales (opción d).
			    }
			    System.out.println("Cobro mensual finalizado y contadores reseteados.");
			    break;*/
			case 0:
				break;
			}
		} while (opc != 0);
	}

}
