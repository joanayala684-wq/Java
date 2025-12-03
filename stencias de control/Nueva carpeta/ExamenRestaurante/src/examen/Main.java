package examen;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int aforo , grupo, barraLibre, dosCopas, totalReservas , totalPersonas , totalBarra ;
		String tipo;
		boolean correcto, tieneCarnet, confirmar, otra;
		String carnet;
		double precioGrupo, totalGanancias;

		Scanner sc = new Scanner(System.in);

		do {
			// Inicializo variables para una noche
			aforo=80;
			totalReservas = totalPersonas = totalBarra =  0;
			totalGanancias = 0;
			//
			System.out.println("Total aforo:" + aforo);
			System.out.println("Anota número de comensales:");
			grupo = sc.nextInt();
			while (grupo != -1 && aforo > 0) {
				if (grupo <= 0 || aforo - grupo < 0) {
					System.out.println("Número incorrecto de comensales");
				} else {
					sc.nextLine(); // Limpio buffer
					do {
						System.out.println("Introduce tipo de menu: (Eco/Deg/Star");
						tipo = sc.nextLine();
						tipo = tipo.toUpperCase();
						correcto = validarTipoMenu(tipo);
					} while (!correcto); // correcto==false
					do {
						System.out.println("Cuántas personas quieren oferta de dos copas?");
						dosCopas = sc.nextInt();
						System.out.println("Cuántas personas quieren barra libre?");
						barraLibre = sc.nextInt();
						if (grupo < dosCopas + barraLibre)
							System.out.println("No hay tantos comensales");
						if (dosCopas < 0 || barraLibre < 0)
							System.out.println("Las cantidades deben ser positivas");
					} while (grupo < dosCopas + barraLibre || dosCopas < 0 || barraLibre < 0);
					// Salida grupo>=dosCopas+barraLibre && dosCopas>=0 && barraLibre>=0
					precioGrupo = calcularPrecio(grupo, tipo, dosCopas, barraLibre);
					System.out.println("Tienes carnet de socio?");
					tieneCarnet = sc.nextBoolean();
					if (tieneCarnet) {
						System.out.println("Anota el carnet:");
						carnet = sc.nextLine();
						if (validarCarnet(carnet)) {
							System.out.println("Tiene descuento del 20%");
							precioGrupo = precioGrupo * 0.8;
						}
					}
					System.out.println("El precio de su reserva es de:" + precioGrupo + " euros");
					System.out.println("Confirma la reserva?(true/false)");
					confirmar = sc.nextBoolean();
					if (confirmar) {
						aforo = aforo - grupo;
						totalReservas++;
						totalGanancias += precioGrupo;
						totalPersonas += grupo;
						totalBarra += barraLibre;
					}
				}

				System.out.println("Quedan " + aforo + " plazas libres");
				if (aforo > 0) {
					System.out.println("Anota número de comensales:");
					grupo = sc.nextInt();
				}
			} //while
			// Salgo porque grupo==-1 || aforo<=0
			System.out.println("Total ganancias:" + totalGanancias);
			System.out.println("Total reservas:" + totalReservas);
			System.out.println("Porcentaje barra libre:" + ((double) totalBarra / totalPersonas) * 100 + "%");

			System.out.println("Quiere gestionar las reservas de otra noche (true/false");
			otra = sc.nextBoolean();
		} while (otra);
	}

	public static boolean validarTipoMenu(String tipo) {
		if (tipo.equals("ECO") || tipo.equals("DEG") || tipo.equals("STAR"))
			return true;
		return false;
	}

	public static double calcularPrecio(int grupo, String tipo, int dosCopas, int barraLibre) {
		final double MECO = 25, MDEG = 35, MSTAR = 50, PDOS = 9, PLIBRE = 30;
		double precio;

		if (tipo.equalsIgnoreCase("ECO"))
			precio = MECO;
		else if (tipo.equalsIgnoreCase("DEG"))
			precio = MDEG;
		else
			precio = MSTAR;

		precio = precio * grupo + PDOS * dosCopas + PLIBRE * barraLibre;
		return precio;

	}

	public static boolean validarCarnet(String carnet) {
		if (carnet.length() != 4 && carnet.length() != 5)
			return false;
		char letra = carnet.charAt(0);
		if (letra >= 'A' && letra <= 'Z') { // (Character.isAlphabetic(letra) && Character.isUpperCase(letra))
			for (int i = 1; i < carnet.length(); i++) {
				if (carnet.charAt(i) < '0' || carnet.charAt(i) > '9')
					return false;
			}
			return true;
		}

		return false;
	}

}
