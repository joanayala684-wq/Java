package Teleférico;

import java.time.LocalDate;

public class Promocional extends Pasajero {
	private String codPromo;
	private static int contPromo;


	public Promocional(String nombre, String dni, LocalDate fechanacimiento, String codPromo, double altura) {
		super(nombre, dni, fechanacimiento, altura);
		contPromo++;
		this.Cod="P-"+contPromo;
		this.codPromo=codPromo;
	}


	@Override
	public double calcularTarifa() {
		String numero=codPromo.substring(codPromo.length()-2);
		int num=Integer.parseInt(numero);
		
		return num;
	}


	

}
