package practica;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class extra5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        Path archivo = Paths.get("usuarios.txt");
        Charset charset = Charset.forName("UTF-8");

        // Usamos try-with-resources para que el archivo se cierre solo al terminar
        // StandardOpenOption.CREATE y APPEND sirven para crear el archivo si no existe 
        // y añadir datos al final sin borrar lo anterior.
        try (BufferedWriter writer = Files.newBufferedWriter(archivo, charset, 
                StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {

            String continuar;
            do {
                // 1. Pedir los datos por teclado
                System.out.println("Nombre de usuario:");
                String nombre = sc.nextLine();
                System.out.println("Password:");
                String pass = sc.nextLine();
                System.out.println("Minutos de conexión:");
                String minutos = sc.nextLine();

                // 2. Escribir en el archivo con el formato solicitado
                // Usamos \n para saltar de línea
                writer.write("<usuario>\n");
                writer.write("  <nombre>" + nombre + "</nombre>\n");
                writer.write("  <password>" + pass + "</password>\n");
                writer.write("  <conexion>" + minutos + "</conexion>\n");
                writer.write("</usuario>\n");

                System.out.println("¿Deseas añadir otro usuario? (s/n)");
                continuar = sc.nextLine();

            } while (continuar.equalsIgnoreCase("s"));

            System.out.println("Datos guardados correctamente.");

        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
	}

}
