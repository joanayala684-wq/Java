	package MontañaRusa;

public class Bono extends Entrada{
	private int numViajes=3;

	public Bono(int edad, double altura) {
		super(edad, altura);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double pagar() {
		double pago;
		if (numViajes<3 && numViajes>0) {
			pago=0;
		}
		if (edad >= 18) {
			pago=10;
		}
		else {
			pago=4;
		}
		
		numViajes--;
		gananciasTotales=gananciasTotales+pago;
		return pago;
	}

}
