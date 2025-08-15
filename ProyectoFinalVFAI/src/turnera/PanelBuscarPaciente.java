package turnera;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import excepciones.*;

public class PanelBuscarPaciente extends AbstractPanelFormulario {
	
	private PacienteTableModel modelo;
	
	public PanelBuscarPaciente(PanelManager panelManager, PacienteTableModel ptm) {
		super(panelManager);
		this.modelo = ptm;
		this.titulo.setText("BUSQUEDA PACIENTE");
	}
	
	@Override
	public void setCamposPanel() {
		this.camposPanel = new CamposBusquedaPaciente(panelManager);
	}
	
	private String obtenerDni() {
		CamposBusquedaPaciente pacientePanel = (CamposBusquedaPaciente) this.camposPanel;
		return pacientePanel.getDniTxt().getText();
	}
	
	private void limpiarCampos() {
		CamposBusquedaPaciente pacientePanel = (CamposBusquedaPaciente) this.camposPanel;
		pacientePanel.getDniTxt().setText("");
	}
	
	@Override 
	public void ejecutarAccionOk() {
		try {
			String dniS = obtenerDni();
			validarDNI(dniS);
			int dni = Integer.parseInt(obtenerDni());
			Paciente p = modelo.showPaciente(dni);
			if(p != null) {
				JOptionPane.showMessageDialog(this, "Se ha encontrando al paciente", "Busqueda exitosa", JOptionPane.PLAIN_MESSAGE);
				limpiarCampos();
				panelManager.mostrarPanelPaciente(p);
			} else {
				JOptionPane.showMessageDialog(this, "No se ha encontrado al paciente", "No encontrado", JOptionPane.PLAIN_MESSAGE);
			}
			
		} catch (UIException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(this, "No se ha podido buscar al paciente", "Error", JOptionPane.ERROR_MESSAGE);
			panelManager.mostrarPanelListaPacientes();
		} catch (CampoException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}
	
	@Override
	public void ejecutarAccionCancel() {
		limpiarCampos();
		panelManager.mostrarPanelListaPacientes();
	}
	
	private void validarDNI(String dni) throws CampoException {
		try {
			ValidarCampos.validarCampoDni(obtenerDni());
		} catch (CampoDNIException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new CampoException("Valor ingresado en DNI no valido");
		}
	}

}
