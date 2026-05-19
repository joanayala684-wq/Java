package bbdd;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import modelos.*;
import wallapop.ErrorBaseDatos;

import java.time.*;

public class BD_Gestion_Vuelos extends BD_Conector {

	private static Statement s;
	private static ResultSet reg;

	public BD_Gestion_Vuelos(String file) {
		super(file);
		//import modelos.*;

	}
	 public Pasajero buscarUsu(String pas) throws ErrorBaseDatos {
	        String cadenaSQL = "SELECT * FROM pasajeros WHERE pasaporte='" + pas + "'";
	        Pasajero p=null;
	        try {
	            this.abrir();
	            s = c.createStatement();
	            reg = s.executeQuery(cadenaSQL);
	            if (reg.next()) {
	               p= new Pasajero (reg.getString(1), reg.getString(2), reg.getString(3), reg.getInt(4));
	            }
	            s.close();
	            this.cerrar();
	            return p;
	        } catch (SQLException e) {
	            this.cerrar();
	            throw new ErrorBaseDatos("Error al buscar cuentas por DNI");
	        }
	    }
	 public ArrayList<Vuelo> filtrarVuelos(String destino, double importe) throws ErrorBaseDatos {
	        String cadenaSQL = "SELECT * FROM vuelos_disponibles WHERE destino='" + destino +"'AND precio_billete<='"+importe+"'";
	        ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>() ;
	        try {
	            this.abrir();
	            s = c.createStatement();
	            reg = s.executeQuery(cadenaSQL);
	            while (reg.next()) {
	            	vuelos.add(new Vuelo (reg.getString(1), reg.getString(2), reg.getDouble(3), reg.getObject(4, java.time.LocalDateTime.class), reg.getInt(5)));
	            }
	            s.close();
	            this.cerrar();
	            return vuelos;
	        } catch (SQLException e) {
	            this.cerrar();
	            throw new ErrorBaseDatos("Error al buscar cuentas por DNI");
	        }
	    }
	 public int altaReserva(Vuelo v, Pasajero pa) throws ErrorBaseDatos {
	        String cadenaSQL = "INSERT INTO reservas_confirmadas (pasaporte_pasajero, codigo_vuelo, precio_final, fecha_reserva) VALUES (?, ?, ?, ?)";
	        try {
	            this.abrir();
	            PreparedStatement p = c.prepareStatement(cadenaSQL);
	            int filas = 0;
	            
	                p.setString(1, pa.getPasaporte());
	                p.setString(2, v.getCodigo_vuelo());
	                p.setDouble(3, v.getPrecio_billete());
	                p.setObject(4, LocalDateTime.now());
	                filas += p.executeUpdate();
	           
	            p.close();
	            this.cerrar();
	            return filas;
	        } catch (SQLException e) {
	            this.cerrar();
	            throw new ErrorBaseDatos("Error en el alta masiva de movimientos: " + e.getMessage());
	        }
	    }
	 public int modificarAsientos(String cod) throws ErrorBaseDatos {
	        String cadenaSQL = "UPDATE vuelos_disponibles SET asientos_libres = asientos_libres-1 WHERE  codigo_vuelo= '" + cod + "' AND asientos_libres > 0";
	        try {
	            this.abrir();
	            s = c.createStatement();
	            int filas = s.executeUpdate(cadenaSQL);
	            s.close();
	            this.cerrar();
	            return filas;
	        } catch (SQLException e) {
	            this.cerrar();
	            throw new ErrorBaseDatos("Error al modificar el estado de carga");
	        }
	    }
	 public int modificarPuntos(Pasajero pa) throws ErrorBaseDatos {
	        String cadenaSQL = "UPDATE pasajeros SET puntos_fidelidad = puntos_fidelidad+10 WHERE  pasaporte= '" + pa.getPasaporte() +"'";
	        try {
	            this.abrir();
	            s = c.createStatement();
	            int filas = s.executeUpdate(cadenaSQL);
	            s.close();
	            this.cerrar();
	            return filas;
	        } catch (SQLException e) {
	            this.cerrar();
	            throw new ErrorBaseDatos("Error al modificar el estado de carga");
	        }
	    }
	 
	 public int borrarVuelo(String cod) throws ErrorBaseDatos {
			String cadenaSQL = "DELETE FROM vuelos_disponibles Where codigo_vuelo='" + cod+ "'";
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

}