package bbdd;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import modelos.*;
import wallapop.ErrorBaseDatos;

import java.time.*;

public class BD_Wallapop extends BD_Conector {

	private static Statement s;
	private static ResultSet reg;

	public BD_Wallapop(String file) {
		super(file);
	}

	public Usuario buscarUsu(String email) throws ErrorBaseDatos {
		String cadenaSQL = "SELECT * FROM usuarios WHERE mail = '" + email + "'";
		Usuario u = null;
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);

			if (reg.next()) {

				u = new Usuario(reg.getString(1), reg.getString(2), reg.getString(3), reg.getDouble(4));
			}

			s.close();
			this.cerrar();
			return u;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("No se puede realizar el alta movimiento");
		}
	}

	public boolean buscarCodigo(String codigo) throws ErrorBaseDatos {
		String cadenaSQL = "SELECT COUNT(*) FROM vendidos WHERE codigo = ?";		Usuario u = null;
		boolean encontrado = false;
		
		try {

			this.abrir();
			PreparedStatement ps = c.prepareStatement(cadenaSQL);
	        ps.setString(1, codigo);

	        reg = ps.executeQuery();
			if (reg.next()) {
				if (reg.getInt(1) > 0) {
					encontrado = true;
				}
			}
			reg.close();
	        ps.close();
			this.cerrar();
			return encontrado;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("No se ha podido verificar el codigo");
		}
	}

	public HashSet<String> listarCategorias() throws ErrorBaseDatos {

		String cadenaSQL = "SELECT categoria FROM anuncios";

		HashSet<String> categorias = new HashSet<String>();
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				categorias.add(reg.getString(1));
			}
			s.close();
			this.cerrar();
			return categorias;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("Error al buscar los anuncios");
		}
	}

	public ArrayList<Anuncio> buscarCuenta1(String categoria, double p1, double p2) throws ErrorBaseDatos {

		String cadenaSQL = "SELECT * FROM anuncios WHERE categoria = '" + categoria + "' AND precioventa BETWEEN " + p1
				+ " AND " + p2;
		ArrayList<Anuncio> anuncios = new ArrayList<Anuncio>();
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				anuncios.add(new Anuncio(reg.getString(1), reg.getString(2), reg.getString(3), reg.getString(4),
						reg.getDouble(5), reg.getDouble(6)));
			}
			s.close();
			this.cerrar();
			return anuncios;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("Error al buscar los anuncios");
		}
	}

	public int venderAnuncio(Anuncio a) throws ErrorBaseDatos {
		String cadenaSQL = "DELETE anuncios Where codigo='" + a.getCodigo() + "'";
		try {
			this.abrir();
			s = c.createStatement();
			int filas = s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
			return filas;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("Error al dar de alta la tarjeta");
		}
	}

	public int altaVendido(Anuncio a, Usuario u) throws ErrorBaseDatos {
		String cadenaSQL = "INSERT INTO vendidos VALUES(?, ?, ?, ?)";

		try {
			this.abrir();
			PreparedStatement ps = c.prepareStatement(cadenaSQL);
			ps.setString(1, a.getCodigo());
			ps.setString(2, u.getMail());
			ps.setDouble(3, a.getPrecioventa());
			ps.setObject(4, LocalDate.now());
			int filas = ps.executeUpdate();
			ps.close();
			this.cerrar();
			return filas;

		} catch (SQLException e) {

			e.printStackTrace();
			throw new ErrorBaseDatos("Error al dar de alta articulo vendido: " + e.getMessage());
		}
	}

	public int modificarSaldo(ArrayList<Vendido> modificar) throws ErrorBaseDatos {
		String cadenaSQL = "UPDATE vendidos SET precioventa = ? WHERE codigo = ?";
		int filas = 0;
		try {
			this.abrir();
			PreparedStatement ps = c.prepareStatement(cadenaSQL);
			for (Vendido v : modificar) {
				ps.setDouble(1, v.getPrecioventa());
				ps.setString(2, v.getCodigo());
				filas += ps.executeUpdate();
			}

			s.close();
			this.cerrar();
			return filas;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("Error al modificar el saldo");
		}

	}

}