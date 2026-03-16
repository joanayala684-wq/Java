package control4;

public class Alumno {
	private String dni, nombre, apellido;
	private double nota;
	public Alumno(String dni, String nombre, String apellido, double nota) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nota = nota;
	}
	public String getDni() {
		return dni;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public double getNota() {
		return nota;
	}
	

}
