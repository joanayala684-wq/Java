package modelos;

public class Usuario {
private String mail, nombre, ciudad;
private double valoracion;
public Usuario(String mail, String nombre, String ciudad, double valoracion) {
	super();
	this.mail = mail;
	this.nombre = nombre;
	this.ciudad = ciudad;
	this.valoracion = valoracion;
}
public String getMail() {
	return mail;
}
public String getNombre() {
	return nombre;
}
public String getCiudad() {
	return ciudad;
}
public double getValoracion() {
	return valoracion;
}
}
