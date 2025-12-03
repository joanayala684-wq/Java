package Strings;

import java.util.Scanner;

public class ejer5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1, s2, s3;
		/*Programa que lee tres cadenas y las escribe por orden alfabético, ignorando
mayúsculas y minúsculas.*/
		Scanner sc=new Scanner(System.in);
		System.out.println("introduce la cadena 1");
		s1=sc.nextLine();
		System.out.println("introduce la cadena 2");
		s2=sc.nextLine();
		System.out.println("introduce la cadena 3");
		s3=sc.nextLine();
		/*if (s1.compareToIgnoreCase(s3)<0 && s1.compareToIgnoreCase(s2) < 0){
			System.out.println(s1);
			if(s2.compareToIgnoreCase(s3) <0 ) {
				System.out.println(s2);
				System.out.println(s3);}
			else {
				System.out.println(s3);
				System.out.println(s2);
			}}
		else 
			if (s2.compareToIgnoreCase(s3)<0 && s2.compareToIgnoreCase(s1) < 0){
				System.out.println(s2);
				if(s1.compareToIgnoreCase(s3) <0 ) {
					System.out.println(s1);
					System.out.println(s3);}
				else {
					System.out.println(s3);
					System.out.println(s1);}
				}
		
		
			else {
					System.out.println(s3);
					if(s2.compareToIgnoreCase(s1) <0 ) {
						System.out.println(s2);
						System.out.println(s1);}
					else {
						System.out.println(s1);
						System.out.println(s2);
						}
					}*/
		String temp;
		for (int i =0; i <2; i++);{
				if (s1.compareToIgnoreCase(s2) >0) {
					temp = s1;
					s1=s2;
					s2=temp;}
				if (s2.compareToIgnoreCase(s3) >0) {
					temp = s2;
					s2=s3;
					s3=temp;}
		}
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
				}
			}

