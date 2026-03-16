package Practicafechas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;

public class ejer5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalTime hora1=null, hora2=null;
		Scanner sc=new Scanner (System.in);
		boolean correcto=false;
		do {
			System.out.println("introduce una hora en formato hh:mm ");
			String hora1S=sc.nextLine();
			try {
				hora1=LocalTime.parse(hora1S);
				correcto= true;
			}catch(DateTimeParseException e) {
				System.out.println("error al introducir la hora, vuelve a intentarlo");
			}
		}while(correcto==false);
		do {
			System.out.println("introduce la otra hora");
			String hora2S=sc.nextLine();
			try {
				hora2=LocalTime.parse(hora2S);
				correcto= true;
			}catch(DateTimeParseException e) {
				System.out.println("error al introducir la hora, vuelve a intentarlo");
			}
		}while(correcto==false);
		long diferenciaMinutos = Math.abs(ChronoUnit.MINUTES.between(hora1, hora2));
		System.out.println("La diferencia total es de **" + diferenciaMinutos + " minutos**.");
	}

}
