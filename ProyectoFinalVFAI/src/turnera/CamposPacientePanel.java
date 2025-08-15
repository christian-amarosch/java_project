package turnera;

import java.awt.GridLayout;
import java.time.LocalDate;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CamposPacientePanel extends CamposPanel{
	
	private JTextField nombreTxt;
	private JTextField apellidoTxt;
	private JTextField generoTxt;
	private JTextField dniTxt;
	private JTextField fechaNacTxt;
	
	public CamposPacientePanel(PanelManager panelManager) {
		super(panelManager);
		// TODO Auto-generated constructor stub
	}
	
	public void armarFormulario() {
		this.setLayout(new GridLayout(5,2));
		
		JLabel nombrelbl = new JLabel("Nombre:");
		JLabel apellidolbl = new JLabel("Apellido:");
		JLabel generolbl = new JLabel("Genero (m/f):");
		JLabel dnilbl = new JLabel("DNI: ");
		JLabel fechaNaclbl = new JLabel("Fecha Nacimiento (Formato yyyy-mm-dd):");
		
		nombreTxt = new JTextField("");
		apellidoTxt = new JTextField("");
		generoTxt = new JTextField("");
		dniTxt = new JTextField("");
		fechaNacTxt = new JTextField("");
		
		this.add(nombrelbl);
		this.add(nombreTxt);
		this.add(apellidolbl);
		this.add(apellidoTxt);
		this.add(generolbl);
		this.add(generoTxt);
		this.add(dnilbl);
		this.add(dniTxt);
		this.add(fechaNaclbl);
		this.add(fechaNacTxt);
		
		
		
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

	public JTextField getGeneroTxt() {
		return generoTxt;
	}

	public void setGeneroTxt(JTextField generoTxt) {
		this.generoTxt = generoTxt;
	}

	public JTextField getDniTxt() {
		return dniTxt;
	}

	public void setDniTxt(JTextField dniTxt) {
		this.dniTxt = dniTxt;
	}

	public JTextField getFechaNacTxt() {
		return fechaNacTxt;
	}

	public void setFechaNacTxt(JTextField fechaNacTxt) {
		this.fechaNacTxt = fechaNacTxt;
	}
	
	
	
}
