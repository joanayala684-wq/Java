package MontañaRusa;

public class Normal extends Entrada {

	public Normal(int edad, double altura) {
		super(edad, altura);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double pagar() {
		double pago;
		if (edad >= 18) {
			pago=4;
		}
		else {
			pago=3;
		}	
		gananciasTotales=gananciasTotales+pago;

		return pago;
	}

}
