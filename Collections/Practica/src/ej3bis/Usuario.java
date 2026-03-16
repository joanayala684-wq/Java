package ej3bis;

public class Usuario {
	private String nombre;
	private int num_entradas;


	public Usuario(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Usuario(String nombre, int num_entradas) {
		super();
		this.nombre = nombre;
		this.num_entradas = num_entradas;

	}
	
	public String getNombre() {
		return nombre;
	}

	public int getNum_entradas() {
		return num_entradas;
	}

}
