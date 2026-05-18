package modelos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ClienteNoCarnet extends Cliente {

	public ClienteNoCarnet(String dni, String nombre, String telefono, String direccion, int carnet, int visitas) {
		super(dni, nombre, telefono, direccion, carnet, visitas);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double pagar(Arreglo a) {
		double importe=0;
		int diasDiferencia = (int)ChronoUnit.DAYS.between(a.getFechaEntrada(), a.getFechaSalida());
		if(diasDiferencia <3) {
			importe=importe*1.20;
		}
		visitas++;

		return importe;
	}

	
}
