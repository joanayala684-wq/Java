package Gimnasio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Normal extends Socio {
	private static int contN;

	public Normal(String nombre, String apellido, String telefono, LocalDate fechaNac) {
		super(nombre, apellido, telefono, fechaNac);
		contN++;
		this.codSocio = "N" + contN;
	}

	@Override
	public double salirGimnasio() throws NoEstaEnGym {
		double importe = 0;
		if (enGym) {
			this.enGym = false;
			contVisitas++;
			this.salida = LocalDateTime.now();
			int diff;
			diff = (int) ChronoUnit.MINUTES.between(salida, entrada);
			tiempoGymTotal = diff / 60;
			if (diff < 0.5) {
				importe = 6;
			} else if (diff <= 1) {
				importe = 9;

			} else {
				importe = 12;
			}
		} else {
			throw new NoEstaEnGym("El socio no se encuntra en el gimnasio");

		}

		return importe;
	}

}
