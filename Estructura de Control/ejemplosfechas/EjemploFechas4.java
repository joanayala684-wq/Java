package ejemplosfechas;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;

public class EjemploFechas4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate fecha = null;
		
		Scanner sc=new Scanner(System.in);
		// Obtengo la fecha del sistema
		LocalDate fechaActual = LocalDate.now(); 
		// La muestra en formato aaaa-mm-dd que es el formato de salida por defecto
		System.out.println(fechaActual); 
			
		//Leo una fecha con formato aaaa-mm-dd que es el formato de entrada por defecto
		System.out.println("Anota fecha en formato:aaaa-mm-dd");
		String fechaAnotada=sc.nextLine();
		try{
			fecha=LocalDate.parse(fechaAnotada);
			System.out.println(fecha);
			System.out.println("Dia:"+fecha.getDayOfMonth()+",mes:"+fecha.getMonthValue()+",año:"+fecha.getYear());
			// Para obtener el día de la semana
			System.out.println("Día de la semana:"+fecha.getDayOfWeek());
			System.out.println("Día de la semana:"+fecha.getDayOfWeek().getDisplayName(TextStyle.FULL,Locale.getDefault()));
			System.out.println("Día de la semana:"+fecha.getDayOfWeek().getValue()); /* en número */
			System.out.println(fecha.getMonth().getDisplayName(TextStyle.FULL,Locale.getDefault()));	
			
		}catch(DateTimeParseException e){
			System.out.println("Formato incorrecto");
			System.exit(0);
		}
		
		/*Diferencia de dos fechas en días */
		long dias=ChronoUnit.DAYS.between(fecha,fechaActual);
		System.out.println("Número de días entre las dos fechas:"+dias);
		
		Period period = Period.between(fecha,fechaActual);
	    int diff = period.getDays();
	    int meses =period.getMonths();
	    int annos= period.getYears();
	    System.out.println("Número de días entre las dos fechas:"+diff+",meses:"+meses+",años:"+annos);
	    
	    /*Diferencia de dos horas */
	    LocalDateTime ahora=LocalDateTime.now();
	    LocalDateTime despues=ahora.plusHours(2);
	    
	    long horas=ChronoUnit.HOURS.between(ahora,despues);
		System.out.println("Número de horas entre las dos:"+horas);
		
	    Duration duration = Duration.between(ahora,despues);
	    long diff2 = duration.toHours();
	    System.out.println("Número de horas entre las dos horas:"+diff2);
	    
	    
		
	}

}
