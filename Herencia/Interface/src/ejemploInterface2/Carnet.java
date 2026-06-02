package ejemploInterface2;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Carnet implements Caducable {
    private String tipo;
    private LocalDate fechaCaducidad;

    public Carnet(String tipo, LocalDate fechaCaducidad) {
        this.tipo = tipo;
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public boolean esCaducado() {
        return LocalDate.now().isAfter(fechaCaducidad);
    }

    @Override
    public long diasParaCaducar() {
        return ChronoUnit.DAYS.between(LocalDate.now(), fechaCaducidad);
    }

    @Override
    public String toString() {
        return "Carnet de " + tipo + " (Caduca el: " + fechaCaducidad + ")";
    }
}