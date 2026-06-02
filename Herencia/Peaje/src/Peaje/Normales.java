package Peaje;

public class Normales extends Cabina{
	public Normales() {
        super(); // Llama al constructor de Cabina para que le ponga número, cola, etc.
    }

	@Override
	public double pagar(double distancia, String tipoVehiculo) {
		double monto = 0;
		if(tipoVehiculo.equalsIgnoreCase("moto")) {
			return 5;
}
		if(distancia <=10) {
			monto=3;
		}
		else {
			monto=distancia*0.3;
		}
		if(tipoVehiculo.equalsIgnoreCase("resto")) {
			monto=monto*1.25;
		}
		contVehiculosAtendidos++;
		contVehiculosAtendidosTotal++;
		return monto;
	}


	
}
