package personasxml2;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "curso_daw1")
@XmlAccessorType(XmlAccessType.FIELD)
public class DAW1 {

    private String nombreCurso = "1º Desarrollo de Aplicaciones Web";

    @XmlElementWrapper(name = "alumnos")
    @XmlElement(name = "DAW1")
    private List<Persona> listaPersonas;

    public DAW1() {
        this.listaPersonas = new ArrayList<>();
    }

    public String getNombreCurso() { return nombreCurso; }
    public void setNombreCurso(String nombreCurso) { this.nombreCurso = nombreCurso; }

    public List<Persona> getListaPersonas() { return listaPersonas; }
    public void setListaPersonas(List<Persona> listaPersonas) { this.listaPersonas = listaPersonas; }
}