package ejercicio13;

import java.time.LocalDate;

public class Alumno {
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido=" + apellido + ", nota=" + nota + ", fecha_nac=" + fecha_nac
				+ "]";
	}


	private String nombre, apellido;
	private double nota;
	private LocalDate fecha_nac;
	
	
	public Alumno(String nombre, String apellido, double nota, LocalDate fecha_nac) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nota = nota;
		this.fecha_nac = fecha_nac;

	}


	public double getNota() {
		return nota;
	}


	

}
