package turnera;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BotoneraPanel extends JPanel {
	private PanelManager panelManager;
	private JButton okBtn;
	private JButton cancelBtn;
	private JButton volverBtn;
	
	public BotoneraPanel (PanelManager panelManager) {
		this.panelManager = panelManager;
		armarBotoneraPanel();
		
	}
	
	public void armarBotoneraPanel() {
		this.setLayout(new FlowLayout());
		okBtn = new JButton("Aceptar");
		cancelBtn = new JButton("Cancelar");
		
		this.add(okBtn);
		this.add(cancelBtn);
		
	}

	public PanelManager getPanelManager() {
		return panelManager;
	}

	public void setPanelManager(PanelManager panelManager) {
		this.panelManager = panelManager;
	}

	public JButton getOkBtn() {
		return okBtn;
	}

	public void setOkBtn(JButton okBtn) {
		this.okBtn = okBtn;
	}

	public JButton getCancelBtn() {
		return cancelBtn;
	}

	public void setCancelBtn(JButton cancelBtn) {
		this.cancelBtn = cancelBtn;
	}

}
