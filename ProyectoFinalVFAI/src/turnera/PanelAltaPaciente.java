package turnera;

import java.time.LocalDate;

import javax.swing.JLabel;
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

public class PanelAltaPaciente extends AbstractPanelFormularioPaciente {

	
	public PanelAltaPaciente(PanelManager panelManager, PacienteTableModel ptm) {
		super(panelManager, ptm, "VA A CREAR AL SIGUIENTE PACIENTE");
	}
	
	@Override
	public void setCamposPanel() {
		this.camposPanel = new CamposPacientePanel(panelManager);
	}
	
	
	
	@Override 
	public void ejecutarAccionOk() {
		try {
			campos = obtenerCampos();
			validarCampos(campos[0],campos[1],campos[2],campos[3],campos[4]);
			verificarDNI(campos[3]);
			Paciente p = obtenerPaciente(campos[0],campos[1],campos[2],campos[3],campos[4]);
			modelo.addPaciente(p);
			JOptionPane.showMessageDialog(this, "Se ha creado un nuevo paciente", "Creacion exitosa", JOptionPane.PLAIN_MESSAGE);
			limpiarCampos();
			panelManager.mostrarPanelListaPacientes();
		}  catch (UIException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(this, "No se ha podido crear al paciente", "Error", JOptionPane.ERROR_MESSAGE);
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
