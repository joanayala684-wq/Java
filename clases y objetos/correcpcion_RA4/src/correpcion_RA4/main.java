package correpcion_RA4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Coche coches[];
		int cont = 0, opc = 0, pos = 0;
		String matricula, cod;

		do {
			System.out.println("introduce numero de coches (2-10)");
		} while (cont < 2 || cont > 10);

		coches = new Coche[cont];//creamos el array con el espacio justo 

		for (int i = 0; i < cont; i++) {
			System.out.println("introduce matricula");
			matricula = sc.nextLine();
			if (matricula.matches("[0-9]{4}[A-Z]{3}"))
				coches[i] = new Coche(matricula);
			else {
				System.out.println("matricula incorrecta");
				i--;
			}
		}
		do {
			System.out.println("elige una opcion ");
			System.out.println("1. Reservar vehiculo libre");
			System.out.println("2. Alquilar un vehiculo alquilado");
			System.out.println("3. Acabar el trayecto del vehiculo");
			System.out.println("4. Poner libres todos los vehiculos");
			System.out.println("5. Salir");
			opc = sc.nextInt();
			switch (opc) {
			case 1:
				for (int i = 0; i < cont; i++)
					if (coches[i].getEstado() == 0)
						System.out.println(coches[i].toString() + "" + i);
				try {
				System.out.println("anota ");
				pos = sc.nextInt();
					if (coches[pos].reservar() == null)
						System.out.println("no se ha podido reservar estado incorrecto");
				} catch (InputMismatchException e) {
					System.out.println("no has anotado un numero");
				} catch (IndexOutOfBoundsException e) {
					System.out.println("posicion incorrecta");
				}

				break;
			case 2:
				System.out.println("introduce matricula");
				matricula=sc.nextLine();
				pos=buscar(coches, matricula);
				if(pos==-1)
					System.out.println("no existe ningun coche con esa matricula");
				else {
					System.out.println("anota codigo del vehiculo");
					cod=sc.nextLine();
					if (coches[pos].alquilar(cod))
						System.out.println("coche alquilado con exito");
					else
						System.out.println("no se ha podido alquilar");
				}
				break;
			case 3:
				System.out.println("introduce matricula");
				matricula=sc.nextLine();
				pos=buscar(coches, matricula);
				if(pos==-1)
					System.out.println("no existe ningun coche con esa matricula");
				else {
					double imp=coches[pos].estacionar();
					if(imp==0)
						System.out.println("no se ha podido estacionar");
					else
						System.out.println("tienes que  pagar " +imp + "euros");
				}
				break;
			case 4:
				liberarCoches(coches);
				break;
				
			}
		} while (opc != 5);
		System.out.println("actualmente " + Coche.getAlquilados()+ "alquilados");
		System.out.println("actualmente " + Coche.getReservados()+ "reservados");
	}
	
	public static void liberarCoches  (Coche coches[]) {
		for(int i=0; i<coches.length; i++) {
			coches[i].liberar();
		}
	}
	public static int buscar(Coche[] coches, String matricula) {
		for (int i = 0; i < coches.length; i++) {
			if (coches[i].getMatricula().equalsIgnoreCase(matricula)) {
				return i;
			}
		}
		System.out.println("No encontrado.");
		return -1;
	}

}
