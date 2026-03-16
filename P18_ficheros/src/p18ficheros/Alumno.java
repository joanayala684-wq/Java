package p18ficheros;

import java.time.LocalDate;
/* Alumno con la interface Comparable */
public class Alumno implements Comparable<Alumno> {
	private String nombre, apellido;
	private double nota;
	private LocalDate fecha;
	
	public Alumno(String nombre, String apellido, double nota, LocalDate fecha) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.nota = nota;
		this.fecha = fecha;
	}

	public Alumno(String nombre, String apellido, String nota, String fecha) {
		super();
		//Pensarlo
		/*
		this.nombre = nombre;
		this.apellido = apellido;
		this.nota = nota;
		this.fecha = fecha;*/
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido=" + apellido + ", nota=" + nota + ", fecha=" + fecha + "]";
	}

	@Override
	public int compareTo(Alumno o) {
		// TODO Auto-generated method stub
		if (this.nota==o.nota)
			return 0;
		if (this.nota<o.nota)
			return 1;
		return -1;
	}

	public double getNota() {
		return nota;
	}
	
	
	
}
