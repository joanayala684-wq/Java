package ejemploInterface2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		/*
		 * Crear un interfaz Caducable, que tenga dos métodos, uno que diga si algo ha
		 * caducado y otro que nos diga cuántos días quedan para que algo caduque. Haced
		 * dos clases una Carnet y otra Medicamento. Añadid los atributos necesarios a
		 * cada clase. Las dos clases tienen algo en común, implementan el interfaz
		 * Caducable. Codificad un Main con un container que dentro tenga medicamentos y
		 * carnets, decid cuáles de ellos han caducado y de los que no han caducado,
		 * cuántos días les quedan para caducar.
		 */
		// Contenedor que acepta cualquier objeto que sea "Caducable"
		List<Caducable> inventario = new ArrayList<>();

		// Añadimos Medicamentos (Unos caducados en el pasado y otros futuros)
		inventario.add(new Medicamento("Ibuprofeno", LocalDate.of(2025, 3, 12)));
		inventario.add(new Medicamento("Amoxicilina", LocalDate.of(2027, 8, 20)));

		// Añadimos Carnets
		inventario.add(new Carnet("Conducir B", LocalDate.of(2024, 1, 15)));
		inventario.add(new Carnet("Identidad (DNI)", LocalDate.of(2030, 5, 10)));

		System.out.println("=== CONTROL DE CADUCIDAD ===");

		// Recorremos el contenedor de forma polimórfica
		for (Caducable elemento : inventario) {
			System.out.println("\nAnalizando -> " + elemento);

			if (elemento.esCaducado()) {
				System.out.println("❌ ALERTA: Este elemento YA ha caducado.");
			} else {
				long diasRestantes = elemento.diasParaCaducar();
				System.out.println("✅ VIGENTE: Le quedan " + diasRestantes + " días para caducar.");
			}
		}
	}
}