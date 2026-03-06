package practica;

public class extra2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static String Capitalizar (String texto) {
		if(texto== null || texto.isEmpty()) 
			return texto;
		return texto.substring(0, 1).toUpperCase()+ texto.substring(1);
	}
}
