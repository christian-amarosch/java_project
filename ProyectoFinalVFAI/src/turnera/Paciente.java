package turnera;

import java.time.LocalDate;
import java.util.Objects;

public class Paciente {
	
	//private static int id_global = 0;
	private int id;
	private String nombre;
	private String apellido;
	private String genero;
	private int dni;
	private LocalDate fechaNac;
	
	public Paciente(String nombre, String apellido, String genero, int dni, LocalDate fechaNac) {
		//this.id = Paciente.id_global;
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.dni = dni;
		this.fechaNac = fechaNac;
		
		//Paciente.id_global++;
	}
	
	/*
	public Paciente(int id, String nombre, String apellido, String genero, int dni, LocalDate fechaNac) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.dni = dni;
		this.fechaNac = fechaNac;
	}
	*/
	
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getDNI() {
		return dni;
	}

	public void setDNI(int dni) {
		this.dni = dni;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	
	


}
