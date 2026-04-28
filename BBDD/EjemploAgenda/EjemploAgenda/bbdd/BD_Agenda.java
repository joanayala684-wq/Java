
/*
 */
package bbdd;

import java.sql.*;
import java.util.*;

import modelos.Contacto;

public class BD_Agenda extends BD_Conector {
	private static Statement s;
	private static ResultSet reg;

	public BD_Agenda(String bbdd) {
		super(bbdd);
	}

	public boolean aadir(Contacto ct) {
		String cadena = "INSERT INTO contactos VALUES('" + ct.getNombre() + "','" + ct.getApellidos() + "','"
				+ ct.getTelefono() + "')";

		try {
			this.abrir();
			s = c.createStatement();
			s.executeUpdate(cadena);
			s.close();
			this.cerrar();
			return true;
		} catch (SQLException e) {
			this.cerrar();
			return false;
		}

	}

	public int borrar(String tel) {
		String cadena = "DELETE FROM contactos WHERE telefono" + tel;

		try {
			this.abrir();
			s = c.createStatement();
			int filas = s.executeUpdate(cadena);
			s.close();
			this.cerrar();
			return filas;

		} catch (SQLException e) {
			this.cerrar();
			return -1;
		}
	}

	public int modificar(Contacto ct) {
		String cadena = "UPDATE contactos SET NOMBRE ='"+ct.getNombre()+", set apellidos='"+ct.getApellidos()+ "WHERE telefono='"+ct.getTelefono() ;

		try {
			this.abrir();
			s = c.createStatement();
			int filas = s.executeUpdate(cadena);
			s.close();
			this.cerrar();
			return filas;

		} catch (SQLException e) {
			this.cerrar();
			return -1;
		}
	}
	/**
	 * BUSDCA EN CONTACTOS LE TELEFONO DADO EL NOMBRE Y APERLLIDO DE UN CONTACTO
	 * @PARAM CT
	 * @RETURN EL TELEFONO I LO ENCUETRA, UNA CADENA VACIA SI NO LO ENCUNETRA Y NULL SI HA HABIDO UN PROBLEMA EN EL CODIGO***/
	public String buscarTelefono(Contacto ct) {
		String cadena = "UPDATE contactos set nombre='"+ct.getNombre()+"',apellidos='"+ct.getApellidos()+"' WHERE telefono = '"+ ct.getTelefono()+"'";		try {
			String t = "";
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadena);
			if (reg.next())
				t = reg.getString(1);
			// t=reg.getString("telefono");

			s.close();
			this.cerrar();
			return t;
		} catch (SQLException e) {

			return null;

		}

	}
	/**
	 * Dado el telefono busca en contactos el nombre y apellidos de ese contacto
	 * @param String tel
	 * @return El nombre y el apellido si se encuentra el telefono, una cadena vacia si no lo encuetra y null si ha ahabido un error**/
	public String buscarTelefono2( String tel) {
		String cadena = "SELECT  nombre, apellidos FROM contactos WHERE telefono='"+ tel +"'";		
		try {
			String t = "";
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadena);
			if (reg.next())
				t = reg.getString("nombre") + " "+ reg.getString("apellidos");
			// t=reg.getString("telefono");

			s.close();
			this.cerrar();
			return t;
		} catch (SQLException e) {

			return null;

		}

	}
	/**
	 * Dado el telefono busca en contactos el nombre y apellidos de ese contacto
	 * @param String tel
	 * @return El nombre y el apellido si se encuentra el telefono, una cadena vacia si no lo encuetra y null si ha ahabido un error
	 * @throws SQLException **/
	public Contacto buscarTelefono3( String tel) throws SQLException {
		Contacto con =null;
		String cadena = "SELECT  nombre, apellidos FROM contactos WHERE telefono='"+ tel +"'";		
		
			String t = "";
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadena);
			if (reg.next())
				t = reg.getString("nombre") + " "+ reg.getString("apellidos");
			con= new Contacto (reg.getString("nombre"),reg.getString("apellidos"), tel );
			
			// t=reg.getString("telefono");

			s.close();
			this.cerrar();
			return con;
		

	}
	
	
	
	public String buscarContacto(Contacto ct) {
		String cadena = "UPDATE contactos set nombre='"+ct.getNombre()+"',apellidos='"+ct.getApellidos()+"' WHERE telefono = '"+ ct.getTelefono()+"'";		try {
			String t = "";
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadena);
			if (reg.next())
				t = reg.getString(1);
			// t=reg.getString("telefono");

			s.close();
			this.cerrar();
			return t;
		} catch (SQLException e) {

			return null;

		}

	}

	public ArrayList<Contacto> mostrarContactos() {
		ArrayList<Contacto> v = new ArrayList<Contacto>();
		String cadena = "SELECT * FROM contactos ";
		try {

			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadena);
			while (reg.next()) {
				v.add(new Contacto(reg.getString("nombre"), reg.getString("apellidos"), reg.getString("telefono")));
			}

			s.close();
			this.cerrar();
			return v;
		} catch (SQLException e) {

			return null;

		}

	}

}
