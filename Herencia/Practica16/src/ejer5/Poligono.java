package ejer5;

public abstract class Poligono {


@Override
	public String toString() {
		return "Poligono [numLados=" + numLados + "]";
	}
protected int numLados;
public int getNumLados() {
	return numLados;
}
	/**
 * @param numLados
 */
protected Poligono(int numLados) {
	this.numLados = numLados;
}
	abstract public double calcularPeri();

	abstract public double calcularArea();
	
	
}
