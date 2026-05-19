package modelos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Vuelo {
	private String codigo_vuelo, destino;
	private double precio_billete;
	private LocalDateTime fecha_salida;
	private int asientos_libres;
	public Vuelo(String codigo_vuelo, String destino, double precio_billete, LocalDateTime fecha_salida,
			int asientos_libres) {
		super();
		this.codigo_vuelo = codigo_vuelo;
		this.destino = destino;
		this.precio_billete = precio_billete;
		this.fecha_salida = fecha_salida;
		this.asientos_libres = asientos_libres;
	}
	public String getCodigo_vuelo() {
		return codigo_vuelo;
	}
	public String getDestino() {
		return destino;
	}
	public double getPrecio_billete() {
		return precio_billete;
	}
	public LocalDateTime getFecha_salida() {
		return fecha_salida;
	}
	public int getAsientos_libres() {
		return asientos_libres;
	}
	@Override
	public String toString() {
		return "Vuelo [codigo_vuelo=" + codigo_vuelo + ", destino=" + destino + ", precio_billete=" + precio_billete
				+ ", fecha_salida=" + fecha_salida + ", asientos_libres=" + asientos_libres + "]";
	}
}
