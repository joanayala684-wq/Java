package Teleférico;

public class Teleferico {
	private Pasajero[] cabina;
	private int contAbordo;
	private boolean enMarcha;

	public Teleferico() {
		this.cabina = new Pasajero[4]; // Capacidad fija de 4 plazas
		this.contAbordo = 0;
		this.enMarcha = false;
	}

	public void agregarPasajero(Pasajero p) {
		cabina[contAbordo] = p;
		contAbordo++;
	}

	public boolean estaLleno() {
		return contAbordo == 4;
	}

	public void iniciarViaje() {
		this.enMarcha = true;
		System.out.println("🚀 El teleférico está lleno. ¡Viaje iniciado con éxito!");
	}

	public void vaciarCabina() {
		// Vaciamos el teleférico para el siguiente viaje
		this.cabina = new Pasajero[4];
		this.contAbordo = 0;
		this.enMarcha = false;
		System.out.println("🛑 Teleférico vacío y listo para la siguiente tanda.");
	}

	public int getContAbordo() { return contAbordo; }
	public boolean isEnMarcha() { return enMarcha; }
}