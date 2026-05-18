package bbdd;

import java.sql.*;
import java.util.*;
import modelos.Cuenta;
import modelos.Movimiento;
import modelos.Tarjeta;
import tarjetas.ErrorBaseDatos;

import java.time.*;

public class BD_Tarjetas extends BD_Conector {

    private static Statement s;
    private static ResultSet reg;

    public BD_Tarjetas(String file) {
        super(file);
    }

    // Utilizado en Case 0 y Case 4
    public int añadir_Movimiento(Movimiento m) throws ErrorBaseDatos {
        String cadenaSQL = "INSERT INTO movimientos (tarjeta, cargado, importe, fecha) VALUES (" 
                + m.getNumtarjeta() + ", "
                + m.isCargado() + ", "  
                + m.getImporte() + ", '" 
                + m.getFecha() + "')";
        try {
            this.abrir();
            s = c.createStatement();
            int filas = s.executeUpdate(cadenaSQL);
            s.close();
            this.cerrar();
            return filas;
        } catch (SQLException e) {
            this.cerrar();
            throw new ErrorBaseDatos("No se puede realizar el alta movimiento");
        }
    }

    // Utilizado en Case 1
    public ArrayList<Cuenta> buscarCuenta1(String dni) throws ErrorBaseDatos {
        String cadenaSQL = "SELECT * FROM cuentas WHERE titular1='" + dni + "' OR titular2='" + dni + "' OR titular3='" + dni + "'";
        ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
        try {
            this.abrir();
            s = c.createStatement();
            reg = s.executeQuery(cadenaSQL);
            while (reg.next()) {
                cuentas.add(new Cuenta(reg.getInt(1), reg.getString(2), reg.getString(3), reg.getString(4),
                        reg.getDouble(5), reg.getObject(6, java.time.LocalDate.class)));
            }
            s.close();
            this.cerrar();
            return cuentas;
        } catch (SQLException e) {
            this.cerrar();
            throw new ErrorBaseDatos("Error al buscar cuentas por DNI");
        }
    }

