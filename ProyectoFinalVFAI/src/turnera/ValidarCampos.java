package turnera;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import excepciones.*;

public class ValidarCampos {
	
	public static void validarCampoTexto(String s) throws CampoTextoException {
		
		String regex = "^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+$";
		if(s.isEmpty() || s == null) {
			throw new CampoTextoException("Campo vacio");
		}
		if(!(s != null && s.matches(regex))) {
			throw new CampoTextoException("El valor ingresado no es valido");
		}
	}
	
	public static void validarCampoGenero(String s) throws CampoGeneroException {
		if(s.isEmpty() || s == null) {
			throw new CampoGeneroException("Campo vacio");
		}
		if(!(s.equalsIgnoreCase("m") || s.equalsIgnoreCase("f"))){
			throw new CampoGeneroException("El valor ingresado no es valido");
		}
	}
	
	public static void validarCampoDni(String s) throws CampoDNIException {
		if(s.isEmpty() || s == null) {
			throw new CampoDNIException("Campo vacio");
		}
		if(!(s.matches("\\d+"))) {
			throw new CampoDNIException("El valor ingresado no es valido");
		}
	}
	
	public static void validarCampoFechaNac(String s) throws CampoFechaNacException {
		String regex = "^\\d{4}-\\d{2}-\\d{2}$";
		if(s.isEmpty() || s == null) {
			throw new CampoFechaNacException("Campo vacio");
		}
		if (!s.matches(regex)) {
			throw new CampoFechaNacException("Fecha no valida");
        }
		try {
            LocalDate.parse(s); // Si la fecha no es válida, lanzará DateTimeParseException
        } catch (DateTimeParseException e) {
            throw new CampoFechaNacException("Fecha no valida");
        }
	}
	
	public static void validarCampoMatricula(String s) throws CampoMatriculaException {
		if(s.isEmpty() || s == null) {
			throw new CampoMatriculaException("Campo vacio");
		}
		if(!(s.matches("\\d+"))) {
			throw new CampoMatriculaException("El valor ingresado no es valido");
		}
		if(s.length() != 5) {
			throw new CampoMatriculaException("El valor ingresado debe poseer 5 numeros");
		}
	}
	
	public static void validarCampoVConsulta(String s) throws CampoVConsultaException {
		if(s.isEmpty() || s == null) {
			throw new CampoVConsultaException("Campo vacio");
		}
		if(!(s.matches("\\d+"))) {
			throw new CampoVConsultaException("El valor ingresado no es valido");
		}
		try {
			float num = Float.parseFloat(s);
			if (num < 0) {
				throw new CampoVConsultaException("El valor ingresado no es valido");
			}
			
		} catch (Exception e) {
			throw new CampoVConsultaException("El valor ingresado no es valido");
		}
		
	}
	
	public static void validarCamposPaciente(String nombre, String apellido, String genero, String dni, String fechaNac) throws CampoNombreException, CampoApellidoException, CampoGeneroException, CampoDNIException, CampoFechaNacException {
		try {
			validarCampoTexto(nombre);
		} catch (CampoTextoException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new CampoNombreException();
		}
		try {
			validarCampoTexto(apellido);
		} catch (CampoTextoException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new CampoApellidoException();
		}
		validarCampoGenero(genero);
		validarCampoDni(dni);
		validarCampoFechaNac(fechaNac);
	}

	public static void validarCamposMedico(String nombre, String apellido, String matricula, String valorConsulta) throws CampoNombreException, CampoApellidoException, CampoMatriculaException, CampoVConsultaException {
		// TODO Auto-generated method stub
		try {
			validarCampoTexto(nombre);
		} catch (CampoTextoException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new CampoNombreException();
		}
		try {
			validarCampoTexto(apellido);
		} catch (CampoTextoException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new CampoApellidoException();
		}
		validarCampoMatricula(matricula);
		validarCampoVConsulta(valorConsulta);
	}
		
}
	


