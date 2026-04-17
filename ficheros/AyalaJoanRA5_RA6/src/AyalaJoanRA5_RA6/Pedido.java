package AyalaJoanRA5_RA6;

public class Pedido {
	private String Cod_usu, destino;
	private int numPed;
	private double precio;
	private static double importeTotal;
	
	public Pedido(int numPed, double precio, String cod_usu, String destino) {

		Cod_usu = cod_usu;
		this.destino = destino;
		this.numPed = numPed;
		this.precio = precio;
	}
	
	
	public String getCod_usu() {
		return Cod_usu;
	}
	public String getDestino() {
		return destino;
	}
	public int getNumPed() {
		return numPed;
	}
	public double getPrecio() {
		return precio;
	}
	@Override
	public String toString() {
		return "Pedido [Cod_usu=" + Cod_usu + ", destino=" + destino + ", numPed=" + numPed + ", precio=" + precio
				+ "]";
	}

}
