package ejer6;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Normal extends Socio{

	private String numSocio;
	private static int num;
	private String letra="N";
	protected Normal(String nombre, String apellido, String telefono, LocalDate fechaNac, int numAcudido) {
		super(nombre, apellido, telefono, fechaNac);
		num++;
		numSocio=letra+num;
	}


	public void entrarGimnasio () {
		// Comprobar si ya está dentro antes de cambiar nada
	    if (this.estado == esta) {
	        System.out.println("Error: El socio ya se encuentra en el gimnasio.");
	        return; // Salimos del método para no sobreescribir la hora de entrada original
	    }
	    
	    this.horaEntrada = LocalTime.now();
	    this.estado = esta;
	}



	@Override
	public double salirGimnasio() {
		horaSalida=LocalTime.now();
		estado=noEsta;
		int diff;
		//primero va el tiempo anterior
		diff=(int) ChronoUnit.MINUTES.between(horaEntrada, horaSalida);
		if(diff<1) {
			return 6;
		}
		else if (diff ==1 ) {
			return 9;
		}
		horasTotales=diff/60;
		numAcudido++;
		return 12;
	}
	
	public String getNumSocio() {
		return numSocio;
	}

}
