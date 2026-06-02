package comerciales;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean otro = true;
		String nombre, tipo, marca;
		double sueldoFijo;
		int unidades;
		Comercial c;
		
		HashSet<String> marcas = new HashSet<>();
		marcas.add("A");
		marcas.add("B");
		marcas.add("C");

		ArrayList<Comercial> comerciales = new ArrayList<>();
		Scanner sc = new Scanner(System.in);

		System.out.println("Anota sueldo base de los empleados que trabajan a sueldo fijo:");
		sueldoFijo = sc.nextDouble();
		Fijo.setFijo(sueldoFijo);
		
		sc.nextLine(); //Limpio buffer

		do {

			System.out.println("Introduce nombre:");
			nombre = sc.nextLine();
			System.out.println("Es un comercial fijo o con comisión (F/C)");
			tipo = sc.nextLine();
			if (tipo.equalsIgnoreCase("F")) {
				comerciales.add(new Fijo(nombre));
			} else {
				do {
					System.out.println("Marca de la que obtiene beneficios extra:");
					marca = sc.nextLine();
				} while (!marcas.contains(marca));
				comerciales.add(new Comision(nombre, marca));
			}

			if (comerciales.size() == 4)
				otro = false;
			else if (comerciales.size() >= 1 && comerciales.size() < 4) {
				System.out.println("Otro comercial (S/N)");
				String seguir = sc.nextLine();
				if (seguir.equalsIgnoreCase("N"))
					otro = false;
			}

		} while (otro == true);
		
		System.out.println("Comerciales:"+ comerciales);
		
		
		System.out.println("Número del comercial:");
		int num=sc.nextInt();
		
		while (num!=-1) {
			c=buscarComercial(comerciales,num);
			if (c==null)
				System.out.println("No existe el comercial");
			else {
				sc.nextLine(); //Limpio
				System.out.println("Introduce marca:");
				marca=sc.nextLine();
				if (marcas.contains(marca)) {
					System.out.println("Unidades vendidas:");
					unidades=sc.nextInt();
					c.vender(unidades, marca);
				}
				else
					System.out.println("No existe esa marca");
			}
			System.out.println("Número del comercial:");
			num=sc.nextInt();
		}
		
		System.out.println("Comerciales:"+ comerciales);
		
		for (Comercial c1:comerciales) {
			System.out.println(c1.getNombre()+ " a cobrado "+ c1.pagar());
		}
		
		System.out.println("Comerciales:"+ comerciales);
		
		
		System.out.println("Anota marca de la que quieres saber quien ha vendido más:");
		marca=sc.nextLine();
		
		c=buscarMarcaMasVendida(comerciales,marca);
		
		if (c instanceof Comision)
			System.out.println("El que más ha vendido trabaja a comisión");
		if (c instanceof Fijo) {
			System.out.println("El que más ha vendido trabaja con sueldo fijo");
			((Fijo)c).aumentaExtra();
		}
		
		/*
		System.out.println("El que más ha vendido es "+ c.getClass().getSimpleName());
		*/
		

	}
	
	
	public static Comercial buscarComercial(ArrayList<Comercial> comerciales,int num) {
		for(Comercial c: comerciales) {
			if (c.getNumero()==num)
				return c;
		}
		return null;
			
	}
	
	public static Comercial buscarMarcaMasVendida(ArrayList<Comercial> comerciales,String marca) {
		return null;
	}

}
