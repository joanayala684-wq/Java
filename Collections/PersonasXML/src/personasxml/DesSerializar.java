package personasxml;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;

public class DesSerializar {
    public static void main(String[] args) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Persona.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Persona persona = (Persona) unmarshaller.unmarshal(new File("persona.xml"));
        System.out.println(persona.getNombre() + " - " + persona.getEdad());
    }
}
