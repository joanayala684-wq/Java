package Ayala_Joan_RA7;
                                           
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;

public class ComercialComision extends Comercial {
	private static final double comision=10;
	private String marca;

	public ComercialComision(String nombre, String marca) {
		super(nombre);
		this.marca=marca;
	}

	
	@Override
	public double pagar() {
		double sueldo=contVentas*10+(contExtra*20);
		salario=sueldo;
		return sueldo;
	}
	@Override
	public String toString() {
		return "ComercialComision[ "+marca+super.toString()+"]";
	}

}
