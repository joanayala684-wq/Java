package ITV;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws AyalaJoanException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		HashSet<String> carburantes = new HashSet<String>();
		LinkedList<Vehiculo> vehiculos = new LinkedList<Vehiculo>();
		carburantes.add("diesel");
		carburantes.add("gasolina");
		carburantes.add("gas");
		carburantes.add("hibrido");
		carburantes.add("electrico");
		Rechazado[] rechazados = new Rechazado[10];
		int contRechazados = 0;
		boolean salir = false;
		String dni = null, matricula = null, carburante = null;
		int opc = 0;
		int posicionCita = 0;
		do {

			System.out.println("BIENVENIDO AL MENU");
			System.out.println("1. Llegada de vehiculo");
			System.out.println("2. Revision de los vehiculos en la cola");
			System.out.println("3. Reparar un vehiculo");
			System.out.println("4. Mostrar informacion");
			System.out.println("introduce la opcion");
			opc=sc.nextInt();
			sc.nextLine();
			switch (opc) {
			case 1:
				Vehiculo v = null;

				String cita, tipo;
				do {
					System.out.println("introduce la matricula");
					matricula = sc.nextLine();
					if (!matricula.matches("[0-9]{4}[A-z]{3}")) {
						System.out.println("el formato de la matricula es incorrecto. ");
					}
				} while (!matricula.matches("[0-9]{4}[A-Z]{3}"));
				do {
					System.out.println("introduce el dni");
					dni = sc.nextLine();

					if (!dni.matches("[0-9]{6,8}[A-Z]{1}")) {
						System.out.println("el formato del DNI es incorrecto. ");
					}
				} while (!dni.matches("[0-9]{6,8}[A-Z]{1}"));
				do {
					System.out.println("introduce el carburante");
					carburante = sc.nextLine();

					if (!carburantes.contains(carburante)) {
						System.out.println("el carburante no es valido ");
					}
				} while (!carburantes.contains(carburante));
				System.out.println("el vehiculo es de transñposte o de carga?");
				tipo = sc.nextLine();
				do {
					if (tipo.equalsIgnoreCase("transporte")) {
						System.out.println("introduce el numero de plazas");
						int num = sc.nextInt();
						sc.nextLine();
						v = new Transporte(matricula, carburante, dni, num);
						salir = true;
					} else if (tipo.equalsIgnoreCase("carga")) {
						System.out.println("introduce el maximo de carga");
						double carga = sc.nextDouble();
						sc.nextLine();
						v = new Carga(matricula, carburante, dni, carga);
						salir = true;
					} else {
						System.out.println("el tipo de vehiculo no es valido.");
					}
				} while (!salir);
				System.out.println("el vehiculo tiene una cita agendada (si/no)");
				cita = sc.nextLine();
				if (cita.equalsIgnoreCase("si")) {
					vehiculos.add(posicionCita, v);
					posicionCita++;
					v.setCita(true);
				} else if (cita.equalsIgnoreCase("no")) {
					vehiculos.add(v);
				}
				System.out.println("vehiculo añadido");
				break;
			case 2:
				v = vehiculos.get(0);
				try {

					double monto = v.pagarITV();
					System.out.println("¡ITV superada! Importe a pagar: " + monto + "€");
					vehiculos.remove(0);
					if(v.isCita()) {
					posicionCita--;}
				} catch (AyalaJoanException e) {
					System.out.println("La ITV ha salido mal: " + e.getMessage());
					if (contRechazados < 10) {
						System.out.println("inidque el mortico");
						String motivo=sc.nextLine();
						rechazados[contRechazados] = new Rechazado (v, motivo);
						contRechazados++;
						vehiculos.remove(0);
						System.out.println("Vehículo movido a la lista de rechazados.");
					} else {
						System.out.println("La lista de rechazados está llena.");
					}

				}
				break;
			case 3:
				salir = false;
				do {
					do {
						System.out.println("introduce la matricula");
						matricula = sc.nextLine();
						if (!matricula.matches("[0-9]{4}[A-z]{3}")) {
							System.out.println("el formato de la matricula es incorrecto. ");
						}
					} while (!matricula.matches("[0-9]{4}[A-Z]{3}"));
					v = buscarVehiculo(rechazados, matricula, contRechazados);
					if (v != null) {
						if (v.isCita()) {
							vehiculos.add(posicionCita, v);
							posicionCita++;
						} else {
							vehiculos.add(v);
						}
						contRechazados--;
						Vehiculo.contSuspensos--;
						salir = true;
						break;
					} else {
						System.out.println("No se ha encontrado ningun vehiculo con esa matricula");
						System.out.println("vuelve a intentarlo");
						System.out.println("si desea salir ponga true");
						salir = sc.nextBoolean();
						if (salir == true) {
							break;
						}
					}
				} while (!salir);
				break;
			case 4:
				for (Vehiculo ve: vehiculos) {
					System.out.println(ve.toString());
					
				}
				// AÑADIDO: Listado de rechazados usando el Iterator requerido (0,25 ptos) e interfaz (1,5 ptos)
				System.out.println("\n--- REVISIONES RECHAZADAS (ORDENADAS) ---");
				ArrayList<Rechazado> listaTemp = new ArrayList<>();
				for (int i = 0; i < contRechazados; i++) {
					listaTemp.add(rechazados[i]);
				}
				// Asumiendo que implementaste Comparable en Rechazado como vimos antes:
				Collections.sort(listaTemp); 
				
				Iterator<Rechazado> it = listaTemp.iterator();
				while(it.hasNext()) {
					Rechazado rch = it.next();
					System.out.println("Matrícula: " + rch.getVehiculo().getMatricula() + " | Motivo: " + rch.getMotivo());
				}
				int contFallos, contTotal, contAprobados;
				contFallos=Vehiculo.contSuspensos;
				contTotal=Vehiculo.contTotal;
				contAprobados=contTotal-contFallos;
				double porcentaje=(contAprobados*100)/contTotal;
				System.out.println("=== ESTADÍSTICAS ITV ===");
		        System.out.println("Vehículos totales atendidos: " + contTotal);
		        System.out.println("Vehículos aprobados: " + contAprobados);
		        System.out.println("Porcentaje de éxito: " + porcentaje + "%");
				break;
			}
		} while (opc != -1);
	}

	public static Vehiculo buscarVehiculo(Rechazado[] rechazados, String matricula, int contRechazados) {
		Rechazado v = null;
		for (int i = 0; i < contRechazados; i++) {
			if (rechazados[i].getVehiculo().getMatricula().equals(matricula)) {
				v = rechazados[i];
				// borramos esa mrd
				for (int j = i; j < contRechazados - 1; j++) {
					rechazados[j] = rechazados[j + 1];
				}
				rechazados[contRechazados - 1] = null;
				return v.getVehiculo();
				
			}
			
		}
		return null ;
	}
}