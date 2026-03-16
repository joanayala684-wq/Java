package ej3;

public class Usuario {
	private String nombre;
	private int num_entradas;
	private static int Displo;

	public Usuario(String nombre) {
		super();
		this.nombre = nombre;
	}

	public static void setDisplo(int displo) {
		Displo = displo;
	}

	public Usuario(String nombre, int num_entradas) {
		super();
		this.nombre = nombre;
		this.num_entradas = num_entradas;

	}

	public int comprar() {
		if (num_entradas > Displo) {
			return 0;
		} else {

			Displo -= num_entradas;
			if (Displo == 0) {
				return -1;
			}
			return 1;

		}
	
	}

	public String getNombre() {
		return nombre;
	}

	public int getNum_entradas() {
		return num_entradas;
	}

}
