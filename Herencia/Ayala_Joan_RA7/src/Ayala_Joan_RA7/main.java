package Ayala_Joan_RA7;


import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double salario=0;
		Vector <Comercial> comerciales=new Vector();
		String nombre;
		double unidVendidas;
		int tipoComercial;
		final int fijo = 1, comision=2;
		
		HashMap<HashSet<String>, Integer> marcas = new HashMap<>();
		Comercial comercial [];
		int cont=0;
		Random r=new Random();
		Scanner sc=new Scanner(System.in);
		System.out.println("introduce el salario fijo de tus empleados");
		salario=sc.nextDouble();
	
		do {
			System.out.println("introduce numero de comerciales (1-4)");
			cont=sc.nextInt();
		} while (cont < 1|| cont > 4);
		sc.nextLine();

		comercial = new Comercial[cont];//creamos el array con el espacio justo 
		
		for (int i = 0; i < cont; i++) {
			System.out.println("introduce el nombre");
			nombre=sc.next();
			tipoComercial=r.nextInt(2)+1;
			if (tipoComercial==fijo) {
				comerciales.add(new ComercialFijo(nombre,marcas));
			}else if (tipoComercial==comision) {
				comerciales.add(new ComercialComision(nombre,marcas ));
			}
		}
		int numEmple=0;
		for (Comercial e : comerciales) {
		do {
			System.out.println("introduce el numero delempleado");
			numEmple=sc.nextInt();
			
			if (numEmple==-1) {
				break;
			}
			
			System.out.println("introduce la marca");
			String marca=sc.next();
			if (marca.equals("A") && marca.equals("B")&& marca.equals("C")) {
				break;
			}
			double numunidad=r.nextDouble();

			if(marcas.containsKey(marca)) {

				marcas.put(marca, marcas.get(marca)+numunidad);
			}
			else {
				marcas.put(marca,numunidad);
			}
			
			}while(numEmple!=-1);
		
		
	}
		//Collections.sort(comerciales);
		for(Comercial co : comercial){  
			System.out.println(co);
		}  
	}
}
