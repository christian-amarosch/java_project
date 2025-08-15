package turnera;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPaciente extends JPanel {
	
	private PanelManager panelManager;
	private CamposPacienteNoMod camposPanel;
	private JLabel titulo;
	private JButton aceptar;
	private Paciente paciente;
	
	public PanelPaciente (PanelManager panelManager) {
		this.panelManager = panelManager;
		this.camposPanel = new CamposPacienteNoMod(panelManager);
		this.titulo = new JLabel("Paciente");
		this.aceptar = new JButton("Aceptar");
		armarPantallaPanel();
	}
	

	public void armarPantallaPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(titulo);
		this.add(camposPanel);
		this.add(aceptar);
		
		
		aceptar.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						panelManager.mostrarPanelListaPacientes();				
					}
				});
	
	
	}
	
	public void setPaciente(Paciente p) {
		this.paciente = p;
		setearCampos(p);
	}
	
	private void setearCampos(Paciente p) {
		camposPanel.getpNombrelbl().setText(p.getNombre());
		camposPanel.getpApellidolbl().setText(p.getApellido());
		camposPanel.getpGenerolbl().setText(p.getGenero());
		camposPanel.getpDnilbl().setText(String.valueOf(p.getDNI()));
		camposPanel.getpFechaNaclbl().setText(p.getFechaNac().toString());
		
	}

	
	


}
