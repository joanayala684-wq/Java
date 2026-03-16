package ejexcepciones;
import java.util.*;

/**
 * Programa que recibe un número y devuelve el número de divisores de éste.
 * Descarta usando excepciones los números incorrectos o los menores o iguales que 0
 * @author Bego
 *
 */

public class ExcepcionPropia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero;
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce un número:");
		try{
			numero=sc.nextInt();
			System.out.println("Número de divisores:"+divisoresNumero(numero));
			
		}catch(InputMismatchException e){
			System.out.println("Formato incorrecto");
		}catch(NumeroIncorrectoException e){
			System.out.println(e.getMessage());
			
		}

	}
	
	/**
	 * Función que recibe un número y devuelve el número de divisores de éste
	 * @param num número a procesar
	 * @return número de divisores
	 * @throws NumeroIncorrectoException si el número recibido es negativo ó 0
	 */
	
	public static int divisoresNumero(int num) throws NumeroIncorrectoException{
		int contador=0;
		if (num<=0)
			throw new NumeroIncorrectoException("Valor no permitido");
		for (int i=1;i<=num;i++)
			if (num%i==0)
				contador++;
		return contador;
	}

}
