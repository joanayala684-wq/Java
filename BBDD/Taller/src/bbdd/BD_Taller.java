
/*
 */
package bbdd;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;

import Cine.ErrorBaseDatos;
import modelos.*;

public class BD_Taller extends BD_Conector {
	private static Statement s;
	private static ResultSet reg;

	public BD_Taller(String bbdd) {
		super(bbdd);
	}

	public LinkedList<Arreglo> listarSalas() throws ErrorBaseDatos {
		String cadenaSQL = "SELECT * FROM arreglos WHERE  fechaSalida is null";
		LinkedList<Arreglo> pendientes = new LinkedList<Arreglo>();
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				pendientes.add(new Arreglo(reg.getInt(1), reg.getInt(2), reg.getString(3),
						reg.getObject(4, java.time.LocalDate.class), reg.getObject(5, java.time.LocalDate.class),
						reg.getDouble(6)));
			}
			s.close();
			this.cerrar();
			return pendientes;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("Error al buscar los arreglos pendientes");
		}
	}

	public Cliente buscarCliente(String mat) throws ErrorBaseDatos {
		String cadenaSQL = "SELECT cl.* FROM clientes cl JOIN vehiculos ve ON idCliente=dni WHERE matricula= '" + mat + "'";
		Cliente cl = null;
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);

			if (reg.next()) {
				if (reg.getInt(5) > 0) {
					cl = new ClienteCarnet(reg.getString(1), reg.getString(2), reg.getString(3), reg.getString(4),
							reg.getInt(5), reg.getInt(6));
				} if(reg.getInt(5)==0) {
					cl = new ClienteNoCarnet(reg.getString(1), reg.getString(2), reg.getString(3), reg.getString(4),
							reg.getInt(5), reg.getInt(6));

				}
			 }

			s.close();
			this.cerrar();
			return cl;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("Error al buscar el cliente");
		}
	}

	public int modificarVisitas(Cliente cl) throws ErrorBaseDatos {
		String cadenaSQL = "UPDATE clientes SET visitas = ? WHERE dni = ?";
		int filas = 0;
		try {
			this.abrir();
			PreparedStatement ps = c.prepareStatement(cadenaSQL);

			ps.setInt(1, cl.getVisitas());
			ps.setString(2, cl.getDni());
			filas += ps.executeUpdate();

			s.close();
			this.cerrar();
			return filas;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("Error al modificar el saldo");
		}
	}

	public int modificarArreglo(Arreglo a, double impor) throws ErrorBaseDatos {
		String cadenaSQL = "UPDATE arreglos SET importe = ?, fechaSalida = ? WHERE idFactura = ?";
		int filas = 0;
		PreparedStatement ps = null;

		try {
			this.abrir();
			ps = c.prepareStatement(cadenaSQL);

			ps.setDouble(1, impor);
			ps.setObject(2, LocalDate.now());
			ps.setInt(3, a.getIdFactura());

			filas = ps.executeUpdate();

			return filas;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ErrorBaseDatos("Error al modificar los datos del arreglo.");
		}
	}
	public Mecanico contarArreglos () throws ErrorBaseDatos {
		String cadenaSQL = "SELECT idMecanico,  COUNT(*)  FROM arreglos GROUP BY idMecanico ORDER BY COUNT(*) DESC";
		Mecanico m = null;
		int cont=0;
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				if(cont==0) {
					m= new Mecanico(reg.getInt(1));
					cont++;}
				else {
					break;
				}
			}
			s.close();
			this.cerrar();
			return m;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("Error al buscar el cliente");
		}
	}
	public Mecanico contarArreglos2 () throws ErrorBaseDatos {
		String cadenaSQL = "SELECT arr.idMecanico,  COUNT(idFactura), nombre, telefono FROM arreglos arr JOIN mecanicos me ON arr.idMecanico=me.idMecanico  GROUP BY arr.idMecanico ORDER BY COUNT(idFactura) DESC";
		Mecanico m = null;
		int cont=0;
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				if(cont==0) {
					m= new Mecanico(reg.getInt(1), reg.getString(3), reg.getString(4));
					cont++;}
				else {
					break;
				}
			}
			s.close();
			this.cerrar();
			return m;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("Error al buscar el cliente");
		}
	}
	public Arreglo arregloExpensive () throws ErrorBaseDatos {
		String cadenaSQL = "SELECT * FROM arreglos WHERE importe in (SELECT MAX(importe) FROM arreglos )";
		Arreglo arr = null;
		int cont=0;
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			if (reg.next()) {
				arr= new Arreglo(reg.getInt(1), reg.getInt(2), reg.getString(3), reg.getObject(4, java.time.LocalDate.class),  reg.getObject(5, java.time.LocalDate.class), reg.getDouble(6));
			}
			s.close();
			this.cerrar();
			return arr;
		} catch (SQLException e) {
			this.cerrar();
			throw new ErrorBaseDatos("Error al buscar el cliente");
		}
	}

	/*
	 * SELECT idMecanico, COUNT(*) AS total_arreglos FROM arreglos GROUP BY
	 * idMecanico ORDER BY total_arreglos DESC LIMIT 1;
	 */
}

