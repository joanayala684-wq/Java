package Teleférico;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Pasajero implements Comparable<Pasajero>{
	
	protected String nombre, Dni, Cod;
	private LocalDate fechanacimiento;
	protected double pago, altura;
	
	public Pasajero(String nombre, String dni, LocalDate fechanacimiento, double altura) {
		super();
		this.nombre = nombre;
		this.altura = altura;
		this.Dni = dni;
		this.fechanacimiento = fechanacimiento;
	}
	
	public abstract double calcularTarifa();
	
	public int calcularEdad() {
		int diff;
		diff = (int) ChronoUnit.YEARS.between(fechanacimiento, LocalDate.now());
		return diff;
	}
	
	public void controlAcceso() throws SizeErrorException {
		// CORREGIDO: De 2000 a 200 para que tenga sentido real
		if(altura < 110 || altura > 200) {
			throw new SizeErrorException("Eres un minion o un gigante.");
		}
	}
	
	@Override
	public int compareTo(Pasajero otro) {
	    if (this.calcularEdad() != otro.calcularEdad()) {
	        return Integer.compare(this.calcularEdad(), otro.calcularEdad());
	    }
	    return Double.compare(otro.getAltura(), this.getAltura());
	}

	@Override
	public String toString() {
		return "Pasajero [nombre=" + nombre + ", Dni=" + Dni + ", Cod=" + Cod + ", Edad=" + calcularEdad() + ", altura=" + altura + "]";
	}
	
	public String getNombre() { return nombre; }
	public String getDni() { return Dni; }
	public String getCod() { return Cod; }
	public LocalDate getFechanacimiento() { return fechanacimiento; }
	public double getPago() { return pago; }
	public double getAltura() { return altura; }	
}