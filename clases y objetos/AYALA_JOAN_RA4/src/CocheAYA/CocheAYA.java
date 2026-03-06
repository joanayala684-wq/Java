package CocheAYA;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class CocheAYA {
	private String matricula, cod;
	private int gananciasCoche, estadoCoche;
	private LocalTime reserva;
	private static final int libre = 0, reservado = 1, alquilado = 2;
	private static int contReservados, contAlquilados;
	Random r = new Random();

	public CocheAYA(String matricula) {
		this.matricula = matricula;
	}

	



	public String reservar() {
		int numero = r.nextInt(9) + 1;
		this.cod = matricula.substring(0, 4).toLowerCase() + numero;
		estadoCoche = reservado;
		contReservados++;
		reserva = LocalTime.now();
		return this.cod;
	}

	public void alquilar(String codigo) {
		if (!codigo.equals(this.cod)) {
			System.out.println("el codigo introducido es incorrecto. has persido la reserva");
			estadoCoche = libre;
			contReservados--;
		} else {
			System.out.println("alquiler completado con exito");
			estadoCoche = alquilado;
			contReservados--;
			contAlquilados++;
		}

	}

	public double estacionar() {
		double importe = 0;
		final double precioSeg = 0.8;
		int segundos = r.nextInt(191) + 10;
		importe = segundos * precioSeg;
		this.gananciasCoche+=importe;
		estadoCoche = libre;
		contAlquilados--;
		return importe;
	}

	public void penalizarReserva(LocalTime ahora) {
		int diffseg;
		diffseg = (int) Math.abs(ChronoUnit.SECONDS.between(reserva, ahora));
		if (diffseg > 20 && estadoCoche == 1) {
			System.out.println("se ha anulado la reserva por limite de tiempo");
			contReservados--;
		} else {
			System.out.println("aun estas a tiempo de alquilar con exito el vehiculo");
		}
	}

	public String getMatricula() {
		return matricula;
	}

	@Override
	public String toString() {
		return "CocheAYA [matricula=" + matricula + ", gananciasCoche=" + gananciasCoche + ", estadoCoche="
				+ estadoCoche + "]";
	}

	public int getGananciasCoche() {
		return gananciasCoche;
	}

	public int getEstadoCoche() {
		return estadoCoche;
	}

	public static int getContReservados() {
		return contReservados;
	}

	public static int getContAlquilados() {
		return contAlquilados;
	}

}
