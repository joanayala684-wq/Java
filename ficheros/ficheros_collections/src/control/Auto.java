package control;

import java.time.LocalDate;

public class Auto {
private String matricula, dni;
private double precio;
private LocalDate FechaCompra;

public Auto(String matricula ,String dni, LocalDate FechaCompra, double precio) {
	super();
	this.matricula = matricula;
	this.dni = dni;
	this.precio = precio;
	this.FechaCompra = FechaCompra;
}

public String getMatricula() {
	return matricula;
}

public LocalDate getFechaCompra() {
	return FechaCompra;
}

public double getPrecio() {
	return precio;
}

public Object getPropietario() {
	
	return dni;
}


		
}
