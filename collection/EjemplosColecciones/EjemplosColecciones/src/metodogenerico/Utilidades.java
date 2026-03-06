package metodogenerico;

class Utilidades {
    // Método genérico que imprime cualquier tipo de array
    public static <T> void imprimirArray(T[] array) {
        for (T elemento : array) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }
}



