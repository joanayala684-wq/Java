package Practicaexamen;

import java.util.Locale;
import java.util.Random;

import java.util.Scanner;

public class examensupercorregido {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		double presupuesto, precioUnidad, totalCompraUsuario = 0;
		double porcentaje = 0, totalenvios = 0, numerodecompras=0, recaudo=0;;
		String codigo = "";
		Random r = new Random();

		int unidades;
		do {
			totalCompraUsuario = 0;
			System.out.println("anota el presupuesto");
			presupuesto = sc.nextDouble();
			if (presupuesto==0)
				break;
			sc.nextLine();

			while (!codigo.equalsIgnoreCase("fin") && totalCompraUsuario <= presupuesto) {
				System.out.println("introduce el codigo del articulo");
				codigo = sc.nextLine();
				while (!validarCodigo(codigo)&& !codigo.equalsIgnoreCase("fin")) {
					System.out.println("introduce el codigo del articulo");
					codigo = sc.nextLine();
					if (codigo.equalsIgnoreCase("fin"))
						break;
				}
				if (codigo.equalsIgnoreCase("fin"))
					break;
				unidades = r.nextInt(4) + 1;
				do {
					System.out.println("anota el precio unidad");
					precioUnidad = sc.nextDouble();
				} while (precioUnidad <= 0);
				double precioproducto = calculaPrecioTotal(codigo, unidades, precioUnidad);
				if (totalCompraUsuario + precioproducto > presupuesto) {
					System.out.println("presupuesto superado, retira articulo");
					
				} else
					totalCompraUsuario += precioproducto;
				sc.nextLine();
				numerodecompras++;
			}
			System.out.println("quiere realizar un pedido a domicilio");
			boolean pedido = sc.nextBoolean();
			if (pedido) {
				int codigoEnvio = 0;

				System.out.println("introduce un codigo de envio");
				codigoEnvio = sc.nextInt();
				if (codigoEnvio >= 1 && codigoEnvio <= 3) {
					System.out.println("podemos realizar el envio");
					System.out.println("esta usted jubilado?");
					boolean jubilado = sc.nextBoolean();

					if (jubilado == true) {
						System.out.println("el envio es gratis");
						
						porcentaje++;
						
					} else if (codigoEnvio == 1) {
						System.out.println("el envio vale 5 euros");
						totalCompraUsuario = totalCompraUsuario + 5;
						
					} else if (codigoEnvio == 2) {
						System.out.println("el envio  vale 7 euros");
						totalCompraUsuario = totalCompraUsuario + 7;
						
					} else {
						System.out.println("el envio vale 10 euros");
						totalCompraUsuario = totalCompraUsuario + 10;
					
					}
					totalenvios++;
				} else
					System.out.println("no podemos realizar el envio, lo sentimos");

			}
			recaudo=recaudo+totalCompraUsuario;
			double mayor1=0, mayor2=0;
			if(mayor1<totalCompraUsuario) {
				mayor2=mayor1;
				mayor1=totalCompraUsuario;}
			else
				if(mayor2<totalCompraUsuario )
					mayor2=totalCompraUsuario;
			System.out.println("el importe total de su compra es de" + totalCompraUsuario);
			
		} while (presupuesto != 0 );
		double calculo=porcentaje/totalenvios;
		double media;
		media=recaudo/numerodecompras;
		System.out.println("el porcentaje de envio a jubilados es de "+ calculo);
		System.out.println("el importe medio de las compras es de " +media);
	}

	public static boolean validarCodigo(String codigo) {
		codigo = codigo.toUpperCase();
		if (codigo.length() < 5 || codigo.length() > 6) {//verificamos que su extension sea de 5 o 6 
			return false;
		}
		if (!codigo.startsWith("P")) {//miramos que empiece por P
			return false;
		}
		if (!Character.isLetter(codigo.charAt(1))) {//verificamos que el segundo caracter sea una letra
			return false;
		}
		for (int i = 2/*desdedonde empieza*/; i < codigo.length()/*hasta que termine*/; i++) { //generamos un bucle para verificar que 3,4,5 y/o 6 sean numeros
			if (!Character.isDigit(codigo.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static double calculaPrecioTotal(String codigo, int unidades, double precioUnidad) {
		double importe = 0;
		codigo = codigo.toUpperCase();
		if (codigo.charAt(1) == 'L') {//si la segunda letra es L 
			importe = unidades * (precioUnidad * 0.80);
		} else if (codigo.charAt(1) == 'P') {//si la segunda letra es p
			if (unidades == 3 || unidades == 4) {//si unidades son 3 o 4, restamos uno ya que uno es gartis
				importe = (unidades - 1) * precioUnidad;
			}
		} else
			importe = unidades * precioUnidad;

		return importe;

	}
}
