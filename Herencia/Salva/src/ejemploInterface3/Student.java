package ejemploInterface3;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;

class Student{  
public int getNumber() {
		return number;
	}




	public int getAge() {
		return age;
	}
private int number;  
private String name;  
private int age;  
private LocalDate fIncorporacion;

Student(int nu,String name,int age, LocalDate fIncorporacion){  
this.number=nu;  
this.name=name;  
this.age=age; 
this.fIncorporacion=fIncorporacion;
}  
  
/*0: Significa que ambos son iguales.

1 (o positivo): Significa que el objeto actual es "mayor".
los mayores se vayan al principio de la lista.

-1 (o negativo): Significa que el objeto actual es "menor".*/

public Student(int nu, String name2, int age2, Date date) {
	// TODO Auto-generated constructor stub
}




//descente
public int compareTo(Student st) {
    if (age == st.age)
        return 0;
    else if (age > st.age)
        return 1;
    else
        return 1;
}
/*
 Ordenar por fecha: Antiguo a Reciente (Ascendente) 
public int compareTo(Student st) {
    // Si mi fecha es anterior, devuelve negativo (va primero)
    // Si mi fecha es posterior, devuelve positivo (va después)
    return this.fechaMatricula.compareTo(st.fechaMatricula);
}*/

/*/* Ordenar por fecha: Reciente a Antiguo (Descendente) 
public int compareTo(Student st) {
    // Multiplicamos por -1 para que la fecha más nueva sea la "primera"
    return this.fechaMatricula.compareTo(st.fechaMatricula) * -1;
}*/
public String getName() {
	return name;
}
public LocalDate getfIncorporacion() {
	return fIncorporacion;
}
@Override
public String toString() {
	return "Student [number=" + number + ", name=" + name + ", age=" + age + ", fIncorporacion=" + fIncorporacion
			+ "]";
}




}  
