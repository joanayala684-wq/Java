package ejer2;

public class Alumno {

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	protected String nombre, apellido, curso;
	protected double importe;

	/**
	 * @param nombre
	 * @param apellido
	 * @param curso
	 * @param importe
	 */
	public Alumno(String nombre, String apellido, String curso, double importe) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.curso = curso;
		this.importe = importe;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido=" + apellido + ", curso=" + curso + ", importe=" + importe
				+ "]";
	}
}
