package agregados;

import java.util.Arrays;
import java.util.List;

public class ag_foreach {
    public static void main(String[] args) {
        List<String> nombres = Arrays.asList("Ana", "Luis", "Carlos", "María");

        // Usando forEach para imprimir cada elemento
        nombres.forEach(nombre -> System.out.println(nombre));
    }
}

