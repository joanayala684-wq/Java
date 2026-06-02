package ejemploInterface3;

import java.time.LocalDate;



	public class Student {
	    private int rollno;
	    private String name;
	    private int age;
	    private LocalDate fechaIncorporacion; // Nuevo atributo

	    // Constructor actualizado
	    public Student(int rollno, String name, int age, LocalDate fechaIncorporacion) {
	        this.rollno = rollno;
	        this.name = name;
	        this.age = age;
	        this.fechaIncorporacion = fechaIncorporacion;
	    }

	    // Getters y Setters
	    public int getRollno() { return rollno; }
	    public String getName() { return name; }
	    public int getAge() { return age; }
	    public LocalDate getFechaIncorporacion() { return fechaIncorporacion; }

	    // Método toString para visualizar los datos en la consola
	    @Override
	    public String toString() {
	        return "Student{" +
	                "id=" + rollno +
	                ", nombre='" + name + '\'' +
	                ", edad=" + age +
	                ", incorporación=" + fechaIncorporacion +
	                '}';
	    }}
	