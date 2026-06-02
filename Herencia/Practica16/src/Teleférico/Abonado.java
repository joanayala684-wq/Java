package Teleférico;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Abonado extends Pasajero {
	private static int contAbonado;
	private double total;
	private final double cuota=15;
	public Abonado(String nombre, String dni, LocalDate fechanacimiento, double altura) {
		super(nombre, dni, fechanacimiento, altura);
		contAbonado++;
		this.Cod="A-"+contAbonado;

	}

	@Override
	public double calcularTarifa() {
		double importe=2;
		total+=importe;
		return importe;
	}
	public double calcularMensualidad() {
		int edad= calcularEdad();
		total=total+cuota;
		if(edad> 60) {
			total=total*0.8;
		}
		
		return total;
	}

}
