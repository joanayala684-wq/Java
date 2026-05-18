package modelos;

import java.time.LocalDate;

public class Arreglo {
	private int idFactura, idMecanico;
	private String matricula;
	private double importe;
	private LocalDate fechaEntrada, fechaSalida;
	
	public Arreglo(int idFactura, int idMecanico, String matricula,   LocalDate fechaEntrada, LocalDate fechaSalida, double importe) {
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
        if (this == obj) return true; // Si es el mismo objeto en memoria, es igual
        if (obj == null || getClass() != obj.getClass()) return false; // Si es nulo o de otra clase, no es igual
        
        Arreglo coche = (Arreglo) obj; 
        return this.matricula.equals(coche.matricula); // Comparamos las matrículas
    }
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
