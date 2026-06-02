package Gimnasio;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		ArrayList<Socio> listaSocios= new ArrayList<Socio>();
		int tipo;
		String nombre, apellido, telefono, fechaS;
		LocalDate fechaNac;
		DateTimeFormatter patron=DateTimeFormatter.ofPattern("dd/MM/yy");

		int opc = 0;
		do {
			System.out.println("MENU");
			System.out.println("1. Alta socio");
			System.out.println("2. Entrada");
			System.out.println("3. Salida socio");
			System.out.println("4. Mostrar la info de todos los socios");
			System.out.println("5. Cobrar una mensualidad ");
			opc=sc.nextInt();
			sc.nextLine();
			switch(opc) {
			case 1:
				boolean existe=false;
				System.out.println("introduce el nombre");
				nombre=sc.nextLine();
				System.out.println("introduce el apellido");
				apellido=sc.nextLine();
				try {
					socioExist(nombre, apellido, listaSocios);
					System.out.println("introduce el telefono");
					telefono=sc.nextLine();
					System.out.println("introduce la fecha");
					fechaS=sc.nextLine();
					fechaNac=LocalDate.parse(fechaS, patron);
					System.out.println("introduce el tipo de Socio");
					tipo=sc.nextInt();
					if(tipo==1) {
					listaSocios.add(new Normal(nombre, apellido, telefono, fechaNac));
					}else if (tipo==2){
						listaSocios.add(new Preferente(nombre, apellido, telefono, fechaNac));

					}
				} catch (SocioExistenteException e) {
					System.out.println(e.getMessage());
				} catch (DateTimeParseException e) {
				    System.out.println(" Error en la fecha: " + e.getMessage());
				}
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			}
		}while(opc!=-1);
	}

	public static void socioExist (String nombre, String apellido, ArrayList<Socio>listaSocios) throws SocioExistenteException {
		for (Socio so: listaSocios) {
			if(so.getApellido().equalsIgnoreCase(apellido)&& so.getNombre().equalsIgnoreCase(nombre)) {
				throw new SocioExistenteException ("El socio ya se encuntra en el gimnasio");
			}
		}
		
	}
}
