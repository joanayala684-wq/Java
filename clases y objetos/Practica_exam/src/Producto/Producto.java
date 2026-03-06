package Producto;

public class Producto {
    private int id;
    private String nombre;

    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("[ID: %03d | Nombre: %-10s]", id, nombre);
    }

}
