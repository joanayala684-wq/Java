package ejemploInterface1;

import java.util.Vector;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Construir una clase ArrayReales que contenga un atributo de tipo double[] y
		 * que implemente una interfaz llamada Estadisticas. El contenido de esta
		 * interfaz es el siguiente: public interface Estadisticas { double minimo();
		 * double maximo(); double sumatorio(); }
		 */
		Telefono tel = new Telefono("666666666");
		Vehiculo ve = new Vehiculo("6666XXX");

		tel.addContacto("Pepe", "444444444");
		tel.addContacto("Ana", "222222222");

		ve.recorrer(20);

		/* Podemos hacer un container con objetos que pertenecen al mismo interface */
		Vector<Machine> maquinas = new Vector<Machine>();
		maquinas.add(ve);
		maquinas.addElement(tel);

		for (int i = 0; i < maquinas.size(); i++) {
			/*
			 * Esto ser�a algo parecido al polimorfismo, ejecuta el m�todo el objeto
			 * adecuado
			 */
			System.out.println(maquinas.get(i).toString());
			System.out.println(maquinas.get(i).suena());
			maquinas.get(i).reset();
		}

		/* Muestro las m�quinas una vez reseteadas */
		for (int i = 0; i < maquinas.size(); i++) {
			System.out.println(maquinas.get(i).toString());
		}

	}

}
