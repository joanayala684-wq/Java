package modelos;

import java.time.LocalDate;

public class Arreglo implements Comparable<Arreglo> {
	private int idFactura, idMecanico;
	private String matricula;
	private double importe;
	private LocalDate fechaEntrada, fechaSalida;

	public Arreglo(int idFactura, int idMecanico, String matricula, LocalDate fechaEntrada, LocalDate fechaSalida,
			double importe) {
		super();
		this.idFactura = idFactura;
		this.idMecanico = idMecanico;
		this.matricula = matricula;
		this.importe = importe;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
	}

	public Arreglo(String matricula) {
		super();
		this.matricula = matricula;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true; // Si es el mismo objeto en memoria, es igual
		if (obj == null || getClass() != obj.getClass())
			return false; // Si es nulo o de otra clase, no es igual

		Arreglo coche = (Arreglo) obj;
		return this.matricula.equals(coche.matricula); // Comparamos las matrículas
	}

	public int compareTo(Arreglo o) {
		/* Por fecha de entrada, de más antigua a más reciente, */
		int resFecha = this.fechaEntrada.compareTo(o.fechaEntrada);

		// Si las fechas NO son iguales, devolvemos el resultado directamente
		if (resFecha != 0) {
			return resFecha;
		}

		// 2. Si hay EMPATE en las fecha. Importe (de mayor a menor)
		if (this.importe == o.importe) {
			return 0;
		} else if (this.importe < o.importe) {
			return 1; // Devolvemos positivo si el mío es menor, para que el mayor vaya primero
						// (descendente)
		} else {
			return -1; // Devolvemos negativo si el mío es mayor
		}
	}
	/*
	 * this.fechaEntrada = 10 de mayo de 2026.
	 * 
	 * o.fechaEntrada = 15 de mayo de 2026.
	 * 
	 * Al hacer this.fechaEntrada.compareTo(o.fechaEntrada), Java restará
	 * internamente las fechas. Como el 10 es anterior al 15, resFecha valdrá un
	 * número negativo (normalmente -5 o -1).
	 * 
	 * Como es distinto de cero, entra en tu if y hace return resFecha;. Al recibir
	 * un número negativo, Collections.sort() sabe perfectamente que tiene que
	 * colocar el arreglo del día 10 antes que el del día 15. ¡Así es como se logra
	 * el orden de más antiguo a más reciente!
	 */

	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public int getIdMecanico() {
		return idMecanico;
	}

	public String getMatricula() {
		return matricula;
	}

	public double getImporte() {
		return importe;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	@Override
	public String toString() {
		return "Arreglo [idFactura=" + idFactura + ", idMecanico=" + idMecanico + ", matricula=" + matricula
				+ ", importe=" + importe + ", fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + "]";
	}
}
