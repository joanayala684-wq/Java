package ejemploInterface3;

import java.util.Comparator;

public class hg {
	public int compare(Student s1, Student s2) {
        boolean ascendente;
		if (ascendente) {
            return Integer.compare(s1.getAge(), s2.getAge());
        } else {
            return Integer.compare(s2.getAge(), s1.getAge()); // Al revés
        }
    }

	// Tenemos nuestro comparador normal (ascendente)
	Comparator<Student> porEdad = new StudentPorEdad();

	// Para ascendente:
	Collections.sort(al, porEdad);

	// Para descendente: ¡Simplemente llama a .reversed()!
	Collections.sort(al, porEdad.reversed());
	
	Collections.sort(al, new StudentComparadorEdad(false)); // Ordena descendente
}

