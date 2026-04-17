package ejemploInterface3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class Ppal {
	public static void main(String args[]){  
		//ArrayList<Student> al=new ArrayList<Student>();  
		Vector <Student> al=new Vector();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");		
		try {
			al.add(new Student(101, "Luis", 23, sdf.parse("15/01/2023")));
			 al.add(new Student(106, "Gemma", 27, sdf.parse("10/05/2022")));
			    al.add(new Student(105, "Pedro", 21, sdf.parse("22/11/2023")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
		  
		Collections.sort(al,new StudentPorNombre());  
		for(Student st:al){  
			System.out.println(st);
		}  
		 
	}  
}
