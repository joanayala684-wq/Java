package modelos;

public class Mecanico {
	 private int idMecanico;
	 private String nombre, telefono;
	 public Mecanico(int idMecanico, String nombre, String telefono) {
		super();
		this.idMecanico = idMecanico;
		this.nombre = nombre;
		this.telefono = telefono;
	 }
	 public int getIdMecanico() {
		 return idMecanico;
	 }
	 public String getNombre() {
		 return nombre;
	 }
	 public String getTelefono() {
		 return telefono;
	 }
	 
}
