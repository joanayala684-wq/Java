package Teleférico;

import java.time.LocalDate;

public class Rechazado  {
	private String motivo;
	private LocalDate fecha;
	private Pasajero pasajero;

	protected Rechazado(Pasajero pasajero, String motivo) {
		this.pasajero = pasajero;
		this.motivo = motivo;
		this.fecha = LocalDate.now();
	}

	

	public String getMotivo() {
		return motivo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public Pasajero getPasajero() {
		return pasajero;
	}
	/*
	 * @Override public int compareTo(Rechazado otro) {
	 * 
	 * // 1. Java resta las matrículas: "A mi matrícula le resto la del OTRO" int
	 * comparacionMatricula =
	 * this.vehiculo.getMatricula().compareTo(otro.getVehiculo().getMatricula());
	 * 
	 * // ¿Qué significa el resultado de esa resta de matrículas? // Si da un número
	 * NEGATIVO (-1) -> Mi matrícula es MENOR. Yo voy antes en la // lista. // Si da
	 * un número POSITIVO (1) -> Mi matrícula es MAYOR. El OTRO va antes que // yo.
	 * // Si da CERO (0) -> Las dos matrículas son EXACTAMENTE IGUALES.
	 * 
	 * // 2. Si dio CERO (0), significa que hay un empate de matrículas. Toca //
	 * desempatar: if (comparacionMatricula == 0) {
	 * 
	 * // Restamos las fechas: "A mi fecha le resto la del OTRO" return
	 * this.fecha.compareTo(otro.getFecha()); // Si da NEGATIVO (-1) -> Mi fecha es
	 * más antigua. Me pongo delante. // Si da POSITIVO (1) -> Mi fecha es más
	 * nueva. El otro se pone delante. // Si da CERO (0) -> Misma matrícula y misma
	 * fecha. Nos da igual quién vaya // delante. }
	 * 
	 * // 3. Si NO dio cero (las matrículas eran diferentes), devolvemos el -1 o el
	 * 1 // que dio la matrícula return comparacionMatricula; }
	 */

	/*
	 * Devuelve -1 (o cualquier número negativo): Significa this < otro. El objeto
	 * actual es más pequeño/va antes.
	 * 
	 * Devuelve 0: Significa this == otro. Son iguales, no se mueven.
	 * 
	 * Devuelve 1 (o cualquier número positivo): Significa this > otro. El objeto
	 * actual es más grande/va después.
	 */

}
