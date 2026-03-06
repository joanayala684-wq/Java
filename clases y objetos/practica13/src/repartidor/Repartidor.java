package repartidor;

public class Repartidor {
 
 private int codigo;
 private int numPedidos;
 private double ganancias;
 private static int totalPedidos;
 private static int totalRepartidores;
 
 
 public Repartidor(){
	 //TODO Auto_generated constructor stub
	 totalRepartidores++;
	 this.codigo=totalRepartidores;
	 //no es necesario inicializar los atributos numericos a 0
	 this.numPedidos=0;
	 this.ganancias=0;
	 
 }
 public double realizarPedido(double importe, double propina) {
	 numPedidos++;
	 totalPedidos++;
	 ganancias+=importe*0.20+propina;
	 double gan=0;
	 ganancias+=gan;
	return gan;
	 
	 
 }
 public double getGanancias() {
	return ganancias;
 }
 public static int getTotalPedidos() {
	return totalPedidos;
 }
 @Override
	public String toString() {
		return "Repartidor [codigo=" + codigo + ", numPedidos=" + numPedidos + ", ganancias=" + ganancias + "]";
	}
 
 
}
