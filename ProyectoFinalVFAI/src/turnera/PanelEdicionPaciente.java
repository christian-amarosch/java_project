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
import excepciones.ServiceException;
import excepciones.UIException;

public class PanelEdicionPaciente extends AbstractPanelFormularioPaciente {

	private Paciente paciente;
	int i_dni;
	int index;

	
	public PanelEdicionPaciente(PanelManager panelManager, PacienteTableModel ptm) {
		super(panelManager, ptm, "VA A EDITAR AL SIGUIENTE PACIENTE");
	}
	
	public void setPaciente(Paciente p) {
		this.paciente = p;
		this.index = this.modelo.getPacientes().indexOf(p);
		this.i_dni = p.getDNI();
		setearCampos(p);
	}
	
	
		private void setearCampos(Paciente p) {
		CamposPacientePanel pacientePanel = (CamposPacientePanel) this.camposPanel;
		pacientePanel.getNombreTxt().setText(p.getNombre());
		pacientePanel.getApellidoTxt().setText(p.getApellido());
		pacientePanel.getGeneroTxt().setText(p.getGenero());
		pacientePanel.getDniTxt().setText(String.valueOf(p.getDNI()));
		pacientePanel.getFechaNacTxt().setText(p.getFechaNac().toString());
		
		}
	
	@Override 
	public void ejecutarAccionOk() {
		try {
			campos = obtenerCampos();
			validarCampos(campos[0],campos[1],campos[2],campos[3],campos[4]);
			verificarDNI(campos[3], i_dni);
			Paciente p = obtenerPaciente(campos[0],campos[1],campos[2],campos[3],campos[4]);
			modelo.modPaciente(i_dni, p, index);
			JOptionPane.showMessageDialog(this, "Se ha modificado el paciente seleccionado", "Modificacion exitosa", JOptionPane.PLAIN_MESSAGE);
			panelManager.mostrarPanelListaPacientes();
		} catch (UIException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(this, "No se ha podido modificar al paciente", "Error", JOptionPane.ERROR_MESSAGE);
			panelManager.mostrarPanelListaPacientes();
		} catch (DniExistenteException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(this, "El DNI ingresado ya existe en el sistema", "DNI existente", JOptionPane.PLAIN_MESSAGE);
		} catch (CampoException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} 
		
	}
	
}
