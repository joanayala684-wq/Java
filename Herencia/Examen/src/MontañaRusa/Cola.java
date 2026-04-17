package MontañaRusa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
public class Cola {
	public static LinkedList<Entrada> getCola() {
		return cola;
	}

	public static int getContPersonas() {
		return contPersonas;
	}

	Random r=new Random();
	private static int  contPersonas=0;

private static LinkedList<Entrada> cola = new LinkedList<>();

public void añadir(int tipo, int  edad, double altura) {
	if (tipo==1) {
		cola.add(new Normal(edad, altura));
	}
	else if (tipo ==2){
		cola.add(new Bono(edad, altura));
	}
	else {
	int numcod=r.nextInt(10, 50);
	String codigo="D"+numcod;
	cola.add(new CodigoPromocional(edad, altura, codigo)); 
	}
	contPersonas++;
	}
public void restarPersona() {
	contPersonas--;
}
public void mostrarCola() {
    if (cola.isEmpty()) {
        System.out.println("La cola está vacía.");
    } else {
        System.out.println("--- Clientes en espera: " + cola.size() + " ---");
        for (Entrada e : cola) {
            System.out.println(e.toString());
        }
    }
}
public void ordenarCola() {
    int n = cola.size();
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            
            Entrada actual = cola.get(j);
            Entrada siguiente = cola.get(j + 1);

            // Usamos nuestra interfaz para decidir si intercambiarlos
            if (actual.esMayorQue(siguiente)) {
                // Intercambio de posiciones
                cola.set(j, siguiente);
                cola.set(j + 1, actual);
            }
        }
    }
}


}
