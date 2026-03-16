package ejercicio13;

import java.time.LocalDate;

public class Alumno {



	private String nombre, apellido;
	private double nota;
	private LocalDate fecha_nac;
	
	
	public Alumno(String nombre, String apellido, double nota, LocalDate fecha_nac) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nota = nota;
		this.fecha_nac = fecha_nac;

	}


	public double getNota() {
		return nota;
	}
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido=" + apellido + ", nota=" + nota + ", fecha_nac=" + fecha_nac
				+ "]";
	}

	

	
/*Para cuando nos dejen ordenar collections con sort: */
	/*//esto en una lista que va de mayor a menor 
	public int compareTo(Alumno o) {
		// TODO Auto-generated method stub
		//ambos alumnos tinene la misma nota
		if (this.nota==o.nota)
			return 0;
		//el objecto actual va despues del otro
		if (this.nota<o.nota)
			return 1;
		//el objecto actual va antes del otro
		return -1;
	}
*/
}
