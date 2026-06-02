package comerciales;

public class Fijo extends Comercial {
	
	private static double fijo;
	private static double comision=5;
	

	public Fijo(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	public static void setFijo(double fijo) {
		Fijo.fijo = fijo;
	}

	@Override
	public String toString() {
		return "Fijo ["+ super.toString()+ "]";
	}

	@Override
	public double pagar() {
		// TODO Auto-generated method stub
		ganar=fijo + (nA + nB + nC)*comision;
		//nA=nB=nC=0;
		return 0;
	}
	
	public void aumentaExtra() {
		ganar+=100;
	}

	
	

	
}
