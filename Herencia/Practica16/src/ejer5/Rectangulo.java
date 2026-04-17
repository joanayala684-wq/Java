package ejer5;

public class Rectangulo extends Poligono {
private double base, altura;
	protected Rectangulo(int numLados, double base, double altura) {
		super(numLados);
		this.base=base;
		this.altura=altura;
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcularPeri() {
		double p = 2*(base+altura);
		return p;
	}


	@Override
	public double calcularArea() {
	double a = base*altura;
		return a;
	}

}
