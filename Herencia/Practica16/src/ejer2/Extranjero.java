package ejer2;

public class Extranjero extends Alumno {
	private final double tasas = 15;;
	private String origen;

	@Override
	public String toString() {
		return "Extranjero [origen=" + origen + ", nombre=" + nombre + ", apellido=" + apellido + ", curso=" + curso
				+ ", importe=" + importe + "]";
	}

	public Extranjero(String nombre, String apellido, String curso, double importe, String origen) {
		super(nombre, apellido, curso, importe);
		this.importe = importe + (importe * tasas / 100);
		this.origen = origen;

	}

}