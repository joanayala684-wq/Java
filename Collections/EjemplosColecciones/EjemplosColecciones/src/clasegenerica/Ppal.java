package clasegenerica;

public class Ppal {
    public static void main(String[] args) {
        // Creamos una Caja de tipo String
        Caja<String> cajaString = new Caja<>();
        cajaString.setContenido("Hola");
        System.out.println("Contenido: " + cajaString.getContenido());

        // Creamos una Caja de tipo Integer
        Caja<Integer> cajaInt = new Caja<>();
        cajaInt.setContenido(42);
        System.out.println("Contenido: " + cajaInt.getContenido());
    }
}
