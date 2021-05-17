package com.rgg.dto;

/**
 * @author Rubentxo
 * Clase data transform object
 */
public class Finca {

	private String localidad;
	private Integer superficie;
	
	/**
	 * Constructor
	 */
	public Finca() {
		super();
	}
	
	/**
	 * @return the localidad
	 */
	public String getLocalidad() {
		return localidad;
	}
	/**
	 * @param localidad the localidad to set
	 */
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	/**
	 * @return the superficie
	 */
	public Integer getSuperficie() {
		return superficie;
	}
	/**
	 * @param superficie the superficie to set
	 */
	public void setSuperficie(Integer superficie) {
		this.superficie = superficie;
	}
	
}
