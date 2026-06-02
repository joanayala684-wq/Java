package ejemploInterface2;



public interface Caducable {
    // Devuelve true si ya ha caducado, false si no
    boolean esCaducado();
    
    // Devuelve el número de días que faltan (si ya caducó, puede devolver 0 o negativo)
    long diasParaCaducar();
}

