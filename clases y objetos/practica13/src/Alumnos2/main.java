package Alumnos2;

import Alumno.Alumnos;
import frutas.Frutas;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alumnos al1=new Alumnos(1,7,3,5);
		Alumnos al2=new Alumnos(2,4,4,5);
		Alumnos al3=new Alumnos(3,9,7,5);
		double nAlum1=al1.notaMedia();
		double nAlum2=al2.notaMedia();
		double nAlum3=al3.notaMedia();
		double mediaClase=(nAlum1+nAlum2+nAlum3)/3;
		double notaMedProg=(al1.getProgramacion()+al2.getProgramacion()+al3.getProgramacion()/3);
		System.out.println("beneficio total:"+Alumno.getNumAprobProg());
	}

}
