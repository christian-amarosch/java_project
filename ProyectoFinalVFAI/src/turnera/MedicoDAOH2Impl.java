package turnera;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import excepciones.DAOException;
import libreriaBBDD.DBManager;
import libreriaBBDD.SentenciaNoEjecutadaException;

public class MedicoDAOH2Impl implements MedicoDAO {
	
	public void crearMedico(Medico unMedico) throws DAOException {
		Integer matricula = unMedico.getMatricula();
		String nombre = unMedico.getNombre();
		String apellido = unMedico.getApellido();
		Float valorConsulta = unMedico.getvalorConsulta();
		
		String sql = "INSERT INTO medicos (matricula, nombre, apellido, valor_consulta) VALUES ('" + matricula + "', '" + nombre + "','" + apellido + "', '" + valorConsulta + "')";
		try {
			DBManager.ejecutarSentenciaDML(sql);
		} catch (SentenciaNoEjecutadaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("No se pudo crear el medico", e);
		}
		
		
	}

	 
	public void borrarMedico(int matricula) throws DAOException {
		String sql = "DELETE FROM pacientes WHERE matricula = '" + matricula + "'";
		try {
			DBManager.ejecutarSentenciaDML(sql);
		} catch (SentenciaNoEjecutadaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("No se pudo borrar al medico", e);
		}
	}

	
	public void actualizarMedico(int i_matricula, Medico unMedico) throws DAOException {
		Integer matricula = unMedico.getMatricula();
		String nombre = unMedico.getNombre();
		String apellido = unMedico.getApellido();
		Float valorConsulta = unMedico.getvalorConsulta();
		
		String sql = "UPDATE pacientes set matricula = '" + matricula + "', nombre = '" + nombre + "', valor_consulta = '" + valorConsulta + "'";
		try {
			DBManager.ejecutarSentenciaDML(sql);
		} catch (SentenciaNoEjecutadaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("No se pudo editar", e);
		}
		
	}

	public Medico muestraMedico(int matricula) throws DAOException {
		String sql = "SELECT * FROM pacientes WHERE dni = '" + matricula + "'";
		Connection c = DBManager.conectar();

		try {
			ResultSet rs = DBManager.ejecutarConsulta(c, sql);
			if(rs.next()) { 
				int matriculaMedico = rs.getInt("matricula");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				float valorConsulta = rs.getFloat("valor_consulta");
				Medico m = new Medico(matriculaMedico, nombre, apellido, valorConsulta);
				return m;
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
	

	public List<Medico> listaTodosLosMedicos() throws DAOException {
		List<Medico> resultado = new ArrayList<>();
		String sql = "SELECT * FROM medicos";
		Connection c = DBManager.conectar();
		
		try {
			ResultSet rs = DBManager.ejecutarConsulta(c, sql);
			while(rs.next()) { 
				int matriculaMedico = rs.getInt("matricula");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				float valorConsulta = rs.getFloat("valor_consulta");
				Medico m = new Medico(matriculaMedico, nombre, apellido, valorConsulta);
				resultado.add(m); 
			}
		} catch (SentenciaNoEjecutadaException e) {
			e.printStackTrace();
			throw new DAOException("No se pudo traer la lista de medicos", e);
		}	catch (SQLException e) {
		
			// TODO Auto-generated catch block
			DBManager.ejecutarRollBack(c);
			e.printStackTrace();
			throw new DAOException("No se pudo traer la lista de medicos", e);
		} finally {
			DBManager.cerrarConexion(c);
		}

		return resultado;
	}

	public List<Integer> listaMatriculasMedicos() throws DAOException {
		List<Integer> resultado = new ArrayList<>();
		String sql = "SELECT matricula FROM pacientes";
		Connection c = DBManager.conectar();
		
		try {
			ResultSet rs = DBManager.ejecutarConsulta(c, sql);
			while(rs.next()) { 
				int matricula = rs.getInt("matricula");
				resultado.add(matricula); 
			}
		} catch (SentenciaNoEjecutadaException e) {
			e.printStackTrace();
			throw new DAOException("No se pudo traer la lista las matriculas de los medicos", e);
		}	catch (SQLException e) {
		
			// TODO Auto-generated catch block
			DBManager.ejecutarRollBack(c);
			e.printStackTrace();
			throw new DAOException("No se pudo traer la lista las matriculas de los medicos", e);
		} finally {
			DBManager.cerrarConexion(c);
		}

		return resultado;
	}




}
