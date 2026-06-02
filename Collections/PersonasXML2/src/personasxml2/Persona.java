package personasxml2;
import jakarta.xml.bind.annotation.*;
import java.util.List;

//@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Persona {
    private String nombre;
    private int edad;

    @XmlElementWrapper(name = "aficiones")
    @XmlElement(name = "aficion")
    private List<Aficion> aficiones;

    public Persona() {}

    public Persona(String nombre, int edad, List<Aficion> aficiones) {
        this.nombre = nombre;
        this.edad = edad;
        this.aficiones = aficiones;
    }
    public class Daw1{
    	private List<Persona>persona;
    }
    

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public List<Aficion> getAficiones() { return aficiones; }
    public void setAficiones(List<Aficion> aficiones) { this.aficiones = aficiones; }
}
