package modelos;

public class Anuncio {
private String codigo, categoria, descripcion, mail;
private double precioventa, peso;


public Anuncio(String codigo, String categoria, String descripcion, String mail, double precioventa, double peso) {
	super();
	this.codigo = codigo;
	this.categoria = categoria;
	this.descripcion = descripcion;
	this.mail = mail;
	this.precioventa = precioventa;
	this.peso = peso;
}
public String getCodigo() {
	return codigo;
}
public String getCategoria() {
	return categoria;
}
public String getDescripcion() {
	return descripcion;
}
public String getMail() {
	return mail;
}
public double getPrecioventa() {
	return precioventa;
}
public double getPeso() {
	return peso;
}



}
