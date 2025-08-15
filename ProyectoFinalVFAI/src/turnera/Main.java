package turnera;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import excepciones.ServiceException;
import excepciones.UIException;


public class Main {
	
	private PanelManager manager;
	private TableManager tbmanager;

	public static void main(String[] args) {
		
		Main main = new Main();
		main.crearTabla();
		main.iniciarManager();
		main.showFrame();
		
	}
	
	public void crearTabla() {
		tbmanager = new TableManager();
		tbmanager.createPacienteTable();
	}

	public void iniciarManager() {
		try {
			manager = new PanelManager();
			manager.armarManager();
			manager.mostrarPanelInicio();
			
		} catch (UIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JPanel panel = new JPanel();
			JOptionPane.showMessageDialog(panel, "No se ha podido cargar la aplicacion", "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
	}
	
	public void showFrame() {
		manager.showFrame();
	}

}
