package Ayala_Joan_RA7;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;

public class ComercialFijo extends Comercial{


	private static final double comision=5;
	private static double salarioFijo;

	public ComercialFijo(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double pagar() {
		
		salario=salario+(contVentas*5);
		return salario;
	}
	public void aumentaExtra() {
		salario+=100;
	}

	
	@Override
	public String toString() {
		return "ComercialFijo[ "+super.toString()+"]";
	}


}
