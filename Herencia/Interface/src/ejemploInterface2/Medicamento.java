package ejemploInterface2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Medicamento implements Caducable {
	    private String nombre;
	    private LocalDate fechaCaducidad;

	    public Medicamento(String nombre, LocalDate fechaCaducidad) {
	        this.nombre = nombre;
	        this.fechaCaducidad = fechaCaducidad;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    @Override
	    public boolean esCaducado() {
	        // Si la fecha actual es posterior a la de caducidad, está caducado
	        return LocalDate.now().isAfter(fechaCaducidad);
	    }

	    @Override
	    public long diasParaCaducar() {
	        // Calculamos los días entre hoy y la fecha de caducidad
	        return ChronoUnit.DAYS.between(LocalDate.now(), fechaCaducidad);
	    }

	    @Override
	    public String toString() {
	        return "Medicamento: " + nombre + " (Caduca el: " + fechaCaducidad + ")";
	    

}}
