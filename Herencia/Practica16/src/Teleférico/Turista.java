package Teleférico;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Turista extends Pasajero {
	
	private String temporada;
	private static int contTurista;
	private LocalTime horaAcceso;

	public Turista(String nombre, String dni,  LocalDate fechanacimiento, double altura) {
		super(nombre, dni, fechanacimiento, altura);
		contTurista++;
		this.Cod="T-"+contTurista;
	}

	@Override
	public double calcularTarifa() {
		int edad =calcularEdad();
		double importe=7;
		LocalTime  pico = LocalTime.of(14, 00);
		horaAcceso=LocalTime.now();

		if (horaAcceso.isBefore(pico)) {
			if (edad>18) {
				importe=10;
			}else {
				importe=6;
			}
		}
		
		return importe;
	}
	
	

}
