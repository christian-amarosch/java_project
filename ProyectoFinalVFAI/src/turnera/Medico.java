package turnera;

import java.util.List;


public class Medico {

	private int matricula;
	private String nombre;
	private String apellido;
	private float valorConsulta;
	//private List<Turno> Turnos;

	public Medico(int matricula, String nombre, String apellido, float valorConsulta) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.matricula = matricula;
		this.valorConsulta = valorConsulta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public float getvalorConsulta() {
		return valorConsulta;
	}

	public void setValorConsulta(float valorConsulta) {
		this.valorConsulta = valorConsulta;
	}

}