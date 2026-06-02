package objetodb;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class AyalaJoanBBDDO {
	public static void main(String[] args) {
		String titulo, autor, id;
		int opcion;
		Scanner sc = new Scanner(System.in);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("libros.odb");
		EntityManager em = emf.createEntityManager();

		do {
			System.out.println("\n--- MENÚ GESTIÓN LIBROS ---");
			System.out.println("1. Alta libro (Control duplicados)");
			System.out.println("2. Mostrar todos los libros");
			System.out.println("3. Buscar un libro por título");
			System.out.println("4. Modificar el autor de un libro");
			System.out.println("5. Borrar un libro");
			System.out.println("6. Salir");
			System.out.print("Selecciona una opción: ");
			opcion = sc.nextInt();
			sc.nextLine(); 

			switch (opcion) {
			case 1:
				System.out.println("Introduce id:");
				id = sc.nextLine();
				
				Libro libroExistente = em.find(Libro.class, id);
				
				if (libroExistente != null) {
					System.out.println(" ERROR: Ya existe un libro con el ID: " + id);
				} else {
					System.out.println("Introduce titulo:");
					titulo = sc.nextLine().trim();
					System.out.println("Introduce autor:");
					autor = sc.nextLine().trim();

					em.getTransaction().begin();
					Libro l1 = new Libro(id, titulo, autor);
					em.persist(l1);
					em.getTransaction().commit();
					System.out.println("Libro insertado con éxito.");
				}
				break;

			case 2:
				TypedQuery<Libro> consulta = em.createQuery("SELECT l FROM Libro l", Libro.class);
				List<Libro> libros = consulta.getResultList();
				if (libros.isEmpty()) {
					System.out.println("No hay libros en la base de datos.");
				} else {
					for (Libro l : libros) {
						System.out.println(l);
					}
				}
				break;

			case 3:
				System.out.println("Introduce el título del libro a buscar:");
				String tituloBuscar = sc.nextLine().trim();
				
				TypedQuery<Libro> queryTitulo = em.createQuery(
					"SELECT l FROM Libro l WHERE UPPER(l.titulo) = UPPER(:tituloParam)", Libro.class);
				queryTitulo.setParameter("tituloParam", tituloBuscar);
				
				List<Libro> resultadosTitulo = queryTitulo.getResultList();
				
				if (resultadosTitulo.isEmpty()) {
					System.out.println(" No se encontró ningún libro con ese título.");
				} else {
					System.out.println("Libros encontrados:");
					for (Libro l : resultadosTitulo) {
						System.out.println(l);
					}
				}
				break;

			case 4:
				System.out.println("Introduce el código (ID) del libro a modificar:");
				String idModificar = sc.nextLine().trim();
				
				Libro libroAEditar = em.find(Libro.class, idModificar);
				
				if (libroAEditar == null) {
					System.out.println(" El libro con ID " + idModificar + " no existe.");
				} else {
					System.out.println("Libro actual: " + libroAEditar);
					System.out.println("Introduce el nuevo nombre del autor:");
					String nuevoAutor = sc.nextLine().trim();
					
					em.getTransaction().begin();
					libroAEditar.setAutor(nuevoAutor); 
					em.getTransaction().commit();
					
					System.out.println("Autor modificado correctamente.");
				}
				break;

			case 5:
				System.out.println("Introduce el código (ID) del libro a borrar:");
				String idBorrar = sc.nextLine();
				
				Libro libroABorrar = em.find(Libro.class, idBorrar);
				
				if (libroABorrar == null) {
					System.out.println(" El libro con ID " + idBorrar + " no existe.");
				} else {
					em.getTransaction().begin();
					em.remove(libroABorrar); 
					em.getTransaction().commit();
					
					System.out.println(" Libro eliminado correctamente.");
				}
				break;
				
			case 6:
				System.out.println("Saliendo de la aplicación...");
				break;

			default:
				System.out.println("Opción no válida.");
			}
		} while (opcion != 6);

		em.close();
		emf.close();
		sc.close();
	}
}