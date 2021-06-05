package com.rgg.dto;

/**
 * @author Rubentxo
 *
 */
public class LineaProductoDTO {
	
	private String nombre;
	private String descripcion;
	
	/**
	 * @param nombre
	 * @param descripcion
	 */
	public LineaProductoDTO(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
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
