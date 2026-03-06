package Tarjeta;

import Viajes.Viaje;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Tarjeta t1 = new Tarjeta("1234", "jose", "4321", 300.4, null);
		 Tarjeta t2 = new Tarjeta("1234", "jose", "hgrt", 300.4, null);
		 t1.pagar("7458", 100);
		 t2.pagar("4321", 100);
		 t1.recargar(20);
		 t2.recargar(30);
		 t1.bloquear(0, -1);
		 t2.bloquear(0, 0);
		 System.out.println(t1.toString());
	      System.out.println(t2.toString());
		 t1.mismaTarjeta(t2);
		 System.out.println("pagos totales realizados: "+ Tarjeta.getContPagos());
		 System.out.println("recargas totales realizados: "+ Tarjeta.getContRecargas());

		 
	}

}
