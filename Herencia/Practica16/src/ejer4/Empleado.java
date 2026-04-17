package ejer4;

public abstract class Empleado {

 

	public static void setNum_emple(int num_emple) {
		Empleado.num_emple = num_emple;
	}

 protected String dni, nombre, telefono, direccion;
protected double salario;
 protected int horas=0;
 protected double salario_final;
 protected static int num_emple=1;

 
 @Override
	public String toString() {
		return "Empleado [dni=" + dni + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion
				+  ", horas=" + horas + "]";
	}


 /**
 * @param dni
 * @param nombre
 * @param telefono
 * @param direccion
 * @param horas
 */
 public Empleado(String dni, String nombre, String telefono, String direccion) {
	this.dni = dni;
	this.nombre = nombre;
	this.telefono = telefono;
	this.direccion = direccion;
	num_emple=num_emple+1;
	

 }
 public void fichar(int fichar_horas){
	 horas=fichar_horas+horas;
 }
 
	abstract public double pagar();
	public String getDni() {
		return dni;
	}


	public String getNombre() {
		return nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public int getHoras() {
		return horas;
	}


 public static int getNum_emple() {
		return num_emple;
	}

	}

