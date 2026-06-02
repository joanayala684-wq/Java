package personasxml2;
import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Aficion a1 = new Aficion("Leer", "Lectura de novelas hist�ricas");
        Aficion a2 = new Aficion("Senderismo", "Excursiones por la monta�a");
        Aficion a3 = new Aficion("Fotografia", "Fotografiar paisajes");


        Persona persona1 = new Persona("Karoll", 30, Arrays.asList(a1, a2));
        Persona persona2 = new Persona("Vicky", 28, Arrays.asList(a1, a3));
        
      
      
    }
}
