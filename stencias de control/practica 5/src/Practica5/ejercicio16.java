package Practica5;

import java.util.Locale;
import java.util.Scanner;

public class ejercicio16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		double  factura, codigo, cantidadvendida, preciolitro = 0;
		double codigos = 0, cantidades = 0, precios = 0, articulo1, primer= 0, facturas =0;
		System.out.println("introduce el codigo del articulo");
		codigo=sc.nextDouble();
		codigos+=codigo;
		articulo1= codigo;
		System.out.println("introduce la cantidad vendida en litros;");
		cantidadvendida=sc.nextDouble();
		cantidades+=cantidadvendida;
		System.out.println("introduce el precio del producto por litro");
		preciolitro=sc.nextDouble();
		precios+=preciolitro;
		for (int i = 1; i <= 2; i++ ) {
			System.out.println("introduce el codigo del articulo");
			codigo=sc.nextDouble();
			codigos+=codigo;
			System.out.println("introduce la cantidad vendida en litros;");
			cantidadvendida=sc.nextDouble();
			cantidades+=cantidadvendida;
			if (codigo == articulo1)
				primer+= cantidadvendida;
			System.out.println("introduce el precio del producto por litro");
			preciolitro=sc.nextDouble();
			precios+=preciolitro;
			 factura = precios*cantidades;
			  if (factura > 600)
				  facturas++;
		}
		  System.out.println("la cantidad en litros vendidas del primer articulo es de" + primer);
		  System.out.println("la facturacion total es de" + facturas);
		System.out.println("el numero de facturas de mas de 600 es de" + facturas);
	}

}
