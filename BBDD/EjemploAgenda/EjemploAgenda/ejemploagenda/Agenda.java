/*
 * agenda:  principal.
 */

package ejemploagenda;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

import bbdd.BD_Conector;
import modelos.Contacto;
import bbdd.*;

public class Agenda {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		int opc = 0;
		String nombre = "", telefono = "", apellidos = "";
		Contacto ct;
		BD_Agenda bd = new BD_Agenda("age"
				+ "nda");

		do {
			System.out.println(
					"\n1.Nuevo Contacto\n2.Borrar Contacto\n3.Consultar teléfono\n4.Mostrar contactos\n5.Modificar un contacto\n6.Buscar nombre y apellido dado el telefono ");
		
				opc = sc.nextInt();
			
			switch (opc) {
			case 1:
				sc.nextLine();//Limpiando buffer
				System.out.println("Introduce nombre");
				nombre = sc.nextLine();
				System.out.println("Introduce apellidos");
				apellidos = sc.nextLine();
				System.out.println("Introduce telefono");
				telefono = sc.nextLine();
				ct = new Contacto(nombre, apellidos, telefono);
				if (bd.aadir(ct))
					System.out.println("Añadido");
				else
					System.out.println("No se ha podido añadir");
				break;
				
			case 2:
				sc.nextLine(); /*Limpiando buffer
				System.out.println("Introduce nombre");
				nombre = sc.nextLine();
				System.out.println("Introduce apellidos");
				apellidos = sc.nextLine();*/
				System.out.println("Introduce telefono");
				telefono = sc.nextLine();
		
				int filas = bd.borrar(telefono);
				switch (filas) {
				case 0:
					System.out.println("No es contacto");
					break;
				case 1:
					System.out.println("Contacto elimindado");
					break;
				default:
					System.out.println("En este momento no podemos eliminar. Int�ntalo m�s tarde");
				}

				break;
			case 3:
				sc.nextLine(); //Limpiando buffer
				System.out.println("Introduce nombre");
				nombre = sc.nextLine();
				System.out.println("Introduce apellidos");
				apellidos = sc.nextLine();
				ct = new Contacto(nombre, apellidos);
				telefono = bd.buscarTelefono(ct);
				if (telefono == null)
					System.out.println("Por motivos t�cnicos no podemos obtener la información en este momento");
				else if (telefono.equals(""))
					System.out.println("No es contacto");
				else
					System.out.println("Su telefono es: " + telefono);
				break;
			case 4:
				ArrayList<Contacto> v = bd.mostrarContactos();
				for (int i = 0; i < v.size(); i++)
					System.out.println(v.get(i));
				break;
			case 5:
				 sc.nextLine();
				 System.out.println("anpta el telefono para modificar el contacto");
				 String tel=sc.nextLine();
				 System.out.println("introduce nuevo nombre");
				 String nom=sc.nextLine();
				 System.out.println("introduce nuevo apellido");
				 String ap=sc.nextLine();
				 ct = new Contacto(nombre, apellidos, telefono);
					 filas = bd.modificar(ct);
					switch (filas) {
					case 0:
						System.out.println("No es contacto");
						break;
					case 1:
						System.out.println("Contacto elimindado");
						break;
					default:
						System.out.println("En este momento no podemos eliminar. Int�ntalo m�s tarde");
					}
			case 6:
				sc.nextLine(); //Limpiando buffer
				System.out.println("Introduce telefono");
				tel = sc.nextLine();
		
				telefono = bd.buscarTelefono2(tel);
				if (telefono == null)
					System.out.println("Por motivos t�cnicos no podemos obtener la información en este momento");
				else if (telefono.equals(""))
					System.out.println("No es contacto");
				else
					System.out.println("Su telefono es: " + telefono);

				break;
			case 7:
				sc.nextLine(); //Limpiando buffer
				System.out.println("Introduce telefono");
				tel = sc.nextLine();
				Contacto con;
				try {
					con = bd.buscarTelefono3(tel);
				
				if (con == null)
					System.out.println("Sus datos son " + con);

				else
					System.out.println("Sus datos son " + con);
				} catch (SQLException e) {
					System.out.println("avise a sistema");
				}
				break;
			}
			
		} while (opc != 7);

	}

}
