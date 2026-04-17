package ejer2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Medicamento implements Caducable {
	private String nombre;
	private LocalDate fecha;


	/**
	 * @param nombre
	 * @param dni
	 * @param fecha
	 */
	protected Medicamento(String nombre, LocalDate fecha) {
		this.nombre = nombre;

		this.fecha = fecha;
	}

	@Override
	public boolean isCaducado() {
		LocalDate hoy=LocalDate.now();
		if(fecha.isAfter(hoy)) {
			return false;
		}
		return true;
	}

	@Override
	public int diasRestantes() {
		LocalDate hoy=LocalDate.now();
		int difftotaldias;
		difftotaldias=(int) ChronoUnit.DAYS.between(hoy, fecha);
		return difftotaldias; 
	}
	

}
