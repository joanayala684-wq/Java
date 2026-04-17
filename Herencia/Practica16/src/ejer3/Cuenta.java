package ejer3;

import java.util.HashSet;

public class Cuenta {
public double getImporte() {
		return importe;
	}



	public void setImporte(double importe) {
		this.importe = importe;
	}



public static int getNumCuenta() {
		return numCuenta;
	}



	public static void setNumCuenta(int numCuenta) {
		Cuenta.numCuenta = numCuenta;
	}



public HashSet<String> getTitulares() {
		return titulares;
	}



	public void setTitulares(HashSet<String> titulares) {
		this.titulares = titulares;
	}



protected final double interes=3;
private double importe;
protected static int numCuenta;
private HashSet<String> titulares = new HashSet<String>();

public Cuenta( HashSet<String> titulares, double importe) {
	numCuenta++;
	this.numCuenta = numCuenta;
	this.importe=importe;
	this.titulares = titulares;
}



@Override
public String toString() {
	return "Cuenta [interes=" + interes + ", numCuenta=" + numCuenta + ", titulares=" + titulares + "]";
}


public double CalcularGanancias (int dias) {
	double ganancias=(importe*interes*30)/365;
	importe+=ganancias;
	return ganancias;
}


}                                                                                                                                                                   
