package Ayala_Joan_RA7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Comercial> comerciales = new ArrayList<Comercial>();
		HashMap<String, Integer> registroComercial = new HashMap<>();

		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		double sueldo;
		boolean otro = true;
		HashSet<String> marcas = new HashSet<String>();
		marcas.add("A");
		marcas.add("B");
		marcas.add("C");

		String nombre, tipo, marca = null;
		System.out.println("introduce el salario base de los comerciales fijos");
		sueldo = sc.nextDouble();
		Comercial.setSalario(sueldo);
		do {
			System.out.println("introduce tu nombre");
			nombre = sc.nextLine();
			System.out.println("Esun comercial fijo o con comision(F/C9");
			tipo = sc.nextLine();
			if (tipo.equalsIgnoreCase("F")) {
				comerciales.add(new ComercialFijo(nombre));
			} else {
				do {
					System.out.println("marca conla que tiene convenio");
					marca = sc.nextLine();

				} while (!marcas.contains(marca));
				comerciales.add(new ComercialComision(nombre, marca));
			}
			if (comerciales.size() == 4) {
				otro = false;
			} else if (comerciales.size() >= 1 && comerciales.size() < 4) {
				System.out.println("otro comercial (S/N)");
				String seguir = sc.nextLine();
				if (seguir.equalsIgnoreCase("N")) {
					otro = false;
				}
			}
		} while (comerciales.size() < 1 || comerciales.size() > 4);

		// salgo del bucle porque size>=1 && size<=4
		int numero = 0;
		do {

			Comercial c = null;

			do {
				System.out.println("introduce el nombre del empleado");
				numero = sc.nextInt();
				sc.nextLine();
				if (numero == -1) {
					break;
				}
				c = buscarComercial(comerciales, numero);
				if (c == null) {
					System.out.println("el numero de emple introducido no es valido");

				}
			} while (c == null);
			if (numero == -1) {
				break;
			}
			do {
				System.out.println("introduce la marca ");
				marca = sc.nextLine();
				if (!marcas.contains(marca)) {
					System.out.println("la marca introducida no es valida");
				} else {
					int unidadesVendidas = r.nextInt(1, 20) + 1;
					if (registroComercial.containsKey(marca)) {
						int unidadesAnteriores = registroComercial.get(marca);
						registroComercial.put(marca, unidadesAnteriores + unidadesVendidas);
					} else {
						registroComercial.put(marca, unidadesVendidas);
					}
					c.venta(marca, unidadesVendidas);
					System.out.println("unidades registradas");
				}

			} while (!marcas.contains(marca));
		} while (numero != -1);
		for (Comercial co : comerciales) {
			double paga = 0;

			paga = co.pagar();
			System.out.println("al comercial" + co.getNumEmple() + " se le ha pagado " + paga);
			System.out.println("es un comercial de tipo " + co.getClass().getSimpleName());
		}

		System.out.println("Comerciales:"+ comerciales);
		
		
		System.out.println("Anota marca de la que quieres saber quien ha vendido más:");
		marca=sc.nextLine();
		
		Comercial c=buscarMarcaMasVendida(comerciales,marca);
		
		if (c instanceof ComercialComision)
			System.out.println("El que más ha vendido trabaja a comisión");
		if (c instanceof ComercialFijo) {
			System.out.println("El que más ha vendido trabaja con sueldo fijo");
			((ComercialFijo)c).aumentaExtra();
		}
		
	
		System.out.println("El que más ha vendido es "+ c.getClass().getSimpleName());
		comerciales.sort(new SortPorSalario());
		System.out.println("--- EMPLEADOS ORDENADOS ---");
        for (Comercial com : comerciales) {
            System.out.println(com.getNombre() + " - Salario: " + com.getSalario() + " - Tipo: " + com.getClass().getSimpleName());
        }

	}

	public static Comercial buscarComercial(ArrayList<Comercial> comerciales, int num) {
		boolean validar = false;
		for (Comercial c : comerciales) {
			if (c.getNumEmple() == num) {
				return c;
			}

		}
		return null;
	}
	public static Comercial buscarMarcaMasVendida(ArrayList<Comercial> comerciales,String marca) {
		Comercial c=null;
		int mayor =0;
		for (Comercial co : comerciales) {
			if(co.getMarcas().containsKey(marca)) {
				int unidadesComercial= co.getMarcas().get(marca);
				if(unidadesComercial> mayor ) {
					mayor = unidadesComercial;
					c=co;
				}
				
			}
		}
		return c;
	}

}
