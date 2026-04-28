package Ayala_Joan_RA7;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;

public class ComercialFijo extends Comercial{
	


	public ComercialFijo(String nombre, HashMap<String, Integer> marcas) {
		super(nombre, marcas);
		this.salario=salario;
		// TODO Auto-generated constructor stub
	}

	@Override
	public double pagar() {
		salario=salario+(contVentas*5);
		return salario;
	}

	



}
