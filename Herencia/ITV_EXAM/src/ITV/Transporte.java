package ITV;

import java.util.Random;

public class Transporte extends Vehiculo {
	private int numPlazas;
	Random r=new Random();

	public Transporte(String matricula, String carburante, String dni, int numPlazas) {
		super(matricula, carburante, dni);
		this.numPlazas = numPlazas;
	}

	public int getNumPlazas() {
		return numPlazas;
	}

	@Override
	public String toString() {
		return "Transporte [numPlazas=" + numPlazas + "]";
	}

	@Override
	public double pagarITV() throws AyalaJoanException {
		int aleatorio=r.nextInt(2)+1;
		if(aleatorio==2) {
		fallos++;
		contSuspensos++;
			throw new AyalaJoanException("el vehiculo no pasa la ITV");
		}
		double monto;

		if (carburante.equalsIgnoreCase("gasolina") || carburante.equalsIgnoreCase("diesel")) {
			monto = 50;
		} else {
			monto = 30;
		}
		if (!cita) {
			monto = monto * 1.20;
		}
		
		return monto+(20*fallos);
	}

}
