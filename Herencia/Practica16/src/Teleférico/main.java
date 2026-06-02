package Teleférico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		// Usamos tu array de rechazados
		Rechazado[] rechazados = new Rechazado[10];
		int contRechazados = 0;

		// Instanciamos el teleférico que creamos arriba
		Teleferico teleferico = new Teleferico();
		
		LinkedList<Pasajero> cola = new LinkedList<Pasajero>();
		String dni = null, fechaS = null;
		double altura;
		int opc = 0;
		DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd/MM/yy");

		do {
			System.out.println("\n--- BIENVENIDO AL MENU ---");
			System.out.println("1. Alta Pasajero");
			System.out.println("2. Mostrar y ordenar cola");
			System.out.println("3. Embarcar 4 pasajeros al Teleférico");
			System.out.println("4. Mostrar rechazados y vaciar cabina");
			System.out.println("-1. Salir");
			System.out.print("Introduce la opción: ");
			opc = sc.nextInt();
			sc.nextLine(); // Limpiar buffer

			switch (opc) {
			case 1:
				try {
					System.out.println("Introduce el nombre:");
					String nombre = sc.nextLine();
					
					do {
						System.out.println("Introduce el DNI (8 números y 1 letra):");
						dni = sc.nextLine();
						if (!dni.matches("[0-9]{8}[A-Z]{1}")) {
							System.out.println("El formato del DNI es incorrecto.");
						}
					} while (!dni.matches("[0-9]{8}[A-Z]{1}"));
					
					pasajeroExist(dni, cola);
					
					System.out.println("Introduce la fecha de nacimiento (dd/MM/yy):");
					fechaS = sc.nextLine();
					LocalDate fechaNac = LocalDate.parse(fechaS, patron);
					
					do {
						System.out.println("Introduce la altura (110 - 200 cm):");
						altura = sc.nextDouble();
						if (altura < 110 || altura > 200) {
							System.out.println("Altura no permitida para la atracción.");
						}
					} while (altura < 110 || altura > 200);
					sc.nextLine(); // Limpiar buffer tras leer número

					int num = r.nextInt(3) + 1;
					switch (num) {
					case 1:
						cola.add(new Abonado(nombre, dni, fechaNac, altura));
						System.out.println("Añadido nuevo Abonado de forma aleatoria.");
						break;
					case 2:
						cola.add(new Turista(nombre, dni, fechaNac, altura));
						System.out.println("Añadido nuevo Turista de forma aleatoria.");
						break;
					case 3:
						String cod = "VIP" + (r.nextInt(89) + 10); // Genera dos dígitos (10-98)
						cola.add(new Promocional(nombre, dni, fechaNac, cod, altura));
						System.out.println("Añadido nuevo Promocional con código: " + cod);
						break;
					}

				} catch (DateTimeParseException e) {
					System.out.println("❌ Error en el formato de la fecha.");
				} catch (PasajeroExistenteException e) {
					System.out.println("❌ Error: " + e.getMessage());
				}
				break;

			case 2:
				System.out.println("--- COLA SIN ORDENAR ---");
				for(Pasajero p : cola) {
					System.out.println(p.toString());
				}
				
				Collections.sort(cola); // Usa el compareTo que tú creaste
				
				System.out.println("--- COLA ORDENADA (EDAD ASC Y ALTURA DESC) ---");
				for(Pasajero p : cola) {
					System.out.println(p.toString());
				}
				break;

			case 3:
				if(cola.size() < 4) {
					System.out.println("❌ No hay suficiente gente en la cola (Mínimo 4 personas).");
					break;
				}
				
				System.out.println("--- Iniciando embarque de 4 personas ---");
				// Controlamos que suban exactamente 4 personas aptas usando tu lógica
				while (!teleferico.estaLleno() && !cola.isEmpty()) {
					
					// Sacamos al primero de la cola una única vez
					Pasajero p = cola.remove(0); 
					
					try {
						p.controlAcceso(); // Si mide mal, saltará directo al catch
						p.calcularTarifa();
						
						// Si pasa el control, sube directamente al teleférico
						teleferico.agregarPasajero(p);
						System.out.println("🟢 " + p.getNombre() + " ha subido a la cabina.");
						
					} catch (SizeErrorException e) {
						// Si mide mal, capturamos su caída aquí
						System.out.println("⚠️ RECHAZADO: " + e.getMessage());
						
						if (contRechazados < rechazados.length) {
							System.out.println("Indique el motivo del fallo:");
							String motivo = sc.nextLine();
							rechazados[contRechazados] = new Rechazado(p, motivo);
							contRechazados++;
							System.out.println("Pasajero movido a la lista de rechazados.");
						} else {
							System.out.println("La lista de rechazados está llena.");
						}
					}
				}
				
				// Al terminar el proceso, si se llenó, arranca
				if (teleferico.estaLleno()) {
					teleferico.iniciarViaje();
				}
				break;

			case 4:
				System.out.println("--- HISTORIAL DE RECHAZADOS ---");
				for (int i = 0; i < contRechazados; i++) {
					System.out.println("Pasajero: " + rechazados[i].getPasajero().getNombre() + " | Motivo: " + rechazados[i].getMotivo());
				}
				
				// Vaciamos el teleférico para simular que terminó el viaje
				teleferico.vaciarCabina();
				break;
			
		case 5: // REPARAR / READMITIR PASAJERO RECHAZADO
		    if (contRechazados == 0) {
		        System.out.println("❌ No hay nadie en la lista de rechazados.");
		        break;
		    }

		    System.out.println("Introduce el DNI del pasajero que ha sido reparado/solucionado:");
		    String dniBuscar = sc.nextLine();
		    boolean encontrado = false;

		    // 1. Buscamos al pasajero en el array clásico usando su contador
		    for (int i = 0; i < contRechazados; i++) {
		        // Accedemos al pasajero que está guardado dentro del objeto Rechazado
		        if (rechazados[i].getPasajero().getDni().equals(dniBuscar)) {
		            
		            // Recogemos el objeto Pasajero limpio
		            Pasajero pasajeroSubsanado = rechazados[i].getPasajero();
		            
		            // Lo volvemos a meter al final de tu LinkedList de la cola
		            cola.add(pasajeroSubsanado);
		            System.out.println("🟢 " + pasajeroSubsanado.getNombre() + " ha sido readmitido y vuelve a la cola de espera.");

		            // 2. BORRADO CLÁSICO EN ARRAYS: Desplazamos todos los elementos siguientes una posición a la izquierda
		            for (int j = i; j < contRechazados - 1; j++) {
		                rechazados[j] = rechazados[j + 1];
		            }
		            
		            // El último elemento duplicado lo ponemos a null y restamos 1 al contador
		            rechazados[contRechazados - 1] = null;
		            contRechazados--;
		            
		            encontrado = true;
		            break; // Salimos del bucle for porque ya lo hemos encontrado y gestionado
		        }
		    }

		    if (!encontrado) {
		        System.out.println("❌ No se ha encontrado ningún pasajero con ese DNI en la lista de rechazados.");
		    }
		    break;
			}
		} while (opc != -1);
	}

	public static void pasajeroExist(String dni, LinkedList<Pasajero> socios) throws PasajeroExistenteException {
		for (Pasajero p : socios) {
			if (p.getDni().equals(dni))
				throw new PasajeroExistenteException("El socio ya se encuentra registrado en la cola.");
		}
	}
}