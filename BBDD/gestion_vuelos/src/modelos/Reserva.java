package modelos;

import java.time.LocalDate;

public class Reserva {
	private int id_reserva;
	private String pasaporte_pasajero, codigo_vuelo;
	private double precio_final;
	private LocalDate fecha_reserva;
	public Reserva(int id_reserva, String pasaporte_pasajero, String codigo_vuelo, double precio_final,
			LocalDate fecha_reserva) {
		super();
		this.id_reserva = id_reserva;
		this.pasaporte_pasajero = pasaporte_pasajero;
		this.codigo_vuelo = codigo_vuelo;
		this.precio_final = precio_final;
		this.fecha_reserva = fecha_reserva;
	}
	public int getId_reserva() {
		return id_reserva;
	}
	public String getPasaporte_pasajero() {
		return pasaporte_pasajero;
	}
	public String getCodigo_vuelo() {
		return codigo_vuelo;
	}
	public double getPrecio_final() {
		return precio_final;
	}
	public LocalDate getFecha_reserva() {
		return fecha_reserva;
	}
	@Override
	public String toString() {
		return "Reserva [id_reserva=" + id_reserva + ", pasaporte_pasajero=" + pasaporte_pasajero + ", codigo_vuelo="
				+ codigo_vuelo + ", precio_final=" + precio_final + ", fecha_reserva=" + fecha_reserva + "]";
	}
}
