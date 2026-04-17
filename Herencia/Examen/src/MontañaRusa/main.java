package MontañaRusa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int ventas[] = new int[5];

		ArrayList<Entrada> plantilla = new ArrayList<>();
		
		DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fechaNacS;
		LocalDate fechaNac = null;
		LocalDate hoy = LocalDate.now();
		Cola miCola = new Cola();
		Vagon viaje = new Vagon();
		double totalRecaudado = 0;
		HashMap<String, Integer> estadisticasTipos = new HashMap<>();
		estadisticasTipos.put("Normal", 0);
		estadisticasTipos.put("Bono", 0);
		estadisticasTipos.put("Promo", 0);
		final int lleno=1, vacio=2;


		int opc;
		do {
			System.out.println("introduce una de las siguientes opciones");
			System.out.println("1. agregar persona a la cola");
			System.out.println("2. ordenar la cola de menor a mayor edad");
			System.out.println("3. Montar en la atraccion");
			System.out.println("4. Poner en marcha la atraccion");
			System.out.println("5. Parar la atraccion");
			System.out.println("6.Mostrara la info de las personas en la cola");
			System.out.println("0. salir");
			opc = sc.nextInt();
			sc.nextLine();

			switch (opc) {
			case 1:
				boolean correcto = false;
				do {
					System.out.println("introduce su fecha de nacimiento");
					fechaNacS = sc.nextLine();
					try {
						fechaNac = LocalDate.parse(fechaNacS, patron);
						correcto = true;
					} catch (DateTimeParseException e) {

						System.out.println("introduce una fecha valida");
					}
				} while (!correcto);

				int edad = (int) Math.abs(ChronoUnit.YEARS.between(fechaNac, hoy));

				double altura = r.nextDouble(70, 210) + 1;
				int tipo = r.nextInt(3) + 1;
				miCola.añadir(tipo, edad, altura);

				break;
			case 2:
				miCola.ordenarCola();
			    System.out.println("Cola ordenada por edad y altura.");
				break;
			case 3:
				if (Cola.getContPersonas() >= 4) {
					Vagon asiento = new Vagon();
					for (int i = 0; i < 4; i++) {
						Entrada pasajero = Cola.getCola().get(0);
						
						try {
							subirAtraccion(pasajero, asiento);
							Cola.getCola().remove(0);
							miCola.restarPersona();
							totalRecaudado += pasajero.pagar();
							String tipoKey = pasajero.getClass().getSimpleName();
			                estadisticasTipos.put(tipoKey, estadisticasTipos.getOrDefault(tipoKey, 0) + 1);
							System.out.println("Pasajero " + (i + 1) + " a bordo.");

						} catch (AlturaNoValidaException e) {
							System.out.println("Pasajero rechazado: " + e.getMessage());
							Cola.getCola().remove(0);
							miCola.restarPersona();

							i--;
						}
					}
				}

				else {
					System.out.println("no hay suficientes personas en la cola");
				}

				break;
			case 4:
				String marcha=viaje.marchar();
				if (marcha != null) {
					System.out.println("la montaña rusa ha iniciado su viaje");
				}
				else {
					System.out.println("el vagon no esta lleno");
				}
				break;
			case 5:
				int estado= viaje.parar();
				if (estado==0) {
					System.out.println("se ha parado la atraccion con exito");
				}
				else {
					System.out.println("la atraccion no esta en marcha");
				}
				break;
			case 6:
				//info de la cola
				miCola.mostrarCola();
				//info de la atraccion (vagon)
				System.out.println("personas en la atraccion");
				Entrada[] enVagon = viaje.getNombres();
				boolean isVacio=true;
				for (Entrada e : enVagon) {
					if (e != null) {
						System.out.println(e.toString());
						isVacio=false;
					}
				}
				if (isVacio) {
					System.out.println("el vagon esta vacio");
				}
				
				//estado de la marcha
				//variable = (condición) ? valor_si_es_cierto : valor_si_es_falso;
				String estadoMarcha = (viaje.getEstado() == 3) ? "SÍ (En movimiento)" : "NO (Parada)";
			    System.out.println("¿En marcha?: " + estadoMarcha);
			    //totalRecaudado
			    double miaw=Entrada.gananciasTotales;
			    System.out.println(miaw);
			    System.out.println(totalRecaudado);
				break;
			case 0:
				System.out.println("cerrando menu de opciones");
				break;
			default:
				System.out.println("opcion selecccionada no valida");
				break;
			}
		} while (opc != 0);

	}

	public static void subirAtraccion(Entrada c, Vagon asiento) throws AlturaNoValidaException {
		
		if (c.getAltura() >= 100 && c.getAltura()<=170) {
		
			asiento.añadir(c);
		}
		else {
			throw new AlturaNoValidaException("no cumple la altura recomendada para la atraccion");
		}
	
}

}
