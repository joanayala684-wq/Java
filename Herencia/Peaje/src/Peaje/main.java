package Peaje;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int contNormal = 0, contAbonado = 0;
		boolean salir = false;
		ArrayList<Cabina> peaje = new ArrayList<>();
		LinkedList<Vehiculo> colaEspera = new LinkedList<>();
		String matricula = null, tipoV=null, tipoC=null;

		HashSet<String> tipoVehiculos = new HashSet<String>();
		tipoVehiculos.add("turismo");
		tipoVehiculos.add("moto");
		tipoVehiculos.add("otro");
		HashSet<String> tipoUsu = new HashSet<String>();
		tipoUsu.add("abonado");
		tipoUsu.add("normal");
		do {
			peaje.clear();
			contNormal = 0;
			contAbonado = 0;

			for (int i = 0; i < 8; i++) {
				int num = r.nextInt(2) + 1;
				if (num == 1) {
					peaje.add(new Normales());
					contNormal++;
				} else {
					peaje.add(new Abonados());
					contAbonado++;
				}
			}

			if (contNormal > 0 && contAbonado > 0) {
				salir = true;
			}
		} while (!salir);
		int opc = 0;

		do {
			System.out.println("MENU DE OPCIONES");
			System.out.println("1. Abrir una cabina");
			System.out.println("2. Llegar vehiculo");
			System.out.println("3. Pagar");
			System.out.println("4. Mostrar la info");
			System.out.println("5. Cerrar cabina");
			System.out.println("-1. Salir");
			opc = sc.nextInt();
			sc.nextLine();
			switch (opc) {
			case 1:
				Cabina c = null;
				int num;
				
					System.out.println("introduce el numero de la cabina");
					num = sc.nextInt();
					c = buscarCabina(peaje, num);
					if (c != null) {
						c.setAbierta(true);
					} else {
						System.out.println("el numero de la cabina no es valido");
					}
				
				break;
			case 2:
				do {
					System.out.println("introduce la matricula");
					matricula = sc.nextLine();
					if (!matricula.matches("[0-9]{4}[A-z]{3}")) {
						System.out.println("el formato de la matricula es incorrecto. ");
					}
				} while (!matricula.matches("[0-9]{4}[A-Z]{3}"));
				do {
					System.out.println("introduce el tipo de vehiculo");
					tipoV = sc.nextLine().toLowerCase();
					if (!tipoVehiculos.contains(tipoV)) {
						System.out.println("el tipo no es valido");
					}
				} while (!tipoVehiculos.contains(tipoV));
				do {
					System.out.println("introduce el tipo de Cliente");
					tipoC = sc.nextLine().toLowerCase();
					if (!tipoUsu.contains(tipoC)) {
						System.out.println("el tipo no es valido");
					}
				} while (!tipoUsu.contains(tipoC));
				try {
					c=buscarCabinaDisplo(peaje, tipoC);
					c.getCola().add(new Vehiculo (matricula, tipoV, tipoC));
				} catch (NoFoundCabinaOpenException e) {
					colaEspera.add(new Vehiculo (matricula, tipoV, tipoC));
					System.out.println("se lo ha resgustrado en la cola de espera");
				}
				break;
			case 3:
				int numCabina=r.nextInt(peaje.size());
				c=peaje.get(numCabina);
				if (c.isAbierta()) {
					if(!c.getCola().isEmpty()) {
						Vehiculo v= c.getCola().get(0);
						System.out.println("introduce los kilometros recorridos");
						double distancia= sc.nextDouble();
						double importe = c.pagar(distancia, v.getTipoVehiculo());
				
					}
					else {
						System.out.println("la cola de los vehiculos de la cabina esta vacia");
					}
				}
				else {
					System.out.println("la cabina se encuentra cerrada");
				}
				break;
			case 4:
				for (Cabina ca: peaje) {
					System.out.println("el tipo de cabina es "+ ca.getClass().getSimpleName());
					System.out.println(ca.toString());
					if(!ca.getCola().isEmpty()) {
						System.out.println("los vehiculos que estan en la cola de la cabina son");
					for (Vehiculo ve : ca.getCola()) {
						System.out.println("matricula: " + ve.getMatricula());
						System.out.println("tipoVehiculo: " + ve.getTipoVehiculo());

						
					}}
					else {
						System.out.println("la cabina no tiene ningun vehiculo en la cola actualmente");
					}
				}
				
				break;
			case 5:
				int numCa=0;
				System.out.println("anota el numero de la cabina ");
				numCa= sc.nextInt();
				c = buscarCabina(peaje, numCa);
				if(c!=null) {
					
					c.setAbierta(false);
					
					try {
						Cabina destino=buscarCabinaDisplo(peaje, c.getClass().getSimpleName());
						for (int i=0; i < c.getCola().size(); i++) {
							Vehiculo v=c.getCola().get(i);
							destino.getCola().add(v);
						}
						
					} catch (NoFoundCabinaOpenException e) {
					
						System.out.println("se lo ha resgistrado en la cola de espera");
						for (int i = 0; i < c.getCola().size(); i++) {
							Vehiculo v = c.getCola().get(i);
							colaEspera.add(v);
						}
					}
					c.getCola().clear();
				    System.out.println("Cabina cerrada y coches movidos.");
				}else {
					System.out.println("el numero que ha introducido no es valido");
					
				}
				break;
			case -1:
				System.out.println("cerrando menu");
				break;
			default:
				System.out.println("opcion no valida");
				break;
			}
		} while (opc != -1);
		System.out.println("el total de vehiculos atendidos es de:" + Cabina.contVehiculosAtendidosTotal);
		System.out.println("total de vehiculos atendidos en cabinas abonadas "+ Cabina.contAbonados);
		
		
		
		
		Collections.sort(peaje);
		
		System.out.println("\n--- INFORMACIÓN DE CABINAS (ORDENADAS POR ATENDIDOS) ---");
		for (Cabina ca : peaje) {
			System.out.println("Tipo: " + ca.getClass().getSimpleName() + " | " + ca.toString());
			if (!ca.getCola().isEmpty()) {
				System.out.println("Vehículos en cola:");
				for (Vehiculo ve : ca.getCola()) {
					System.out.println("  > Matrícula: " + ve.getMatricula() + " [Tipo: " + ve.getTipoVehiculo() + "]");
				}
			} else {
				System.out.println("  No hay vehículos esperando.");
			}
		}
	}

	public static Cabina buscarCabina(ArrayList<Cabina> peaje, int num) {
		Cabina c = null;
		for (Cabina ca : peaje) {
			if (ca.getNumCabina() == num) {
				return ca;
			}
		}
		return c;
	}
	public static Cabina buscarCabinaDisplo(ArrayList<Cabina> peaje, String tipo) throws NoFoundCabinaOpenException {
		Cabina c = null;
		//int menor =Integer.MAX_VALUE;
		int menor =10000000;
		for (Cabina ca : peaje) {
			if(ca.isAbierta()) {
			if (ca.getClass().getSimpleName().equalsIgnoreCase(tipo)) {
				
				int numActual= ca.getCola().size();
				if (numActual<menor) {
					menor=numActual;
					c=ca;	
				}
			}
		}
			}
		if (c==null) {
			throw new NoFoundCabinaOpenException ("No se ha encontrado ninguna cabina abierta de ese tipo");
		}
		return c;
	}

}
