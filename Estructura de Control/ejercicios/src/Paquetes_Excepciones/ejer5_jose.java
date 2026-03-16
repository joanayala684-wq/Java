package Paquetes_Excepciones;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ejer5_jose {
	static Scanner sc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean correcto = false;
		String nacimiento, posible = null;
		LocalDate fecha;
		DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		// llamo el scanner para poder leer desde cualquier lado
		sc = new Scanner(System.in);

		// pido la fecha
		System.out.println("QUE DIAS HAS NACIDO?");
		nacimiento = sc.nextLine();

		// intento con un bucle por ir pasando por cada caracter del string
		for (int i = 0; i < nacimiento.length(); i++) {
			// si lee un caracter que es numero para
			if (Character.isDigit(nacimiento.charAt(i))) {
				// cuando detecta solo se queda ese numero, entonces le digo i+10 (10 porque es
				// lo que mide mi patron dd/MM/yyyy )para que pille todo los numeros siguientes
				// y que no se pase de la longitud de la cadena
				if (i + 10 <= nacimiento.length()) {
					// posible es la que almacenara la cadena de numeros que hemos sacado con un
					// substring diciendo que pille i y i le sume 10 para coger todos los numeros
					posible = nacimiento.substring(i, i + 10);
					System.out.println("Posible:" + posible);

					// intento pasar el string a local date + el patron, si es correcto sale del
					// bucle
					fecha = LocalDate.parse(posible, patron);
					System.out.println("LA FECHA ES " + patron.format(fecha));

					break;
				}
			}
		}

	}



	}
