package Liga_futbol;

public class Equipo {
	private String nombre;
	private int victorias, derrotas, empates, goles_favor, goles_contra, puntos;
	


	public Equipo(String nombre) {
		this.nombre = nombre;
	
	}
	public void anotarPartido( int goles1, int goles2  ) {
		this.goles_favor+=goles1;
		this.goles_contra+=goles2;
		if(goles1==goles2) {
			this.empates++;
			this.puntos++;
		
		}
		else if(goles1>goles2) {
			this.victorias++;
			this.puntos+=3;
		}
		else if  (goles1<goles2) {
			this.derrotas++;
		}
		}
	public String getNombre() {
		return nombre;
	}
	public int getPuntos() {
		return puntos;
	}
	@Override
	public String toString() {
		return "Liga [nombre=" + nombre + ", victorias=" + victorias + ", derrotas=" + derrotas + ", empates=" + empates
				+ ", goles_favor=" + goles_favor + ", goles_contra=" + goles_contra + ", puntos=" + puntos + "]";
	}
	
}
