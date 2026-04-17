package ejemploInterface3;

public class hg {
	@Override
    public int compare(Student s1, Student s2) {
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

