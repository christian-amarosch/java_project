package turnera;

//import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import excepciones.UIException;

public abstract class AbstractPanelFormulario extends JPanel{
	protected PanelManager panelManager;
	protected CamposPanel camposPanel;
	protected BotoneraPanel botonesPanel;
	protected JLabel titulo = new JLabel();
	
	public AbstractPanelFormulario(PanelManager panelManager) {
		this.panelManager = panelManager;
		this.setCamposPanel();
		this.setBotoneraPanel();
		armarPantallaPanel();
	}
	
	public void armarPantallaPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(titulo);
		this.add(camposPanel);
		this.add(botonesPanel);
		
		
		this.botonesPanel.getOkBtn().addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						ejecutarAccionOk();				
					}
				});
		
		this.botonesPanel.getCancelBtn().addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						ejecutarAccionCancel();
					}
				});
	
	
	}	
	public void setBotoneraPanel() {
		this.botonesPanel = new BotoneraPanel(this.panelManager);
		
	}
	
	
	public abstract void setCamposPanel();
	public abstract void ejecutarAccionOk();
	public abstract void ejecutarAccionCancel();
}
