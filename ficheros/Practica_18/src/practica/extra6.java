package practica;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class extra6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Path archivo = Paths.get("usuarios.txt");
        Charset charset = Charset.forName("UTF-8");
        String continuar;

        do {
            System.out.println("--- CONSULTA DE CONEXIÓN ---");
            System.out.print("Introduce usuario: ");
            String userBusca = sc.nextLine();
            System.out.print("Introduce password: ");
            String passBusca = sc.nextLine();

            boolean encontrado = false;

            // Abrimos el lector (pajita) para leer el archivo
            try (BufferedReader reader = Files.newBufferedReader(archivo, charset)) {
                String linea;
                String nombreActual = "", passActual = "", conexActual = "";

                while ((linea = reader.readLine()) != null) {
                    // Quitamos espacios en blanco a los lados para no fallar
                    linea = linea.trim();

                    // Si leemos los datos, extraemos el contenido de las etiquetas
                    if (linea.startsWith("<nombre>")) {
                        nombreActual = extraerDato(linea, "nombre");
                    } else if (linea.startsWith("<password>")) {
                        passActual = extraerDato(linea, "password");
                    } else if (linea.startsWith("<conexion>")) {
                        conexActual = extraerDato(linea, "conexion");
                    }
                    
                    // Al llegar al final de un bloque </usuario>, comprobamos si es el que buscamos
                    if (linea.equals("</usuario>")) {
                        if (nombreActual.equals(userBusca) && passActual.equals(passBusca)) {
                            System.out.println("¡Login correcto! Minutos conectados: " + conexActual);
                            encontrado = true;
                            break; // Ya lo encontramos, salimos del while
                        }
                    }
                }

                if (!encontrado) {
                    System.out.println(" Usuario o contraseña incorrectos.");
                }

            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }

            System.out.println("\n¿Quieres consultar otro? (s/n)");
            continuar = sc.nextLine();

        } while (continuar.equalsIgnoreCase("s"));
    }

    // Método auxiliar para limpiar las etiquetas: <nombre>daw1</nombre> -> daw1
    public static String extraerDato(String linea, String etiqueta) {
        // Reemplaza "<etiqueta>" y "</etiqueta>" por nada ("")
        return linea.replace("<" + etiqueta + ">", "").replace("</" + etiqueta + ">", "");
    }
}