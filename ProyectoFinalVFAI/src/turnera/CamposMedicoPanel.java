package turnera;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class CamposMedicoPanel extends CamposPanel {
	
	private JTextField matTxt;
	private JTextField nombreTxt;
	private JTextField apellidoTxt;
	private JTextField vConsultaTxt;
	
	public CamposMedicoPanel(PanelManager panelManager) {
		super(panelManager);
		// TODO Auto-generated constructor stub
	}
	
	public void armarFormulario() {
		this.setLayout(new GridLayout(5,2));
		
		JLabel matlbl = new JLabel("Matricula: ");
		JLabel nombrelbl = new JLabel("Nombre:");
		JLabel apellidolbl = new JLabel("Apellido:");
		JLabel vConsultalbl = new JLabel("Valor Consulta: ");
		
		matTxt = new JTextField("");
		nombreTxt = new JTextField("");
		apellidoTxt = new JTextField("");
		vConsultaTxt = new JTextField("");
		
		this.add(matlbl);
		this.add(matTxt);
		this.add(nombrelbl);
		this.add(nombreTxt);
		this.add(apellidolbl);
		this.add(apellidoTxt);
		this.add(vConsultalbl);
		this.add(vConsultaTxt);
		
		
		
	}
	
	public JTextField getMatriculaTxt() {
		return matTxt;
	}

	public void setMatriculaTxt(JTextField matTxt) {
		this.matTxt = matTxt;
	}

	public JTextField getNombreTxt() {
		return nombreTxt;
	}

	public void setNombreTxt(JTextField nombreTxt) {
		this.nombreTxt = nombreTxt;
	}

	public JTextField getApellidoTxt() {
		return apellidoTxt;
	}

	public void setApellidoTxt(JTextField apellidoTxt) {
		this.apellidoTxt = apellidoTxt;
	}

	public JTextField getVConsultaTxt() {
		return vConsultaTxt;
	}

	public void setVConsultaTxt(JTextField vConsultaTxt) {
		this.vConsultaTxt = vConsultaTxt;
	}

	
	
}
