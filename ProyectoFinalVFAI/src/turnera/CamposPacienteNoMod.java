package turnera;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class CamposPacienteNoMod extends CamposPanel{
	
	private Paciente paciente;
	
	JLabel pNombrelbl;
	JLabel pApellidolbl;
	JLabel pGenerolbl;
	JLabel pDnilbl;
	JLabel pFechaNaclbl;
	
	public CamposPacienteNoMod(PanelManager panelManager) {
		super(panelManager);
		//this.paciente = p;
		// TODO Auto-generated constructor stub
	}
	
	public void armarFormulario() {
		this.setLayout(new GridLayout(5,2));
		
		JLabel nombrelbl = new JLabel("Nombre:");
		JLabel apellidolbl = new JLabel("Apellido:");
		JLabel generolbl = new JLabel("Genero (m/f):");
		JLabel dnilbl = new JLabel("DNI: ");
		JLabel fechaNaclbl = new JLabel("Fecha Nacimiento (Formato yyyy-mm-dd):");
		
		pNombrelbl = new JLabel("");
		pApellidolbl = new JLabel("");
		pGenerolbl = new JLabel("");
		pDnilbl = new JLabel("");
		pFechaNaclbl = new JLabel("");
		
		
		
		this.add(nombrelbl);
		this.add(pNombrelbl);
		this.add(apellidolbl);
		this.add(pApellidolbl);
		this.add(generolbl);
		this.add(pGenerolbl);
		this.add(dnilbl);
		this.add(pDnilbl);
		this.add(fechaNaclbl);
		this.add(pFechaNaclbl);
		
		
		
	}

	public JLabel getpNombrelbl() {
		return pNombrelbl;
	}

	public void setpNombrelbl(JLabel pNombrelbl) {
		this.pNombrelbl = pNombrelbl;
	}

	public JLabel getpApellidolbl() {
		return pApellidolbl;
	}

	public void setpApellidolbl(JLabel pApellidolbl) {
		this.pApellidolbl = pApellidolbl;
	}

	public JLabel getpGenerolbl() {
		return pGenerolbl;
	}

	public void setpGenerolbl(JLabel pGenerolbl) {
		this.pGenerolbl = pGenerolbl;
	}

	public JLabel getpDnilbl() {
		return pDnilbl;
	}

	public void setpDnilbl(JLabel pDnilbl) {
		this.pDnilbl = pDnilbl;
	}

	public JLabel getpFechaNaclbl() {
		return pFechaNaclbl;
	}

	public void setpFechaNaclbl(JLabel pFechaNaclbl) {
		this.pFechaNaclbl = pFechaNaclbl;
	}
	
	

}
