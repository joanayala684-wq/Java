package Peaje;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;



public abstract class Cabina  implements Comparable<Cabina>{
	private LinkedList<Vehiculo> cola = new LinkedList<Vehiculo>();
	private boolean abierta;
	private int numCabina, minutosAbierta;
	private LocalDateTime tiempoAbierto, tiempoCerrado;
	protected static  int contVehiculosAtendidosTotal, contAbonados;
	protected int contVehiculosAtendidos;
	private static int contCabinas;

	/**
	 * @param distancia
	 * @param tipoVehiculo
	 * @param tipoUsu
	 */
	public Cabina() {
		contCabinas++;

		this.numCabina = contCabinas;
		this.abierta = false;
		this.contVehiculosAtendidos = 0;
		this.minutosAbierta = 0;
	}

	public abstract double pagar(double distancia, String tipoVehiculo);

	public boolean isAbierta() {
		return abierta;
	}

	

	

	public void setAbierta(boolean abierta) {
		if (this.abierta != abierta) {
		if (!abierta) {
			this.tiempoCerrado = LocalDateTime.now();
			
		}
		else {
			this.tiempoAbierto = LocalDateTime.now();
		}}
		this.abierta = abierta;
	}

	public int compareTo(Cabina otra) {
		// Orden de mayor a menor (los que más han atendido primero)
		return Integer.compare(otra.contVehiculosAtendidos, this.contVehiculosAtendidos);
		// NOTA: Si el profesor lo quiere de menor a mayor, dale la vuelta:
        // return Integer.compare(this.vehiculosAtendidos, otra.vehiculosAtendidos);

	}
	public LinkedList<Vehiculo> getCola() {
		return cola;
	}

	public int getNumCabina() {
		return numCabina;
	}

	public int getMinutosAbierta() {
		if(tiempoAbierto==null) {
			return 0;
		}
		if (abierta) {
			minutosAbierta = (int) Math.abs(ChronoUnit.MINUTES.between(tiempoAbierto, LocalDateTime.now()));
		} else {
			minutosAbierta = (int) Math.abs(ChronoUnit.MINUTES.between(tiempoAbierto, tiempoCerrado));
		}
		return minutosAbierta;
	}

	public int getContVehiculosAtendidos() {
		return contVehiculosAtendidos;
	}

	public static int getContCabinas() {
		return contCabinas;
	}

	@Override
	public String toString() {
		return "Cabina [abierta=" + abierta + ", numCabina=" + numCabina + ", minutosAbierta=" + minutosAbierta
				+ ", contVehiculosAtendidos=" + contVehiculosAtendidos + "]";
	}

}
