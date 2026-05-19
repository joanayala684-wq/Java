package wallapop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

import bbdd.BD_A;



public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DateTimeFormatter patron = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		Scanner sc = new Scanner(System.in);
		
		BD_A bd = new BD_A("mysql-properties.xml");
	}

}
