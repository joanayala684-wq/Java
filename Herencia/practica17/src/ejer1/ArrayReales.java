package ejer1;

public class ArrayReales {
	private double[] valores;

	    public ArrayReales(double[] valores) {
	        this.valores = valores;
	    }
	    
	public double minimo() {
		if (valores.length==0) {
			return 0;
		}
		double minimo=valores[0];
		for (double v : valores) {
			if (v < minimo) {
				minimo=v;
			}
			
		}
		return minimo;
	
	}
	public double maximo() {
		if (valores.length==0) {
			return 0;
		}
		double maximo=valores[0];
		for (double v : valores) {
			if (v > maximo) {
				maximo=v;
			}
			
		}
		return maximo;
	
	}
	public double sumatorio() {
		if (valores.length==0) {
			return 0;
		}
		double suma=0;
		for (int i=0; i<valores.length; i++) {
			suma=valores[i];
		}
		return suma;
	
	}
	}

	


