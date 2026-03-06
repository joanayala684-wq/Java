package ejHashSet;
import java.util.HashSet;
import java.util.Iterator;

public class ejHashSet {
  public static void main(String[] args) {

    // Create a HashSet object called numbers
    HashSet<Integer> numbers = new HashSet<Integer>();

    // Add values to the set
    numbers.add(4);
    numbers.add(7);
    numbers.add(8);

    // Recorrer el set
    System.out.println("Elementos del conjunto:");
    for (Integer i:numbers)
    	System.out.println(i);
    if(numbers.contains(7)) {
    	System.out.println("tu numero esta en el cojunto");
    }
    else
    	System.out.println("el numero no esta en el conjunto");
    /*
    // De otra manera
    System.out.println("Usando un iterator:");
    Iterator<Integer> iterator = numbers.iterator();
    while (iterator.hasNext()) {
        Integer nombre = iterator.next();
        System.out.println(nombre);
         }
        */
   
    
  }
}
