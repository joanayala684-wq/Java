package Teleférico;

import java.util.Comparator;

public class ComparadorPasajeros implements Comparator<Pasajero> {

	@Override
	public int compare(Pasajero p1, Pasajero p2) {
	    // 1º Criterio: Menor a mayor edad (son enteros)
	    if (p1.calcularEdad() != p2.calcularEdad()) {
	        return Integer.compare(p1.calcularEdad(), p2.calcularEdad());
	    }
	    
	    // 2º Criterio (Desempate): Mayor a menor altura (¡Usando Double!)
	    // Invertimos el orden (p2 primero) para que sea descendente
	    return Double.compare(p2.getAltura(), p1.getAltura());
	}
}