package turnera;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import excepciones.CampoApellidoException;
import excepciones.CampoDNIException;
import excepciones.CampoException;
import excepciones.CampoFechaNacException;
import excepciones.CampoGeneroException;
import excepciones.CampoNombreException;
import excepciones.DniExistenteException;
import excepciones.UIException;

public abstract class AbstractPanelFormularioPaciente extends AbstractPanelFormulario {
	
	protected PacienteTableModel modelo;
	protected String[] campos = new String[5];
	
	public AbstractPanelFormularioPaciente(PanelManager panelManager, PacienteTableModel ptm, String titulo) {
		super(panelManager);
		this.modelo = ptm;
		this.titulo.setText(titulo);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void setCamposPanel() {
		this.camposPanel = new CamposPacientePanel(panelManager);
	}
	
	protected String[] obtenerCampos() {
		String[] campos = new String[5];
		CamposPacientePanel pacientePanel = (CamposPacientePanel) this.camposPanel;
		campos[0] = pacientePanel.getNombreTxt().getText();
		campos[1] = pacientePanel.getApellidoTxt().getText();
		campos[2] = pacientePanel.getGeneroTxt().getText();
		campos [3]= pacientePanel.getDniTxt().getText();
		campos[4] = pacientePanel.getFechaNacTxt().getText();
		return campos;
	}
	
	protected Paciente obtenerPaciente(String nombre, String apellido, String genero, String dni, String fechaNac) {
		CamposPacientePanel pacientePanel = (CamposPacientePanel) this.camposPanel;
		String nombreP = nombre;
		String apellidoP = apellido;
		String generoP = genero.toLowerCase();
		int dniP = Integer.parseInt(dni);
		LocalDate fechaNacP = LocalDate.parse(fechaNac);
		return new Paciente(nombreP, apellidoP, generoP, dniP, fechaNacP);
	}
	
	protected void limpiarCampos() {
		CamposPacientePanel pacientePanel = (CamposPacientePanel) this.camposPanel;
		pacientePanel.getNombreTxt().setText("");
		pacientePanel.getApellidoTxt().setText("");
		pacientePanel.getGeneroTxt().setText("");
		pacientePanel.getDniTxt().setText("");
		pacientePanel.getFechaNacTxt().setText("");
	}
	
	@Override
	public void ejecutarAccionCancel() {
		limpiarCampos();
		panelManager.mostrarPanelListaPacientes();
	}
	
	protected void validarCampos(String nombre, String apellido, String genero, String dni, String fechaNac) throws CampoException  {
		try {
			ValidarCampos.validarCamposPaciente(nombre, apellido, genero, dni, fechaNac);
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
		} catch (CampoGeneroException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Se ha ingresado un valor invalido para el campo genero. Por favor, revisar", "Campo Invalido", JOptionPane.PLAIN_MESSAGE);
			throw new CampoException("Genero invalido");
		} catch (CampoDNIException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Se ha ingresado un valor invalido para el campo DNI. Por favor, revisar", "Campo Invalido", JOptionPane.PLAIN_MESSAGE);
			throw new CampoException("DNI invalido");
		} catch (CampoFechaNacException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Se ha ingresado un valor invalido para el campo fecha. Por favor, revisar", "Campo Invalido", JOptionPane.PLAIN_MESSAGE);
			throw new CampoException("Fecha de Nacimiento invalida");
		}

	}
	
	protected void verificarDNI(String dni) throws DniExistenteException {
		if(modelo.getDnis().contains(Integer.parseInt(dni))) {
			throw new DniExistenteException("DNI ya se encuentra en la base de datos");
		}
	}
	
	protected void verificarDNI(String dni, int i_dni) throws DniExistenteException {
		
		if(!(Integer.parseInt(dni) == i_dni)) {
			if(modelo.getDnis().contains(Integer.parseInt(dni))) {
				throw new DniExistenteException("DNI ya se encuentra en la base de datos");
			}
		}
		
	}
	
	
}
