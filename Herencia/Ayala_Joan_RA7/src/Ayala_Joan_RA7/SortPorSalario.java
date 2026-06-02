package Ayala_Joan_RA7;

import java.util.Comparator;

/*
 * Si c1 es mayor que c2   devuelves -1 (para que vaya a la izquierda, primero).
 * Si c1 es menor que c2  devuelves 1 (para que vaya a la derecha, después).*/

public class SortPorSalario  implements Comparator<Comercial>{
	@Override 
	public int compare (Comercial c1, Comercial c2) {
		// 1. COMPARAR POR SALARIO (De más a menos)
        // Si c2 tiene más salario, irá antes que c1
        if (c1.getSalario() > c2.getSalario()) return -1;
        if (c1.getSalario() < c2.getSalario()) return 1;

        // 2. DESEMPATE: Si tienen el mismo salario, miramos el tipo
        // Queremos: Primero Fijo (Comercial normal), luego Comisión (ComercialComision)
        
        boolean c1EsComision = c1 instanceof ComercialComision;
        boolean c2EsComision = c2 instanceof ComercialComision;

        if (c1EsComision && !c2EsComision) {
            // c1 es comisión y c2 es fijo -> c2 (fijo) debe ir antes, así que c1 va después
            return 1; 
        }
        if (!c1EsComision && c2EsComision) {
            // c1 es fijo y c2 es comisión -> c1 (fijo) va antes
            return -1;
        }

        // Si ambos son del mismo tipo y tienen el mismo sueldo, son iguales
        return 0;
    
	}
	

}
