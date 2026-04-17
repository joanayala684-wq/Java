package utilidades;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionFicheros {

    /**
     * Lee un fichero y devuelve un ArrayList con cada línea como un String.
     * @param rutaArchivo Nombre o ruta del fichero .txt
     * @return Lista de líneas leídas
     */
    public static ArrayList<String> leerLineas(String rutaArchivo) {
        ArrayList<String> lineas = new ArrayList<>();
        File archivo = new File(rutaArchivo);

        try (Scanner sc = new Scanner(archivo)) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                // Omitimos líneas vacías por seguridad
                if (!linea.trim().isEmpty()) {
                    lineas.add(linea);
                }
            }
        } catch (Exception e) {
            System.err.println("Error al leer el archivo " + rutaArchivo + ": " + e.getMessage());
        }

        return lineas;
    }
}