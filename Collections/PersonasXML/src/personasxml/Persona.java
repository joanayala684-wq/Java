package personasxml;
import jakarta.xml.bind.annotation.*;


 // Indicamos que persona es el elmento raíz

@XmlRootElement

// Indicamos que los nombres de los datos los use como etiquetas
@XmlAccessorType(XmlAccessType.FIELD)
public class Persona {
    private String nombre;
    private int edad;

    // Constructor vacío requerido por JAXB
   public Persona() {}

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // No es necesario anotar los getters ni setters al haber puesto la opción XmlAccessType.FIELD
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
}
