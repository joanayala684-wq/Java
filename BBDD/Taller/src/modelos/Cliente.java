package modelos;

public abstract class Cliente {
	private String dni, nombre, telefono, direccion;
	private int carnet;
	public int visitas;
	
	public Cliente(String dni, String nombre, String telefono, String direccion, int carnet, int visitas) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.carnet = carnet;
		this.visitas = visitas;
	}
	
	public abstract double pagar (Arreglo a) ;

	public String getDni() {
		return dni;
	}
	public String getNombre() {
		return nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	
	public int getCarnet() {
		return carnet;
	}
	public int getVisitas() {
		return visitas;
	}@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion
				+ ", carnet=" + carnet + ", visitas=" + visitas + "]";
	}
	
}
