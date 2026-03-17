package Sintaxis;

public class Alumno {
	String nombre;
	int edad;

	public Alumno(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	
}