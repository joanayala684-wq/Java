package Gimnasio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Preferente extends Socio {
	private int importeVisitas;
	private static int contP;

	public Preferente(String nombre, String apellido, String telefono, LocalDate fechaNac) {
		super(nombre, apellido, telefono, fechaNac);
		contP++;
		this.codSocio = "P" + contP;
	}

	@Override
	public double salirGimnasio() throws NoEstaEnGym {

		if (enGym) {
			this.enGym = false;
			contVisitas++;
			this.salida = LocalDateTime.now();
			int diff;
			diff=(int) ChronoUnit.MINUTES.between(salida, entrada);
			tiempoGymTotal=diff/60;
		} else {

		}
		return importeVisitas += 2;
	}

}
