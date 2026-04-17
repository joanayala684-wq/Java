package ejemploInterface3;

import java.util.Comparator;

public class StudentPorEdad implements Comparator<Student> {
	// ASCENDENTE (Menor a Mayor)
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getAge(), s2.getAge());
    }
}
//DESCENDENTE (Mayor a Menor)
class StudentEdadDesc implements Comparator<Student> {
 public int compare(Student s1, Student s2) {
     return Integer.compare(s2.getAge(), s1.getAge()); // Invertimos
 }
}