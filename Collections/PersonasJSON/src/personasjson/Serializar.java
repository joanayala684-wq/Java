package personasjson;

import java.io.File;
import java.util.Arrays;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Serializar {

    public static void main(String[] args) throws Exception {
        // Asignamos el archivo físico
        File archivo = new File("persona.json");
        
        // Definimos las aficiones reales
        Aficion a1 = new Aficion("Leer", "Lectura de novelas históricas");
        Aficion a2 = new Aficion("Senderismo", "Excursiones por la montaña");

        // Creamos el objeto Persona con tu nombre (Joan)
        Persona persona1 = new Persona("Joan", 20, Arrays.asList(a1, a2));

        ObjectMapper mapper = new ObjectMapper();

        // ==========================================
        // FASE 1: SERIALIZAR (Guardar en el archivo)
        // ==========================================
        // CORRECCIÓN CRÍTICA: writeValue escribe directamente en el archivo "persona.json"
        mapper.writerWithDefaultPrettyPrinter().writeValue(archivo, persona1);
        
        // También lo imprimimos como String para ver el JSON generado
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(persona1);
        System.out.println("=== JSON GENERADO Y GUARDADO ===");
        System.out.println(jsonString);
        System.out.println("================================\n");
        
        // ==========================================
        // FASE 2: DESERIALIZAR (Leer del archivo)
        // ==========================================
        Persona personaLeida = mapper.readValue(archivo, Persona.class);

        System.out.println("=== PANTALLAZO DE LA SALIDA (INDIVIDUAL) ===");
        System.out.println("Nombre: " + personaLeida.getNombre());
        System.out.println("Edad:   " + personaLeida.getEdad());
        System.out.println("Aficiones:");
        
        if (personaLeida.getAficiones() != null) {
            for (Aficion afic : personaLeida.getAficiones()) {
                System.out.println(" * " + afic.getNombre() + ": " + afic.getDescripcion());
            }
        }
        System.out.println("============================================");
    }
}