package Practicaexamen;

import java.util.Scanner;

public class correcion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int  grupo, barra = 0, copas ;
		double cuenta = 0, ganacias =0;
		String tipo;
		boolean otra, correcto, tienecarnet, confirmar;
		String carnet;
		int reserva=0, totalpersonas=0, totalbarra=0;
		do {
			//inicializo varibales para una noche
		int aforo=80;
		reserva= totalpersonas=totalbarra=0;
		ganacias=0;
		System.out.println("total aforo=" + aforo);
		System.out.println("anota numero de comensales:");
		grupo=sc.nextInt(); 
		while (grupo != -1 && aforo>0) {
			if (grupo < 0 || aforo -grupo <0) {
				System.out.println("nombre incorrecto de comensales");
			}
	 		else {
				sc.nextLine();
				do {
					System.out.println("introduce tipo de menu (Eco/Deg/Star");
					tipo=sc.nextLine();
					tipo=tipo.toUpperCase();
					correcto= validarTipoMenu(tipo);
				}while(!correcto);//correcto ==false
			
				do {
					System.out.println("habra una fiesta despues");
					System.out.println("cuantas personas quieren dos copas");
					copas=sc.nextInt();
					System.out.println("cuantas personas quieren barra libre");
					barra=sc.nextInt();
					if(grupo<copas+barra)
						System.out.println("no hay tantos comensales");
					if (copas <0|| barra <0)
						System.out.println("las cantidades deben ser positivas");
				}while(grupo<copas+barra || copas<0 || barra<0);
				//salida grupo<=copas+barra  && copa|| barra<0s>0 &&barra>0 
				cuenta=(int) calcularPrecio(grupo, tipo, copas, barra);
				System.out.println("tienes carnet de socio");
				tienecarnet=sc.nextBoolean();
				if (tienecarnet)
					System.out.println("anota el carnet");
					carnet=sc.nextLine();
					if (validarcarnet(carnet)) {
						System.out.println("tiene descuento del 20%");
						cuenta=cuenta*0.8;
						}
				
			} 
			System.out.println("el precio de su reseerva es de" + cuenta);
			System.out.println("quiere confrimar su reserva");
			confirmar=sc.nextBoolean();
			if(confirmar)
				aforo=aforo-grupo;
				reserva++;
				ganacias+=cuenta;
				totalpersonas+=grupo;
				totalbarra+=barra;
		}
		if(aforo>0) {
			System.out.println("quedan" + aforo+ "plazas libres");
			System.out.println("anota numero de comensales:");
			grupo=sc.nextInt(); }
			//salgo porque grupo ==-1 || aforo>0
			System.out.println("total ganacias" + ganacias);
			System.out.println("total reserva" + reserva);
			System.out.println("porcentaje barra libre" +((double)totalbarra/totalpersonas ) *100);
			System.out.println("quieres gestionzr la reserva de otra noche");
			otra=sc.nextBoolean();
		} while (otra);
		
}
	public static boolean validarTipoMenu(String tipo) {
		if (tipo.equals("ECO") ||tipo.equals("DEG") ||tipo.equals("STAR"))
				return true;
		return false; }
	
	public static double calcularPrecio(int grupo, String tipo, int copas, int barra) {
		final double MECO=25, MDEG=35, MSTAR=50, PD0S=9, PLIBRE=30;
		double precio;
		if(tipo.equalsIgnoreCase("ECO"))
			precio=MECO;
		else 
			if (tipo.equalsIgnoreCase("DEG"))
				precio=MDEG;
			else 
				precio=MSTAR;
		precio=precio*grupo+PD0S*copas+PLIBRE*barra;
		return precio;
	}
	public static boolean validarcarnet(String carnet) {
	if (carnet.length()!=4 && carnet.length()!=5)
		return false;
	char letra=carnet.charAt(0);
	if (letra <='A' && letra <= 'Z') { //(Character.isAlphabetic(letra) && Character.isUpperCase(letra));
	 for (int i=1; 1<carnet.length(); i++) {
		 if (carnet.charAt(i) < '0' || carnet.charAt(i)> '9')
			 return false;
	}
	 return true;
	}
		return false;
	}
}