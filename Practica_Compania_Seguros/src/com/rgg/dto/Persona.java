package com.rgg.dto;

public class Persona {

	private Integer id;
	private Integer edad;
	private Coche coche;
	
	
	/**
	 * @param id
	 * @param edad
	 */
	public Persona(Integer id, Integer edad) {
		this.id = id;
		this.edad = edad;
	}
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * @return the coche
	 */
	public Coche getCoche() {
		return coche;
	}
	/**
	 * @param coche the coche to set
	 */
	public void setCoche(Coche coche) {
		this.coche = coche;
	}
	
	@Override
	public String toString() {
		return "Persona [id=" + id + ", edad=" + edad + ", coche=" + coche + "]";
	}
}
