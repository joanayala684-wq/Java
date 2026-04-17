package ejer3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

 
public class main {
	public static void main(String[] args) throws DniNoValidoException {
		// TODO Auto-generated method stub
	/*En un banco existen cuentas de dos tipos: la normal y el cuentón. Una cuenta
normal tiene un interés del 3% mientras que en un cuentón es del 4%. Mientras
que una cuenta normal se puede abrir con cualquier cantidad de dinero, un
cuentón se tiene que abrir con al menos 600 euros. Cada cuenta tiene un número
único que le es asignado por el banco en el momento de abrirla. Además cada
cuenta puede tener varios titulares (máximo 3), que vienen identificados por su nif.
Codificar un programa usando herencia que mantenga un linkedList de cuentas en
el que se puedan hacer las siguientes operaciones:
a) Dar de alta una cuenta.
b) Cancelar (borrar) todas las cuentas en las que figure un titular anotado por
teclado.
c) Al anotar un número de días, nos muestre la información de todas las cuentas,
incluido el dinero que han producido.
Ejemplo: Si una cuenta tiene un capital de 400 euros y se le aplica un
interés del 3% durante 30 días, el dinero producido es:
(400 * 3 * 30) / 365.

d) Sortee un viaje entre todos los cuentones abiertos.*/
	LinkedList<Cuenta> cuentas = new LinkedList<>();

	Scanner sc = new Scanner(System.in);
	String nif;
	int opc=0, num;
	HashSet<String> titulares = new HashSet<String>();

do {
	System.out.println("bienvenido al menu de opciones");
	System.out.println("1.Dar de alta");
	System.out.println("2. cancelar cuentas");
	System.out.println("3. info cuentas");
	System.out.println("0. salir");
	opc=sc.nextInt();
	switch (opc) {
	case 1:
		System.out.println("introduce el numero de titulas");
		num=sc.nextInt();
		for (int i=0; i<num; i++) {
			System.out.println("introduce el nif del titular " + (i+1));
			nif=sc.nextLine();
			if (!nif.matches("[0-9]{8}[A-Z]")) {
				i--;
				throw new DniNoValidoException ("el dni debe tener 8 letras y un numero");
			}
			else {
				if (!titulares.contains(nif)) {
				titulares.add(nif);}
				else {
					System.out.println("el dni ingresado ya esta registrado en la cuenta");
					i--;
				}
				
			}
		}
		System.out.println("introduce el importe");
		double importe=sc.nextDouble();
		System.out.println("selecciona el tipo de cuenta 1 (Normal) 2 (Cuenton)");
		int tipo=sc.nextInt();
		if (tipo==1) {
			cuentas.add(new Cuenta( titulares, importe ));
		}
		else if (tipo==2) {
			try {
				cuentas.add(new Cuenton( titulares, importe ));
			} catch (ImporteNoValidoException e) {
				System.out.println(e.getMessage());
			}
		}
		else {
			System.out.println("opcion no valida");
		}
		
		break;
	case 2:
		System.out.println("introduce el dni del titular a eliminar");
		String titular=sc.nextLine();
		boolean bandera=false;
		for (Cuenta c: cuentas) {
			if (c.getTitulares().contains(titular)) {
				cuentas.remove(c);
				bandera=true;
			}
			
		}
		if (!bandera) {
			System.out.println("no se ha encontrado ninguna cuenta con ese titulat");
		}
		break;
	case 3:
		System.out.println("introduce un numero de dias");
		int dias = sc.nextInt();
		for (Cuenta c : cuentas) {
			System.out.println("la cuenta numero "+ c.getNumCuenta());
			System.out.println("ha ganado "+c.CalcularGanancias(dias)+ "en intereses");
			System.out.println("y tiene de importe " + c.getImporte());
			
		}
		
		break;
	case 4:
		int premio=Cuenton.sorteo();
		if (premio==-1)
			System.out.println("No hay cuentones");
		else
			for(Cuenta cuenta:cuentas)
				if (cuenta instanceof Cuenton)
					if (premio==0) {
						System.out.println("Premiada:"+cuenta);
						break;
					}
					else
						premio--;
		break;
	
	default:
		System.out.println("opcion no valida");
	}
}while(opc!=0);
	}

}
