package Ejemplos_fechas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class EjemploFechas3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate fecha;
		
		Scanner sc=new Scanner(System.in);
		// Obtengo la fecha del sistema
		LocalDate fechaActual = LocalDate.now(); 
		System.out.println("Hoy sin patron:"+fechaActual); 

		// Formateo para sacar la fecha en formato dia mes en letra a�o en 4 d�gitos	 
		//Creo el patr�n
		DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd MMMM yyyy"); 
		//Aplico el patr�n a mi fecha
		System.out.println("Hoy con patron:"+patron.format(fechaActual));

		//Formateo para sacar la fecha en formato dia/mes/a�o
		//Creo el patr�n
		patron = DateTimeFormatter.ofPattern("dd/LL/yy"); 
		//Aplico el patr�n a mi fecha
		System.out.println("Hoy con otro patron:"+patron.format(fechaActual));
		/**************************************************************************/
		//Leo una fecha con formato dd/LL/yy y construyo un objeto LocalDate
		System.out.println("Anota fecha en formato:dd/mm/aa");
		String fechaAnotada=sc.nextLine();
		try{
			fecha=LocalDate.parse(fechaAnotada,patron);
			System.out.println("Dia:"+fecha.getDayOfMonth()+",mes:"+fecha.getMonthValue()+",a�o:"+fecha.getYear());
			// D�a de la semana en ingl�s			
			System.out.println("D�a de la semana en ingl�s:"+ fecha.getDayOfWeek().name());
			
			// Para obtener el d�a de la semana en n�mero
			
			System.out.println("D�a de la semana en n�mero:"+ fecha.getDayOfWeek().getValue());
		
		}catch(DateTimeParseException e){
			System.out.println("Formato incorrecto");
		}
		
		
		
	}

}
