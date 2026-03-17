package Sintaxis;

import java.util.ArrayList;
import java.util.ListIterator;

import Almacen.ArrayList.Almacen;

public class Arraylist {

    public static void main(String[] args) {

        /***********************************ArrayList*****************************************/

        /*
         * ArrayList<E>:
         * Ventaja: acceso rápido a un elemento en particular.
         * Desventaja: eliminar un elemento implica mover todos los demás para cerrar el "hueco".
         *
         * Concepto:
         * - Lista dinámica que crece o se achica sola según lo que metas o saques.
         * - No necesitas indicar el tamaño inicial.
         * - Internamente usa un array; si se llena, crea uno más grande y copia los elementos (transparente para el usuario, pero puede ser costoso si ocurre mucho).
         * - Array = viene con Java y puede contener tipos básicos u objetos.
         * - ArrayList = clase de java.util y solo contiene objetos.
         */

        /* Declarar un ArrayList */
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        // ArrayList<Alumno> → tipo de objeto que guarda
        // listaAlumnos → nombre de la lista

        /* Tamaño */
        System.out.println(listaAlumnos.size()); // Inicialmente 0

        /* Agregar elementos */
        listaAlumnos.add(new Alumno("Ana", 20));
        listaAlumnos.add(new Alumno("Luis", 22));

        /* Obtener elemento */
        listaAlumnos.get(0); // obtiene el primer elemento

        /* Modificar elemento */
        listaAlumnos.set(0, new Alumno("Marta", 21)); // reemplaza el elemento en la posición 0

        /* Borrar elemento */
        listaAlumnos.remove(0); // elimina el elemento en la posición 0
        listaAlumnos.remove(new Alumno("Luis", 22)); // elimina el primer elemento que sea igual usando equals
        listaAlumnos.clear(); // deja la lista vacía

        /* Recorrer lista */
        for (int i = 0; i < listaAlumnos.size(); i++) {
            System.out.println(listaAlumnos.get(i)); // imprime cada elemento
        }

        // ➤ FOR-EACH (más limpio)
        for (Alumno a : listaAlumnos) {
            System.out.println(a.nombre + " " + a.edad);
        }

        // ➤ CONTAINS (verificar si existe un objeto en la lista)
        if (listaAlumnos.contains(new Alumno("Ana", 20))) {
            System.out.println("Ana está en la lista");
        }

        // ➤ CLONAR la lista
        ArrayList<Alumno> copiaLista = new ArrayList<>(listaAlumnos);

        // ➤ VERIFICAR si está vacía
        if (listaAlumnos.isEmpty()) {
            System.out.println("La lista está vacía");
        }
        
        // ➤ OBTENER POSICIÓN de un elemento
        int pos = listaAlumnos.indexOf(new Alumno("Ana", 20));
        System.out.println(pos); // muestra la posición o -1 si no está
        
     // ➤ ITERATOR (recorrer con ListIterator)
        ListIterator<Alumno> it = listaAlumnos.listIterator();
        System.out.println("Recorrido hacia adelante:");
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("Recorrido hacia atrás:");
        while(it.hasPrevious()) {
            System.out.println(it.previous());
        }
        
    }
}