package personasxml2;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;

public class DesSerializar {
    public static void main(String[] args) throws Exception {
        File archivo = new File("daw.xml");

        JAXBContext context = JAXBContext.newInstance(DAW1.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        DAW1 daw = (DAW1) unmarshaller.unmarshal(archivo);

        System.out.println("=== PANTALLAZO DE LA EJECUCIÓN (DESERIALIZACIÓN) ===");
        
        if (daw.getListaPersonas() != null) {
            for (Persona p : daw.getListaPersonas()) {
                System.out.println("Alumno: " + p.getNombre() + " | Edad: " + p.getEdad());
                System.out.println("-------------------------------------------------");
                
              
            }
        }
    }
}