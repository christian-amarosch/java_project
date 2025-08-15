package turnera;

import java.util.List;

import excepciones.DAOException;
import excepciones.ServiceException;

public class PacienteService {
	
	private PacienteDAO pacienteDao;
	
	public PacienteService() {
		this.pacienteDao = new PacienteDAOH2Impl();
	}
	
	public void crearPaciente(Paciente p) throws ServiceException {
		try {
			pacienteDao.crearPaciente(p);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException ("Error capa de servicio | creacion de paciente",e);
		}
	}
	
	public void borrarPaciente(int dni) throws ServiceException {
		try {
			pacienteDao.borrarPaciente(dni);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException ("Error capa de servicio | eliminacion de paciente",e);
		}
	}
	
	public void actualizarPaciente(int i_dni, Paciente p) throws ServiceException {
		try {
			pacienteDao.actualizarPaciente(i_dni, p);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException ("Error capa de servicio | actualizacion de paciente",e);
		}
	}
	
	public Paciente muestraPaciente(int dni) throws ServiceException {
		try {
			Paciente p = pacienteDao.muestraPaciente(dni);
			return p;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException ("Error capa de servicio | no se pudo obtener el paciente",e);
		}
	}
	
	public List<Paciente> listarPacientes() throws ServiceException {
		try {
			List<Paciente> lp = pacienteDao.listaTodosLosPacientes();
			return lp;
			
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("Error capa de servicio | listado de pacientes", e);
		}
	}
	
	public List<Integer> listarDNIs() throws ServiceException {
		try {
			List<Integer> ld = pacienteDao.listaDNIsPacientes();
			return ld;
			
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("Error capa de servicio | listado de DNIs de pacientes", e);
		}
	}

}
