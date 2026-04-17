package ejer4;

import java.util.LinkedList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		LinkedList<Prestable> inventario = new LinkedList<Prestable>();
		String titulo;
		inventario.add(new Serie("The Bear",  "Comedia"));
        inventario.add( new Videojuego("The Witcher", "Aventura", "FromSoftware"));
        boolean seguir=true;
        
        do {
        	System.out.println("introduce el titulo");
        	titulo=sc.nextLine();
        	if (titulo.equalsIgnoreCase("salir")) {
        		seguir=false;
        		break;
        	}
        	
        	/*if (p instanceof Serie) {
    			Serie s = (Serie) p; // Convertimos p a Serie para leer sus datos
    				if (s.getTitulo().equals(busqueda)) { ... }
}**/
        	boolean encontrado=false;
        	for (Prestable p : inventario) {
        		if (p.toString().toLowerCase().contains(titulo.toLowerCase())) {
        			encontrado=true;
        			if(!p.isEntragado()) {
        				p.isEntragado();
        				System.out.println("miaw");
        			}
        			else {
        				System.out.println("el artiulo seleccionado esta entregado");
        			}
        			break;
        		}
        	}
        	if(!encontrado) {
        		System.out.println("no se ha encontrado ningun articulo");
        	}
        	
        }while(seguir);
        System.out.println("Recaudado en Series: " + Serie.getRecaudacion() + "€");
        System.out.println("Recaudado en Juegos: " + Videojuego.getRecaudacion() + "€");
	}

	
	
	
}
