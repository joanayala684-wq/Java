package control6;

public class Asistente {
	private String dni, nombre;
	private int edad;
	@Override
	public String toString() {
		return "Asistente [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + "]";
	}
	public String getDni() {
		return dni;
	}
	public String getNombre() {
		return nombre;
	}
	public int getEdad() {
		return edad;
	}
	
}
