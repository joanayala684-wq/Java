package Tarjeta;

import java.util.Scanner;

public class main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		Tarjeta clientes[] = new Tarjeta[3];
		int cont = 0;
		int menu, borrar;
		int año = 0, mes = 0;
		String numero1, numero2;

		do {

			System.out.println("MENU");
			System.out.println("1. DAR DE ALTA CLIENTE");
			System.out.println("2. BLOQUEO TARJETA");
			System.out.println("3. REALIZAR UN PAGO");
			System.out.println("4. DEPOSITAR");
			System.out.println("5. DATOS TARJETA");
			System.out.println("6. COMPROBAR TITULAR");
			System.out.println("7. NUMERO DE TARJETAS BLOQUEADAS");
			System.out.println("8. SALIR ");
			menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			/***************************************************************/

			case 1:

				System.out.println("Numero tarjeta");
				String numero = sc.nextLine();

				System.out.println("Nombre titular");
				String titular = sc.nextLine();

				System.out.println("clave");
				String clave = sc.nextLine();

				System.out.println("Credito tarjeta");
				double credito = sc.nextDouble();

				System.out.println("mes");
				mes = sc.nextInt();

				System.out.println("año");
				año = sc.nextInt();

				clientes[cont] = new Tarjeta(numero, titular, clave, credito, mes, año);

				cont++;

				break;

			/********************************************************************/

			case 2:
				
				System.out.println("Numero tarjeta");
				numero = sc.nextLine();

				int pos = buscar(clientes, cont, numero);

				if (pos == -1) {
					System.out.println("Tarjeta no encontrada");
					break;
				}
				
				if (clientes[pos].isBloqueado()) {
				    System.out.println("La tarjeta ya está bloqueada");
				} else {
				    System.out.println("¿Deseas bloquear la tarjeta? (true/false)");
				    boolean bloquear = sc.nextBoolean();
				    sc.nextLine();

				    if (bloquear) {
				        clientes[pos].setBloqueado(true);
				        System.out.println("Tarjeta bloqueada correctamente");
				    }
				}

					
				
				break;

			/********************************************************************/

			case 3:

				System.out.println("Numero tarjeta");
				numero = sc.nextLine();

				int pos = buscar(clientes, cont, numero);

				if (pos == -1) {
					System.out.println("Tarjeta no encontrada");
					break;
				}

				System.out.println("Cuanto cuesta lo que quiere comprar?");
				double pagar = sc.nextDouble();
				sc.nextLine();
				System.out.println("Dime tu clave");
				clave = sc.nextLine();

				int contIntentos = 0;

				for (int i = 0; i < 3; i++) {

					if (clientes[pos].Pagar(clave, pagar, mes, año, contIntentos)) {
						System.out.println("Pago realizado correctamente");
						break;
					} else {
						contIntentos++;
						System.out.println("No se pudo realizar el pago");
					}
				}

				break;

			/********************************************************************/

			case 4:

				System.out.println("NUMERO CUENTA");
				numero = sc.nextLine();

				System.out.println("Cuanto deseas depositar en tu tarjeta");
				double deposito = sc.nextDouble();

				boolean encontrada = false;

				for (int i = 0; i < cont; i++) {

					if (numero.equals(clientes[i].getNumeroTarjeta())) {

						if (clientes[i].recargar(deposito)) {
							System.out.println("Crédito aumentado, se queda en = " + clientes[i].getCredito());
						} else {
							System.out.println("Cantidad inválida");
						}

						encontrada = true;
						break;
					}
				}

				if (!encontrada) {
					System.out.println("Tarjeta no encontrada");
				}

				break;

			/*********************************************************************/

			case 5:

				System.out.println("DATOS DEL CLIENTE");
				for (int i = 0; i < cont; i++) {
					System.out.println(clientes[i].info());
					System.out.println(clientes[i].toString());
				}
				break;

			case 6:

				System.out.println("Dime numero del titular 1");
				numero1 = sc.nextLine();

				System.out.println("Dime numero del titular 2");
				numero2 = sc.nextLine();

				int posicion1 = buscar(clientes, cont, numero1);
				int posicion2 = buscar(clientes, cont, numero2);

				if (posicion1 == -1 || posicion2 == -1)
					System.out.println("NO ESTA");

				if (clientes[posicion1].mismoTitular(clientes[posicion2]))
					System.out.println("SON EL MISMO TITULAR");

				if (clientes[posicion1].getAño() > clientes[posicion2].getAño()) {
					borrar = posicion2;
				} else {
					borrar = posicion1;
				}

				if (clientes[posicion1].getAño() == clientes[posicion2].getAño()) {

					if (clientes[posicion1].getMes() > clientes[posicion2].getMes()) {
						borrar = posicion2;

					}
				}

				for (int i = borrar; i < cont - 1; i++) {
					clientes[i] = clientes[i + 1];
				}

				clientes[cont - 1] = null; // Limpiamos la última posición
				cont--; // Reducimos el contador de tarjetas activas

				System.out.println("Tarjeta borrada con éxito.");

				break;
				
			case 7:
				
				System.out.println("Numero de tarjetas bloqueadas son" + Tarjeta.getNumBloqueadas() );
				
				break;

			}

		} while (menu != 8);

	}

	private static int buscar(Tarjeta[] clientes, int cont, String numero1) {

		int post = -1;

		for (int i = 0; i < cont; i++) {

			if (numero1.equals(clientes[i].getNumeroTarjeta())) {

				return post = i;

			}
		}

		return post;
	}

}