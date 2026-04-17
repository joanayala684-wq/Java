package ejer1;

public class Texto extends Libro {

@Override
	public String toString() {
		return "Texto [curso=" + curso + ", descuento=" + descuento + ", toString()=" + super.toString() + "]";
	}






private String curso;
private double descuento;



public Texto(String titulo, String autor, String editorial, double precio, String curso, double descuento) {
	super(titulo, autor, editorial, precio);
	this.curso = curso;
	this.precio=precio-(precio*descuento/100);
	
}






public String getCurso() {
	return curso;
}




}
