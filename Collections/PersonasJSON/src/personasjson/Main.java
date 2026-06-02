package personasjson;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Aficion a1 = new Aficion("Leer", "Lectura de novelas hist�ricas");
        Aficion a2 = new Aficion("Senderismo", "Excursiones por la monta�a");
        Aficion a3 = new Aficion("Fotografia", "Fotografiar paisajes");


        Persona persona1 = new Persona("Karoll", 30, Arrays.asList(a1, a2));
        Persona persona2 = new Persona("Vicky", 28, Arrays.asList(a1, a3));

      
        ObjectMapper mapper = new ObjectMapper();

        // Escribir a JSON
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("persona.json"), persona1);
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("persona.json"), persona2);

        // Leer desde JSON
        Persona personaLeida = mapper.readValue(new File("salida.json"), Persona.class);
        System.out.println("Nombre le�do: " + personaLeida.getNombre() + personaLeida.getAficiones());
    }
}
