package com.rgg.dto;

public class Siniestro {
	
	private int idCliente;
	private String nombre;
	private String ciudadResidencia;
	private String descripcion;

	/**
	 * 
	 */
	public Siniestro() {
		
	}
	
	/**
	 * @param idCliente
	 * @param nombre
	 * @param ciudadResidencia
	 * @param descripcion
	 */
	public Siniestro(int idCliente, String nombre, String ciudadResidencia, String descripcion) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.ciudadResidencia = ciudadResidencia;
		this.descripcion = descripcion;
	}
	
	/**
	 * @return the idCliente
	 */
	public int getIdCliente() {
		return idCliente;
	}
	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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
	 * @return the ciudadResidencia
	 */
	public String getCiudadResidencia() {
		return ciudadResidencia;
	}
	/**
	 * @param ciudadResidencia the ciudadResidencia to set
	 */
	public void setCiudadResidencia(String ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
