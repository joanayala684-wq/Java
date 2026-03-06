package Producto;

import java.util.Scanner;

public class main {
    // Capacidad máxima de 10. Siempre usar .length para comparaciones.
    private static Producto[] inventario = new Producto[10];
    private static int contador = 0; 
    private static Scanner sn = new Scanner(System.in);

    public static void main(String[] args) {
        datosIniciales();
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n*****************************************");
            System.out.println("* SISTEMA DE INVENTARIO         *");
            System.out.println("*****************************************");
            System.out.println("1. Listar Productos");
            System.out.println("2. Borrar Producto (Desplazar Izquierda)");
            System.out.println("3. Ordenar Ascendente (Burbuja)");
            System.out.println("4. Ordenar Descendente (Burbuja)");
            System.out.println("5. Reubicar Objeto (Swap paso a paso)");
            System.out.println("6. Insertar en Posición (Desplazar Derecha)");
            System.out.println("0. Salir");
            System.out.print("\nSeleccione una opción: ");
            
            opcion = sn.nextInt();

            switch (opcion) {
                case 1 -> listar();
                case 2 -> borrar();
                case 3 -> ordenarBurbuja(true);
                case 4 -> ordenarBurbuja(false);
                case 5 -> reubicar();
                case 6 -> insertarEnPosicion();
                case 0 -> System.out.println("Cerrando sistema...");
                default -> System.out.println("Error: Opción no válida.");
            }
        }
    }

    // --- CASE 1: LISTAR ---
    private static void listar() {
        System.out.println("\n--- LISTADO (Ocupado: " + contador + "/" + inventario.length + ") ---");
        if (contador == 0) {
            System.out.println("El inventario está vacío.");
        } else {
            for (int i = 0; i < contador; i++) {
                // Validación de seguridad contra nulos
                if (inventario[i] != null) {
                    System.out.println("Índice [" + i + "] " + inventario[i]);
                }
            }
        }
    }

    // --- CASE 2: BORRAR (Lógica de contracción) ---
    private static void borrar() {
        listar();
        if (contador == 0) return;

        System.out.print("\nÍndice a borrar: ");
        int idx = sn.nextInt();

        if (idx >= 0 && idx < contador) {
            // Se mueven los elementos desde la derecha hacia la izquierda
            for (int i = idx; i < contador - 1; i++) {
                inventario[i] = inventario[i + 1];
            }
            inventario[contador - 1] = null; // Limpieza de memoria
            contador--;
            System.out.println(">> Borrado y compactado.");
        } else {
            System.out.println(">> Error: Índice fuera de rango.");
        }
    }

    // --- CASE 3 y 4: ORDENAMIENTO BURBUJA ---
    private static void ordenarBurbuja(boolean ascendente) {
        if (contador < 2) return;

        for (int i = 0; i < contador - 1; i++) {
            for (int j = 0; j < contador - i - 1; j++) {
                boolean intercambio = false;
                if (ascendente) {
                    if (inventario[j].getId() > inventario[j + 1].getId()) intercambio = true;
                } else {
                    if (inventario[j].getId() < inventario[j + 1].getId()) intercambio = true;
                }

                if (intercambio) {
                    intercambiar(j, j + 1);
                }
            }
        }
        System.out.println(">> Ordenamiento " + (ascendente ? "Asc" : "Desc") + " completado.");
    }

    // --- CASE 5: REUBICAR (Burbuja dirigida) ---
    private static void reubicar() {
        if (contador == 0) return;
        listar();
        System.out.print("\nÍndice del objeto a mover: ");
        int actual = sn.nextInt();

        if (actual < 0 || actual >= contador) return;

        System.out.println("¿Destino? (1: Inicio, 2: Final, 3: Medio)");
        int destinoOp = sn.nextInt();
        int destinoIdx = (destinoOp == 1) ? 0 : (destinoOp == 2) ? contador - 1 : contador / 2;

        while (actual != destinoIdx) {
            int siguiente = (actual < destinoIdx) ? actual + 1 : actual - 1;
            intercambiar(actual, siguiente);
            actual = siguiente;
        }
        System.out.println(">> Reubicado en índice " + destinoIdx);
    }

    // --- CASE 6: INSERTAR EN POSICIÓN (Lógica de expansión) ---
    private static void insertarEnPosicion() {
        // 1. Validar si hay espacio físico en el array
        if (contador >= inventario.length) {
            System.out.println(">> Error: El inventario está lleno (Capacidad: 10).");
            return;
        }

        System.out.print("¿En qué índice desea insertar? (0 a " + contador + "): ");
        int destino = sn.nextInt();

        if (destino < 0 || destino > contador) {
            System.out.println(">> Error: Posición inválida.");
            return;
        }

        // 2. Pedir datos del nuevo objeto
        System.out.print("ID del nuevo producto: ");
        int id = sn.nextInt();
        sn.nextLine(); // Limpiar buffer
        System.out.print("Nombre del producto: ");
        String nombre = sn.nextLine();
        Producto nuevo = new Producto(id, nombre);

        // 3. DESPLAZAMIENTO A LA DERECHA (Clave del examen)
        // Empezamos desde el final (contador) y vamos hacia atrás hasta el destino
        for (int i = contador; i > destino; i--) {
            inventario[i] = inventario[i - 1];
        }
       

        // 4. Colocar el nuevo objeto en el hueco creado
        inventario[destino] = nuevo;
        contador++;
        System.out.println(">> Producto insertado y resto de elementos desplazados.");
    }

    private static void intercambiar(int p1, int p2) {
        Producto temporal = inventario[p1];
        inventario[p1] = inventario[p2];
        inventario[p2] = temporal;
    }

    private static void datosIniciales() {
        inventario[contador++] = new Producto(105, "Monitor");
        inventario[contador++] = new Producto(101, "Mouse");
        inventario[contador++] = new Producto(108, "Teclado");
        inventario[contador++] = new Producto(102, "Memoria RAM");
    }
}