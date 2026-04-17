package ejer4;

public class Externo extends Empleado{
	private final double valor_hora= 22;
	private String nom_empresa;

	public Externo(String dni, String nombre, String telefono, String direccion, String nom_empresa) {
		super(dni, nombre, telefono, direccion);
		this.nom_empresa=nom_empresa;
	
	}

	@Override
	public double pagar() {
		salario_final=(valor_hora*horas);
		horas=0;
		return salario_final;
	}
	
}
