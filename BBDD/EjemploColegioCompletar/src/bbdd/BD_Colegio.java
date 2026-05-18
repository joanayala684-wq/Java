package bbdd;
import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.*;
import colegio.*;
import modelos.Alumno;
import modelos.Curso;

public class BD_Colegio extends BD_Conector{

	private static Statement s;	/* Se usa en todas las instrucciones que vaya a ejecutar en la BBDD */
	private static ResultSet reg;  /* sólo en los select */
	
	public BD_Colegio(String file){
		super(file);
	}
	
	public  int añadir_Alumno( Alumno al) throws ErrorBaseDatos{	
		String cadenaSQL="INSERT INTO alumnos VALUES('" + al.getNombre() + "','" +
		al.getDni()+"','"+ al.getTelenono() +"',"+ al.getMatricula()+",'"+
				al.getCurso()+"','"+al.getFechaMatricula()+"')"; 	
		
		try{
			this.abrir();
			s=c.createStatement();
			int filas=s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
			return filas;
		}
		catch ( SQLException e){	
			this.cerrar();
			throw new ErrorBaseDatos("No se puede realizar el alta");
		}
	}
	public int añadir_Alumno2(Alumno al) throws ErrorBaseDatos {
		try {
			this.abrir();
			PreparedStatement p = c.prepareStatement("INSERT alumnos VALUES(?,?,?,?,?,?)");
			p.setString(1, al.getNombre());
			p.setString(2, al.getDni());
			p.setString(3, al.getTelenono());
			p.setInt(4, al.getMatricula());
			p.setString(5, al.getCurso());
			// Transformo LocalDate a Date de Sql
			p.setDate(6,Date.valueOf(al.getFechaMatricula()));
			int filas = p.executeUpdate();
			p.close();
			this.cerrar();
			return filas;
		} catch (SQLException e) {
			throw new ErrorBaseDatos("No se puede realizar el alta");
		}
	}
	
	public int añadir_Curso2(Curso cu) throws ErrorBaseDatos {
		try {
			this.abrir();
			PreparedStatement p = c.prepareStatement("INSERT alumnos VALUES(?,?,?)");
			p.setString(1, cu.getAula());
			p.setString(2, cu.getCurso());
			p.setString(3, cu.getDescripcion());
		
			int filas = p.executeUpdate();
			p.close();
			this.cerrar();
			return filas;
		} catch (SQLException e) {
			throw new ErrorBaseDatos("No se puede realizar el alta");
		}
	}
	public  int añadir_Curso( Curso cur) throws ErrorBaseDatos{	
		String cadenaSQL="INSERT INTO cursos VALUES('" + cur.getCurso() + "','" + cur.getDescripcion()+"','"+cur.getAula()+"')";
		
		try{
			this.abrir();
			s=c.createStatement();
			int filas=s.executeUpdate(cadenaSQL); //Me va a devolver 0 ó 1
			s.close();
			this.cerrar();
			return filas;
		}
		catch ( SQLException e){	
			this.cerrar();
			throw new ErrorBaseDatos("No se puede realizar el alta");
		}
	}
	
