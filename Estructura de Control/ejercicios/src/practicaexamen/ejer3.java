package practicaexamen;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class ejer3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String cod = "";
		boolean correcto = false;

		String fechaentradas = "", fechacaducidads = "";
		LocalDate fechaentrada = null, fechacaducidad = null;
		DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd/MM/yy");
		do {
			try {
				System.out.println("introduce el codigo del producto ");
				cod = sc.nextLine();
				correcto = ValidarCod(cod);
			} catch (ExtencionIncorrectaExcepcion e) {
				System.out.println(e.getMessage());
			} catch (CategoriaProductoInvalidoException e) {
				System.out.println(e.getMessage());
			} catch (NumEmptyException e) {
				System.out.println(e.getMessage());
			} catch (NumCodIvalidoException e) {
				System.out.println(e.getMessage());
			}
		} while (!correcto);
		for (int i = 0; i < 5; i++) {
			correcto = false;
			do {

				try {
					System.out.println("introduce la fecha de entrada del producto");
					fechaentradas = sc.nextLine();
					fechaentrada = LocalDate.parse(fechaentradas, patron);
					System.out.println("introduce la fecha de entrada del producto");
					fechacaducidads = sc.nextLine();
					fechacaducidad = LocalDate.parse(fechacaducidads, patron);
					if (fechaentrada.isBefore(fechacaducidad)) {
						correcto = true;
					} else {
						System.out.println("Error: La primera fecha debe ser anterior a la segunda.");
					}

				} catch (DateTimeParseException e) {
					System.out.println("introduce una fecha valida");
				} catch (NullPointerException e) {
					System.out.println("introduce una fecha valida");
				} 
			} while (!correcto);
		
		int diff = 0;
		try {
			diff = DiasCaducidad(fechaentrada, fechacaducidad);
		} catch (ProductoCaducidadException e) {
			System.out.println(e.getMessage());
		} catch (ProductoNoCaducadoException e) {
			System.out.println(e.getMessage());
		}
	}
	}
	public static boolean ValidarCod(String cod) throws CategoriaProductoInvalidoException, NumCodIvalidoException,
			ExtencionIncorrectaExcepcion, NumEmptyException {
		String letra = cod.substring(0, 3);
		
		if (cod.length() != 7) {
			throw new ExtencionIncorrectaExcepcion("la extension del codigo debe ser de 7 caracteres");
		}
		if (!letra.equalsIgnoreCase("ALI") && !letra.equalsIgnoreCase("HIG") && !letra.equalsIgnoreCase("ELE")) {
			throw new CategoriaProductoInvalidoException("las unicas categorias validas son, ALI, HIG y ELE");
		}
		String numeros = cod.substring(3, cod.length());
		int numero = Integer.parseInt(numeros);
		for (int i = 4; i < cod.length(); i++) {
			if (!Character.isDigit(cod.charAt(i)))
				throw new NumEmptyException("el codigo debe tener 4 numeros ");
		}
		if (numero < 1000 || numero > 5000) {
			throw new NumCodIvalidoException("los numeros del codigo deben estar comprendidos entre 1000 y 5000");

		}
		return true;

	}
         
	public static int DiasCaducidad(LocalDate fechaentrada, LocalDate fechacaducidad)
			throws ProductoCaducidadException, ProductoNoCaducadoException {
		int diff = (int) ChronoUnit.DAYS.between(fechaentrada, fechacaducidad);
		if (diff > 0) {
			throw new ProductoNoCaducadoException("La vida útil es <= 0 " + Math.abs(diff) + " días");
}
			else {
				throw new ProductoCaducidadException("El producto tiene " + diff + " días de vida útil a partir de su entrada.");}
		
	}
}/*iff > 0 (Positivo)La fecha de caducidad es posterior a la fecha de entrada. Aún tiene vida útil.$\rightarrow$ ProductoNoCaducadoExceptiondiff = 0 (Cero)La fecha de caducidad es igual a la de entrada. Vida útil inmediata / nula.$\rightarrow$ ProductoCaducidadExceptiondiff < 0 (Negativo)La fecha de caducidad es anterior a la fecha de entrada. Registro inválido / Producto caducado al entrar.$\rightarrow$ ProductoCaducidadException*/