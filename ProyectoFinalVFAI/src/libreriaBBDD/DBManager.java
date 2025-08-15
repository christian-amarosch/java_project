package libreriaBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import excepciones.*;

public class DBManager {
	
	private static final String DB_DRIVER = "org.h2.Driver";
	private static final String DB_BASE_URL = "jdbc:h2:C:\\Users\\Chris\\OneDrive\\Desktop\\eclipse-workspace\\eclipse-workspace\\ProyectoFinal\\h2\\base_de_datos\\turnera.h2";
	private static final String DB_USERNAME = "sa";
	private static final String DB_PASSWORD = "";
	

	public static void ejecutarRollBack(Connection c) {
		try {
			c.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
    public static void cargarDriver() {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
        }
    }
    
	public static Connection conectar() {
		Connection c = null;
		cargarDriver();
		try {
			c = DriverManager.getConnection(DB_BASE_URL, DB_USERNAME, DB_PASSWORD);
			c.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}

		return c;
	}
	
	public static void cerrarConexion(Connection c) {
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean ejecutarSentenciaDDL(String sql) throws SentenciaNoEjecutadaException {
		boolean result = false;
		Connection c = conectar();
		try {
			Statement s = c.createStatement();
			result = s.execute(sql);
			c.commit();
		} catch (SQLException e) {		
			ejecutarRollBack(c);
			throw new SentenciaNoEjecutadaException("No se pudo ejecutar la sentencia DDL", e);
		} finally {
			cerrarConexion(c);
		}
		return result;
		

	}
	
	public static int ejecutarSentenciaDML(String sql) throws SentenciaNoEjecutadaException {
		int result = 0;
		
		Connection c = conectar();
		
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {		
			ejecutarRollBack(c);
			throw new SentenciaNoEjecutadaException("No se pudo ejecutar la sentencia DML", e);
		} finally {
			cerrarConexion(c);
		}
		
		return result;
	}
	
	public static ResultSet ejecutarConsulta(Connection c, String sql) throws SentenciaNoEjecutadaException {
		ResultSet rs = null;
		try {
			Statement s = c.createStatement();
			rs = s.executeQuery(sql);
		}  catch (SQLException e) {		
			ejecutarRollBack(c);
			cerrarConexion(c);
			throw new SentenciaNoEjecutadaException("No se pudo ejecutar la consulta", e);
		}
		return rs;
	}


}
