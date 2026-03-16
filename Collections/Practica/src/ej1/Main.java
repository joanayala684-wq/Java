package ej1;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int opc = 0, pos=0;
String nombre;
double nota;
ArrayList <Alumno> alumnos =new ArrayList<Alumno>();
Scanner sc=new Scanner (System.in);
sc.useLocale(Locale.ENGLISH);
do {
	System.out.println("1- alta ");
	System.out.println("2. Modificar ");
	System.out.println("3. sustituir alumno");
	System.out.println("4. borrar");
	System.out.println("5- buscar");
	System.out.println("6- fin ");
	opc=sc.nextInt();
	sc.nextLine();
	switch(opc) {
	case 1:
		
		System.out.println("introduce nombre del alumno");
		nombre=sc.nextLine();
		//pos=buscarArrayList( alumnos, nombre);
		pos=alumnos.indexOf(new Alumno(nombre));
		if(pos!=-1) {
			System.out.println("ya exixste el alumno");}
			else {
				System.out.println("introduce una nota");
				nota=sc.nextDouble();
				alumnos.add(new Alumno(nombre, nota));
			}
		break;
	case 2: 
		System.out.println("introduce nombre del alumno");
		nombre=sc.nextLine();
		pos=buscarArrayList( alumnos, nombre);
		if(pos==-1) {
			System.out.println("nombre de alumno incorrecto");
			}
		else {
			System.out.println("introduce la nueva nota");
			nota=sc.nextDouble();
			alumnos.get(pos).setNota(nota);
		}
		break;
	case 3:
		System.out.println("introduce nombre del alumno");
		nombre=sc.nextLine();
		pos=buscarArrayList( alumnos, nombre);
		if(pos==-1) {
			System.out.println("nombre de alumno incorrecto");
			}
		else {
			System.out.println("introduce nombre");
			nombre=sc.nextLine();
			System.out.println("introduce la nueva nota");
			nota=sc.nextDouble();
			Alumno a=new Alumno(nombre, nota);
			alumnos.set(pos, a);
		}
		break;
	case 4:
		System.out.println("introduce nombre del alumno");
		nombre=sc.nextLine();
		pos=buscarArrayList( alumnos, nombre);
		if(pos==-1) {
			System.out.println("nombre de alumno incorrecto");
			}
		else {
			alumnos.remove(pos);}
		
		break;
	case 5:
		System.out.println("introduce nombre del alumno");
		nombre=sc.nextLine();
		pos=buscarArrayList( alumnos, nombre);
		if(pos==-1) {
			System.out.println("no esta en el array");
			}
		else {
			System.out.println("estos son los datos del alumno " + alumnos.get(pos).toString());
		}
		break;
		}
	
}while(opc !=6);

	}
	public static int buscarArrayList(ArrayList<Alumno> alumnos, String nombre) {
	    int pos = -1; 
	    for (int i = 0; i < alumnos.size(); i++) {
	        if (alumnos.get(i).getNombre().equalsIgnoreCase(nombre)) {
	            pos = i;
	            break;
	        }
	    }
	    return pos;
	}
}
