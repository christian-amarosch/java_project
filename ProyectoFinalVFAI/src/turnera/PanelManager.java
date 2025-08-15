package turnera;

import javax.swing.*;

import excepciones.ServiceException;
import excepciones.UIException;

public class PanelManager {
	private JFrame frame;
	private PantallaInicioPanel panelInicio;
	private PanelListaPacientes panelPacientes;
	private PacienteTableModel modeloPacienteTable;
	private PanelAltaPaciente altaPaciente;
	private PanelEdicionPaciente edicionPaciente;
	private PanelEliminarPaciente eliminarPaciente;
	private PanelBuscarPaciente buscarPaciente;
	private PanelPaciente mostrarPaciente;
	private PanelListaMedicos panelMedicos;
	private MedicoTableModel modeloMedicoTable;
	
	
	public PanelManager() {
	}
	
	public void armarManager() throws UIException {
		frame= new JFrame();
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelInicio = new PantallaInicioPanel(this);
		modeloPacienteTable = new PacienteTableModel();
		panelPacientes = new PanelListaPacientes(this, modeloPacienteTable);
		altaPaciente = new PanelAltaPaciente(this, modeloPacienteTable);
		edicionPaciente = new PanelEdicionPaciente(this, modeloPacienteTable);
		eliminarPaciente = new PanelEliminarPaciente(this, modeloPacienteTable);
		buscarPaciente = new PanelBuscarPaciente(this, modeloPacienteTable);
		mostrarPaciente = new PanelPaciente(this);
		modeloMedicoTable = new MedicoTableModel();
		panelMedicos = new PanelListaMedicos(this, modeloMedicoTable);
	}
	public void showFrame() {
		frame.setVisible(true);
	}
	
	public void mostrarSalir() {
		int response = JOptionPane.showConfirmDialog(frame, "Esta seguro?");
		if(response == JOptionPane.OK_OPTION) {
			System.exit(0);
		}
	}
	
	public void mostrarPanelInicio() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panelInicio);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
	public void mostrarPanelListaPacientes() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panelPacientes);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}
	
	public void mostrarPanelAltaPaciente() {
	frame.getContentPane().removeAll();
	frame.getContentPane().add(altaPaciente);
	frame.getContentPane().validate();
	frame.getContentPane().repaint();
	}

	public void mostrarPanelEditarPaciente(Paciente p) {
		edicionPaciente.setPaciente(p);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(edicionPaciente);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
		
	}
	
	public void mostrarPanelEliminarPaciente(Paciente p) {
		eliminarPaciente.setPaciente(p);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(eliminarPaciente);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
		
	}
	
	public void mostrarPanelBuscarPaciente() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(buscarPaciente);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
		
	}
	
	public void mostrarPanelPaciente(Paciente p) {
		mostrarPaciente.setPaciente(p);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(mostrarPaciente);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
		
	}
	
	public void mostrarPanelListaMedicos() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panelMedicos);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
	}

}
