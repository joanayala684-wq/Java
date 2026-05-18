package modelos;

import java.sql.Statement;
import java.time.LocalDate;

public class Cuenta {
	private int numero ;
	private String titular1, titular2, titular3;
	private double saldo;
	private LocalDate fecha;
	
	public Cuenta(int numero, String titular1, String titular2, String titular3, double saldo, LocalDate fecha) {
		super();
		this.numero = numero;
		this.titular1 = titular1;
		this.titular2 = titular2;
		this.titular3 = titular3;
		this.saldo = saldo;
		this.fecha = fecha;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public int getNumero() {
		return numero;
	}
	public String getTitular1() {
		return titular1;
	}
	public String getTitular2() {
		return titular2;
	}
	public String getTitular3() {
		return titular3;
	}
	public double getSaldo() {
		return saldo;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	
}
