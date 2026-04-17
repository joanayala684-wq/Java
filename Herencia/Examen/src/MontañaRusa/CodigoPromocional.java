package MontañaRusa;


public class CodigoPromocional extends Entrada{



	private String codigo;

	public CodigoPromocional(int edad, double altura, String codigo) {
		super(edad, altura);
		this.codigo=codigo;
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
		String numero=codigo.substring(1, codigo.length());
		int descuento=Integer.parseInt(numero);
		pago=pago-(pago*descuento/100);
		gananciasTotales=gananciasTotales+pago;

		return pago;
	}


}
  