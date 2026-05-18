package modelos;

public class Vehiculo {
	private String matricula, modelo, idCliente;
	private int anioMatricula;
	public Vehiculo(String matricula, String modelo, String idCliente, int anioMatricula) {
		super();
		this.matricula = matricula;
		this.modelo = modelo;
		this.idCliente = idCliente;
		this.anioMatricula = anioMatricula;
	}
	public String getMatricula() {
		return matricula;
	}
	public String getModelo() {
		return modelo;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public int getAnioMatricula() {
		return anioMatricula;
	}
}
