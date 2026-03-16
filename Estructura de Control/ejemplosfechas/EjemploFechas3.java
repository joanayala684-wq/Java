package ejemplosfechas;

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

		// Formateo para sacar la fecha en formato dia mes en letra año en 4 dígitos	 
		//Creo el patrón
		DateTimeFormatter patron = DateTimeFormatter.ofPattern("dd MMMM yyyy"); 
		//Aplico el patrón a mi fecha
		System.out.println("Hoy con patron:"+patron.format(fechaActual));

		//Formateo para sacar la fecha en formato dia/mes/año
		//Creo el patrón
		patron = DateTimeFormatter.ofPattern("dd/LL/yy"); 
		//Aplico el patrón a mi fecha
		System.out.println("Hoy con otro patron:"+patron.format(fechaActual));
		/**************************************************************************/
		//Leo una fecha con formato dd/LL/yy y construyo un objeto LocalDate
		System.out.println("Anota fecha en formato:dd/mm/aa");
		String fechaAnotada=sc.nextLine();
		try{
			fecha=LocalDate.parse(fechaAnotada,patron);
			System.out.println("Dia:"+fecha.getDayOfMonth()+",mes:"+fecha.getMonthValue()+",año:"+fecha.getYear());
			// Día de la semana en inglés			
			System.out.println("Día de la semana en inglés:"+ fecha.getDayOfWeek().name());
			
			// Para obtener el día de la semana en número
			
			System.out.println("Día de la semana en número:"+ fecha.getDayOfWeek().getValue());
		
		}catch(DateTimeParseException e){
			System.out.println("Formato incorrecto");
		}
		
		
		
	}

}
