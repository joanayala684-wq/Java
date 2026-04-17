package ejer3;

import java.util.Comparator;

public class ComparaPorFecha implements Comparator <Student>{
/*Introducir un dato fecha de incorporación en la clase Student del ejemplo tres y
usando interfaces ordenar un vector de Student de más reciente a más antigua
fecha de incorporación.*/
	//Ordenar por edad de menor a mayor
	 
    public int compare(Student arg0, Student arg1) {
    	// Para orden descendente (reciente a antiguo), comparamos s2 con s1.
       return arg1.getfIncorporacion().compareTo(arg0.getfIncorporacion());
       
    }

	

/*Ordenar por nombre menor a mayor
    public int compareTo(Student st) {
        return name.compareTo(st.name);
    }
*/
    
/*Ordenar por nombre mayor a menor
    public int compareTo(Student st) {
        return name.compareTo(st.name)*-1;
    }
*/
}
