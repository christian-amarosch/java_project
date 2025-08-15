package turnera;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import libreriaBBDD.*;
import excepciones.*;




public class PacienteDAOH2Impl implements PacienteDAO {
	
	public void crearPaciente(Paciente unPaciente) throws DAOException {
		String nombre = unPaciente.getNombre();
		String apellido = unPaciente.getApellido();
		String genero = unPaciente.getGenero();
		Integer dni = unPaciente.getDNI();
		Date fechanac = Date.valueOf(unPaciente.getFechaNac());
		
		String sql = "INSERT INTO pacientes (nombre, apellido, genero, dni, fecha_de_nacimiento) VALUES ('" + nombre + "', '" + apellido + "','" + genero + "', '" + dni + "', '" + fechanac + "')";
		try {
			DBManager.ejecutarSentenciaDML(sql);
		} catch (SentenciaNoEjecutadaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("No se pudo crear el paciente", e);
		}
		
		
	}

	 
	public void borrarPaciente(int dni) throws DAOException {
		String sql = "DELETE FROM pacientes WHERE dni = '" + dni + "'";
		try {
			DBManager.ejecutarSentenciaDML(sql);
		} catch (SentenciaNoEjecutadaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("No se pudo borrar al paciente", e);
		}
	}

	
	public void actualizarPaciente(int i_dni, Paciente unPaciente) throws DAOException {
		String nombre = unPaciente.getNombre();
		String apellido = unPaciente.getApellido();
		String genero = unPaciente.getGenero();
		Integer dni = unPaciente.getDNI();
		Date fechanac = Date.valueOf(unPaciente.getFechaNac());
		
		String sql = "UPDATE pacientes set nombre = '" + nombre + "', apellido = '" + apellido + "', genero = '" + genero + "', fecha_de_nacimiento = '" + fechanac +"', dni = '" + dni + "' WHERE dni = '" + i_dni + "'";
		try {
			DBManager.ejecutarSentenciaDML(sql);
		} catch (SentenciaNoEjecutadaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("No se pudo editar", e);
		}
		
	}

	public Paciente muestraPaciente(int dni) throws DAOException {
		String sql = "SELECT * FROM pacientes WHERE dni = '" + dni + "'";
		Connection c = DBManager.conectar();

		try {
			ResultSet rs = DBManager.ejecutarConsulta(c, sql);
			if(rs.next()) { 
				//int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String genero = rs.getString("genero");
				int DNI = rs.getInt("dni");
				LocalDate fechanac = rs.getDate("fecha_de_nacimiento").toLocalDate();
				Paciente p = new Paciente(nombre, apellido, genero, DNI, fechanac);
				return p;
			}
		} catch (SentenciaNoEjecutadaException e) {
			e.printStackTrace();
			throw new DAOException("No se pudo realizar la busqueda", e);
		}catch (SQLException e) {
		
			// TODO Auto-generated catch block
			DBManager.ejecutarRollBack(c);
			e.printStackTrace();
			throw new DAOException("No se pudo realizar la busqueda", e);
		} finally {
			DBManager.cerrarConexion(c);
		}

		return null;
	}
	

	public List<Paciente> listaTodosLosPacientes() throws DAOException {
		List<Paciente> resultado = new ArrayList<>();
		String sql = "SELECT * FROM pacientes";
		Connection c = DBManager.conectar();
		
		try {
			ResultSet rs = DBManager.ejecutarConsulta(c, sql);
			while(rs.next()) { 
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String genero = rs.getString("genero");
				int dni = rs.getInt("dni");
				LocalDate fechanac = rs.getDate("fecha_de_nacimiento").toLocalDate();
				Paciente p = new Paciente(nombre, apellido, genero, dni, fechanac);
				resultado.add(p); 
			}
		} catch (SentenciaNoEjecutadaException e) {
			e.printStackTrace();
			throw new DAOException("No se pudo traer la lista de pacientes", e);
		}	catch (SQLException e) {
		
			// TODO Auto-generated catch block
			DBManager.ejecutarRollBack(c);
			e.printStackTrace();
			throw new DAOException("No se pudo traer la lista de pacientes", e);
		} finally {
			DBManager.cerrarConexion(c);
		}

		return resultado;
	}

	public List<Integer> listaDNIsPacientes() throws DAOException {
		List<Integer> resultado = new ArrayList<>();
		String sql = "SELECT dni FROM pacientes";
		Connection c = DBManager.conectar();
		
		try {
			ResultSet rs = DBManager.ejecutarConsulta(c, sql);
			while(rs.next()) { 
				int dni = rs.getInt("dni");
				resultado.add(dni); 
			}
		} catch (SentenciaNoEjecutadaException e) {
			e.printStackTrace();
			throw new DAOException("No se pudo traer la lista los DNIs de los pacientes", e);
		}	catch (SQLException e) {
		
			// TODO Auto-generated catch block
			DBManager.ejecutarRollBack(c);
			e.printStackTrace();
			throw new DAOException("No se pudo traer la lista los DNIs de los pacientes", e);
		} finally {
			DBManager.cerrarConexion(c);
		}

		return resultado;
	}
	
	

}
