package Ayala_Joan_RA7;


import java.util.HashMap;
import java.util.HashSet;


public abstract class Comercial {
	
	

	public HashMap<String, Integer> getMarcas() {
		return marcas;
	}



	private String nombre;
	private static int numEmple;
	protected int contVentas;
	protected int contExtra;
	protected static double salario;

	
	private HashMap<String, Integer>  marcas = new HashMap<>();
	
	public Comercial(String nombre, HashMap<String, Integer> marcas) {
		super();
		numEmple=numEmple++;
		this.nombre = nombre;
		this.marcas = marcas;
	}
	
	public abstract double pagar () ;
	
	public int compareTo(Comercial co) {
	    if (salario == co.salario)
	        return 0;
	    else if (salario > co.salario)
	        return 1;
	    else
	        return 1;
	}
	public void venta (String marca, int numUnidades) {
		contVentas+=numUnidades;
		marcas.put(marca, numUnidades);
		if (numUnidades>= 5) {
			contExtra++;
		}
	}
	public static void setSalario(double salario) {
		Comercial.salario = salario;
	}


	@Override
	public String toString() {
		return "Comercial [nombre=" + nombre + ", marcas=" + marcas + "]";
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
