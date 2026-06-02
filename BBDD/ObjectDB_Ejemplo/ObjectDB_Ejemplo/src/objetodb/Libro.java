package objetodb;

import javax.persistence.*;

@Entity
public class Libro {
    @Id 
    private String id;

    private String titulo;
    private String autor;

    public Libro() {}

    public Libro(String id, String titulo, String autor) {
    	this.id=id;
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }

    public String getId() {
		return id;
	}

	@Override
    public String toString() {
        return "Libro{Id="+id + ", titulo='" + titulo + "', autor='" + autor + "'}";
    }

	public void setAutor(String autor) {
		this.autor = autor;
	}
}