	public int borrar_Alumno(String dni) throws ErrorBaseDatos{
		String cadenaSQL="DELETE from alumnos where dni='"+dni+"'";
		try{
			this.abrir();
			s=c.createStatement();
			int filas=s.executeUpdate(cadenaSQL); //Me va a devolver 0 ó 1
			s.close();
			this.cerrar();
			return filas;
		}
		catch ( SQLException e){	
			this.cerrar();
			throw new ErrorBaseDatos("No se puede realizar el alta");
		}
	}
	
	
	public Alumno buscar_Alumno(String dni) throws ErrorBaseDatos{
		String cadenaSQL="SELECT * from alumnos WHERE dni='"+dni+"'";
		Alumno al=null;
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			if ( reg.next()){
				// La fecha que se extrae de la bbdd es sql.Date, hay que transformarla a LocalDate
				//java.sql.Date f=reg.getDate("fechaMatricula");
				//LocalDate fBuena=f.toLocalDate();
				//listaCursos.add(new Alumno(reg.getString("dni"),reg.getString("nombre"),reg.getString("curso"),reg.getInt("matricula"),reg.getString("telefono"),fBuena));
				al=new Alumno(reg.getString("dni"),reg.getString("nombre"),reg.getString("curso"),reg.getInt("matricula"),reg.getString("telefono"),reg.getDate("fechaMatricula").toLocalDate());
				
			}
			s.close();
			this.cerrar();
			return al;
		}
		catch ( SQLException e){	
			this.cerrar();
			throw new ErrorBaseDatos("Listando alumnos curso");	
		}
		
	}
	
	
	public ArrayList<Alumno> buscar_Alumno_Mat(int mat) throws ErrorBaseDatos{
		String cadenaSQL="SELECT * from alumnos WHERE matricula >"+ mat;
		ArrayList<Alumno> alumnos=new ArrayList<Alumno>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				// La fecha que se extrae de la bbdd es sql.Date, hay que transformarla a LocalDate
				//java.sql.Date f=reg.getDate("fechaMatricula");
				//LocalDate fBuena=f.toLocalDate();
				//listaCursos.add(new Alumno(reg.getString("dni"),reg.getString("nombre"),reg.getString("curso"),reg.getInt("matricula"),reg.getString("telefono"),fBuena));
				alumnos.add(new Alumno(reg.getString("dni"),reg.getString("nombre"),reg.getString("curso"),reg.getInt("matricula"),reg.getString("telefono"),reg.getDate("fechaMatricula").toLocalDate()));
				
			}
			s.close();
			this.cerrar();
			return alumnos;
		}
		catch ( SQLException e){	
			this.cerrar();
			throw new ErrorBaseDatos("Listando alumnos por matrícula superior");	
		}
		
	}
	
	public  ArrayList<Alumno> listadoAlumnosCurso(String curso) throws ErrorBaseDatos{
		String cadenaSQL="SELECT * from alumnos WHERE curso='"+curso+"'";
		ArrayList<Alumno> listaCursos=new ArrayList<Alumno>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				// La fecha que se extrae de la bbdd es sql.Date, hay que transformarla a LocalDate
				//java.sql.Date f=reg.getDate("fechaMatricula");
				//LocalDate fBuena=f.toLocalDate();
				//listaCursos.add(new Alumno(reg.getString("dni"),reg.getString("nombre"),reg.getString("curso"),reg.getInt("matricula"),reg.getString("telefono"),fBuena));
				listaCursos.add(new Alumno(reg.getString("dni"),reg.getString("nombre"),reg.getString("curso"),reg.getInt("matricula"),reg.getString("telefono"),reg.getDate("fechaMatricula").toLocalDate()));
				
			}
			s.close();
			this.cerrar();
			return listaCursos;
		}
		catch ( SQLException e){	
			this.cerrar();
			throw new ErrorBaseDatos("Listando alumnos curso");	
		}
	}
	
	
	public  Vector<String> listadoCursos() throws ErrorBaseDatos{
		String cadenaSQL="SELECT curso from cursos";
		Vector<String> listaCursos=new Vector<String>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				listaCursos.add(reg.getString(1));
			}			
			s.close();
			this.cerrar();
			return listaCursos;
		}
		catch ( SQLException e){
		//	System.out.println(e.getMessage());
		
			this.cerrar();
			throw new ErrorBaseDatos("Listando cursos");
			
		}
	}
	public int añadir_cursos(ArrayList<Curso> cursos) throws ErrorBaseDatos {
        try {
            this.abrir();
            int filas=0;
            PreparedStatement p = c.prepareStatement("INSERT cursos VALUES(?,?,?)");
            for (Curso cur : cursos) {
                p.setString(1, cur.getCurso());
                p.setString(2, cur.getDescripcion());
                p.setString(3, cur.getAula());
                filas+= p.executeUpdate();
            }
            p.close();
            this.cerrar();
            return filas;
        } catch (SQLException e) {
            throw new ErrorBaseDatos("No se puede realizar el alta");
        }
    }
	
	public  void listadoAlumnosPorCurso() throws ErrorBaseDatos{
		String cadenaSQL="SELECT curso from cursos";
	    String curso="";
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				curso=reg.getString(1);
				System.out.println("CURSO:"+curso);
				Statement s2=c.createStatement();
				ResultSet reg2=s2.executeQuery("select nombre from alumnos where curso='"+curso+"'");
				while ( reg2.next()){
					System.out.println("\t"+reg2.getString(1));
				}			
				s2.close();
			}			
			s.close();
			this.cerrar();
			return;
		}
		catch ( SQLException e){
		//	System.out.println(e.getMessage());
			this.cerrar();
			throw new ErrorBaseDatos("Listando cursos");
			
		}
	}
	
}
