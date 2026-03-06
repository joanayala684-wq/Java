package proyecto_dado;

import java.util.Random;
import java.util.Scanner;

public class proyeto_dado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		Random r = new Random();

		int num_ronda = 0;
		int resultado1 = 0, resultado2 = 0;

		System.out.println("Empieza el juego");

		System.out.println("introduce el numero de rodas que quieres jugar");

		num_ronda = sc.nextInt();

		for (int i = 0; i < num_ronda; i++) {// juega el jugador
			int puntaje = 0;
			int dados[];

			System.out.println("Inicio ronda:" + i);

			dados = lanzar_dados(r);
			System.out.println("Resultados");
			for (int j = 0; j < dados.length; j++) {
				System.out.println(" dado " + j + " : " + dados[j]);
			}
			int dado1 = dados[0];
			int dado2 = dados[1];
			int dado3 = dados[2];

			if (dado1 == dado2 || dado2 == dado3 || dado1 == dado3) {

				System.out.println("puedes volver a tirar un dado");
				puntaje = relanzar_dado(dado1, dado2, dado3);
				puntaje = puntaje + 2;
			} else {

				puntaje = condiciones_puntos(dado1, dado2, dado3);
			}
			resultado1 += puntaje;
		}

		for (int i = 0; i < num_ronda; i++) {// juega la maquina
			int puntaje = 0;
			int dados[];

			System.out.println("Inicio ronda:" + i);

			dados = lanzar_dados(r);
			System.out.println("Resultados");
			for (int j = 0; j < dados.length; j++) {
				System.out.println(" dado " + j + " : " + dados[j]);
			}
			int dado1 = dados[0];
			int dado2 = dados[1];
			int dado3 = dados[2];

			if (dado1 == dado2 || dado2 == dado3 || dado1 == dado3) {
				System.out.println("puedes volver a tirar un dado");

				if (dado1 == dado2 && dado2 == dado3) {
					puntaje = puntaje + 3;
				} else {
					puntaje = puntaje + 2;
				}
			} else {

				puntaje = condiciones_puntos(dado1, dado2, dado3);
			}
			resultado2 += puntaje;
		}

		System.out.println("Fin del juego, comparemos resultados");
		System.out.println("jugador: " + resultado1);
		System.out.println("maquina: " + resultado2);
		if (resultado1 > resultado2)
			System.out.println("el ganador es el jugador");
		else if (resultado1 == resultado2)
			System.out.println("se ha producido un empate");
		else
			System.out.println("el ganador es la maquina");

	}

	
	public static int[] lanzar_dados(Random r) {
		int dados[] = new int[3];
		int puntaje=0;
		for (int i = 0; i < dados.length; i++) {
			dados[i] = r.nextInt(6) + 1;
		}
		return dados;

	}
	public static int Partidas (int dados[], int num_ronda, Random r) {
		int resultado=0, puntaje=0;
		for (int i = 0; i < num_ronda; i++) {// juega el jugador
			System.out.println("Inicio ronda:" + i);
			dados = lanzar_dados(r);
			System.out.println("Resultados");
			for (int j = 0; j < dados.length; j++) {
				System.out.println(" dado " + j + " : " + dados[j]);
			}
			int dado1 = dados[0];
			int dado2 = dados[1];
			int dado3 = dados[2];

			if (dado1 == dado2 || dado2 == dado3 || dado1 == dado3) {

				System.out.println("puedes volver a tirar un dado");
				puntaje = relanzar_dado(dado1, dado2, dado3);
				puntaje = puntaje + 2;
			} else {

				puntaje = condiciones_puntos(dado1, dado2, dado3);
			}
			resultado += puntaje;
		}
		return puntaje;

	}

	public static int condiciones_puntos(int dado1, int dado2, int dado3) {
		int puntaje = dado1 + dado2 + dado3;
		if (dado1 == dado2 && dado2 == dado3) {
			puntaje = puntaje + 3;
		}
		if (dado1 == dado2 || dado2 == dado3 || dado1 == dado3) {
			puntaje = puntaje + 2;

		}
		if (dado1 != dado2 || dado2 != dado3 || dado1 != dado3) {
			if (dado1 == 6 || dado2 == 6 || dado3 == 6) {

 }
			puntaje = puntaje + 1;
		}
		return puntaje;
	}

	public static int relanzar_dado(int dados[], Random r) {
		int dado1 = dados[0];
		int dado2 = dados[1];
		int dado3 = dados[2];
		int puntaje = 0;
		if (dado1 == dado2) {
			dado3 = r.nextInt(6) + 1;
			System.out.println("dado3: " + dado3);
		}
		if (dado2 == dado3) {
			dado1 = r.nextInt(6) + 1;
			System.out.println("dado1: " + dado1);
		}
		if (dado1 == dado3) {
			dado2 = r.nextInt(6) + 1;
			System.out.println("dado2: " + dado2);
		}

		puntaje = dado1 + dado2 + dado3;
		return puntaje;

	}
}
