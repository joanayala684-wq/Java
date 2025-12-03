package Paquetes_Excepciones;
import java.util.Scanner;
public class ejr5_hoja7 {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		/*
		 * En un cine las entradas cuestan 5 euros. Se hace el 50% de descuento los
		martes a los mayores de 65 años, los miércoles el 20% a todos los públicos y el
		fin de semana el 15% a los menores de 18 años. Hacer un programa que simule
		el siguiente proceso : se pide por teclado el día de la semana , se valida que sea
		correcto (L,M,X,J,V,S o D). Se van pidiendo las edades de la gente que llega a la
		taquilla, si es necesario, y se muestra el precio de la entrada.
		Utilizar un método para validar el día y otro para calcular el precio de cada entrada
		 */

				char dia;
				boolean correcto,seguir;
				int edad;
				double precio=0;
				Scanner sc = new Scanner(System.in);
				/*do {
					System.out.println("Introduce día de la semana (L,M,X,J,V,S,D):");
					dia = sc.nextLine().charAt(0);
					dia=Character.toUpperCase(dia); //dia está en mayúsculas
					correcto = esCorrectoDia(dia);
				} while (correcto==false);*/
				System.out.println("Introduce día de la semana (L,M,X,J,V,S,D):");
				dia = sc.nextLine().charAt(0);
				System.out.println("El dia es:"+dia);
				
				do {
					System.out.println("Introduce la edad:");
					edad=sc.nextInt();
					if (edad<0)
						System.out.println("Edad incorrecta");
					else {
						try {
							precio=calcPrecio(dia,edad);
						} catch (DatosInvalidosException e) {
							// TODO Auto-generated catch block
							System.out.println(e.getMessage());
							precio=0;
						}
						System.out.println("El precio a pagar es:"+precio);
					}
					System.out.println("Quieres introducir otra edad?");
					seguir=sc.nextBoolean();
				}while(seguir);
				
				
				
			}
			/**
			 * Recibe un día de la semana y devuelve si es correcto o no
			 * @param dia
			 * @return
			 */
			public static boolean esCorrectoDia(char dia) {
				
				if (dia=='L' || dia=='M' || dia=='X' || dia=='J' || dia=='V' ||dia=='S' || dia=='D')
					return true;
				return false;
			}
			/**
			 * Calcula el precio de una entrada en función del día y la edad
			 * @param dia ya está validado
			 * @param edad
			 * @return el precio que vale la entrada
			 * @throws DatosInvalidosException 
			 */
			public static double calcPrecio(char dia,int edad) throws DatosInvalidosException {
				double entrada=5;
				assert (dia=='L'||dia=='M'||dia=='X'||dia=='J'||dia=='V'||dia=='S'||dia=='D'):"dia incorrecto";
				if(edad<0 || edad>99)
					throw new DatosInvalidosException("edad incorrecta");
				if (dia=='M' && edad>65)
					entrada=entrada*0.5;
				if (dia=='X')
					entrada=entrada*0.8;
				if ((dia=='S' || dia=='D') && edad<18)
					entrada=entrada*0.85;		
				return entrada;
			}

		

	

}
