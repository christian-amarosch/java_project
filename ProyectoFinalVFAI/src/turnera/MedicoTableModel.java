package turnera;

import java.time.LocalDate;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import excepciones.ServiceException;
import excepciones.UIException;

public class MedicoTableModel extends AbstractTableModel {
	
	//Indices de las columnas
		private static final int COLUMNA_MATRICULA = 0;
		private static final int COLUMNA_NOMBRE = 1;
		private static final int COLUMNA_APELLIDO = 2;
		private static final int COLUMNA_VALOR= 3;
		//Nombre de los encabezados
		private String[] nombresColumnas = {"Matricula", "Nombre", "Apellido","Valor_Consulta"};
		
		private Class[] tiposColumnas = {Integer.class, String.class, String.class, Float.class};
		
		private List<Medico> medicos;
		
		private List<Integer> matriculas;
		
		private MedicoService medicosrv;
		
		
		public MedicoTableModel() throws UIException {
			this.medicosrv = new MedicoService();
			this.setMedicos();
			this.setMatriculas();
		}
		
		@Override
		public int getColumnCount() {
			return nombresColumnas.length;
		}
		
		@Override
		public int getRowCount() {
			return medicos.size();
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
			
			Medico m = medicos.get(rowIndex);
			
			Object result = null;
			
			switch(columnIndex) {
			case COLUMNA_MATRICULA:
				result = m.getMatricula();
				break;
			case COLUMNA_NOMBRE:
				result = m.getNombre();
				break;
			case COLUMNA_APELLIDO:
				result = m.getApellido();
				break;
			case COLUMNA_VALOR:
				result = m.getvalorConsulta();
				break;
			default:
				result = new String("default");
			}
			
			return result;
			
		}
		
		public void setMedicos() throws UIException {
			try {
				this.medicos = medicosrv.listarMedicos();
				fireTableDataChanged();
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				throw new UIException();
			}
		}
		
		public List<Medico> getMedicos() {
			return medicos;
		}
		
		public void addMedico(Medico m) {
			this.medicos.add(m);
			this.matriculas.add(m.getMatricula());
			fireTableDataChanged();
		}
		
		
		public void modMedico(int i_matricula, Medico m, int index) {
			if((medicos.get(index)).getMatricula() != m.getMatricula()) {
				Integer matricula = medicos.get(index).getMatricula();
				matriculas.remove(matricula);
				matriculas.add(m.getMatricula());
			}
			this.medicos.set(index, m);
			fireTableDataChanged();
			
		}
		
		public void eliminarMedico(int matricula, int index) {
			this.medicos.remove(index);
			this.medicos.remove(Integer.valueOf(matricula));
			fireTableDataChanged();
		}
		
		public List<Integer> getMatriculas(){
			return this.matriculas;
		}
		
		private void setMatriculas() throws UIException {
			try {
				this.matriculas = medicosrv.listarMatriculas();
				fireTableDataChanged();
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				throw new UIException();
			}
		}

		

}
