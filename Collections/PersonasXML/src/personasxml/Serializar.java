package personasxml;
import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

public class Serializar {
    public static void main(String[] args) throws Exception {
        Persona persona = new Persona("Ana", 30);

        JAXBContext context = JAXBContext.newInstance(Persona.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(persona, System.out); // salida por consola
        marshaller.marshal(persona, new File("salida.xml")); //salida a fichero
    }
}
