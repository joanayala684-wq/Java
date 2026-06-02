package personasxml2;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;

public class Serializar {

    public static void main(String[] args) throws Exception {
        File archivo = new File("daw.xml");

        DAW1 daw = new DAW1();

        Persona tuPersona = new Persona();
        tuPersona.setNombre("Juan");
        tuPersona.setEdad(20);



        daw.getListaPersonas().add(tuPersona);

        JAXBContext context = JAXBContext.newInstance(DAW1.class);
        Marshaller marshaller = context.createMarshaller();
        
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(daw, archivo);

        System.out.println("=== PROCESO DE SERIALIZACIÓN (DAW1) ===");
        System.out.println(">> Éxito: Objeto DAW serializado correctamente.");
        System.out.println(">> Archivo generado: " + archivo.getName());
        System.out.println("=======================================");
    }
}