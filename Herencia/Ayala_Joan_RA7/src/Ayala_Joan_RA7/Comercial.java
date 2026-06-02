package Ayala_Joan_RA7;

import java.util.HashMap;
import java.util.HashSet;

public abstract class Comercial {

	public HashMap<String, Integer> getMarcas() {
		return registroComercial;
	}

	private String nombre;
	private static int numEmple;
	protected int contVentas;
	protected int contExtra;
	protected static double salario;

	private HashMap<String, Integer> registroComercial = new HashMap<>();

	public Comercial(String nombre) {
		super();
		numEmple = numEmple++;
		this.nombre = nombre;
	}

	public abstract double pagar();

	

	public void venta(String marca, int unidadesVendidas) {
		if (marca.equalsIgnoreCase("A")) {
			registroComercial.put(marca, registroComercial.get(marca+unidadesVendidas));}

		
		if (marca.equalsIgnoreCase("B")) {
			registroComercial.put(marca, registroComercial.get(marca+unidadesVendidas));}

		
		if (marca.equalsIgnoreCase("C")) {
			registroComercial.put(marca, registroComercial.get(marca+unidadesVendidas));}

		
	}

	public static void setSalario(double salario) {
		Comercial.salario = salario;
	}

	@Override
	public String toString() {
		return "Comercial [nombre=" + nombre + ", marcas=" + registroComercial + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public static int getNumEmple() {
		return numEmple;
	}

	public int getContVentas() {
		return contVentas;
	}

	public static double getSalario() {
		return salario;
	}

}
