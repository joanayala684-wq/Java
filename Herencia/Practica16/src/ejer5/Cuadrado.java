package ejer5;

public class Cuadrado extends Poligono {
	private double lado;

	protected Cuadrado(int numLados, double lado) {
		super(numLados);
		this.lado=lado;
	}

	@Override
	public double calcularPeri() {
		double p = lado*4;
		return p;
	}

	@Override
	public double calcularArea() {
		double a = lado*numLados;
		return a;
	}

}
