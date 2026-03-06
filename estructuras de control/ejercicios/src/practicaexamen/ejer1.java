package practicaexamen;

import java.util.Scanner;

public class ejer1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Ejercicio Único: Gestión de Envíos Urgentes (8 Puntos) Una empresa de
		 * logística necesita un sistema para procesar los códigos de seguimiento de sus
		 * paquetes urgentes durante una jornada. Los códigos deben ser validados y, en
		 * caso de error, debe registrarse una incidencia.
		 * 
		 * Requisitos y Especificaciones: Estructura del Código de Seguimiento:
		 * 
		 * Un código de seguimiento debe ser una cadena (String) de exactamente 10
		 * caracteres.
		 * 
		 * Debe comenzar con el prefijo de la ciudad, que puede ser "MAD" (Madrid),
		 * "BCN" (Barcelona), o "VAL" (Valencia).
		 * 
		 * Los siguientes 7 caracteres deben ser dígitos numéricos (del 0 al 9).
		 * 
		 * Ejemplos Válidos: MAD1234567, BCN9876540.
		 * 
		 * Definición de Excepciones (2 Ptos): Deberás crear y utilizar las siguientes
		 * excepciones personalizadas (dentro de un "paquete" o módulo, si tu lenguaje
		 * lo requiere):
		 * 
		 * CodigoInvalidoException: Excepción base que hereda de la clase estándar
		 * Exception.
		 * 
		 * LongitudIncorrectaException: Se lanza si el código no tiene 10 caracteres.
		 * 
		 * PrefijoDesconocidoException: Se lanza si los primeros 3 caracteres no son
		 * MAD, BCN, o VAL.
		 * 
		 * Función de Validación: Define una función llamada validarCodigo(codigo:
		 * String) que reciba el código como parámetro.
		 * 
		 * Dentro de esta función, implementa la lógica necesaria. Si el código no
		 * cumple con la longitud o el prefijo, debe lanzar la excepción personalizada
		 * correspondiente. (4 Ptos)
		 * 
		 
		 * 
		 * Requisitos de Entrega (2 Puntos) Código Fuente: Presenta el código completo
		 * de las clases de excepciones y la función validarCodigo.
		 * 
		 * Resultado Final: Al finalizar, muestra por pantalla:
		 * 
		 * El número total de códigos válidos procesados.
		 * 
		 * El contenido completo de la lista_incidencias.
		 */
		Scanner sc = new Scanner(System.in);
		boolean correcto = false;
		
		String codigo = "";
		do {

			try {
				System.out.println("introduce un codigo de envio");
				codigo=sc.nextLine();
				 {
				correcto = validarCodigo(codigo);}
			} catch (LongitudInvalidaExcepcion e) {
				System.out.println(e.getMessage());
			}catch (PrefijoDesconocidoExcepcion e) {
				System.out.println(e.getMessage());
			}
		} while (!correcto);
		

	}
	public static boolean validarCodigo(String codigo) throws LongitudInvalidaExcepcion, PrefijoDesconocidoExcepcion {
		String patron = "^[A-Z]{3}[0-9]{7}$";
		String letras;
		letras=codigo.substring(0, 3);
		if(codigo.length()!=10) {
			throw new LongitudInvalidaExcepcion("el codigo debe ser de 10 caracteres");
		}
		if(!letras.equalsIgnoreCase("MAD") && !letras.equalsIgnoreCase("BCN") && !letras.equalsIgnoreCase("VAL") ) {
			throw new PrefijoDesconocidoExcepcion("solo tenemos envios para los prefijos MAD, BCN, Y VAL");
		}
		if(!codigo.matches(letras)) {
			return false;
		}
		System.out.println("miaw");
		return true;
		
		
	}

}
