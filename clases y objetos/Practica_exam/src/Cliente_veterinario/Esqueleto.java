package Cliente_veterinario;


import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Esqueleto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"); 
        CocheAYA[] citas = new CocheAYA[15];
        int cont = 0; // Contador de elementos reales
        int opc = 0;

        do {
            System.out.println("\n--- MENU CLINICA ---");
            System.out.println("1. Alta Cita");
            System.out.println("2. Modificar");
            System.out.println("3. Borrar (Cancelar)");
            System.out.println("4. Listar");
            System.out.println("5. Insertar en Posición");
            System.out.println("6. Salir");
            System.out.print("Elige: ");
            
            opc = sc.nextInt();
            sc.nextLine(); // LIMPIEZA DE BUFFER SIEMPRE

            switch (opc) {
                case 1: // ALTA
                    if (cont < citas.length) {
                        // 1. Pedir datos
                        // 2. Try-Catch para la fecha
                        // 3. citas[cont] = new citaMedica(...);
                        // 4. cont++;
                    } else {
                        System.out.println("Array lleno.");
                    }
                    break;

                case 2: // MODIFICAR
                    // 1. int pos = buscarCita(citas, sc, cont);
                    // 2. if(pos != -1) { ... sobreescribir citas[pos] ... }
                    break;

                case 3: // BORRAR
                    // 1. int posB = buscarCita(citas, sc, cont);
                    // 2. if(posB != -1) { bucle desplazar izquierda y cont--; }
                    break;

                case 4: // LISTAR
                    for (int i = 0; i < cont; i++) {
                        System.out.println(citas[i].toString());
                    }
                    break;

                case 5: // INSERTAR ESPECIFICO
                    // 1. Pedir posición
                    // 2. Validar pos <= cont
                    // 3. Bucle desplazar derecha (desde cont hasta pos)
                    // 4. citas[pos] = new...
                    // 5. cont++;
                	
                	/* //DESPLAZAMIENTO HACIA LA DERECHA
    		        // Empezamos desde el final (cont) hacia atrás hasta llegar a posInsertar
    		        for (int i = cont; i > posInsertar; i--) {
    		            citas[i] = citas[i - 1];
    		        }

    		        // 3. Insertar el nuevo objeto en el hueco creado
    		        citas[posInsertar] = new citaMedica(nombre, motivo, fecha);
    		        
    		        // 4. Aumentar el contador global
    		        cont++;
    		        System.out.println("Cita insertada en la posición " + posInsertar);
    		        
    		    } else {
    		        System.out.println("Posición inválida.");
    		    
    		    break;*/
                    break;
                 

                case 6:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opc != 6);
    }

    // MÉTODO DE BÚSQUEDA (El comodín del examen)
    public static int buscarCita(CocheAYA[] array, Scanner sc, int total) {
        System.out.print("Introduce código: ");
        String cod = sc.nextLine();
        for (int i = 0; i < total; i++) {
            if (array[i].getCodigo().equalsIgnoreCase(cod)) {
                return i;
            }
        }
        System.out.println("No encontrado.");
        return -1;
    }
}
