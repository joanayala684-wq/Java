package wallapop;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import modelos.*;
import bbdd.BD_Gestion_Vuelos;

public class Principal2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BD_Gestion_Vuelos bd = new BD_Gestion_Vuelos("mysql-properties.xml");
        
        Pasajero p = null;
        String pas;
        boolean valido = false;

        // 1. VALIDACIÓN DEL PASAJERO
        do {
            System.out.println("Introduce el número de pasaporte (8 números y 1 letra):");
            pas = sc.nextLine().toUpperCase(); // Aseguramos mayúscula
            
            if (!pas.matches("[0-9]{8}[A-Z]")) {
                System.out.println("Formato de pasaporte incorrecto. Vuelve a intentarlo.");
                continue;
            }
            
            try {
                p = bd.buscarUsu(pas);
                if (p != null) {
                    valido = true;
                    System.out.println("Bienvenido/a, " + p.getNombre());
                } else {
                    System.out.println("El pasaporte no está registrado en el sistema.");
                }
            } catch (ErrorBaseDatos e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
        } while (!valido);

        // 2. FILTRADO INTERACTIVO DE VUELOS
        ArrayList<Vuelo> destinosDisponibles = new ArrayList<>();
        do {
            System.out.println("\n--- BÚSQUEDA DE VUELOS ---");
            System.out.println("Introduce el destino:");
            String destino = sc.nextLine();
            
            System.out.println("Introduce el importe máximo:");
            double importe = sc.nextDouble();
            sc.nextLine(); // ¡IMPORTANTE! Limpiamos el buffer del salto de línea

            try {
                destinosDisponibles = bd.filtrarVuelos(destino, importe);
            } catch (ErrorBaseDatos e) {
                System.out.println(e.getMessage());
            }

            if (destinosDisponibles.isEmpty()) {
                System.out.println("No se ha encontrado ningún vuelo disponible con esos criterios. Vuelve a intentarlo.");
            }
            
        } while (destinosDisponibles.isEmpty());

        // MOSTRAR LOS VUELOS ENCONTRADOS
        int cont = 1;
        for (Vuelo v : destinosDisponibles) {
            System.out.println(cont + ". " + v.toString());
            cont++;
        }

        // SELECCIÓN DEL VUELO
        int pos = 0;
        do {
            System.out.println("Introduce la posición del vuelo que deseas comprar:");
            pos = sc.nextInt();
            sc.nextLine(); // Limpiamos buffer
        } while (pos > destinosDisponibles.size() || pos <= 0);
        
        Vuelo vSeleccionado = destinosDisponibles.get(pos - 1);

        // 3. PROCESO DE REGISTRO Y ACTUALIZACIONES EN LA BBDD
        try {
            // A) Alta de la reserva
            int filasReserva = bd.altaReserva(vSeleccionado, p);
            if (filasReserva > 0) {
                System.out.println("Reserva registrada con éxito.");
                
                // B) Modificar asientos del vuelo (Restar 1)
                int filasAsientos = bd.modificarAsientos(vSeleccionado.getCodigo_vuelo());
                
                if (filasAsientos > 0) {
                    System.out.println("Asiento descontado del vuelo correctamente.");
                    
                    // C) REQUERIMIENTO: Si el vuelo se quedó sin asientos en la BD, lo borramos
                    // Restamos 1 en memoria para saber si hay que lanzar el borrado
                    if ((vSeleccionado.getAsientos_libres() - 1) == 0) {
                        bd.borrarVuelo(vSeleccionado.getCodigo_vuelo());
                        System.out.println("¡Atención! El vuelo se ha quedado sin plazas libres y ha sido retirado de la venta.");
                    }
                }
                
                // D) Modificar puntos de fidelidad del pasajero (+10)
                int filasPuntos = bd.modificarPuntos(p);
                if (filasPuntos > 0) {
                    System.out.println("Se han añadido 10 puntos de fidelidad a tu cuenta.");
                }
            } else {
                System.out.println("No se pudo procesar la reserva. Avise a sistemas.");
            }
            
        } catch (ErrorBaseDatos e) {
            System.out.println("Error en la operación: " + e.getMessage() + ". Avise a sistemas.");
        }

        System.out.println("\n--- Resumen de Operación ---");
        System.out.println("Pasajero: " + p.getNombre() + " (" + p.getPasaporte() + ")");
        System.out.println("Vuelo Destino: " + vSeleccionado.getDestino());
        sc.close();
    }
}