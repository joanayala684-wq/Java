package ejer3;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

class Student{  

@Override
	public String toString() {
		return "Student [number=" + number + ", name=" + name + ", age=" + age + ", fIncorporacion=" + fIncorporacion
				+ "]";
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
  

public String getName() {
	return name;
}
public LocalDate getfIncorporacion() {
	return fIncorporacion;
}


public int compareTo(Student st) {
    if (age == st.age)
        return 0*-1;
    else if (age > st.age)
        return 1*-1;
    else
        return -1*-1;
}




}  
