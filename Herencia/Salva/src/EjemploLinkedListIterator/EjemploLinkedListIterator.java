package EjemploLinkedListIterator;

import java.util.LinkedList;
import java.util.ListIterator;



import java.util.Iterator;

public class EjemploLinkedListIterator {
    public static void main(String[] args) {
        LinkedList<Student> lista = new LinkedList<>();
        
        lista.add(new Student(101, "Luis", 23));
        lista.add(new Student(106, "Gemma", 27));
        lista.add(new Student(105, "Pedro", 21));

        // --- FORMA 1: Iterador Tradicional (Hacia adelante) ---
        System.out.println("Recorrido normal:");
        Iterator<Student> it = lista.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        // --- FORMA 2: ListIterator (Hacia atrás) ---
        // Le decimos que empiece al final de la lista: lista.size()
        System.out.println("\nRecorrido inverso (del último al primero):");
        ListIterator<Student> listIt = lista.listIterator(lista.size());
        
        while(listIt.hasPrevious()) {
            Student s = listIt.previous(); // "Dame el anterior"
            System.out.println(s);
        }
        System.out.println("Estudiantes mayores de 21 años:");
        Iterator<Student> it1 = lista.iterator();

        while(it1.hasNext()) {
            Student st = it1.next(); // Sacamos el objeto actual
            
            // Usamos el IF para filtrar
            if (( st).getAge() > 21) {
                System.out.println("ADMITIDO: " + st.getName());
            } else {
                System.out.println("PENDIENTE: " + st.getName() + " (muy joven)");
            }
        }
        Iterator<Student> it11 = lista.iterator();

        while(it11.hasNext()) {
            Student st = it11.next();
            
            // Si el nombre empieza por 'P', lo borramos de la lista
            if (st.getName().startsWith("P")) {
                it11.remove(); // Borra a 'Pedro' de la LinkedList de forma segura
                System.out.println("Se ha eliminado a " + st.getName() + " de la lista.");
            }
        }

        // --- FORMA 3: Modificar mientras recorres ---
        System.out.println("\nModificando nombres durante el recorrido...");
        ListIterator<Student> editIt = lista.listIterator();
        while(editIt.hasNext()) {
            Student s = editIt.next();
            if(s.getName().equals("Luis")) {
                // ListIterator nos permite REEMPLAZAR el objeto
                editIt.set(new Student(101, "Luis (Delegado)", 23));
            }
        }
        
        // Ver resultado final
        lista.forEach(System.out::println);
        
        /*El Iterator mantiene una conexión interna con la estructura de la lista. Cuando el if se cumple y llamas a it.remove(), el iterador le dice a la lista: "Oye, el último nodo que te pedí, elimínalo y reajusta los punteros para que yo pueda seguir al siguiente sin perderme".

Resumen de la lógica:
it.next(): Te da el objeto y mueve el cursor.

if(...): Comprueba una propiedad de ese objeto.

it.remove(): Actúa sobre la lista basándose en el resultado del if.*/
    }
}