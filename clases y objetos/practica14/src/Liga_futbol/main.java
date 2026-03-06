package Liga_futbol;

import java.util.Scanner;

import Garaje.Garaje;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Equipo equipo[] = new Equipo[10];
		String nombre, nombre1, nombre2;
		int opcion;
		int goles1, goles2;
		for (int i = 0; i < equipo.length; i++) {
			System.out.print("Ingrese el nombre del equipo " + (i + 1) + ": ");
			nombre = sc.nextLine();
			equipo[i] = new Equipo(nombre);
		}
		do {
			System.out.println("--ABRIENDO MENU DE OPCIONES");
			System.out.println("1. Anotar partido");
			System.out.println("Ordenar equipos por puntos");
			System.out.println("mostrar la info de todos los equipos");
			opcion = sc.nextInt();
			sc.nextLine();
			switch (opcion) {
			case 1:
				boolean correcto = false;
				do {
					try {
						System.out.println("introduce el nombre A");
						nombre1 = sc.nextLine();
						System.out.println("introduce el nombre B");
						nombre2 = sc.nextLine();
						System.out.println("introduce los goles equipo A ");
						goles1 = sc.nextInt();
						System.out.println("introduce los goles equipo B ");
						goles2=sc.nextInt();
						sc.nextLine();
						goles2 = sc.nextInt();
						Anotar_puntos(equipo, nombre1, nombre2, goles1, goles2);
						correcto = true;
					} catch (MismoEquipoException e) {
						System.out.println(e.getMessage());
					}
				} while (!correcto);
				break;
			case 2:
				ordenarEquipos(equipo);
				for (int i = 0; i < equipo.length; i++) {
					System.out.println(equipo[i].getNombre());
					System.out.println(equipo[i].getPuntos());
				}
				break;
			case 3:
				for (int i = 0; i < equipo.length; i++) {
					System.out.println(equipo[i].toString());
				}
				break;
			case 0:
				System.out.println("cerrando menu");
				break;
			default:
				System.out.println("la opcion no es valida, vuelve a intentarlo");
			}
		} while (opcion != 0);

	}

	private static void Anotar_puntos(Equipo[] equipo, String nombre1, String nombre2, int goles1, int goles2)
			throws MismoEquipoException {
		if (nombre1.equalsIgnoreCase(nombre2)) {
			throw new MismoEquipoException("debe seleccionar dos equipos distintos");

		}
		try {
			anotarPuntuacion(equipo, nombre1, goles1, goles2);
			anotarPuntuacion(equipo, nombre2, goles2, goles1);
		} catch (NoEncontradoException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void anotarPuntuacion(Equipo[] equipo, String nombre1, int goles1, int goles2) throws NoEncontradoException {
		boolean encontrado=false;
		for (int i = 0; i < equipo.length; i++) {
			if (nombre1.equalsIgnoreCase(equipo[i].getNombre())) {
				equipo[i].anotarPartido( goles1, goles2);
				encontrado=true;
				break;
			}
		}
		if(!encontrado) {
			throw new NoEncontradoException("el nombre del equipo que has introducido no existe");

		}
		
	}

	public static void ordenarEquipos(Equipo[] equipo) {
		int n = equipo.length;
		Equipo temp; // Variable auxiliar para el intercambio de objetos

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				// Comparamos los puntos del equipo actual con el siguiente
				// Usamos < para que el que tenga más puntos quede arriba (descendente)
				if (equipo[j].getPuntos() < equipo[j + 1].getPuntos()) {

					// Intercambio de posiciones (Swap)
					temp = equipo[j];
					equipo[j] = equipo[j + 1];
					equipo[j + 1] = temp;
				}
			}
		}
	}

} 
