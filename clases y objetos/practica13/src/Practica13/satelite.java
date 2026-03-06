package Practica13;

public class satelite {

	private double distancia;
	private int meridiano;
	private int paralelo;
	
	public satelite() {
		
	}
	public satelite (int m, int p) {
		meridiano=m;
		paralelo=p;
	}
	public boolean estaOrbita() {
		return distancia<0;
	 if(distancia>0) 
		 return true;
	  return false;
		
	}
	public void getDistancia (double d) {
		distancia=d;
	}
	public void getPosicion(int m, int p) {
		meridiano=m;
		paralelo=p;
	}
}
