package com.rgg.dto;

/**
 * @author Rubentxo
 *
 */
public class EmpleadoDTO {

	private int numeroEmpleado;
	private String apellido;
	private String nombre;
	private String extension;
	private String puesto;
	
	/**
	 * @param numeroEmpleado
	 * @param apellido
	 * @param nombre
	 * @param extension
	 * @param puesto
	 */
	public EmpleadoDTO(int numeroEmpleado, String apellido, String nombre, String extension, String puesto) {
		super();
		this.numeroEmpleado = numeroEmpleado;
		this.apellido = apellido;
		this.nombre = nombre;
		this.extension = extension;
		this.puesto = puesto;
	}

	/**
	 * @return the numeroEmpleado
	 */
	public int getNumeroEmpleado() {
		return numeroEmpleado;
	}

	/**
	 * @param numeroEmpleado the numeroEmpleado to set
	 */
	public void setNumeroEmpleado(int numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
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
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * @param extension the extension to set
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}

	/**
	 * @return the puesto
	 */
	public String getPuesto() {
		return puesto;
	}

	/**
	 * @param puesto the puesto to set
	 */
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
}
