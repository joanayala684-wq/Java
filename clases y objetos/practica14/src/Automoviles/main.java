package Automoviles;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String matricula, marca, modelo;
		int año, categoria;
		boolean correcto = false;
		Automovil automovil[] = new Automovil[5];
		Scanner sc = new Scanner(System.in);
		double importeAlqui=0;

		for (int i = 0; i < automovil.length; i++) {
			do {
				System.out.println("introduce una matricula");
				matricula = sc.nextLine();
				correcto = matricula.matches("[0-9]{4}[A-Z]{3}");
			} while (!correcto);
			System.out.println("introduce marca");
			marca = sc.nextLine();
			System.out.println("introduce modelo");
			modelo = sc.nextLine();
			System.out.println("Año de compra");
			año = sc.nextInt();
			System.out.println("categoria 1/2");
			categoria = sc.nextInt();
			automovil[i] = new Automovil(matricula, modelo, marca, año, categoria);
		}
		int opc=0;
		do {
			System.out.println("1. alquilar, 2 devolver, 3, ");
			opc=sc.nextInt();
			switch(opc) {
			case 1:
				System.out.println("introduce matricula");
				matricula=sc.nextLine();
				int pos=buscarMatriculaVehiculo(automovil, matricula);
				if(pos==-1) {
					System.out.println("no existe ese vehiculo");
				}
				else {
					if(automovil[pos].devolver())
						System.out.println("ya esta alquilado");
					else {
						System.out.println("por cuantos dias vas a alquilarlo?");
						int dias=sc.nextInt();
						importeAlqui=automovil[pos].alquiler(dias);
						if(importeAlqui==0)
							System.out.println("error alquilando,avisa a sistema");
						System.out.println("el importe de su alquier es " + importeAlqui);
					}
				}
				break;
			case 2:
				System.out.println("introduce matricula");
				matricula=sc.nextLine();
				pos=buscarMatriculaVehiculo(automovil, matricula);
				if(pos==-1) {
					System.out.println("no existe ese vehiculo");
				}
				else {
					if(!automovil[pos].devolver())
						System.out.println("no esta alquilado, no se puede devolver");
					else {
						System.out.println("el coche se ha devuleto con exito");	}
				}
				break;
			case 3:
				System.out.println("introduce matricula");
				matricula=sc.nextLine();
				pos=buscarMatriculaVehiculo(automovil, matricula);
				if(pos==-1) {
					System.out.println("no existe ese vehiculo");
				}
				else 
					System.out.println(automovil[pos].toString());
				break;
			case 4:
				for(int i=0; i<automovil.length; i++)
					System.out.println(automovil[i].toString());
				break;
			case 5:
				System.out.println("fin del programa");
				System.out.println("total vehiculos alquilados"+Automovil.getContAlquileres());
				System.out.println("total ganancias"+ Automovil.getGananciasTotalesEmpresa());
				break;
			default:
				System.out.println("opcion incorrecta");
			}
		}while(opc!=5);
		
		
	}
	public static int buscarMatriculaVehiculo (Automovil a[], String mat) {
		for(int i=0; i<a.length; i++) {
			if(a[i].getMatricula().equalsIgnoreCase(mat))
					return i;}
		return -1;
		
	} 

}
