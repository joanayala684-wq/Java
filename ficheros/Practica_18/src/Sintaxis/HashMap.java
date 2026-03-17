package Sintaxis;

import java.util.HashMap;

public class Hashmap {

    public static void main(String[] args) {

        /***********************************HashMap*****************************************/

        /*
         * HashMap<K,V>:
         * Estructura que almacena datos en pares clave-valor.
         *
         * Concepto:
         * - Cada elemento tiene una clave (key) y un valor (value).
         * - Las claves no se pueden repetir.
         * - Permite acceder muy rápido a un valor usando su clave.
         * - No mantiene el orden de los elementos.
         * - Clase del paquete java.util.
         */

        /* Declarar un HashMap */
        HashMap<Integer, Alumno> mapaAlumnos = new HashMap<>();
        // Integer → clave (key)
        // Alumno → valor (value)
        // mapaAlumnos → nombre de la variable

        /* Tamaño */
        System.out.println(mapaAlumnos.size()); // inicialmente 0

        /* Agregar elementos */
        mapaAlumnos.put(1, new Alumno("Ana", 20));
        mapaAlumnos.put(2, new Alumno("Luis", 22));
        // put(key, value) → agrega o reemplaza un elemento

        /* Obtener elemento */
        mapaAlumnos.get(1); // obtiene el valor asociado a la clave 1

        /* Verificar si existe una clave */
        if (mapaAlumnos.containsKey(1)) {
            System.out.println("Existe la clave 1");
        }

        /* Verificar si existe un valor */
        if (mapaAlumnos.containsValue(new Alumno("Ana", 20))) {
            System.out.println("Existe ese alumno");
        }

        /* Eliminar elemento */
        mapaAlumnos.remove(1); // elimina el elemento con clave 1

        /* Verificar si está vacío */
        if (mapaAlumnos.isEmpty()) {
            System.out.println("El mapa está vacío");
        }

        /* Borrar todos los elementos */
        mapaAlumnos.clear();

        /* Recorrer HashMap (clave y valor) */
        for (Integer clave : mapaAlumnos.keySet()) {
            System.out.println(clave + " -> " + mapaAlumnos.get(clave));
        }
    }
}