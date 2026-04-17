package ejer4;

import java.util.Random;

public class Serie implements Prestable {

	Random r=new Random();

	private String titulo, genero;
	private int numTemp;
	private boolean prestado=false;
	private static double tasa=2;
	private static double recaudacion;
	private static int contEnPrestamo;
	
	/**
	 * @param titulo
	 * @param genero
	 * @param numTemp
	 * @param prestado
	 */
	protected Serie(String titulo, String genero) {
		this.titulo = titulo;
		this.genero = genero;
		this.numTemp = r.nextInt(3,12)+1;
	}
	@Override
	public double prestar() {
		prestado=true;
		recaudacion+=numTemp*tasa;
		contEnPrestamo++;
		return numTemp*tasa;
		
		
	}
	@Override
	public void devolver() {
		contEnPrestamo--;
		prestado=false;
	}
	@Override
	public boolean isEntragado() {
		return prestado;
	}
	
	@Override
	public String toString() {
		return "Serie [r=" + r + ", titulo=" + titulo + ", genero=" + genero + ", numTemp=" + numTemp + ", prestado="
				+ prestado + "]";
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
