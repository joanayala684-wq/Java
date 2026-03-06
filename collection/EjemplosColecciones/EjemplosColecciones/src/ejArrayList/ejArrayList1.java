package ejArrayList;

import java.util.ArrayList;

public class ejArrayList1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <Integer> numeros=new ArrayList<Integer>();
		System.out.println("Elementos:"+numeros.size());
		
		numeros.add(5);
		numeros.add(7);
		numeros.add(10);
		
		System.out.println(numeros);
		
		System.out.println("Elementos:"+numeros.size());
		
		numeros.add(2,8);
		System.out.println(numeros);	
		
		System.out.println("Elemento posición 1:"+numeros.get(1));
		
		numeros.remove(0);
		
		System.out.println(numeros);
		
		numeros.clear();
		
		System.out.println(numeros);
		
	}

}
