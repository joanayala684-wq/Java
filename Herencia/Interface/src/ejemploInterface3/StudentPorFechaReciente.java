package ejemploInterface3;

import java.util.Comparator;


public class StudentPorFechaReciente implements Comparator<Student> {

    @Override
    public int compare(Student arg0, Student arg1) {
        // Al comparar arg1 con arg0 logramos el orden descendente (más reciente a más antigua)
        return arg1.getFechaIncorporacion().compareTo(arg0.getFechaIncorporacion());
    }
}