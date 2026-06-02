package ITV;

import java.util.Random;

public  abstract class   Vehiculo {
	protected  String matricula, carburante, dni;
	protected double tarifa;
	protected boolean cita=false;
	protected int fallos=0;
	protected static int contSuspensos, contTotal;
	Random r=new Random();

	/**
	 * @param matricula
	 * @param carburante
	 * @param dni
	 */
	protected Vehiculo(String matricula, String carburante, String dni) {
		this.matricula = matricula;
		this.carburante = carburante;
		this.dni = dni;
		contTotal++;
	}

	public abstract double pagarITV() throws AyalaJoanException;
	public String getMatricula() {
		return matricula;
	}


	public String getCarburante() {
		return carburante;
	}


	public String getDni() {
		return dni;
	}


	
@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", carburante=" + carburante + ", dni=" + dni + "]";
	}
public boolean isCita() {
	return cita;
}
public  void setCita(boolean cita) {
	this.cita = cita;
}





}
