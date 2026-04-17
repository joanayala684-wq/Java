package ejer1;

public class Libro  implements Comparable<Libro>{
	private String titulo, autor, editorial;
	protected double precio;
	
	public Libro(String titulo, String autor, String editorial, double precio) {
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", precio=" + precio + "]";
	}

	public double getPrecio() {
		return precio;
	}

	@Override
	public int compareTo(Libro arg0) {
		// TODO Auto-generated method stub
		return titulo.compareTo(arg0.titulo);
	}
	

}
