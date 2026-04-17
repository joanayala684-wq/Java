package ejer6;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Socio {
	
	protected int estado;
	protected static final int noEsta=-1;
	protected static final int esta=1;
	protected LocalTime horaEntrada, horaSalida;
	protected double horasTotales;
	
	private String nombre, apellido, telefono;
	private LocalDate fechaNac;
	protected int numAcudido;
	/**
	 * @param nombre
	 * @param apellido
	 * @param telefono
	 * @param fechaNac
	 * @param numAcudido
	 */
	protected Socio(String nombre, String apellido, String telefono, LocalDate fechaNac) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.fechaNac = fechaNac;
		
	}
	public void entrarGimnasio () {
		horaEntrada=null;
		horaEntrada=LocalTime.now();
		estado=esta;
	}
	public abstract double salirGimnasio();
	@Override
	public String toString() {
		return "Socio [nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", fechaNac="
				+ fechaNac + ", numAcudido=" + numAcudido + "]";
	}
	public int getNumAcudido() {
		return numAcudido;
	}
	public double getHorasTotales() {
		return horasTotales;
	}
}
