package turnera;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import excepciones.ServiceException;


public class PanelListaPacientes extends JPanel {
	private PanelManager panelManager;
	private JTable tablaPacientes;
	private PacienteTableModel modelo;
	
	private JScrollPane scrollPaneParaTabla;
	private JButton crearBtn;
	private JButton editarBtn;
	private JButton borrarBtn;
	private JButton buscarBtn;
	private JButton volverBtn;
	
	
	public PanelListaPacientes(PanelManager manager, PacienteTableModel modelo) {
		super();
		this.panelManager = manager;
		this.modelo = modelo;
		armarPanelLista();
	}
	
	public void armarPanelLista() {
		this.setLayout(new FlowLayout());
		
		tablaPacientes = new JTable(modelo);
		scrollPaneParaTabla = new JScrollPane(tablaPacientes);
		this.add(scrollPaneParaTabla);
		
		crearBtn = new JButton("Crear");
		crearBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelManager.mostrarPanelAltaPaciente();
			}
		});
		this.add(crearBtn);
		
		editarBtn = new JButton("Editar");
		editarBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				int filaSeleccionada = tablaPacientes.getSelectedRow();
				if(filaSeleccionada == -1) {
					JPanel panel = new JPanel();
					JOptionPane.showMessageDialog(panel, "No se ha seleccionado a ningun paciente", "Aviso", JOptionPane.PLAIN_MESSAGE);
				} else {
					Paciente edit = modelo.getPacientes().get(filaSeleccionada);
					panelManager.mostrarPanelEditarPaciente(edit);
				}
				
			}
		});
		this.add(editarBtn);
		
		borrarBtn = new JButton("Eliminar");
		borrarBtn.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			int filaSeleccionada = tablaPacientes.getSelectedRow();
			if(filaSeleccionada == -1) {
				JPanel panel = new JPanel();
				JOptionPane.showMessageDialog(panel, "No se ha seleccionado a ningun paciente", "Aviso", JOptionPane.PLAIN_MESSAGE);
			} else {
				Paciente eliminar = modelo.getPacientes().get(filaSeleccionada);
				panelManager.mostrarPanelEliminarPaciente(eliminar);
			}
			
		}
		});
		this.add(borrarBtn);
		
		buscarBtn = new JButton("Buscar");
		buscarBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelManager.mostrarPanelBuscarPaciente();
			}
		});
		this.add(buscarBtn);
		
		volverBtn = new JButton("Volver");
		volverBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelManager.mostrarPanelInicio();
			}
		});
		this.add(volverBtn);
		
		
		
	}

}
