package modelos;

import java.time.LocalDateTime;

public class Vendido {
private String codigo, mailcomprador;
private double precioventa;
private LocalDateTime fecha;
public Vendido(String codigo, String mailcomprador, double precioventa, LocalDateTime fecha) {
	super();
	this.codigo = codigo;
	this.mailcomprador = mailcomprador;
	this.precioventa = precioventa;
	this.fecha = fecha;
}
public String getCodigo() {
	return codigo;
}
public String getMailcomprador() {
	return mailcomprador;
}
public double getPrecioventa() {
	return precioventa;
}
public LocalDateTime getFecha() {
	return fecha;
}
}
