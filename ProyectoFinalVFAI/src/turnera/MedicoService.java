package turnera;

import java.util.List;

import excepciones.DAOException;
import excepciones.ServiceException;

public class MedicoService {
private MedicoDAO medicoDao;
	
	public MedicoService() {
		this.medicoDao = new MedicoDAOH2Impl();
	}
	
	public void crearMedico(Medico m) throws ServiceException {
		try {
			medicoDao.crearMedico(m);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException ("Error capa de servicio | creacion de medico",e);
		}
	}
	
	public void borrarMedico(int matricula) throws ServiceException {
		try {
			medicoDao.borrarMedico(matricula);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException ("Error capa de servicio | eliminacion de medico",e);
		}
	}
	
	public void actualizarMeico(int i_matricula, Medico m) throws ServiceException {
		try {
			medicoDao.actualizarMedico(i_matricula, m);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException ("Error capa de servicio | actualizacion de medico",e);
		}
	}
	
	public Medico muestraPaciente(int matricula) throws ServiceException {
		try {
			Medico m = medicoDao.muestraMedico(matricula);
			return m;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException ("Error capa de servicio | no se pudo obtener el medico",e);
		}
	}
	
	public List<Medico> listarMedicos() throws ServiceException {
		try {
			List<Medico> lm = medicoDao.listaTodosLosMedicos();
			return lm;
			
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("Error capa de servicio | listado de medicos", e);
		}
	}
	
	public List<Integer> listarMatriculas() throws ServiceException {
		try {
			List<Integer> lm = medicoDao.listaMatriculasMedicos();
			return lm;
			
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("Error capa de servicio | listado de matriculas de medicos", e);
		}
	}

}
