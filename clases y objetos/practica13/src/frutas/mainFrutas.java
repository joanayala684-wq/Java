package frutas;

public class mainFrutas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frutas f1 = new Frutas("Manzana", "Huelva", 100, 1.0, 2.0);
		Frutas f2 = new Frutas("Pera", "Huelva", 50, 0.8, 1.8);
		Frutas f3 = new Frutas("Piña", "Madrid", 60, 0.9, 2.0);
		f1.mismaProcedencia(f2);
		f3.rebajar(1.5);
		f1.vender(8);
		f2.vender(10);
		f3.vender(20);
		System.out.println("beneficio total:"+Frutas.getBeneficioTotal());
		
	}

}
