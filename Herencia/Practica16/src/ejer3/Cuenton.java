package ejer3;

import java.util.HashSet;
import java.util.Random;

public class  Cuenton extends Cuenta {
private final double interes=4;
private static int TotalCuentones;
	@Override
	public String toString() {
		return "Cuenton [toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

	public Cuenton(HashSet<String> titulares, double importe) throws ImporteNoValidoException {
		super(titulares, importe);
		numCuenta++;
		TotalCuentones++;
		this.numCuenta = numCuenta;
		if (importe < 600) {
			throw new ImporteNoValidoException("el importe debe ser de al menos 600$");
		}
	}

	public static void borrar() {
		TotalCuentones--;
	}
	
	public static int sorteo() {
		if (TotalCuentones==0)
			return -1;
		Random r=new Random();
		return r.nextInt(TotalCuentones);
	}
	

	
}
