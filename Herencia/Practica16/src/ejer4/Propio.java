package ejer4;

import java.util.Iterator;

import ejer1.Libro;

public class Propio extends Empleado {

	 private double salario_base;
	 private double beneficios;
	 public static int getContEmple() {
		return contEmple;
	}

	public static void setContEmple(int contEmple) {
		Propio.contEmple = contEmple;
	}



	 private static int contEmple;
	 public Propio(String dni, String nombre, String telefono, String direccion, double salario) {
		super(dni, nombre, telefono, direccion);
		salario_base=salario;
		// TODO Auto-generated constructor stub
	}

	 public void repartoBeneficios(double beneficio){
		 beneficios=beneficio/contEmple;
		 
	 }  


	public double pagar() {
		salario_final=salario_base+ (15*horas)+beneficios;
		horas=0;
		beneficios=0;
	return salario_final;
	}
	
	
	

	

}
