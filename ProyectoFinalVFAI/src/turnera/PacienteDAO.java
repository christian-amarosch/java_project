package turnera;

import java.util.List;

import excepciones.DAOException;


public interface PacienteDAO {
	
	void crearPaciente(Paciente unPaciente) throws DAOException;
	
	void borrarPaciente(int dni) throws DAOException;
	
	void actualizarPaciente(int i_dni, Paciente unPaciente) throws DAOException;
	
	Paciente muestraPaciente(int dni) throws DAOException;
	
	List<Paciente> listaTodosLosPacientes() throws DAOException;
	
	List<Integer> listaDNIsPacientes() throws DAOException;

}