package ejer3;

import java.util.Comparator;

public class StudentPorNombre implements Comparator<Student>{

	@Override
	// ASCENDENTE (A-Z)
	public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
	class StudentNombreDesc implements Comparator<Student> {
	    public int compare(Student s1, Student s2) {
	        return s2.getName().compareTo(s1.getName()); // Invertimos s2 y s1
	    }
	}
}
