package modelos;

import java.time.LocalDate;

public class Movimiento {
	private int numtarjeta;
	private boolean cargado;
	private double importe;
	private LocalDate fecha;
	
	
	public Movimiento( int numtarjeta, boolean cargado, double importe, LocalDate fecha) {
		super();

		this.numtarjeta = numtarjeta;
		this.cargado = cargado;
		this.importe = importe;
		this.fecha = fecha;
	}

	public Movimiento(int numtarjeta, double importe) {
		super();
		this.numtarjeta = numtarjeta;
		this.cargado =false;
		this.importe = importe;
		this.fecha = LocalDate.now();
	}

	public int getNumtarjeta() {
		return numtarjeta;
	}

	public boolean isCargado() {
		return cargado;
	}



	public double getImporte() {
		return importe;
	}

	public LocalDate getFecha() {
		return fecha;
	}
	
	
	
	
	

}
