package MontañaRusa;


public class Vagon {
	public Entrada[] getNombres() {
		return nombres;
	}
	public int getEstado() {
		return estado;
	}

	private Entrada nombres[] = new Entrada[4];
	private int cont=0;
	private static final int lleno=1, vacio=2, marcha=3;
	private int estado=vacio;
	
	public void añadir (Entrada c) {
		if (cont==nombres.length) {
			estado=lleno;
		}
		else {
			nombres[cont]=c;
			cont++;
		}
		
	}
	public String marchar() {
		String mensaje = "en marcha";
		if (estado==lleno) {
			estado=marcha;
		
			return mensaje;
		}
		return null;
	}
	public int parar() {
		if (estado==marcha) {
			estado=vacio;
			cont=0;
			nombres=new Entrada[4];
			return 0;
		}
		return -1;
	}

}
