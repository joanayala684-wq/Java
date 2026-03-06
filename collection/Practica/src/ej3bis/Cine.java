package ej3bis;

import java.util.LinkedList;

public class Cine {
	private LinkedList<Usuario> cola;
	private int aforo, vendidos;
	
	public Cine (int aforo) {
		this.aforo=aforo;
		 cola = new LinkedList<Usuario> ();
	}
	public void llegarCola(String n, int num) {
		Usuario us=new Usuario(n, num);
		cola.add(us);
	}
	


}
