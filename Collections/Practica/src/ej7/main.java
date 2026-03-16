package ej7;

import java.util.HashSet;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> numbers1 = new HashSet<Integer>();
		HashSet<Integer> numbers2 = new HashSet<Integer>();
		int number;
		do {
			System.out.println("introduce el numero ");
			number = sc.nextInt();
			if (number == 0) {
				break;
			}
			if (numbers1.contains(number)) {
				System.out.println("tu numero esta en el cojunto");
			} else {
				System.out.println("no esta en el cojunto");
				numbers1.add(number);
			}
		} while (number != 0);
		System.out.println("comenzamos con el conjunto 2");
		do {
			System.out.println("introduce el numero ");
			number = sc.nextInt();
			if (number == 0) {
				break;
			}
			if (numbers2.contains(number)) {
				System.out.println("tu numero esta en el cojunto");
			} else {
				System.out.println("no esta en el cojunto");
				numbers2.add(number);
			}
		} while (number != 0);
		System.out.println("Elementos del conjunto 1:");
		for (Integer i : numbers1)
			System.out.println(i);
		System.out.println("Elementos del conjunto 2:");
		for (Integer i : numbers2)
			System.out.println(i);
		if (numbers2.containsAll(numbers1)) {
			System.out.println("El Conjunto numbers1 está incluido en el Conjunto nummbers2");
		}
		

	}

}
