package colegio;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.*;

import bbdd.*;
import modelos.Alumno;
import modelos.Curso;


public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Scanner sc=new Scanner(System.in);
		int opc=0;
		
		
		BD_Colegio bd=new BD_Colegio("mysql-properties.xml");
		
		
		do	
		{
			System.out.println("\n\nGESTI�N COLEGIO");
			System.out.println("***************");
			System.out.println("1.Nuevo Alumno\n"
					+ "2.Nuevo Curso\n"
					+ "3.Borrar Alumno\n"
					+ "4.Listado alumnos por curso\n"
					+ "5.Listado de cursos\n"
					+ "6.Consultar alumno\n"
					+ "7.Consultar tutor de un curso\n"
					+ "8.Listado alumnos por tutor\n"
					+ "9.Listado alumnos por curso"
					+ "10.Alumnos con la matrícula superior a un número introducido por teclado\n"
					+ "11.Dado un archivo de texto con alumnos, insertarlos en la tabla de alumnos");
			System.out.print("\tTeclea opci�n: ");
			try{
			opc=sc.nextInt();
			}
			
			catch(InputMismatchException e ){
				System.out.println("Debes introducir n�mero 1-5");
				opc=0;
			}
			
			sc.nextLine();
			switch (opc){
			case 1:
				System.out.println("\n\nALTA ALUMNO");
				System.out.print("Introduce nombre completo\t");
				String nombre=sc.nextLine();				
				System.out.print("Introduce telefono\t");
				String telefono=sc.nextLine();
				System.out.print("Introduce DNI\t");
				String dni=sc.nextLine();
				System.out.print("Introduce n�mero de matr�cula\t");
				int matricula=sc.nextInt();	
				Vector<String> cursos;
				try {
					cursos = bd.listadoCursos();
				} catch (ErrorBaseDatos e) {
					System.out.println("Contacte con sistemas:"+e.getMessage());
					break;
				}
				if (cursos.size()==0){
						System.out.println("No hay cursos disponibles");
						break;
				}
				System.out.println("Lista de cursos");
				for (int i=0;i<cursos.size();i++)
					System.out.println(cursos.get(i));				
				System.out.print("Teclea el curso\t");
				String curso=sc.next();
				Alumno al=new Alumno(dni,nombre,curso,matricula,telefono);			
				int filas;
				try {
					filas = bd.añadir_Alumno2(al);
					switch (filas){
					case 1:
						System.out.println("\nAlumno a�adido");
						break;
					case 0:
						System.out.println("\nNo a�adido, contacte con sistemas");
						break;
					
						
					}
				} catch (ErrorBaseDatos e) {
					// TODO Auto-generated catch block
					System.out.println("Contacte con sistemas:"+e.getMessage());
				}				
				
			break;
			
			case 2:
				
				System.out.println("Introduce curso:");
				String nombreCurso=sc.nextLine();
				System.out.println("Anota descripción:");
				String des=sc.nextLine();
				System.out.println("anota aula:");
				String aula=sc.nextLine();
				Curso cur=new Curso(des,nombreCurso,aula);
				
				
				try {
					filas=bd.añadir_Curso(cur);
					switch (filas){
					case 1:
						System.out.println("\nCurso añadido");
						break;
					case 0:
						System.out.println("\nNo se ha podido añadir el cuso");
						break;
					
						
					}
				} catch (ErrorBaseDatos e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage() + "  Algo ha ido mal contacte con sistemas");;
				}
				
				break;
			
			case 3:
				System.out.println("Introduce dni:");
			    dni=sc.nextLine();
			    
			    try {
					filas=bd.borrar_Alumno(dni);
					
					switch (filas){
					case 1:
						System.out.println("\nAlumno borrado");
						break;
					case 0:
						System.out.println("\nNo se ha podido borrar el alumno");
						break;
					
						
					}
				} catch (ErrorBaseDatos e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage() + "  Algo ha ido mal contacte con sistemas");
				}
				
				
				break;
			case 4:	
				cursos=null;
				try {
					
					cursos=bd.listadoCursos();
					
				} catch (ErrorBaseDatos e) {
					System.out.println("Contacte con sistemas:"+e.getMessage());
					break;
				}
				if (cursos.size()==0){
						System.out.println("No hay cursos disponibles");
						break;
				}
				System.out.println("Lista de cursos");
				for (int i=0;i<cursos.size();i++)
					System.out.println(cursos.get(i).toString());		
				
				System.out.print("Teclea el curso del cual quieres ver los alumnos\t");
				curso=sc.next();
				ArrayList<Alumno> listado=null;
				try {
					listado = bd.listadoAlumnosCurso(curso);
				} catch (ErrorBaseDatos e) {
					System.out.println("Contacte con sistemas:"+e.getMessage());
					break;
				}
				
				System.out.println("\n\nLISTADO ALUMNOS "+ curso.toUpperCase()+"\n");
				for (int i=0;i<listado.size();i++)									
					System.out.println(listado.get(i).toString());
				break;
				
			case 6:
				System.out.println("Introduce dni:");
			    dni=sc.nextLine();
			    
			    try {
					al=bd.buscar_Alumno(dni);
					if (al==null)
						System.out.println("No existe ese alumno");
					else
						System.out.println(al);
				} catch (ErrorBaseDatos e) {
					// TODO Auto-generated catch block
					System.out.println("Contacte con sistemas:"+e.getMessage());
				}
			    
			    break;
			case 9:
				try {
					bd.listadoAlumnosPorCurso();
				} catch (ErrorBaseDatos e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			
			case 10:
				System.out.println("Anota matrícula:");
				int num=sc.nextInt();
				
				ArrayList<Alumno> alumnos;
				
				try {
					alumnos=bd.buscar_Alumno_Mat(num);
					if (alumnos.size()==0)
						System.out.println("No hay ningún alumno con la matrícula mayor a "+ num);
					else
						System.out.println(alumnos);
				} catch (ErrorBaseDatos e) {
					// TODO Auto-generated catch block
					System.out.println("Contacte con sistemas:"+e.getMessage());
				}
			break;
			case 11:
				ArrayList<Curso> cursos2 =new ArrayList<Curso>();
				String curso2;
				System.out.println("anota curso");
				curso2=sc.nextLine();
				while(!curso2.equals("fin")) {
					System.out.println("anota la descripcion");
					String des2=sc.nextLine();
					System.out.println("anota el aula");
					String aula2=sc.nextLine();
					System.out.println("anota curso");
					curso2=sc.nextLine();
					
				}
				try {
					bd.añadir_cursos(cursos2);
				} catch (ErrorBaseDatos e) {
					System.out.println(e.getMessage());
				}
				/*LinkedList<Alumno> lista = new LinkedList<>();

				Path file = Paths.get("entrada.txt");
				Path log = Paths.get("log.txt");
				Charset charset = Charset.forName("UTF-8");
				BufferedReader reader = null;
				String line=null;
				int cont=0;
				try {
					reader = Files.newBufferedReader(file, charset);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					while ((line = reader.readLine()) != null) {
						cont++;
						String[] partes = line.split(",");
						if (partes.length != 4) {
							

						} else {
							}
						}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				break;
			}
			
		}
		while (opc!=12);
			
	
		}
	
	
	

}
