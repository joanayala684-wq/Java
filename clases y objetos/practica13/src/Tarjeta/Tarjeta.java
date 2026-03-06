package Tarjeta;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Tarjeta {

	private String NumeroTarjeta;
	private String Titular;
	private String pin;
	private Double credito;
	private int mes, año;
	private boolean bloqueado = false;
	private static int NumBloqueadas=0;

	public Tarjeta(String numeroTarjeta, String titular, String pin, Double credito, int mes, int año) {
		super();
		NumeroTarjeta = numeroTarjeta;
		Titular = titular;
		this.pin = pin;
		this.credito = credito;
		this.mes = mes;
		this.año = año;
	}

	public void bloquear(boolean block, int cont) {

		if (block == true) {
			System.out.println("HAS BLOQUEADO LA TARJETA");
			NumBloqueadas++;
			bloqueado = true;
		}

		if (cont == 3) {
			System.out.println("Tarjeta bloqueada por limite de intentos");
			bloqueado = true;
			NumBloqueadas++;
		}

		if (bloqueado == false)
			System.out.println("NO ESTA BLOQUEADAE");
	}

	public boolean Pagar(String contraseña, double pago, int M, int A, int contIntentos) {

		if (!contraseña.equals(pin)) {
			System.out.println("Contraseña incorrecta");
			return false;
		}

		if (contIntentos > 3 || bloqueado) {
			System.out.println("Tarjeta bloqueada por limite de intentos");
			return false;
		}

		if (A > año || (A == año && M > mes)) {
			System.out.println("Tarjeta caducada");
			return false;
		}

		if (pago > credito) {
			System.out.println("No tienes suficiente dinero");
			return false;
		}

		credito -= pago;
		return true;
	}

	public boolean recargar(double recarga) {
		if (recarga < 0) {
			System.out.println("cantidad invalida");
			return false;
		}
		credito += recarga;
		return true;
	}

	/* Maestro JOSE */
	public String info() {

		return "\nNumeroTarjeta:" + NumeroTarjeta + "\nTitular:" + Titular + "\nPin : ******";
	}

	/* MAESTRO JOAN */
	@Override
	public String toString() {
		return "Tarjeta [NumeroTarjeta=" + NumeroTarjeta + ", Titular=" + Titular + ", pin=" + "*****" + ", credito="
				+ credito + ", año=" + año + ", bloqueado=" + bloqueado + "]";
	}

	public Double getCredito() {
		return credito;
	}

	public boolean mismoTitular(Tarjeta otratarjeta) {

		return Titular.equalsIgnoreCase(otratarjeta.getTitular());

	}

	public String getNumeroTarjeta() {
		return NumeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		NumeroTarjeta = numeroTarjeta;
	}

	public String getTitular() {
		return Titular;
	}

	public void setTitular(String titular) {
		Titular = titular;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public static int getNumBloqueadas() {
		return NumBloqueadas;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public void setCredito(Double credito) {
		this.credito = credito;
	}

}
