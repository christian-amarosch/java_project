package turnera;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.*;
import excepciones.*;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;


public class PacienteTableModel extends AbstractTableModel {

	
	//Indices de las columnas
	//private static final int COLUMNA_ID = 0;
	private static final int COLUMNA_NOMBRE = 0;
	private static final int COLUMNA_APELLIDO = 1;
	private static final int COLUMNA_GENERO = 2;
	private static final int COLUMNA_DNI = 3;
	private static final int COLUMNA_FECHANAC = 4;
	
	//Nombre de los encabezados
	private String[] nombresColumnas = {"Nombre", "Apellido","Genero", "DNI", "Fecha_Nac"};
	
	private Class[] tiposColumnas = {String.class, String.class, String.class, Integer.class, LocalDate.class};
	
	private List<Paciente> pacientes;
	
	private List<Integer> dnis;
	
	private PacienteService pacientesrv;
	
	
	public PacienteTableModel() throws UIException {
		this.pacientesrv = new PacienteService();
		this.setPacientes();
		this.setDnis();
	}
	
	@Override
	public int getColumnCount() {
		return nombresColumnas.length;
	}
	
	@Override
	public int getRowCount() {
		return pacientes.size();
	}
	
	@Override
	public String getColumnName(int col) {
		return nombresColumnas[col];
	}
	
	@Override
	public Class getColumnClass(int col) {
		return tiposColumnas[col];
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Paciente p = pacientes.get(rowIndex);
		
		Object result = null;
		
		switch(columnIndex) {
		case COLUMNA_NOMBRE:
			result = p.getNombre();
			break;
		case COLUMNA_APELLIDO:
			result = p.getApellido();
			break;
		case COLUMNA_GENERO:
			result = p.getGenero();
			break;
		case COLUMNA_DNI:
			result = p.getDNI();
			break;
		case COLUMNA_FECHANAC:
			result = p.getFechaNac();
			break;
		default:
			result = new String("default");
		}
		
		return result;
		
	}
	
	public void setPacientes() throws UIException {
		try {
			this.pacientes = pacientesrv.listarPacientes();
			fireTableDataChanged();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new UIException();
		}
	}
	
	public List<Paciente> getPacientes() {
		return pacientes;
	}
	
	public void addPaciente(Paciente p) throws UIException {
		try {
			pacientesrv.crearPaciente(p);
			this.pacientes.add(p);
			this.dnis.add(p.getDNI());
			fireTableDataChanged();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new UIException("No se pudo crear al paciente");
		}
	}
	
	public Paciente showPaciente(int dni) throws UIException{
		try {
			Paciente p = pacientesrv.muestraPaciente(dni);
			return p;
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new UIException("No se pudo buscar al paciente");
		}
	}
	
	public void modPaciente(int i_dni, Paciente p, int index) throws UIException {
		try {
			pacientesrv.actualizarPaciente(i_dni, p);
			if((pacientes.get(index)).getDNI() != p.getDNI()) {
				Integer dni = pacientes.get(index).getDNI();
				dnis.remove(dni);
				dnis.add(p.getDNI());
			}
			this.pacientes.set(index, p);
			fireTableDataChanged();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new UIException("No se pudo actualizar al paciente");
		}
		
	}
	
	public void eliminarPaciente(int dni, int index) throws UIException {
		try {
			pacientesrv.borrarPaciente(dni);
			this.pacientes.remove(index);
			this.dnis.remove(Integer.valueOf(dni));
			fireTableDataChanged();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new UIException("No se pudo borrar al paciente");
		}
		
	}
	
	public List<Integer> getDnis(){
		return this.dnis;
	}
	
	private void setDnis() throws UIException {
		try {
			this.dnis = pacientesrv.listarDNIs();
			fireTableDataChanged();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new UIException();
		}
	}

	

}
