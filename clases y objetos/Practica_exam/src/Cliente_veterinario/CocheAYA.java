package Cliente_veterinario;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CocheAYA {
private String nombre, motivo, codigo;
private LocalDateTime fecha;
public CocheAYA(String nombre, String motivo, LocalDateTime fecha) {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMM");
	this.nombre = nombre;
	this.motivo = motivo;
	this.fecha = fecha;
	this.codigo = motivo.substring(0,2).toUpperCase()+"-"+ fecha.format(formatter);

}
public String getCodigo() {
	return codigo;
}
public String getNombre() {
	return nombre;
}
public LocalDateTime getFecha() {
	return fecha;
}
@Override
public String toString() {
	return "citaMedica [nombre=" + nombre + ", motivo=" + motivo + ", codigo=" + codigo + ", fecha=" + fecha + "]";
}

}
