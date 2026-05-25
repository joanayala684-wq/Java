package modelos;

public class Libro {
	private String isbn, titulo, autor, editorial;
	private int numejemplares, prestados;
	
	public Libro(String isbn, String titulo, String autor, String editorial, int numejemplares, int prestados) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.numejemplares = numejemplares;
		this.prestados = prestados;
	}
	public String getIsbn() {
		return isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getAutor() {
		return autor;
	}
	public String getEditorial() {
		return editorial;
	}
	public int getNumejemplares() {
		return numejemplares;
	}
	public int getPrestados() {
		return prestados;
	}
	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial
				+ ", numejemplares=" + numejemplares + ", prestados=" + prestados + "]";
	}
	
}
