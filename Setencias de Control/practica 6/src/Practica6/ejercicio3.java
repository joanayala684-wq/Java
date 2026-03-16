package Practica6;

import java.util.Scanner;

public class ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int calibre;
		int categoria = 0, categoriab= 0, categoriac =0;
		do {
			System.out.println("introduce el calibre de la fresa");
			calibre=sc.nextInt();
			switch (calibre) {
			case 1:
			case 2:
			case 3:
			categoria++;
			break;
			case 4:
			case 5:
			categoriab++;
			break;
			default:
			categoriac++;
			}
		}while (calibre != 0);
		 System.out.println("el numero de fresas en la categoria a es:" + categoria);
		 System.out.println("el numero de fresas en la categoria b es:" + categoriab);
		 System.out.println("el numero de fresas en la categoria c es:" + categoriac);
		 if (categoria == 0 )
			 System.out.println("no ha habido ninguna fresa de la categoria a");
		 else
			 if (categoriab == 0 )
				 System.out.println("no ha habido ninguna fresa de la categoria b");
			 else 
				 if (categoriac == 0 )
					 System.out.println("no ha habido ninguna fresa de la categoria c");
			 
	}

}
