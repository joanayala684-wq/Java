package modelos;

public class Usuario {
	private int numero;
	private String nombre, apellidos, tipo;
	private int penalizado;
	
	public Usuario(int numero, String nombre, String apellidos, String tipo, int penalizado) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.tipo = tipo;
		this.penalizado = penalizado;
	}
	public int getNumero() {
		return numero;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public String getTipo() {
		return tipo;
	}
	public int getPenalizado() {
		return penalizado;
	}
	@Override
	public String toString() {
		return "Usuario [numero=" + numero + ", nombre=" + nombre + ", apellidos=" + apellidos + ", tipo=" + tipo
				+ ", penalizado=" + penalizado + "]";
	}
	
}
