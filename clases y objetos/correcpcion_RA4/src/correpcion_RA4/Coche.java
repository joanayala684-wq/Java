package correpcion_RA4;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Coche {
	private String matricula, codigo;
	private double ganancias;
	private int estado;
	private LocalTime horaReserva;
	private static final double precioSegundo = 0.8;
	private static int alquilados, reservados;
	Random r = new Random();

	public Coche(String matricula) {

		this.matricula = matricula;
	}

	public String reservar() {
		if (estado != 0)
			return null;
		estado = 1;
		codigo = matricula.substring(4, 7).toLowerCase() + (r.nextInt(10) + 1);
		horaReserva = LocalTime.now();
		reservados++;
		return codigo;

	}

	public boolean alquilar(String cod) {
		if (estado != 1)
			return false;
		if (cod.equals(codigo)) {
			estado = 0;
			codigo = null;
			horaReserva = null;
			reservados--;
			return false;
		}
		codigo = null;// para limpiar los datos ya que al no estar reservado el coche no tiene sentido
						// tenerlos rellenados
		horaReserva = null;
		estado = 2;
		reservados--;
		alquilados++;

		return true;
	}

	public double estacionar() {
		double importe;
		if (estado != 2) {
			return 0;
		}
		int n = r.nextInt(10, 201);
		// int n=r.nextInt(191)+10;
		importe = n * precioSegundo;
		ganancias += importe;
		estado = 0;
		alquilados--;
		return n;
	}

	public void liberar () {
		if(estado !=1)
			return;
		long seg=ChronoUnit.SECONDS.between(horaReserva, LocalTime.now());
		if(seg>20) {
			estado=0;
			reservados--;
		}
		
	}
	public static int getAlquilados() {
		return alquilados;
	}

	public static int getReservados() {
		return reservados;
	}

	public int getEstado() {
		return estado;
	}

	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", codigo=" + codigo + ", ganancias=" + ganancias + ", estado="
				+ estado + ", horaReserva=" + horaReserva + "]";
	}

	public String getMatricula() {
		return matricula;
	}

}
