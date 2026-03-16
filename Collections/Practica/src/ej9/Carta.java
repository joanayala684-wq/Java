package ej9;

public class Carta {
private String nombre, apellido, ciudad, pais ;
public Carta(String nombre, String apellido, String ciudad, String pais) {
	
	this.nombre = nombre;
	this.apellido = apellido;
	this.ciudad = ciudad;
	this.pais = pais;
}

@Override
public String toString() {
	return "Carta [nombre=" + nombre + ", apellido=" + apellido + ", ciudad=" + ciudad + ", pais=" + pais
			+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}

public String getApellido() {
	return apellido;
}

public String getPais() {
	return pais;
}






}
