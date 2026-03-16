package practicaexamen;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class ejer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		LocalDate fecha_producto = null;
		String fecha="";
		boolean correcto=false;
		DateTimeFormatter patron=DateTimeFormatter.ofPattern("dd/MM/yy");
		do {
		try {
			System.out.println("introduce la fecha del producto");
			fecha=sc.nextLine();
			fecha_producto=LocalDate.parse(fecha, patron);
			correcto=true;
		} catch (DateTimeParseException e) {
			System.out.println("la fecha introducida es incorrecta");
		}
		}while(!correcto);
		System.out.println("miaw");
		int diff=0;
		try {
			diff=DiasCaducidad(fecha_producto);
		} catch (ProductoCaducidadException e) {
			System.out.println(e.getMessage());
		} catch (ProductoNoCaducadoException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("introduce un codigo de producto ");
		String cod=sc.nextLine();
	int sctock=0;
	sctock=VerificarSctock(cod);
		
	}
	public static int DiasCaducidad (LocalDate fecha_producto) throws ProductoCaducidadException, ProductoNoCaducadoException {
		LocalDate hoy=LocalDate.now();
		int diff =(int) ChronoUnit.DAYS.between( fecha_producto, hoy);
		if(diff>0) {
			throw new ProductoCaducidadException ("el producto a caducado hace " + (diff)+" dias");
		}
		else {
			throw new ProductoNoCaducadoException ("el producto se vence en  " + (-diff)+ " dias");
		}
		
		
	}
	public static int VerificarSctock (String cod_producto) {
		final int oreo=10, pelota=-2, agua=1;
		int stock=0;
		cod_producto=cod_producto.toUpperCase();
		switch(cod_producto) {
		case "oreo":
			stock=oreo;
			break;
		case "pelota":
			stock=pelota;
			break;
		case "agua":
			stock=agua;
			break;

	}
		assert (oreo<0  && agua<0 && pelota<0): "el producto no esta disponible";
		return oreo;

}}
