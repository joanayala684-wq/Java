package ejer2;

public class Puente extends Alumno {

	private String carrera;

	public Puente(String nombre, String apellido, String curso, double importe, String carrera) {
		super(nombre, apellido, curso, importe);
		this.carrera = carrera;
	}

	@Override
	public String toString() {
		return "CursoPuente [carrera=" + carrera + ", nombre=" + nombre + ", apellido=" + apellido + ", curso=" + curso
				+ ", importe=" + importe + "]";
	}
}