    // Utilizado en Case 1 y Case 2
    public int altaTarjeta(Tarjeta t) throws ErrorBaseDatos {
        String cadenaSQL = "INSERT INTO tarjetas VALUES('" 
                + t.getNumero() + "', '" 
                + t.getCuenta() + "', '"
                + t.getTitular() + "', " 
                + t.getLimite() + ", '"      
                + t.getTipo() + "', '" 
                + t.getCaducidad() + "', '" 
                + t.getClave() + "', "      
                + t.isBloqueado() + ")";
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

    // Utilizado en Case 2 y Case 3
    public Cuenta buscarCuenta(int num) throws ErrorBaseDatos {
        String cadenaSQL = "SELECT * FROM cuentas WHERE número= '" + num + "'";
        try {
            this.abrir();
            s = c.createStatement();
            reg = s.executeQuery(cadenaSQL);
            Cuenta cu = null;
            if (reg.next()) {
                cu = new Cuenta(reg.getInt(1), reg.getString(2), reg.getString(3), reg.getString(4),
                        reg.getDouble(5), reg.getObject(6, java.time.LocalDate.class));
            }
            s.close();
            this.cerrar();
            return cu;
        } catch (SQLException e) {
            this.cerrar();
            throw new ErrorBaseDatos("Error al buscar la cuenta");
        }
    }

    // Utilizado en Case 3 y Case 5
    public int modificarSaldo(Cuenta cu, double importe) throws ErrorBaseDatos {
        double nuevoSaldo = cu.getSaldo() - importe;
        String cadenaSQL = "UPDATE cuentas SET saldo = " + nuevoSaldo + " WHERE número = " + cu.getNumero();
        try {
            this.abrir();
            s = c.createStatement();
            int filas = s.executeUpdate(cadenaSQL);
            s.close();
            this.cerrar();
            return filas;
        } catch (SQLException e) {
            this.cerrar();
            throw new ErrorBaseDatos("Error al modificar el saldo");
        }
    }

    // Utilizado en Case 5
    public double calcularCargo(int numT) throws ErrorBaseDatos {
        String cadenaSQL = "SELECT SUM(m.importe) FROM movimientos m JOIN tarjetas t ON m.tarjeta = t.numero " +
                           "WHERE m.tarjeta = " + numT + " AND m.cargado = 0 AND t.tipo = 'C'";
        double importeTotal = 0;
        try {
            this.abrir();
            s = c.createStatement();
            reg = s.executeQuery(cadenaSQL);
            if (reg.next()) {
                importeTotal = reg.getDouble(1);
            }
            s.close();
            this.cerrar();
            return importeTotal;
        } catch (SQLException e) {
            this.cerrar();
            throw new ErrorBaseDatos("Error al calcular el cargo");
        }
    }

    // Utilizado en Case 5
    public int modificarCarga(int numT) throws ErrorBaseDatos {
        String cadenaSQL = "UPDATE movimientos SET cargado = 1 WHERE tarjeta = " + numT + " AND cargado = 0";
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

    // Utilizado en Case 4, 5 y 6
    public Cuenta darCuenta(int numT) throws ErrorBaseDatos {
        String cadenaSQL = "SELECT c.número, c.titular1, c.titular2, c.titular3, c.saldo, c.fecha " +
                           "FROM tarjetas t JOIN cuentas c ON t.cuenta = c.número WHERE t.numero = " + numT;
        try {
            this.abrir();
            s = c.createStatement();
            reg = s.executeQuery(cadenaSQL);
            Cuenta cu = null;
            if (reg.next()) {
                cu = new Cuenta(reg.getInt(1), reg.getString(2), reg.getString(3), reg.getString(4), 
                        reg.getDouble(5), reg.getObject(6, java.time.LocalDate.class));
            }
            s.close();
            this.cerrar();
            return cu;
        } catch (SQLException e) {
            this.cerrar();
            throw new ErrorBaseDatos("Error al obtener la cuenta asociada a la tarjeta");
        }
    }

 // Utilizado en Case 6
    public ArrayList<Tarjeta> buscarTitular(String nombre) throws ErrorBaseDatos {
        String cadenaSQL = "SELECT * FROM tarjetas WHERE titular='" + nombre + "'";
        ArrayList<Tarjeta> tarjetas = new ArrayList<Tarjeta>();
        try {
            this.abrir();
            s = c.createStatement();
            reg = s.executeQuery(cadenaSQL);
            while (reg.next()) {
                LocalDate caducidad = reg.getObject(6, LocalDate.class);
                if (caducidad != null && !caducidad.isBefore(LocalDate.now())) {
                    tarjetas.add(new Tarjeta(reg.getInt(1), reg.getInt(2), reg.getString(3), reg.getDouble(4),
                            reg.getString(5), reg.getObject(6, java.time.LocalDate.class), reg.getString(7),
                            reg.getBoolean(8)));
                }
            }
            s.close();
            this.cerrar();
            return tarjetas;
        } catch (SQLException e) {
            this.cerrar();
            throw new ErrorBaseDatos("Error al buscar tarjetas por titular");
        }
    }

    // Utilizado en Case 7
    public int altaMovimientos(ArrayList<Movimiento> movimientos) throws ErrorBaseDatos {
        String cadenaSQL = "INSERT INTO movimientos (tarjeta, cargado, importe, fecha) VALUES (?, ?, ?, ?)";
        try {
            this.abrir();
            PreparedStatement p = c.prepareStatement(cadenaSQL);
            int filas = 0;
            for (Movimiento m : movimientos) {
                p.setInt(1, m.getNumtarjeta());
                p.setBoolean(2, m.isCargado());
                p.setDouble(3, m.getImporte());
                p.setObject(4, m.getFecha());
                filas += p.executeUpdate();
            }
            p.close();
            this.cerrar();
            return filas;
        } catch (SQLException e) {
            this.cerrar();
            throw new ErrorBaseDatos("Error en el alta masiva de movimientos: " + e.getMessage());
        }
    }

    // Utilizado en Case 3 y Case 4
    public Tarjeta buscarTarjeta(int num) throws ErrorBaseDatos {
        String cadenaSQL = "SELECT * FROM tarjetas WHERE numero= '" + num + "'";
        try {
            this.abrir();
            s = c.createStatement();
            reg = s.executeQuery(cadenaSQL);
            Tarjeta t = null;
            if (reg.next()) {
                t = new Tarjeta(reg.getInt(1), reg.getInt(2), reg.getString(3), reg.getDouble(4),
                        reg.getString(5), reg.getObject(6, java.time.LocalDate.class), reg.getString(7),
                        reg.getBoolean(8));
            }
            s.close();
            this.cerrar();
            return t;
        } catch (SQLException e) {
            this.cerrar();
            throw new ErrorBaseDatos("Error al buscar la tarjeta");
        }
    }
}