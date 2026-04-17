package ejemploInterface3;

import java.util.Comparator;

public class StudentPorNumero implements Comparator<Student> {
    @Override
 // ASCENDENTE (1, 2, 3...)
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getNumber(), s2.getNumber());
    }
}
//DESCENDENTE (...3, 2, 1)
class StudentNumeroDesc implements Comparator<Student> {
 public int compare(Student s1, Student s2) {
     return Integer.compare(s2.getNumber(), s1.getNumber());
 }
}
