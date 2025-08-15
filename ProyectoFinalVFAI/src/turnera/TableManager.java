package turnera;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import libreriaBBDD.DBManager;

public class TableManager {
	
	public void createPacienteTable() {
		
		Connection c = DBManager.conectar();
		
		String sql = "CREATE TABLE IF NOT EXISTS pacientes (id INTEGER IDENTITY(0,1), nombre VARCHAR(256), apellido VARCHAR(256), genero VARCHAR(256), dni INTEGER, fecha_de_nacimiento DATE)";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
	}
	
	
	public void dropPacienteTable() {
		
		Connection c = DBManager.conectar();
		
		String sql = "DROP TABLE usuarios";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
