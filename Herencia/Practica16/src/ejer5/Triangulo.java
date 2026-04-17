package ejer5;

public class Triangulo extends Poligono {
	private double ladoA, ladoB, ladoC;


	protected Triangulo(int numLados, double ladoA, double ladoB, double ladoC) {
		super(numLados);
		this.ladoA=ladoA;
		this.ladoB=ladoB;
		this.ladoC=ladoC;
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcularPeri() {
		double p = ladoA+ ladoB+ladoC;
		return p;
	}

	@Override
	public double calcularArea() {
		double a = (ladoA*ladoB)/2;
		return a;
	}

}
