package ejer4;

import java.util.Random;

public class Videojuego implements Prestable {


	Random r=new Random();
	private String titulo, genero, compañia;
	private int hEstimadas;
	private boolean prestado=false;
	private static double tasa=0.5;
	private static double recaudacion;
	private static int contEnPrestamo;
	/**
	 * @param titulo
	 * @param hEstimadas
	 * @param genero
	 * @param compañia
	 * @param numTemp
	 * @param prestado
	 */
	protected Videojuego(String titulo, String genero, String compañia) {
		this.titulo = titulo;
		this.hEstimadas = r.nextInt(10,50)+1;
		this.genero = genero;
		this.compañia = compañia;
	}
	@Override
	public double prestar() {
		prestado=true;
		recaudacion+=hEstimadas*tasa;
		contEnPrestamo++;
		return hEstimadas*tasa;
		
		
	}
	@Override
	public void devolver() {
		contEnPrestamo--;
		prestado=false;
	}
	@Override
	public String toString() {
		return "Videojuego [r=" + r + ", titulo=" + titulo + ", genero=" + genero + ", compañia=" + compañia
				+ ", hEstimadas=" + hEstimadas + ", prestado=" + prestado + "]";
	}
	@Override
	public boolean isEntragado() {
		return prestado;
	}
	public String getTitulo() {
		return titulo;
	}
	public static double getRecaudacion() {
		return recaudacion;
	}
	public static int getContEnPrestamo() {
		return contEnPrestamo;
	}
}
