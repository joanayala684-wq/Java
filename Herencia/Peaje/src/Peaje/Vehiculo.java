package Peaje;

public class Vehiculo {
	private String matricula, tipoVehiculo, tipoUsuario;

	/**
	 * @param matricula
	 * @param tipoVehiculo
	 * @param tipoUsuario
	 */
	public Vehiculo(String matricula, String tipoVehiculo, String tipoUsuario) {
		this.matricula = matricula;
		this.tipoVehiculo = tipoVehiculo;
		this.tipoUsuario = tipoUsuario;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", tipoVehiculo=" + tipoVehiculo + ", tipoUsuario=" + tipoUsuario
				+ "]";
	}
}
