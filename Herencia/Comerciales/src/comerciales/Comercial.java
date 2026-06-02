package comerciales;

public abstract class Comercial implements Comparable<Comercial> {

	private String nombre;
	private int numero;
	protected int nA,nB,nC;
	protected double ganar;
	private static int numeroTotal=0;
	
	public Comercial(String nombre) {
		super();
		this.nombre = nombre;
		numeroTotal++;
		numero=numeroTotal;
	}

	@Override
	public String toString() {
		return "nombre=" + nombre + ", numero=" + numero + " , ganar="+ ganar +", nA=" + nA + ", nB=" + nB + ", nC=" + nC ;
	}
	
	public void vender(int unidades,String marca) {
		if (marca.equalsIgnoreCase("A"))
			nA+=unidades;
		if (marca.equalsIgnoreCase("B"))
			nB+=unidades;
		if (marca.equalsIgnoreCase("C"))
			nC+=unidades;
	}

	public int getNumero() {
		return numero;
	}
	
	public abstract double pagar();

	public String getNombre() {
		return nombre;
	}

	public int getnA() {
		return nA;
	}

	

	public int getnB() {
		return nB;
	}

	

	public int getnC() {
		return nC;
	}

	
	@Override
	public int compareTo(Comercial o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