/*
 * 
 * 
 * public ArrayList<Reserva> listarReservas(String peli) throws ErrorBaseDatos {
 * // 1. Usamos ? para el parámetro de la película String cadenaSQL =
 * "SELECT * FROM reservas WHERE sala IN (SELECT sala FROM salas WHERE pelicula = ?)"
 * ; ArrayList<Reserva> reservas = new ArrayList<Reserva>();
 * 
 * try { this.abrir(); PreparedStatement ps = c.prepareStatement(cadenaSQL);
 * ps.setString(1, peli);
 * 
 * reg = ps.executeQuery();
 * 
 * while (reg.next()) { reservas.add(new Reserva( reg.getInt(1), reg.getInt(2),
 * reg.getInt(3), reg.getInt(4) )); }
 * 
 * reg.close(); ps.close(); this.cerrar(); return reservas;
 * 
 * } catch (SQLException e) { this.cerrar(); throw new
 * ErrorBaseDatos("Error al listar reservas de la película: " + peli); } } /*
 * String cadenaSQL =
 * "SELECT pelicula, SUM(plazas_ocupadas) FROM salas GROUP BY PELICULA ORDER BY SUM (plazas_ocupadas) DESC"
 * ;
 */
/*
 * public HashMap<String, Integer> taquilla() throws ErrorBaseDatos { String
 * cadenaSQL = "SELECT pelicula, plazas_ocupadas FROM salas"; HashMap<String,
 * Integer> taquilla = new HashMap<String, Integer>();
 * 
 * try { this.abrir(); s = c.createStatement(); reg = s.executeQuery(cadenaSQL);
 * while (reg.next()) { if (!taquilla.containsKey(reg.getString(1))) {
 * taquilla.put(reg.getString(1), reg.getInt(2));
 * 
 * } else { int sumaActual = taquilla.get(reg.getString(1));
 * taquilla.put(reg.getString(1), sumaActual + reg.getInt(2)); } } s.close();
 * this.cerrar(); return taquilla; } catch (SQLException e) { this.cerrar();
 * throw new ErrorBaseDatos("Error al buscar cuentas por DNI"); } }
 * 
 * public int altaReserva(Reserva r) throws ErrorBaseDatos { String cadenaSQL =
 * "INSERT INTO reservas (precio, entradas, sala , telefono) " +
 * "VALUES (?, ?, ?, ?)"; try { this.abrir(); PreparedStatement p =
 * c.prepareStatement(cadenaSQL); int filas = 0; p.setInt(1, r.getPrecio());
 * p.setInt(2, r.getEntradas()); p.setInt(3, r.getSala()); p.setInt(4,
 * r.getTelefono()); filas += p.executeUpdate();
 * 
 * p.close(); this.cerrar(); return filas; } catch (SQLException e) {
 * this.cerrar(); throw new
 * ErrorBaseDatos("Error en el alta masiva de movimientos: " + e.getMessage());
 * } }
 * 
 * public boolean modificarPlazasOcupadas(Sala s, Reserva r) throws
 * ErrorBaseDatos { int nuevas_ocupadas = s.getPlazas_ocupadas() +
 * r.getEntradas();
 * 
 * String cadenaSQL = "UPDATE salas SET plazas_ocupadas = ? WHERE sala = ?";
 * boolean ejecutado = false; int filas = 0; try { this.abrir();
 * 
 * // 3. Preparar la sentencia PreparedStatement ps =
 * c.prepareStatement(cadenaSQL); ps.setInt(1, nuevas_ocupadas); ps.setInt(2,
 * s.getSala());
 * 
 * filas = ps.executeUpdate(); if (filas > 0) { ejecutado = true; } ps.close();
 * this.cerrar(); return ejecutado;
 * 
 * } catch (SQLException e) { this.cerrar(); throw new
 * ErrorBaseDatos("Error al actualizar las plazas de la sala: " +
 * e.getMessage()); }
 * 
 * }
 */
