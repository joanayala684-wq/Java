package modelos;

public class Sala {
	private String pelicula;
	private int aforo, sala, plazas_ocupadas, plazas_libres;
	public Sala(String pelicula, int aforo, int sala, int plazas_ocupadas) {
		super();
		this.pelicula = pelicula;
		this.aforo = aforo;
		this.sala = sala;
		this.plazas_ocupadas = plazas_ocupadas;
		plazas_libres=aforo-plazas_ocupadas;
	}
	public String getPelicula() {
		return pelicula;
	}
	public int getAforo() {
		return aforo;
	}
	public int getSala() {
		return sala;
	}
	public int getPlazas_ocupadas() {
		return plazas_ocupadas;
	}
	public int getPlazas_libres() {
		return plazas_libres;
	}
	@Override
	public String toString() {
		return "Sala [pelicula=" + pelicula + ", aforo=" + aforo + ", sala=" + sala + ", plazas_ocupadas="
				+ plazas_ocupadas + "]";
	}
	
}
