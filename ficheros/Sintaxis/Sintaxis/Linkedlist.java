package Sintaxis;


import java.util.LinkedList;
import java.util.ListIterator;


public class Linkedlist {

    public static void main(String[] args) {

        /***********************************LinkedList*****************************************/

        /*
         * LinkedList<E>:
         * Ventaja: agregar o eliminar elementos en cualquier posición es rápido.
         * Desventaja: acceder a un elemento por índice es más lento que en ArrayList.
         *
         * Concepto:
         * - Lista dinámica que crece o se achica sola según lo que metas o saques.
         * - Internamente usa nodos enlazados (cada elemento apunta al siguiente y al anterior).
         * - Solo guarda objetos.
         * - Clase de java.util.
         */

        /* Declarar un LinkedList */
        LinkedList<Alumno> listaAlumnos = new LinkedList<>();
        // LinkedList<Alumno> → tipo de objeto que guarda
        // listaAlumnos → nombre de la lista

        /* Tamaño */
        System.out.println(listaAlumnos.size()); // Inicialmente 0

        /* Agregar elementos */
        listaAlumnos.add(new Alumno("Ana", 20)); // al final
        listaAlumnos.addLast(new Alumno("Marta", 21)); // al final
        listaAlumnos.addFirst(new Alumno("Luis", 22)); // al inicio

        /* Obtener elemento */
        listaAlumnos.get(0); // obtiene el primer elemento
        // ➤ Obtener primero o último
        System.out.println(listaAlumnos.getFirst()); // primer elemento
        System.out.println(listaAlumnos.getLast());  // último elemento

        /* Modificar elemento */
        listaAlumnos.set(0, new Alumno("Carlos", 23)); // reemplaza el elemento en la posición 0

        /* Borrar elemento */
        listaAlumnos.remove(0); // elimina el elemento en la posición 0
        listaAlumnos.remove(new Alumno("Marta", 21)); // elimina por objeto usando equals
        // ➤ Eliminar primero o último
        listaAlumnos.removeFirst();
        listaAlumnos.removeLast();

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
        LinkedList<Alumno> copiaLista = new LinkedList<>(listaAlumnos);

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