package turnera;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class CamposBusquedaPaciente extends CamposPanel {
	
	private JTextField dniTxt;
	
	public CamposBusquedaPaciente(PanelManager panelManager) {
		super(panelManager);
		// TODO Auto-generated constructor stub
	}
	
	public void armarFormulario() {
		this.setLayout(new GridLayout(5,2));
		
		JLabel dnilbl = new JLabel("DNI: ");

		dniTxt = new JTextField("");

		this.add(dnilbl);
		this.add(dniTxt);
		
		
	}

	public JTextField getDniTxt() {
		return dniTxt;
	}

	public void setDniTxt(JTextField dniTxt) {
		this.dniTxt = dniTxt;
	}


}
