package turnera;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PantallaInicioPanel extends JPanel{
	
	protected PanelManager panelManager;
	private JButton pacienteBtn;
	private JButton medicoBtn;
	
	public PantallaInicioPanel(PanelManager panelManager) {
		this.panelManager = panelManager;
		armarPantallaPanel();
	}
	
	public void armarPantallaPanel() {
		this.setLayout(new FlowLayout());
		this.pacienteBtn = new JButton("Pacientes");
		this.medicoBtn = new JButton("Medicos");
		
		this.add(pacienteBtn);
		this.add(medicoBtn);
		
		this.pacienteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelManager.mostrarPanelListaPacientes();
			}
		});
		this.medicoBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelManager.mostrarPanelListaMedicos();
			}
		});
		
	}
	

}
