package turnera;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelListaMedicos extends JPanel {
	
	private PanelManager panelManager;
	private JTable tablaMedicos;
	private MedicoTableModel modelo;
	
	private JScrollPane scrollPaneParaTabla;
	private JButton crearBtn;
	private JButton editarBtn;
	private JButton borrarBtn;
	private JButton buscarBtn;
	private JButton volverBtn;
	
	
	public PanelListaMedicos(PanelManager manager, MedicoTableModel modelo) {
		super();
		this.panelManager = manager;
		this.modelo = modelo;
		armarPanelLista();
	}
	
	public void armarPanelLista() {
		this.setLayout(new FlowLayout());
		
		tablaMedicos = new JTable(modelo);
		scrollPaneParaTabla = new JScrollPane(tablaMedicos);
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
				int filaSeleccionada = tablaMedicos.getSelectedRow();
				if(filaSeleccionada == -1) {
					JPanel panel = new JPanel();
					JOptionPane.showMessageDialog(panel, "No se ha seleccionado a ningun medico", "Aviso", JOptionPane.PLAIN_MESSAGE);
				} else {
					Medico edit = modelo.getMedicos().get(filaSeleccionada);
					panelManager.mostrarPanelEditarMedico(edit);
				}
				
			}
		});
		this.add(editarBtn);
		
		borrarBtn = new JButton("Eliminar");
		borrarBtn.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			int filaSeleccionada = tablaMedicos.getSelectedRow();
			if(filaSeleccionada == -1) {
				JPanel panel = new JPanel();
				JOptionPane.showMessageDialog(panel, "No se ha seleccionado a ningun paciente", "Aviso", JOptionPane.PLAIN_MESSAGE);
			} else {
				Medico eliminar = modelo.getMedicos().get(filaSeleccionada);
				panelManager.mostrarPanelEliminarMedico(eliminar);
			}
			
		}
		});
		this.add(borrarBtn);
		
		buscarBtn = new JButton("Buscar");
		buscarBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelManager.mostrarPanelBuscarMedico();
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
