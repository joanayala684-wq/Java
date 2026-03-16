package control5;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Tenemos una carpeta con vuestro apellido dentro de la carpeta de vuestra
		 * aplicación. Esa carpeta contiene varios ficheros de texto con la información
		 * de varios libros (un libro en cada línea) separada por comas (titulo, autor,
		 * precio ): Leed todos los ficheros de esta carpeta que empiecen por “ventas” y
		 * generad un único fichero con vuestro nombre ( a la misma altura que la
		 * carpeta de vuestro apellido) que contenga todos los libros cuyo precio sea
		 * superior a 20 euros. Cada línea del nuevo fichero tendrá el siguiente
		 * formato: Título:’La Odisea’ autor:Homero Titulo:’Ulises’ autor:James Joyce
		 */
		Path carp = Paths.get("tuApellido"); // Carpeta origen
        Path ficheroSalida = Paths.get("tuNombre.txt"); // Fichero destino
        Charset charset = Charset.forName("UTF-8");

        if (!Files.exists(carp) || !Files.isDirectory(carp)) {
            System.out.println("La carpeta no existe o no es un directorio.");
            return;
        }

        // 1. Abrimos el escritor principal (se cierra solo al final)
        try (BufferedWriter writer = Files.newBufferedWriter(ficheroSalida, charset, CREATE, WRITE, APPEND);
             DirectoryStream<Path> stream = Files.newDirectoryStream(carp)) {

            for (Path path : stream) {
                // Filtramos archivos que empiecen por "ventas"
                if (Files.isRegularFile(path) && path.getFileName().toString().startsWith("ventas")) {
                    
                    // 2. Abrimos un lector para CADA archivo encontrado
                    try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            String[] datos = line.split(",");
                            
                            if (datos.length == 3) {
                                try {
                                    String titulo = datos[0].trim();
                                    String autor = datos[1].trim();
                                    double precio = Double.parseDouble(datos[2].trim());

                                    if (precio > 20) {
                                        // Formato: Título:’La Odisea’ autor:Homero
                                        writer.write("Título:’" + titulo + "’ autor:" + autor);
                                        writer.newLine();
                                    }
                                } catch (NumberFormatException e) {
                                    System.err.println("Precio no válido en: " + line);
                                }
                            }
                        }
                    } // Aquí el reader se cierra automáticamente (muy importante)
                }
            }
            System.out.println("Proceso finalizado correctamente.");

        } catch (IOException e) {
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }
}