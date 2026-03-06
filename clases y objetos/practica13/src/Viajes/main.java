package Viajes;

public class main {
    public static void main(String[] args) {
        
        // 1. Crear dos viajes
        // (Origen, Destino, Código base, Importe, NumViaje, Plazas Disponibles, Plazas Reservadas iniciales)
        Viaje v1 = new Viaje("Madrid", "Barcelona", "001", 50.0, 0 , 40, 0);
        Viaje v2 = new Viaje("Sevilla", "Valencia", "002", 45.0,0, 20, 0);

        // 2. Mostrad la información de ambos viajes
        System.out.println("--- INFORMACIÓN INICIAL ---");
        System.out.println(v1.toString());
        System.out.println(v2.toString());
        System.out.println();

        // 3. Reservad varias plazas de ambos viajes
        System.out.println("--- REALIZANDO RESERVAS ---");
        // Reserva para v1: 5 plazas en total, de las cuales 2 son niños
        double res1 = v1.reservar(5, 2);
        System.out.println("Reserva Viaje 1 (5 plazas, 2 niños): " + res1 );

        // Reserva para v2: 2 plazas, 0 niños
        double res2 = v2.reservar(2, 0);
        System.out.println("Reserva Viaje 2 (2 plazas, 0 niños): " + res2 );
        System.out.println();

        // 4. Modificad el número de plazas del primer viaje
        System.out.println("--- MODIFICANDO CAPACIDAD ---");
        boolean modificado = v1.modificarPlazasTotales(60);
        if (modificado) {
            System.out.println("Capacidad de " + v1.getOrigen() + " ampliada a 60 plazas.");
        } else {
            System.out.println("No se pudo modificar la capacidad.");
        }
      
        System.out.println(v1.toString());
        System.out.println(v2.toString());
        System.out.println();

        System.out.println("Recaudación total: " + Viaje.getTotalRecaudado() + "€");
    }
}
