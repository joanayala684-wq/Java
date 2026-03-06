package ejArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class ejArrayListIterator {

	public static void main(String st[]) {
	ArrayList<String> cars = new ArrayList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");
  
    // Get the iterator
    Iterator<String> it = cars.iterator();
    
    // Loop through a collection
    while(it.hasNext()) {
      System.out.println(it.next());
    }

}
}