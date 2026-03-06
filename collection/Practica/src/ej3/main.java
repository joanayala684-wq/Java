package ej3;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import ej1.Alumno;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		String nombre;
		int numEntradas = 0, opc, entradas;
		System.out.println("anota el numero de entradas que hay a la venta ");
		entradas=sc.nextInt();
		Usuario.setDisplo(entradas);
		do {
			System.out.println("---MENU ---");
			System.out.println("1.dar de alta una persona en la fila");
			System.out.println("2. comprar entradas");
			System.out.println("3. borrar usuario random");
			opc = sc.nextInt();
			switch (opc) {
			case 1:
				sc.nextLine();

				int pos;
				System.out.println("introduce el nombre");
				nombre = sc.nextLine();
				pos = buscarLink(usuarios, nombre);
				if (pos != -1) {
					System.out.println("el usuario ya esta registrado");

				} else {
					System.out.println("introduce el numero de entradas");
					numEntradas = sc.nextInt();
					usuarios.add(new Usuario(nombre, numEntradas));
				}
				break;
			case 2:
				sc.nextLine();
				if (usuarios.isEmpty()) {
					System.out.println("no hay ningun elemento ");
					break;
				}
				int mensaje;

				mensaje = usuarios.get(0).comprar();
				if (mensaje == 0) {
					System.out.println("no hay suficientes entradas disponibles");
					System.out.println("compra cancelada");
				}

				if (mensaje == -1) {
					usuarios.clear();
					break;
				} else {
					usuarios.remove(0);
				}
				break;
			case 3:
				sc.nextLine();
				if (usuarios.isEmpty()) {
					System.out.println("no hay ningun elemento ");
					break;
				}

				int delete = r.nextInt(usuarios.size());
				System.out.println(usuarios.get(delete).getNombre() + "ha abandonado la fila");
				usuarios.remove(delete);
				break;
			case 4:
				System.out.println("cerrando menu");
				break;
			default:
				System.out.println("opcion no valida, vuelve a intentarlo");
				break;
			}
		} while (opc != 4);
	}

	public static int buscarLink(LinkedList<Usuario> fila, String nombre) {
		int pos = -1;
		for (int i = 0; i < fila.size(); i++) {
			if (fila.get(i).getNombre().equalsIgnoreCase(nombre)) {
				pos = i;
				break;
			}
		}
		return pos;
	}
}
