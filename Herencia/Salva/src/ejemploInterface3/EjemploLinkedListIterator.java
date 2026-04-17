package ejemploInterface3;

import java.util.LinkedList;
import java.util.ListIterator;

import ejemploInterface3.Student;

import java.util.Iterator;

public class EjemploLinkedListIterator {
    public static void main(String[] args) {
        LinkedList<Student> lista = new LinkedList<>();
        
        lista.add(new Student(101, "Luis", 23, null));
        lista.add(new Student(106, "Gemma", 27, null));
        lista.add(new Student(105, "Pedro", 21, null));

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

        // --- FORMA 3: Modificar mientras recorres ---
        System.out.println("\nModificando nombres durante el recorrido...");
        ListIterator<Student> editIt = lista.listIterator();
        while(editIt.hasNext()) {
            Student s = editIt.next();
            if(s.getName().equals("Luis")) {
                // ListIterator nos permite REEMPLAZAR el objeto
                editIt.set(new Student(101, "Luis (Delegado)", 23, null));
            }
        }
        
        // Ver resultado final
        lista.forEach(System.out::println);
    }
}