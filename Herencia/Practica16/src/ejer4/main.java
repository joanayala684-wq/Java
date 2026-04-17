package ejer4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ejer1.Libro;
import ejer1.Texto;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * En una empresa informática se guarda por cada empleado: nombre, dni,
		 * dirección, teléfono. Hay dos tipos de empleados: propios y externos. De cada
		 * empleado externo se guarda la empresa de la cual procede. A cada empleado el
		 * programa le asigna un número para identificarlo. Realizar un programa en JAVA
		 * que me permita realizar las siguientes operaciones: a. Dar de alta un
		 * empleado. Se pide por teclado el tipo de empleado a dar de alta y se anotan
		 * sus datos. b. Fichar un empleado. Se anota el número del empleado y se pide
		 * el número de horas realizadas, que se acumulan al empleado correspondiente.
		 * c. Reparto de beneficios. Se pide una cantidad por teclado y se reparte a
		 * partes iguales entre todos los empleados propios. d. Pagar a todos los
		 * empleados de la empresa, mostrando por pantalla lo que se le paga a cada uno.
		 * A los empleados externos se les paga a 22 euros la hora realizada, y a los
		 * propios se les paga una cantidad introducida por teclado al dar de alta al
		 * empleado más 15 euros la hora realizada. Una vez pagado un empleado se ponen
		 * a cero las horas realizadas y los beneficios. e. Añadir una opción que
		 * muestre por pantalla la información que se mantiene en la empresa de todos
		 * los empleados.
		 */

		Scanner sc=new Scanner (System.in);
		ArrayList<Empleado> plantilla = new ArrayList<>();
		int opc, tipo, num_emple;
		String dni, nombre, direccion, telefono;
		double salario, beneficio;
		
		do{
			System.out.println("introduce la opcion que quieres realizar");
			System.out.println("1.Dar de alta");
			System.out.println("2.Fichar un empleado");
			System.out.println("3.Repartode beneficios");
			System.out.println("4.Pagar a tdods los empleados");
			System.out.println("5.info de tosos los emple");
			System.out.println("0. salir");

			opc=sc.nextInt();
			sc.nextLine();
			switch(opc) {
			case 1:
				System.out.println("introduce el tipo de empleado 1. Propio 2. Externo");
				tipo=sc.nextInt();
				sc.nextLine();
				System.out.println("introduce el nombre");
				nombre=sc.next();
				System.out.println("introduce el dni");
				dni=sc.next();
				System.out.println("introduce el direccion");
				direccion=sc.next();
				System.out.println("introduce el telefono");
				telefono=sc.next();
				
				if(tipo==1) {
					System.out.println("introduce el salario");
					salario=sc.nextDouble();
					plantilla.add(new Propio(nombre, dni, direccion, telefono, salario));

				}
				if(tipo==2) {
					System.out.println("introduce la empresa de procedencia");
					String nom_empresa = sc.nextLine();
					plantilla.add(new Externo(nombre, dni, direccion, telefono, nom_empresa));

				}
				break;
			case 2:
				System.out.println("introduce el numero de empleado");
				num_emple=sc.nextInt();
				Empleado p;
				boolean encontrado=false;
				for (int i =0; i < plantilla.size(); i++) {
					if (plantilla.get(i).getNum_emple()==num_emple) {
						System.out.println("introduce el numero de horas");
						int horas=sc.nextInt();
						plantilla.get(i).fichar(horas);
						encontrado=true;
						break;
					}}
					if (!encontrado) {
						System.out.println("numero de empleado no encontrado");
					
				
				}
			
				break;
			case 3:
				System.out.println("introduce el beneficio");
				beneficio=sc.nextDouble();
				int totalPropio=0;
				for (Empleado e : plantilla) {
					if (e instanceof Propio) {
						totalPropio++;
					}}
				if (totalPropio > 0) {
					double cuota = beneficio / totalPropio;
			        for (Empleado e : plantilla) {
			        	if (e instanceof Propio) {
			        		((Propio) e).repartoBeneficios(beneficio);
			        	}
			        }
				}
				
				break;
			case 4:
				for (int i =0; i < plantilla.size(); i++) {
					
						double pago = plantilla.get(i).pagar();
						System.out.println("nombre:"+plantilla.get(i).getNombre()+ "pago:" +pago);
					
				}
				break;
			case 5:
				for (int i =0; i < plantilla.size(); i++) {
					System.out.println(plantilla.get(i).toString());
					
				}
				break;
			case 0:
				System.out.println("finalizando menu de opciones");
				break;
			default :
				System.out.println("opcion no valida");
				break;
			
			}
			
		}while(opc!=0);
	}

}
