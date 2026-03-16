package ej9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> paisesValidos = new HashSet<String>();
		// la usamos para regustrar los 10 paises permitidos
		HashMap<String, ArrayList<Carta>> sacos = new HashMap<String, ArrayList<Carta>>();
		// se agrupan las cartas, se identifica el pais y se crea el saco de cartas
		LinkedList<Carta> cartasRecibidas = new LinkedList<Carta>();
		// utilizado para ordenar albafeticamente cada carta en su seccion
		//camabiarlo a un array list
		LinkedList<Carta> excluidos = new LinkedList<Carta>();
		// correo basura que no puede ser enviado

		Scanner sc = new Scanner(System.in);
		String destino;
		String apellido, nombre, ciudad, pais;
		
		//puedes declarar el hasset y llamar a la funcion Array.asList
		/*
		 * HashSET <String destinos = new HasSet (Array.asLiat("Madrid", ))*/

		for (int i = 0; i < 10; i++) {
			System.out.println("introduce los paises a los que realizamos envios");
			destino = sc.nextLine();
			if (paisesValidos.contains(destino)) {
				System.out.println("el destino ya se encuentra registrado");
				i--;
			} else
				paisesValidos.add(destino);
		}
		int opc;
		do {
			System.out.println("-------MENU------");
			System.out.println("1. Guardar carta ordenada");
			System.out.println("2. Clasificar cartas");
			System.out.println("3. Mostrar colecciones");
			opc = sc.nextInt();
			sc.nextLine();
			switch (opc) {
			case 1:
				int pos = 0;

				System.out.println(" introduce el apellido");
				apellido = sc.nextLine();
				System.out.println(" introduce el nombre");
				nombre = sc.nextLine();
				System.out.println(" introduce el pais");
				pais = sc.nextLine();
				System.out.println(" introduce el ciudad");
				ciudad = sc.nextLine();
				if (!paisesValidos.contains(pais)) {
					System.out
							.println(" el pais que ha introducido no es valido, su corro pasara a papelera en breves");
					pos = buscarPos(excluidos, apellido);
					Carta carta = new Carta(nombre, apellido, ciudad, pais);
					excluidos.add(carta);
				} else {

					pos = buscarPos(cartasRecibidas, apellido);

					Carta carta = new Carta(nombre, apellido, ciudad, pais);
					cartasRecibidas.add(pos, carta);
				}
				break;
			case 2:
				if (cartasRecibidas.isEmpty()) {
					System.out.println();
				} else {
					for (int i = 0; i < cartasRecibidas.size(); i++) {

						if (!sacos.containsKey(cartasRecibidas.get(i).getPais())) {
							sacos.put(cartasRecibidas.get(i).getPais(), new ArrayList<Carta>());
						}
						// arraylist temporal para ir poniendo las cartas
						ArrayList<Carta> sacoTemporal = sacos.get(cartasRecibidas.get(i).getPais());
						sacoTemporal.add(cartasRecibidas.get(i));
					}
					System.out.println("bandeja vacia");
					cartasRecibidas.clear();
				}
				break;
			case 3:
				// cartas penmdientes de clasificar
				if (cartasRecibidas.isEmpty()) {
					System.out.println("vacia");
				} else {
					for (Carta c : cartasRecibidas) {
						System.out.println("   - " + c);
					}
				}
				// cartas excluidas
				if (excluidos.isEmpty()) {
					System.out.println("vacia");
				} else {
					for (Carta c : excluidos) {
						System.out.println("   - " + c);
					}
				}
				// Mostrar sacos clasificados
				if (sacos.isEmpty()) {
					System.out.println("vacia");
				} else {
					for (String p : sacos.keySet()) {
						ArrayList<Carta> sacoDeEstePais = sacos.get(p);
						System.out.println("   -> SACO [" + p.toUpperCase() + "]: " + sacoDeEstePais);
					}
				}

				break;
			}
		} while (opc != 4);

	}/*
	static void clasificarCartas2(LinkedList <Carta> cartaOrdenadas, HashMap <String , ArrayList <Carta> cartasDestino)
	Iterator<Carta>it=cartasOrdenadas-iterato();
	while (it.hasNext()){
	carta=it.next;
		if (!sacos.containsKey(cartasRecibidas.get(i).getPais())) {
							sacos.put(cartasRecibidas.get(i).getPais(), new ArrayList<Carta>());
						}
						// arraylist temporal para ir poniendo las cartas
						ArrayList<Carta> sacoTemporal = sacos.get(cartasRecibidas.get(i).getPais());
						sacoTemporal.add(cartasRecibidas.get(i));
	
	}
	*/
	public static int buscarPos(LinkedList<Carta> lista, String Newapellido) {
		for (int i = 0; i < lista.size(); i++) {
	
			if (Newapellido.compareToIgnoreCase(lista.get(i).getApellido()) < 0)
				return i;
		}
		return lista.size();
	}

}
