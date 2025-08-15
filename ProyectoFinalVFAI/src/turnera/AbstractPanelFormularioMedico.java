package turnera;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import excepciones.*;

public abstract class AbstractPanelFormularioMedico extends AbstractPanelFormulario {
	
	protected MedicoTableModel modelo;
	protected String[] campos = new String[4];
	
	public AbstractPanelFormularioMedico(PanelManager panelManager, MedicoTableModel mtm, String titulo) {
		super(panelManager);
		this.modelo = mtm;
		this.titulo.setText(titulo);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void setCamposPanel() {
		this.camposPanel = new CamposPacientePanel(panelManager);
	}
	
	protected String[] obtenerCampos() {
		String[] campos = new String[4];
		CamposMedicoPanel medicoPanel = (CamposMedicoPanel) this.camposPanel;
		campos[0] = medicoPanel.getNombreTxt().getText();
		campos[1] = medicoPanel.getApellidoTxt().getText();
		campos[2] = medicoPanel.getMatriculaTxt().getText();
		campos [3]= medicoPanel.getVConsultaTxt().getText();
		return campos;
	}
	
	protected Medico obtenerMedico(String nombre, String apellido, String matricula, String valorConsulta) {
		CamposMedicoPanel medicoPanel = (CamposMedicoPanel) this.camposPanel;
		String nombreM = nombre;
		String apellidoM = apellido;
		int matriculaM = Integer.parseInt(matricula);
		int valorConsultaM = Integer.parseInt(valorConsulta);
		return new Medico(matriculaM, nombreM, apellidoM, valorConsultaM);
	}
	
	protected void limpiarCampos() {
		CamposMedicoPanel medicoPanel = (CamposMedicoPanel) this.camposPanel;
		medicoPanel.getNombreTxt().setText("");
		medicoPanel.getApellidoTxt().setText("");
		medicoPanel.getMatriculaTxt().setText("");
		medicoPanel.getVConsultaTxt().setText("");
	}
	
	@Override
	public void ejecutarAccionCancel() {
		limpiarCampos();
		panelManager.mostrarPanelListaMedicos();
	}
	
	protected void validarCampos(String nombre, String apellido, String matricula, String valorConsulta) throws CampoException  {
		try {
			ValidarCampos.validarCamposMedico(nombre, apellido, matricula, valorConsulta);
		} catch (CampoNombreException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Se ha ingresado un valor invalido para el campo nombre. Por favor, revisar", "Campo Invalido", JOptionPane.PLAIN_MESSAGE);
			throw new CampoException("Nombre invalido");
		} catch (CampoApellidoException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Se ha ingresado un valor invalido para el campo apellido. Por favor, revisar", "Campo Invalido", JOptionPane.PLAIN_MESSAGE);
			throw new CampoException("Apellido invalido");
		} catch (CampoMatriculaException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Se ha ingresado un valor invalido para el campo matrcicula. Por favor, revisar", "Campo Invalido", JOptionPane.PLAIN_MESSAGE);
			throw new CampoException("Genero invalido");
		} catch (CampoVConsultaException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Se ha ingresado un valor invalido para el campo valor consulta. Por favor, revisar", "Campo Invalido", JOptionPane.PLAIN_MESSAGE);
			throw new CampoException("DNI invalido");
		} 
	}
	
	protected void verificarMatricula(String matricula) throws MatriculaExistenteException {
		if(modelo.getMatriculas().contains(Integer.parseInt(matricula))) {
			throw new MatriculaExistenteException("Matricula ya se encuentra en la base de datos");
		}
	}
	
	protected void verificarMatricula(String matricula, int i_matricula) throws MatriculaExistenteException {
		
		if(!(Integer.parseInt(matricula) == i_matricula)) {
			if(modelo.getMatriculas().contains(Integer.parseInt(matricula))) {
				throw new MatriculaExistenteException("Matricula ya se encuentra en la base de datos");
			}
		}
		
	}
	
	

}
