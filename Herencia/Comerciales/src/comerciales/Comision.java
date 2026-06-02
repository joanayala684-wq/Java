package comerciales;

public class Comision extends Comercial {
	
	private static final double comision=10;
	private String marca;

	public Comision(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	public Comision(String nombre, String marca) {
		super(nombre);
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Comision ["+ super.toString() + " ,marca=" + marca + "]";
	}
	
	public double pagar() {
		// TODO Auto-generated method stub
		double extra=0;
		ganar= (nA + nB + nC)*comision;
		if (marca.equals("A"))
			extra=(nA/5)*20;
		if (marca.equals("B"))
			extra=(nB/5)*20;
		if (marca.equals("C"))
			extra=(nC/5)*20;
		//nA=nB=nC=0;
		return ganar+extra;
	}

}
