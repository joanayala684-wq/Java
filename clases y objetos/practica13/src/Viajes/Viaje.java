package Viajes;

public class Viaje {
	private String origen, destino, codigo;
	private double importe;
	private static int  numViaje;
	private int PlazasTotales;
	private int plazasReser;
	public static double totalRecaudado;
	
	
	
	public Viaje(String origen, String destino, String codigo, double importe, int numViaje, int plazasDisplo,
			int plazasReser) {
		this.origen = origen;
		this.destino = destino;
		this.importe = importe;
		this.PlazasTotales = plazasDisplo;
		this.plazasReser = plazasReser;
		numViaje++;
		this.codigo = origen.substring(0, 2).toUpperCase()+
				destino.substring(0, 2).toUpperCase()+numViaje;
	}
	
	public double  reservar(int numPlazasSoli, int numniño) {
		
		if(plazasReser+numPlazasSoli<=PlazasTotales) {
			int adultos = numPlazasSoli - numniño;
            double precioNiño = importe * 0.80;
            double totalReserva = (adultos * importe) + (numniño * precioNiño);
      
            this.plazasReser += numPlazasSoli;
            totalRecaudado += totalReserva;
            
            return totalReserva;
        }
        return 0; // No se pudo realizar la reserva
    }

    public boolean modificarPlazasTotales(int nuevoTotal) {
        if (nuevoTotal >= this.plazasReser) {
            this.PlazasTotales = nuevoTotal;
            return true;
        }
        return false;
    }

    @Override
	public String toString() {
		return "Viaje [origen=" + origen + ", destino=" + destino + ", codigo=" + codigo + ", importe=" + importe
				+ ", plazasDisplo=" + PlazasTotales + ", plazasReser=" + plazasReser + "]";
	}

    public static double getTotalRecaudado() {
        return totalRecaudado;
}

	public String getOrigen() {
		return origen;
	}
	
	
	
	
	
	
	
	
	

}
