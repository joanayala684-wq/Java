package bbdd;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import biblioteca.ErrorBaseDatos;
import modelos.*;

import java.time.*;

public class BD_Biblioteca extends BD_Conector {

	private static Statement s;
	private static ResultSet reg;

	public BD_Biblioteca(String file) {
		super(file);
		// import modelos.*;

	}

	public Usuario buscarUsu(int num) throws ErrorBaseDatos {
		String cadenaSQL = "SELECT * FROM usuarios WHERE numero = '" + num + "'";
		Usuario u = null;
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);

			if (reg.next()) {

				u = new Usuario(reg.getInt(1), reg.getString(2), reg.getString(3), reg.getString(4), reg.getInt(5));
			}

			s.close();
			this.cerrar();
			return u;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("No se puede realizar el alta movimiento");
		}
	}

	public ArrayList<Libro> filtrarLibros(Usuario u) throws ErrorBaseDatos {
		String cadenaSQL = "SELECT li.* FROM prestamos pe JOIN usuarios usu ON codigousuario=numero JOIN libros li ON isbnlibro=isbn"
				+ " WHERE numero = ? AND fechadevolucion > ?";
		ArrayList<Libro> librosPrestados = new ArrayList<Libro>();
		PreparedStatement ps = null;

		try {
			this.abrir();
			ps = c.prepareStatement(cadenaSQL);
			ps.setInt(1, u.getNumero());
			ps.setObject(2, LocalDate.now());
			reg = ps.executeQuery();

			while (reg.next()) {
				librosPrestados.add(new Libro(reg.getString(1), reg.getString(2), reg.getString(3), reg.getString(4),
						reg.getInt(5), reg.getInt(6)));
			}
			reg.close();
			ps.close();
			this.cerrar();
			return librosPrestados;
		} catch (SQLException e) {
			try {
				this.cerrar();
			} catch (Exception ex) {
			}
			throw new ErrorBaseDatos("Error al buscar los anuncios");
		}

	}
	public Libro libroDisponible(String isbn) throws ErrorBaseDatos {
		String cadenaSQL = "SELECT * FROM libros WHERE isbn = '" + isbn + "'";
		
		Libro l = null;
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);

			if (reg.next()) {
				if((reg.getInt(5)-reg.getInt(6))>0) {
				l = new Libro(reg.getString(1), reg.getString(2), reg.getString(3), reg.getString(4),
						reg.getInt(5), reg.getInt(6));
						}}
			int disponibles= l.getNumejemplares()-l.getPrestados();
			
			s.close();
			this.cerrar();
			return l;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("No se puede realizar el alta movimiento");
		}
	}
	public int altaPrestamo(Usuario u, Libro l) throws ErrorBaseDatos {
		String cadenaSQL = "INSERT INTO prestamos VALUES(?, ?, ?)";
		PreparedStatement ps = null;

		try {
			this.abrir();
			ps = c.prepareStatement(cadenaSQL);
			ps.setInt(1, u.getNumero());
			ps.setString(2, l.getIsbn());
			ps.setObject(3, LocalDate.now().plusDays(15));
			int filas = ps.executeUpdate();
			ps.close();
			return filas;

		} catch (SQLException e) {
	
			throw new ErrorBaseDatos("Error al dar de alta articulo vendido: " + e.getMessage());
		}
	}
	public int modificarUnidades(Libro l) throws ErrorBaseDatos {
		String cadenaSQL = "UPDATE libros SET prestados = ? WHERE isbn = ?";
		int filas = 0;
		PreparedStatement ps = null;
		try {
			this.abrir();
				ps.setInt(1, l.getPrestados()+1);
				ps.setString(2, l.getIsbn());	
				filas += ps.executeUpdate();
		
			ps.close();
			this.cerrar();
			return filas;
		} catch (SQLException e) {
			throw new ErrorBaseDatos("Error al modificar el saldo");
		}
	}
	public HashSet<String> libros () throws ErrorBaseDatos {
		String cadenaSQL = "SELECT isbn FROM libros";
		HashSet<String> libros = new HashSet<String>();

		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);

			while(reg.next()) {
				libros.add(reg.getString(1));
					}

			s.close();
			this.cerrar();
			return libros;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("No se puede listar los libros");
		}
	}
	public int modificarUnidades2(String isbn, int unidades) throws ErrorBaseDatos {
		String cadenaSQL = "UPDATE libros SET numejemplares = ? WHERE isbn = ?";
		int filas = 0;
		PreparedStatement ps = null;
		try {
			this.abrir();
			ps = c.prepareStatement(cadenaSQL);
			
				ps.setString(1, isbn);
				ps.setInt(2, unidades);
				filas += ps.executeUpdate();
			

			ps.close();
			this.cerrar();
			return filas;
		} catch (SQLException e) {
			try { this.cerrar(); } catch (Exception ex) {}
			throw new ErrorBaseDatos("Error al modificar el saldo");
		}
	}
	public int totalLibros() throws ErrorBaseDatos {
		String cadenaSQL = "SELECT SUM(numejemplares) FROM libros";
		int total=0;
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);

			if (reg.next()) {
				total=reg.getInt(1);
			}

			s.close();
			this.cerrar();
			return total;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("No se puede realizar el alta movimiento");
		}
	}

	
}