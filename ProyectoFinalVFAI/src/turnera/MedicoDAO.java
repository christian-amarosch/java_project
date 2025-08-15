package turnera;

import java.util.List;

import excepciones.DAOException;

public interface MedicoDAO {
	
	void crearMedico(Medico unMedico) throws DAOException;
	
	void borrarMedico(int matricula) throws DAOException;
	
	void actualizarMedico(int i_matricula, Medico unMedico) throws DAOException;
	
	Medico muestraMedico(int matricula) throws DAOException;
	
	List<Medico> listaTodosLosMedicos() throws DAOException;
	
	List<Integer> listaMatriculasMedicos() throws DAOException;

}
