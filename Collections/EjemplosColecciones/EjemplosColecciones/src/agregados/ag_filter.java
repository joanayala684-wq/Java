package agregados;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ag_filter {
    public static void main(String[] args) {
    	ArrayList <String> nombres=new ArrayList<>(Arrays.asList("Ana", "Luis", "Carlos"));

        // Filtrar nombres que empiezan con "A"
        List<String> nombresConA = nombres.stream()
        								   .filter(nombre -> nombre.startsWith("A"))
                                          .collect(Collectors.toList());

        System.out.println(nombresConA);
    }
}

