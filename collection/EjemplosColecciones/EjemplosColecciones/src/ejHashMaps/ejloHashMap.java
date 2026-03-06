package ejHashMaps;

import java.util.HashMap;

public class ejloHashMap {
    public static void main(String[] args) {
        // Crear un HashMap para almacenar nombres y edades
        HashMap<String, Integer> edades = new HashMap<>();

        // Insertar pares clave-valor
        edades.put("Juan", 30);
        edades.put("María", 25);
        edades.put("Pedro", 40);

        // Acceder a un valor asociado a una clave
        System.out.println("La edad de María es: " + edades.get("María"));

        // Comprobar si una clave existe
        if (edades.containsKey("Pedro")) {
            System.out.println("Pedro está en el HashMap");
        }

        // Iterar sobre el conjunto de claves
        for (String nombre : edades.keySet()) {
            System.out.println(nombre + " tiene " + edades.get(nombre) + " años.");
        }

        // Eliminar un elemento
        edades.remove("Juan");

        // Imprimir el tamaño actual del HashMap
        System.out.println("Número de elementos: " + edades.size());
    }
}


	


