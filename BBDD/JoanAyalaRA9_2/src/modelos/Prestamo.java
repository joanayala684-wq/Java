package modelos;

import java.time.LocalDate;

public class Prestamo {
	private int codigousuario;
	private String isbnlibro;
	private LocalDate fechadevolucion;
	public Prestamo(int codigousuario, String isbnlibro, LocalDate fechadevolucion) {
		super();
		this.codigousuario = codigousuario;
		this.isbnlibro = isbnlibro;
		this.fechadevolucion = fechadevolucion;
	}
	public int getCodigousuario() {
		return codigousuario;
	}
	public String getIsbnlibro() {
		return isbnlibro;
	}
	public LocalDate getFechadevolucion() {
		return fechadevolucion;
	}
	@Override
	public String toString() {
		return "Prestamo [codigousuario=" + codigousuario + ", isbnlibro=" + isbnlibro + ", fechadevolucion="
				+ fechadevolucion + "]";
	}
	
}
