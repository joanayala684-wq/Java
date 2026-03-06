package arrays;

import java.util.Scanner;

public class ejer8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Dado un array de 10 números decid cual es el número que más se repite.*/
		Scanner sc=new Scanner(System.in);
		int numeros[]=new int [10];
		int unicos[]=new int [10];
		int maxconteo=0, masrepetido=0;//varibales utilizadas para guardar el numero mas reptido y su cantidada de repes
		for(int i=0; i<numeros.length; i++) {/*introducimos los datos*/
			System.out.println("introduce un numero");
			numeros[i]=sc.nextInt();}

			int contador_unicos=0;
		for(int i=0; i<numeros.length; i++) {/* convertimos la lsita original a una mas pequeña con los todos los numeros diferentes*/
			boolean enlista=false;
			
			for(int j=0; j<contador_unicos; j++) {/* usamos un bucle anidado para comparar si el numero ya esta dentro de la lista provisional*/
				if(numeros[i]==unicos[j] ){/*si se lo encuenta se sale del bucle*/
					enlista=true;
					break;
				}	
			}
			if(!enlista) {/*si no esta en unicos se lo agrega*/
				unicos[contador_unicos]=numeros[i];/*se usa el contador para saber hasta que casilla se han introducido valores*/
				contador_unicos++;/*se aumenta el contador para que no sobre escriba la casilla ya llenada*/
			}
	
		}
		/*ahora vamos a usar un bucle anidado para comparar unicos con la lista principal*/
		for(int i=0; i<contador_unicos; i++) {/*se usa el contador para no recorrer los espaciosj dejados en blanco del array*/
			int numero_unico=unicos[i];
			int conteo_actual=0;/*para contar el numero de veces que apaerece cada numeo en el array*/
			for(int j=0; j<numeros.length; j++) {
				if(numero_unico==numeros[j]) {
					conteo_actual++;
					
				}
			}
			/*comparamos el conteo actual con el coneto maximo*/
			/*si se cambia el conteo maximo tambien debemos guardar el numeor que genera este conteo*/
			if(conteo_actual>maxconteo) {
				maxconteo=conteo_actual;
				masrepetido=numero_unico;
				
			}
		}
		System.out.println("segun el array introducido el numero coon mas repeticiones es:");
		System.out.println(" numero "+masrepetido+ " con un total de "+maxconteo+ " repeticiones ");
	}

}
