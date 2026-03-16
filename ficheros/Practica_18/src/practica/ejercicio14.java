package practica;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;
import static java.nio.file.StandardOpenOption.APPEND;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ejercicio14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 14. Programa que elimina una palabra introducida por teclado de un fichero.
		 * El nombre del fichero de entrada y el de salida se introducen por teclado y
		 * no pueden coincidir.
		 */
Scanner sc = new Scanner(System.in);
        
        // Configuramos el idioma de los textos (UTF-8 es el estándar universal)
        Charset charset = Charset.forName("UTF-8");
        
        // Declaramos el lector y el escritor fuera para poder cerrarlos en el 'finally'
        BufferedReader reader = null;
        BufferedWriter writer = null;

        // 1. Pedir datos por teclado
        System.out.println("--- PROGRAMA ELIMINADOR DE PALABRAS ---");
        System.out.print("Introduce el nombre del archivo de ENTRADA (ej: datos.txt): ");
        String nombreEntrada = sc.nextLine();
        
        System.out.print("Introduce el nombre del archivo de SALIDA (ej: limpio.txt): ");
        String nombreSalida = sc.nextLine();

        // Regla de oro: No pueden ser el mismo archivo o se borrarán los datos
        if (nombreEntrada.equalsIgnoreCase(nombreSalida)) {
            System.out.println(" Error: El archivo de entrada y salida deben ser diferentes.");
            return; 
        }

        System.out.print("Introduce la palabra que quieres eliminar: ");
        String palabra = sc.nextLine();

        // Convertimos los nombres de texto a rutas reales de sistema (Paths)
        Path fileEntrada = Paths.get(nombreEntrada);
        Path fileSalida = Paths.get(nombreSalida);

        try {
            // Comprobamos si el archivo de entrada existe antes de empezar
            if (!Files.exists(fileEntrada)) {
                System.out.println(" El archivo de entrada no existe.");
                return;
            }

            // Creamos el "túnel" de lectura y el de escritura
            reader = Files.newBufferedReader(fileEntrada, charset);
            writer = Files.newBufferedWriter(fileSalida, charset, CREATE, WRITE);

            String line;
            int contadorLineas = 0;

            // Leemos el archivo línea por línea hasta que no haya más (null)
            while ((line = reader.readLine()) != null) {
                contadorLineas++;

                /* * EL TRUCO DE LA LIMPIEZA:
                 * (?i) -> No importa si es mayúscula o minúscula.
                 * \\b  -> Asegura que borre la palabra entera (que no borre "sol" dentro de "soldado").
                 */
                String lineaLimpia = line.replaceAll("(?i)\\b" + palabra + "\\b", "");

                // Quitamos espacios dobles que hayan quedado y espacios sobrantes al inicio/final
                lineaLimpia = lineaLimpia.replaceAll("\\s{2,}", " ").trim();

                // Escribimos la línea ya limpia en el archivo de destino
                writer.write(lineaLimpia);
                
                // ¡IMPORTANTE! readLine() quita los saltos de línea, así que hay que ponerlos de nuevo
                writer.newLine(); 
            }

            System.out.println("✅ Proceso finalizado con éxito.");
            System.out.println("Se han procesado " + contadorLineas + " líneas.");

        } catch (IOException x) {
            // Si algo falla (archivo bloqueado, sin permisos...), saltará aquí
            System.err.println("Error de entrada/salida: " + x.getMessage());
        } finally {
            // El bloque finally siempre se ejecuta, ideal para cerrar archivos
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close(); // Si no cierras el writer, el archivo de salida podría quedar vacío
                }
            } catch (IOException e) {
                System.err.println("Error al cerrar los archivos.");
            }
        }
    }
}