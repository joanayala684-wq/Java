package personasjson;

import java.util.List;

public class Persona {
    private String nombre;
    private int edad;

  
    private List<Aficion> aficiones;

    public Persona() {}

    public Persona(String nombre, int edad, List<Aficion> aficiones) {
        this.nombre = nombre;
        this.edad = edad;
        this.aficiones = aficiones;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public List<Aficion> getAficiones() { return aficiones; }
    public void setAficiones(List<Aficion> aficiones) { this.aficiones = aficiones; }
}
