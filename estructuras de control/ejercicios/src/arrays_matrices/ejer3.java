package arrays_matrices;
import java.util.Random;

public class ejer3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Generar una matriz con números aleatorios, mostrarla por pantalla y después
			mostrar su transpuesta, es decir cambiar las filas por columnas.*/
		Random r=new Random();
		int fila=r.nextInt(6)+1;
		int colum=r.nextInt(4)+3;
		int matriz[][] = new int[fila][colum];
		for(int f=0; f<fila; f++) {
			for(int c=0; c<colum; c++) {
				matriz[f][c]=r.nextInt(10);
				}
			}
		for(int f=0; f<fila; f++) {
			for(int c=0; c<colum; c++) {
				System.out.print("\t"+ matriz[f][c]);
				}
			System.out.println();
			}
		System.out.println("ahora mostraremos su transpuesta");
		
		for(int f=0; f<colum; f++) {
			for(int c=0; c<fila; c++) {
				System.out.print("\t"+ matriz[c][f]);
				}
			System.out.println();
			}
	}

}
