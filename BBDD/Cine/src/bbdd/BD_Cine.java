
/*
 */
package bbdd;

import java.sql.*;
import java.util.*;

import Cine.ErrorBaseDatos;
import modelos.*;

public class BD_Cine extends BD_Conector {
	private static Statement s;
	private static ResultSet reg;

	public BD_Cine(String bbdd) {
		super(bbdd);
	}

	public ArrayList<Sala> listarSalas() throws ErrorBaseDatos {
		String cadenaSQL = "SELECT * FROM salas";
		ArrayList<Sala> salas = new ArrayList<Sala>();
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				salas.add(new Sala(reg.getString(1), reg.getInt(2), reg.getInt(3), reg.getInt(4)));
			}
			s.close();
			this.cerrar();
			return salas;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("Error al buscar cuentas por DNI");
		}
	}

	public ArrayList<Reserva> listarReservas(String peli) throws ErrorBaseDatos {
	    // 1. Usamos ? para el parámetro de la película
	    String cadenaSQL = "SELECT * FROM reservas WHERE sala IN (SELECT sala FROM salas WHERE pelicula = ?)";
	    ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	    
	    try {
	        this.abrir();
	        PreparedStatement ps = c.prepareStatement(cadenaSQL);
	        ps.setString(1, peli);
	        
	        reg = ps.executeQuery();
	        
	        while (reg.next()) {
	            reservas.add(new Reserva(
	                reg.getInt(1), 
	                reg.getInt(2), 
	                reg.getInt(3), 
	                reg.getInt(4)  
	            ));
	        }
	        
	        reg.close();
	        ps.close();
	        this.cerrar();
	        return reservas;
	        
	    } catch (SQLException e) {
	        this.cerrar();
	        throw new ErrorBaseDatos("Error al listar reservas de la película: " + peli);
	    }
	}
/*		String cadenaSQL = "SELECT pelicula, SUM(plazas_ocupadas) FROM salas GROUP BY PELICULA ORDER BY SUM (plazas_ocupadas) DESC";
*/
	
	public HashMap<String, Integer> taquilla() throws ErrorBaseDatos {
		String cadenaSQL = "SELECT pelicula, plazas_ocupadas FROM salas";
		HashMap<String, Integer> taquilla = new HashMap<String, Integer>();

		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				if (!taquilla.containsKey(reg.getString(1))) {
					taquilla.put(reg.getString(1), reg.getInt(2));

				} else {
					int sumaActual = taquilla.get(reg.getString(1));
					taquilla.put(reg.getString(1), sumaActual + reg.getInt(2));
				}
			}
			s.close();
			this.cerrar();
			return taquilla;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("Error al buscar cuentas por DNI");
		}
	}

	public int altaReserva(Reserva r) throws ErrorBaseDatos {
		String cadenaSQL = "INSERT INTO reservas (precio, entradas, sala , telefono) " + "VALUES (?, ?, ?, ?)";
		try {
			this.abrir();
			PreparedStatement p = c.prepareStatement(cadenaSQL);
			int filas = 0;
			p.setInt(1, r.getPrecio());
			p.setInt(2, r.getEntradas());
			p.setInt(3, r.getSala());
			p.setInt(4, r.getTelefono());
			filas += p.executeUpdate();

			p.close();
			this.cerrar();
			return filas;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("Error en el alta masiva de movimientos: " + e.getMessage());
		}
	}

	public boolean modificarPlazasOcupadas(Sala s, Reserva r) throws ErrorBaseDatos {
		int nuevas_ocupadas = s.getPlazas_ocupadas() + r.getEntradas();

		String cadenaSQL = "UPDATE salas SET plazas_ocupadas = ? WHERE sala = ?";
		boolean ejecutado = false;
		int filas = 0;
		try {
			this.abrir();

			// 3. Preparar la sentencia
			PreparedStatement ps = c.prepareStatement(cadenaSQL);
			ps.setInt(1, nuevas_ocupadas);
			ps.setInt(2, s.getSala());

			filas = ps.executeUpdate();
			if (filas > 0) {
				ejecutado = true;
			}
			ps.close();
			this.cerrar();
			return ejecutado;

		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("Error al actualizar las plazas de la sala: " + e.getMessage());
		}

	}

}
