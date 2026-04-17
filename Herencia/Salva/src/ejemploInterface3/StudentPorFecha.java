package ejemploInterface3;

import java.util.Comparator;
//ASCENDENTE (Más antigua a más reciente)

public class StudentPorFecha implements Comparator<Student> {
    @Override
    
    public int compare(Student s1, Student s2) {
        return s1.getfIncorporacion().compareTo(s2.getfIncorporacion());
    }
}
//DESCENDENTE (Más reciente a más antigua)
class StudentFechaDesc implements Comparator<Student> {
 public int compare(Student s1, Student s2) {
     return s2.getfIncorporacion().compareTo(s1.getfIncorporacion());
 }
 /*
 // Usando la clase que ya tienes para invertirla sin escribir código extra
 Collections.sort(al, new StudentNombreAsc().reversed());*/
}
