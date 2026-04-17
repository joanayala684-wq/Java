package MontañaRusa;

public abstract class Entrada {
	protected static double gananciasTotales=0;
	@Override
	public String toString() {
		return "Entrada [edad=" + edad + ", altura=" + altura + ", importe=" + importe + "]";
	}


	public int getEdad() {
		return edad;
	}


	public double getAltura() {
		return altura;
	}


	public double getImporte() {
		return importe;
	}


	protected int edad;
	protected double altura, importe;
	 
	
	/**
	 * @param edad
	 * @param altura
	 */
	public Entrada(int edad, double altura) {
		this.edad = edad;
		this.altura = altura;
	}


	abstract public double pagar();
	public boolean esMayorQue(Entrada otra) {
        // Regla 1: Si mi edad es mayor, soy "mayor"
        if (this.edad > otra.edad) {
            return true;
        }
        // Regla 2: Si tenemos la misma edad, comprueba la altura
        if (this.edad == otra.edad) {
            return this.altura > otra.altura;
        }
        // En cualquier otro caso, no soy mayor
        return false;
    }


}
