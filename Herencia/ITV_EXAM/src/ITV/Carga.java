package ITV;

import java.util.Random;

public class Carga extends Vehiculo{
	private double cargaMaxima;
	Random r=new Random();

	public Carga(String matricula, String carburante, String dni, double  cargaMaxima) {
		super(matricula, carburante, dni);
		this.cargaMaxima=cargaMaxima;
	}
	public double getCargaMaxima() {
		return cargaMaxima;
	}
	@Override
	public String toString() {
		return "Carga [cargaMaxima=" + cargaMaxima + "]";
	}
	@Override
	public double pagarITV() throws AyalaJoanException {
		int aleatorio=r.nextInt(2)+1;
		if(aleatorio==2) {
		fallos++;
		contSuspensos++;
			throw new AyalaJoanException("el vehiculo no pasa la ITV");
		}
		double monto=0;
		monto= 25*(cargaMaxima/1000);
		if (!cita) {
			monto= monto*1.15;
		}
		
		return monto+(20*fallos);
	}

}
