package Practica13_ej2;

public class etiqueta {
	private int ancho, alto;
	private char letra;
	
	public void setletra(char nueva) {letra=nueva;}
	
	public etiqueta (char l, int h, int w) {
		this.letra=l;
			ancho=w;
			alto=h;
			
	}
	public void dibujar() {
		for(int l=1; l <=alto; l++) {
			for (int i =1; i<=ancho; i++) 
				System.out.print(letra);
			System.out.println();
			
			
		}
																									
	}
	
}
