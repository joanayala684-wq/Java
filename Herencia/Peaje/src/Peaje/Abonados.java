package Peaje;

public class Abonados extends Cabina {

	public Abonados() {
        super(); // Llama al constructor de Cabina para que le ponga número, cola, etc.
    }

	@Override
	public double pagar(double distancia, String tipoVehiculo) {
		double monto = 0;

		if (distancia <= 10) {
			monto = 2;

		} else {
			monto = 5;
		}

		if (tipoVehiculo.equalsIgnoreCase("moto")) {
			return monto * 0.8;

		} else if (tipoVehiculo.equalsIgnoreCase("resto")) {
			return monto * 1.2;
		}
		contVehiculosAtendidosTotal++;
		contVehiculosAtendidos++;
		contAbonados++;
		return monto;
	}

}
