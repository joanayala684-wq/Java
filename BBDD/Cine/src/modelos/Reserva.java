package modelos;

public class Reserva {
	private int codigo, precio, entradas, sala, telefono;

	public Reserva( int precio, int entradas, int sala, int telefono) {
		super();
		this.precio = precio;
		this.entradas = entradas;
		this.sala = sala;
		this.telefono = telefono;
	}

	public int getCodigo() {
		return codigo;
	}

	public int getPrecio() {
		return precio;
	}

	public int getEntradas() {
		return entradas;
	}

	public int getSala() {
		return sala;
	}

	public int getTelefono() {
		return telefono;
	}

	@Override
	public String toString() {
		return "Reserva [codigo=" + codigo + ", precio=" + precio + ", entradas=" + entradas + ", sala=" + sala
				+ ", telefono=" + telefono + "]";
	}
}
