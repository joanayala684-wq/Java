package ejemploInterface3;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Vector;

public class Ppal {
	public static void main(String args[]) {
		/*
		 * Introducir un dato fecha de incorporación en la clase Student del ejemplo
		 * tres y usando interfaces ordenar un vector de Student de más reciente a más
		 * antigua fecha de incorporación.
		 */
		// Creamos el Vector de estudiantes pasándole fechas (Año, Mes, Día)
		Vector<Student> al = new Vector<Student>();
		al.add(new Student(101, "Luis", 23, LocalDate.of(2023, 5, 10)));
		al.add(new Student(106, "Gemma", 27, LocalDate.of(2025, 1, 15)));
		al.add(new Student(105, "Pedro", 21, LocalDate.of(2024, 8, 22)));

		// Ordenamos usando el nuevo comparador por fecha reciente
		Collections.sort(al, new StudentPorFechaReciente());

		// Mostramos el resultado por pantalla
		System.out.println("--- Estudiantes ordenados por fecha de incorporación (Reciente a Antigua) ---");
		for (Student st : al) {
			System.out.println(st);
		}
	}
}