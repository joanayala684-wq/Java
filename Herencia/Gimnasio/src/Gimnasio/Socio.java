package Gimnasio;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Socio {
	protected String codSocio, nombre, apellido, telefono;
	protected LocalDate fechaNac;
	protected int tiempoGymTotal, contVisitas;
	protected LocalDateTime entrada, salida;
	protected double pago;
	protected  boolean enGym=false; 
	/**
	 * @param nombre
	 * @param apellido
	 * @param telefono
	 * @param fechaNac
	 */
	public  Socio(String nombre, String apellido, String telefono, LocalDate fechaNac) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.fechaNac = fechaNac;
	}
	public void entrarGimnasio() throws YaEstaException {
		if (!enGym) {
			this.entrada= LocalDateTime.now();
			this.enGym= true;
			contVisitas++;
		}else {
			throw new YaEstaException ("El socio ya se encuntra en el gimnasio");
		}
	}
	public abstract double  salirGimnasio() throws NoEstaEnGym;
	
	public LocalDateTime getEntrada() {
		return entrada;
	}
	public void setEntrada(LocalDateTime entrada) {
		this.entrada = entrada;
	}
	public LocalDateTime getSalida() {
		return salida;
	}
	public void setSalida(LocalDateTime salida) {
		this.salida = salida;
	}
	public double getPago() {
		return pago;
	}
	public void setPago(double pago) {
		this.pago = pago;
	}
	public String getCodSocio() {
		return codSocio;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public LocalDate getFechaNac() {
		return fechaNac;
	}
	public int getTiempoGym() {
		return tiempoGymTotal;
	}
	
}
