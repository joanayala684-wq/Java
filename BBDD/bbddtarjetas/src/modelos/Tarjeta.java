package modelos;

import java.time.LocalDate;
import java.util.Random;

public class Tarjeta {
	private int numero, cuenta;
	private String titular, clave;
	private double limite;
	private String tipo;
	private LocalDate caducidad;
	private boolean bloqueado;
	Random r=new Random();
	//tajeta de credito
	public Tarjeta(int cuenta, String titular, double limite, String clave) {
		super();
		
		this.cuenta = cuenta;
		this.titular = titular;
		this.limite = limite;
		tipo = "C";
		this.clave=clave;
		numero=r.nextInt(8998)+1001;
		caducidad=LocalDate.now().plusYears(1);
	}
	//tarjeta de debito
	public Tarjeta( int cuenta, String titular,  String clave) {
		super();
		this.cuenta = cuenta;
		this.titular = titular;
		this.limite = 0;
	tipo = "D";
		this.clave=clave;
		caducidad =LocalDate.now().plusMonths(6);
	}
	public Tarjeta(int numero, int cuenta, String titular, double limite, String tipo, LocalDate caducidad, String clave, boolean bloqueada) {
	    this.numero = numero;
	    this.cuenta = cuenta;
	    this.titular = titular;
	    this.limite = limite;
	    this.tipo = tipo;
	    this.caducidad = caducidad;
	    this.clave = clave;
	    this.bloqueado = bloqueada;
	}
	
	
	public String getClave() {
		return clave;
	}
	public int getNumero() {
		return numero;
	}
	public int getCuenta() {
		return cuenta;
	}
	public String getTitular() {
		return titular;
	}
	public double getLimite() {
		return limite;
	}
	public String getTipo() {
		return tipo;
	}
	public LocalDate getCaducidad() {
		return caducidad;
	}
	public boolean isBloqueado() {
		return bloqueado;
	}
}
