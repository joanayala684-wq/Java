package arrays;

import java.util.Random;
import java.util.Scanner;

public class ahorcados {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		/*Implementad el juego del ahorcado. Llevad un array con el nombre de 20 películas.
			Cuando empieza el juego elegir una al azar. Mostrar al usuario el primer y último
			carácter de dicha película y todas las apariciones de estas letras en la película. El
			usuario va diciendo letras una a una y éstas se van mostrando en la película. Si falla
			5 letras pierde y termina el juego. Si adivina antes la película gana 3 puntos y tiene
			que adivinar el nombre de otra película. Se muestra al final el total de puntos
			obtenidos.*/
		Random r = new Random();
		boolean continua = false;
		String peliculas[] = { "El Rey León", "La Sirenita", "La Bella y la Bestia", "Aladdín", "Bambi", "Dumbo",
				"Peter Pan", "Pocahontas", "Frozen", "Enredados", "Zootopia", "Moana", "Toy Story", "Monstruos SA",
				"Buscando a Nemo", "Los Increíbles", "Ratatouille", "Wall E", "Del Revés", "Up" };
		System.out.println("Bienvenido al juego del ahorcado tematica Disney ");
		System.out.println("Comencemos");
			int puntos=0;
			int num_peli = r.nextInt(20);
			int extension = (peliculas[num_peli].length());
			String secreta = peliculas[num_peli].toUpperCase();
			char peliRevelada[] = new char[extension];
			char primer = secreta.charAt(0);
			char ultimo = secreta.charAt(extension-1);

			for (int i = 0; i < extension; i++) {
				char actual = secreta.charAt(i);
				if (actual == ' ' || actual == '-') {
					peliRevelada[i] = actual;
				} else if (actual == primer || actual == ultimo) {
					peliRevelada[i] = actual;
				} else {
					peliRevelada[i] = '_';
				}
			}
			System.out.println("vamos a empezar el juego, aqui tienes una pista");

			int fallos=5;
			char letra;
			boolean  encontrada=false;
			boolean victoria = false;
			
			do {
				
				encontrada=false;
				for(int i=0; i<extension; i++) {
					System.out.print( peliRevelada[i] +" ");
				}
				System.out.println("");
				System.out.println("intentos restantes" +fallos);
				System.out.println("introduce una letra  ");
				letra=sc.nextLine().charAt(0);
				for(int i = 0; i < extension; i++) {
					char actual=peliRevelada[i];
					if(letra==secreta.charAt(i)) { 
						if(actual=='_') {
							peliRevelada[i] = letra;
							encontrada=true;
						}
						else if(actual!='_') {
							encontrada=true;
						}
					
							
					}
				}
				int cont=0;
				
				if( !encontrada) {
				fallos--;
				System.out.println("te queda un total de " +fallos +"intentos");}
				
				for(int i = 0; i < extension; i++) {
					char caracter='_';
					if(caracter!=peliRevelada[i]) {
						cont++;
					}
					
				}
				if(cont==extension) {
					victoria=true;
					puntos+=3;
					System.out.println("felicidades has ganado");
					System.out.println("la peli era " +secreta);
					System.out.println("comencemos otra ronda");
				}
			}while(fallos>0 && !victoria);
			
			if(fallos==0) {
				System.out.println("has perdido");
				System.out.println("la peli era " +secreta);}
			}

}


