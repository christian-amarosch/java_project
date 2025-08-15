package turnera;

import java.time.LocalDate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import excepciones.ServiceException;
import excepciones.UIException;

public class PanelEliminarPaciente extends AbstractPanelFormulario {
	
	private Paciente paciente;
	private PacienteTableModel modelo;
	int dni;
	int index;

	
	public PanelEliminarPaciente(PanelManager panelManager, PacienteTableModel ptm) {
		super(panelManager);
		this.modelo = ptm;
		this.titulo.setText("VA A ELIMINAR AL SIGUIENTE PACIENTE");
		// TODO Auto-generated constructor stub
	}
	
	public void setPaciente(Paciente p) {
		this.paciente = p;
		this.dni = p.getDNI();
		this.index = this.modelo.getPacientes().indexOf(p);
		setearCampos(p);
	}
	
	@Override
	public void setCamposPanel() {
		this.camposPanel = new CamposPacienteNoMod(panelManager);
	}
	
	
		private void setearCampos(Paciente p) {
		CamposPacienteNoMod panel = (CamposPacienteNoMod) camposPanel;
		panel.getpNombrelbl().setText(p.getNombre());
		panel.getpApellidolbl().setText(p.getApellido());
		panel.getpGenerolbl().setText(p.getGenero());
		panel.getpDnilbl().setText(String.valueOf(p.getDNI()));
		panel.getpFechaNaclbl().setText(p.getFechaNac().toString());
		
		}
	
	
	@Override 
	public void ejecutarAccionOk() {
		try {
			modelo.eliminarPaciente(dni, index);
			JOptionPane.showMessageDialog(this, "Se ha eliminado al paciente seleccionado", "Eliminacion exitosa", JOptionPane.PLAIN_MESSAGE);
			panelManager.mostrarPanelListaPacientes();
		} catch (UIException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(this, "No se ha podido modificar al paciente", "Error", JOptionPane.ERROR_MESSAGE);
			panelManager.mostrarPanelListaPacientes();
		} 
		
	}
	
	@Override
	public void ejecutarAccionCancel() {
		panelManager.mostrarPanelListaPacientes();
	}
	

}
