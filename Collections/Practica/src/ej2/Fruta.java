package ej2;


public class Fruta {
	private String nombre;
	private String procedencia;
	private double numkg;
	private double  precioCoste;
	private double precioVenta;
	private static double beneficioTotal=0;

	public Fruta(String nombre, String procedencia, double numkg, double precioCoste, double precioVenta) {
	
		this.nombre = nombre;
		this.procedencia = procedencia;
		this.numkg = numkg;
		this.precioCoste = precioCoste;
		this.precioVenta = precioVenta;
	}
	public void rebajar (double rebaja) {
		if((this.precioVenta-rebaja)>=this.precioCoste) {
			this.precioVenta-=rebaja;
			
		}else {
			System.out.println("no se puede, case");
		}
		}
	@Override
	public String toString() {
		return "Frutas [nombre=" + nombre + ", procedencia=" + procedencia + ", numkg=" + numkg + ", precioCoste="
				+ precioCoste + ", precioVenta=" + precioVenta + "]";
	}
	public double vender(double cantidad) {
		if(cantidad<=this.numkg) {
			this.numkg -= cantidad;
			double importeCobrado =cantidad*this.precioVenta;
			beneficioTotal +=(this.precioVenta-this.precioCoste)*cantidad;
			return importeCobrado;
		}else {
			System.out.println("sctock insuficiente ");
			return 0;
		}
	}
	public boolean mismaProcedencia (Fruta otraFruta) {
		return this.procedencia.equalsIgnoreCase(otraFruta.getProcedencia());
		
	}
	public static double getBeneficioTotal() {
		return beneficioTotal;
	}
	public String getNombre() {
		return nombre;
	}
	public String getProcedencia() {
		return procedencia;
	}
	
	
	public double getNumkg() {
		return numkg;
	}
	public double getPrecioCoste() {
		return precioCoste;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}
	
	
	
}


