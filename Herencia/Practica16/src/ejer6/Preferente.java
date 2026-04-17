package ejer6;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Preferente extends Socio{
	public String getNumSocio() {
		return numSocio;
	}

	private String numSocio;
	private static int num;
	private String letra="P";

	protected Preferente(String nombre, String apellido, String telefono, LocalDate fechaNac, int numAcudido) {
		super(nombre, apellido, telefono, fechaNac);
		num++;
		numSocio=letra+num;
	}

	@Override
	public double salirGimnasio() {
		horaSalida=LocalTime.now();
		estado=noEsta;
		int diff;
		diff=(int) ChronoUnit.MINUTES.between(horaSalida, horaEntrada);
		horasTotales=diff/60;
		numAcudido++;
		return 0;
		}

}
