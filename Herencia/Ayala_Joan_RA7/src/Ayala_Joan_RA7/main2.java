package Ayala_Joan_RA7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class main2 {


		public static void main(String[] args) {		
			//Vector <Comercial> comerciales=new Vector();
		String nombre;
		
		final int fijo = 1, comision=2;
		ArrayList<Comercial> comerciales = new ArrayList<>();
		HashSet<String> marcasv = new HashSet<String>();

		HashMap<String, Integer> marcas = new HashMap<>();
		marcas.put("a", 0);
		marcas.put("b", 0);
		marcas.put("c", 0);
		Comercial comercial [];
		int cont=0;
		Random r=new Random();
		Scanner sc=new Scanner(System.in);
		System.out.println("intrpoduce el salario de tus empleados");
		double salario=sc.nextDouble();
		Comercial.setSalario(salario);	
		do {
			if (cont==4) {
				break;
			}
			System.out.println("introduce el nombre");
			nombre=sc.nextLine();
			if (nombre.equalsIgnoreCase("fin")) {
				break;
			}
			int tipoComercial= r.nextInt(2)+1;
			if (tipoComercial== fijo)
				comerciales.add(new ComercialFijo (nombre,marcas));
			else 
				comerciales.add(new ComercialComision (nombre,marcas));
				cont++;
		
		}while(cont>1 || !nombre.equalsIgnoreCase("fin"));
		int numEmple=0;
		do {
		
			System.out.println("introduce el numero del empleado");
			numEmple=sc.nextInt();
			boolean encontrado=false;
			for (Comercial c : comerciales) {
				if (c.getNumEmple()==numEmple) {
				encontrado=true;
				boolean correcto=false;
				do {
					System.out.println("introduce la marca ");
					String marca= sc.nextLine();
					if (marca.equalsIgnoreCase("a") || marca.equalsIgnoreCase("b")|| marca.equalsIgnoreCase("c")) {
						correcto=true;
						int  unidVendidas=r.nextInt(10)+1;
						c.venta(marca, unidVendidas);
					}
				} while(!correcto);
			}
				}
			if (!encontrado) {
				System.out.println("no se ha encontrado el empleado");
				
			}
			
		}while(numEmple != -1);
		for (Comercial c: comerciales) {
			c.pagar();
		}
		System.out.println("introduce una marca");
		String marca=sc.nextLine();
		
		for (Comercial c: comerciales) {
			c.getMarcas();
			if ()
		}
		
		
	/*	for (Comercial c : comerciales) {
			System.out.println(c.toString());
		}*/
		
		
	}

}
