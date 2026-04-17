package letras;

public class prLetras {
	static Letra tabla[] = new Letra[6];

	public static void main(String st[]) {
		tabla[0] = new LetraA('@');
		tabla[1] = new LetraE('4');
		tabla[2] = new LetraA('#');
		tabla[3] = new LetraE('&');
		tabla[4] = new LetraE('8');
		tabla[5] = new LetraI('$');

		for (int i = 0; i < 6; i++) {
			System.out.println();
			tabla[i].dibuja();

		}

	}
}