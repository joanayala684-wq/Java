package modelos;

public class Pasajero {
	private String pasaporte, nombre, nacionalidad;
	private int puntos_fidelidad;
	public Pasajero(String pasaporte, String nombre, String nacionalidad, int puntos_fidelidad) {
		super();
		this.pasaporte = pasaporte;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.puntos_fidelidad = puntos_fidelidad;
	}
	public String getPasaporte() {
		return pasaporte;
	}
	public String getNombre() {
		return nombre;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public int getPuntos_fidelidad() {
		return puntos_fidelidad;
	}
	@Override
	public String toString() {
		return "Pasajero [pasaporte=" + pasaporte + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad
				+ ", puntos_fidelidad=" + puntos_fidelidad + "]";
	}
	

}
