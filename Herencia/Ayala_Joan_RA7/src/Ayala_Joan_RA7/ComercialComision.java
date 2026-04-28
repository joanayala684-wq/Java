package Ayala_Joan_RA7;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;

public class ComercialComision extends Comercial {

	public ComercialComision(String nombre, HashMap<String, Integer> marcas) {
		super(nombre, marcas);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public double pagar() {
		double sueldo=contVentas*10+(contExtra*20);
		salario=sueldo;
		return sueldo;
	}
	

}
