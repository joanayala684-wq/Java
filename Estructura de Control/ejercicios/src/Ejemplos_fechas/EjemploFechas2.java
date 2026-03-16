package Ejemplos_fechas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.DateTimeException;

public class EjemploFechas2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Obtengo la fecha del sistema
		LocalDate fechaActual = LocalDate.now();
		System.out.println("Fecha actual:"+fechaActual); 
		//Extraigo dia, mes y año
		System.out.println("Fecha actual con otro formato:"+fechaActual.getDayOfMonth()+"/"+fechaActual.getMonthValue()+"/"+fechaActual.getYear());
		//Resto tres d�as a la fecha
		fechaActual=fechaActual.minusDays(3);
		System.out.println("Fecha tres días antes:"+fechaActual); 
		//Sumo 4 meses a la fecha
		fechaActual=fechaActual.plusMonths(4);
		System.out.println("Fecha cuatro meses después:"+ fechaActual); 
		// Obtengo la hora del sistema
		LocalTime horaActual = LocalTime.now(); 
		System.out.println("Hora actual:"+horaActual); 
		if (horaActual.isBefore(LocalTime.of(11, 25)))
			System.out.println("Todav�a no hemos ido al recreo");
		else
			System.out.println("Ya hemos subido del recreo");
		// Extraigo horas, minutos y segundos
		System.out.println("Hora obteniendo los datos:"+horaActual.getHour()+":"+horaActual.getMinute()+":"+horaActual.getSecond());
	
		
	}

}
