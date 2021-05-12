package com.rgg.dto;

/**
 * @author rgg
 * 
 */
public class PacienteDTO implements Comparable<PacienteDTO> {
	
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int edad;
	
	/**
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param edad
	 */
	public PacienteDTO(String nombre, String apellido1, String apellido2, int edad) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.edad = edad;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the apellido1
	 */
	public String getApellido1() {
		return apellido1;
	}
	/**
	 * @param apellido1 the apellido1 to set
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	/**
	 * @return the apellido2
	 */
	public String getApellido2() {
		return apellido2;
	}
	/**
	 * @param apellido2 the apellido2 to set
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	/**
	 * @return the edad
	 */
	public Integer getEdad() {
		return edad;
	}
	/**
	 * @param edad the edad to set
	 */
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	/**
	 *
	 */
	@Override
	public int compareTo(PacienteDTO o) {
		if(this.edad > o.getEdad()) {
			return 1;
		}
		else if(this.edad == o.getEdad())
			return 0;
		else {
			return -1;
		}
	}
}
