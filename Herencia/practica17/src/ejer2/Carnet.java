package ejer2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Carnet implements Caducable{

	private String nombre, dni;
	private LocalDate fecha;
	/**
	 * @param nombre
	 * @param dni
	 * @param fecha
	 */
	public Carnet(String nombre, String dni, LocalDate fecha) {
		this.nombre = nombre;
		this.dni = dni;
		this.fecha = fecha;
	}
	public boolean isCaducado() {
		LocalDate hoy=LocalDate.now();
		if(fecha.isAfter(hoy)) {
			return false;
		}
		return true;
		
	}
	public int diasRestantes (){
		LocalDate hoy=LocalDate.now();
		int difftotaldias;
		difftotaldias=(int) ChronoUnit.DAYS.between(hoy, fecha);
		return difftotaldias; 
	}
}
