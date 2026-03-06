package repartidor;

public class mainRepartidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Repartidor r1=new Repartidor ();
		Repartidor r2=new Repartidor ();
		r1.realizarPedido(30, 2);
		r2.realizarPedido(40, 2);
		r1.realizarPedido(40, 2);
		
		System.out.println(r1.toString());
		System.out.println(r2.toString());
		
		System.out.println("total peididos de todos los repartidore"+Repartidor.getTotalPedidos());
		

	}

}
