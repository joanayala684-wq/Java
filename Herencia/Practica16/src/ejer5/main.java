package ejer5;

import java.util.ArrayList;
import java.util.Scanner;

import utilidades.GestionFicheros;


public class main {

	public main() {
		// TODO Auto-generated constructor stub
		/*Hacer una clase polígono con dos métodos abstractos, uno que calcule el área y
otro el perímetro. Para cada polígono se guarda su número de lados. Codificar
después tres clases derivadas: Cuadrado, Rectángulo y Triángulo que codifiquen
dichos métodos. Hacer un main con un array de polígonos para probarlo.*/
		Scanner sc=new Scanner(System.in);
		Poligono[] poligonos= new Poligono[4];
		ArrayList<String> datosBrutos = GestionFicheros.leerLineas("poligonos.txt");
		int cont=0;
		for (String linea : datosBrutos) {
			if (cont>3) {
				System.out.println("array lleno");
				break;
			}
			String[] v = linea.split(";");
			String tipo = v[0];
			double lA = Double.parseDouble(v[1]);
			
			if (tipo.equalsIgnoreCase("TRIANGULO")) {
				double lB = Double.parseDouble(v[2]);
				double lC = Double.parseDouble(v[3]);
				poligonos[cont]= new Triangulo(v.length, lA, lB, lC);
				cont++;
			}
			else if (tipo.equalsIgnoreCase("RECTANGULO")) {
				double lB = Double.parseDouble(v[2]);
				poligonos[cont]= new Rectangulo(v.length, lA, lB);
				cont++;
			}
			else if (tipo.equalsIgnoreCase("Cuadrado")) {
				double lB = Double.parseDouble(v[2]);
				poligonos[cont]= new Cuadrado(v.length, lA);
				cont++;
			}
	}
		for (int i =0; i<poligonos.length; i++) {
			if (poligonos[i] !=null) {
			String tipo = "";
	        if (poligonos[i] instanceof Triangulo) tipo = "Triángulo";
	        else if (poligonos[i] instanceof Rectangulo) tipo = "Rectángulo";
	        else if (poligonos[i] instanceof Cuadrado) tipo = "Cuadrado";
	       /*System.out.println("Tipo: " + poligonos[i].getClass().getSimpleName());
        System.out.println("Lados: " + poligonos[i].getNumLados());*/
	        System.out.println("El polígono es un: " + tipo);
	        System.out.println("tiene " + poligonos[i].getNumLados()+ "lados");
			System.out.println("el perimetro es de: " + poligonos[i].calcularPeri());
			System.out.println("el area es de: " + poligonos[i].calcularArea());

		}
	}
}}
