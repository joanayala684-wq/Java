package Sintaxis;

import java.util.HashSet;
import java.util.Iterator;

public class Hashset {

    public static void main(String[] args) {

        /***********************************HashSet*****************************************/

        /*
         * HashSet<E>:
         * Colección que almacena elementos únicos.
         *
         * Concepto:
         * - No permite elementos duplicados.
         * - No mantiene el orden de inserción.
         * - Internamente usa un HashMap.
         * - Solo guarda objetos.
         * - Clase del paquete java.util.
         */

        /* Declarar un HashSet */
        HashSet<Alumno> conjuntoAlumnos = new HashSet<>();
        // HashSet<Alumno> → tipo de objeto que guarda
        // conjuntoAlumnos → nombre del conjunto

        /* Tamaño */
        System.out.println(conjuntoAlumnos.size()); // inicialmente 0

        /* Agregar elementos */
        conjuntoAlumnos.add(new Alumno("Ana", 20));
        conjuntoAlumnos.add(new Alumno("Luis", 22));
        // add(E e) → agrega un elemento si no existe

        /* Verificar si existe un elemento */
        if (conjuntoAlumnos.contains(new Alumno("Ana", 20))) {
            System.out.println("Ana está en el conjunto");
        }

        /* Eliminar elemento */
        conjuntoAlumnos.remove(new Alumno("Luis", 22));

        /* Verificar si está vacío */
        if (conjuntoAlumnos.isEmpty()) {
            System.out.println("El conjunto está vacío");
        }

        /* Borrar todos los elementos */
        conjuntoAlumnos.clear();

        /* Recorrer con for-each */
        for (Alumno a : conjuntoAlumnos) {
            System.out.println(a);
        }

        /* Recorrer con Iterator */
        Iterator<Alumno> it = conjuntoAlumnos.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}