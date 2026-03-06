package Automoviles;

public class Automovil {
	private String matricula, modelo, marca;
	private int año, categoria;
	private boolean Alquilado = false;
	private static int contAlquileres, gananciasTotalesEmpresa;
	private int gananciasV;

	public Automovil(String matricula, String modelo, String marca, int año2, int categoria) {

		this.matricula = matricula;
		this.modelo = modelo;
		this.marca = marca;
		this.año = año;
		if (categoria == 1 || categoria == 2) {
			this.categoria = categoria;
		} else {
			System.out.println("error, categoria iniciada a 1");
			categoria = 1;
		}
	}
	public boolean devolver() {
		if(!Alquilado) {
			return false;
		}
		else {
			Alquilado=false;
			contAlquileres--;
			return true;
		}
	}

	public int alquiler(int diasAlqui) {
		if (Alquilado) {
			return 0;
		}
		int TotalAlqui = 0;
		switch (categoria) {
		case 1:
			if (diasAlqui == 2) {
				TotalAlqui = 45 * diasAlqui ;
				
			}else {
				TotalAlqui = 30 * diasAlqui;
			}
			break;
		case 2:
			if (diasAlqui == 2) {
				TotalAlqui = 50 * diasAlqui;
			}
			else {
				TotalAlqui = 40 * diasAlqui;
			}
		}
		gananciasV++;
		contAlquileres++;
		gananciasTotalesEmpresa+=TotalAlqui;
		Alquilado=true;
		return TotalAlqui;
	}

	public static int getContAlquileres() {
		return contAlquileres;
	}


	public static int getGananciasTotalesEmpresa() {
		return gananciasTotalesEmpresa;
	}



	public String getMatricula() {
		return matricula;
	}
	public int getGananciasV() {
		return gananciasV;
	}
	@Override
	public String toString() {
		return "Automovil [matricula=" + matricula + ", modelo=" + modelo + ", marca=" + marca + ", año=" + año
				+ ", categoria=" + categoria + ", Alquilado=" + Alquilado + ", gananciasV=" + gananciasV + "]";
	}

	
	
}
