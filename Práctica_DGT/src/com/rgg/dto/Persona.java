package com.rgg.dto;

/**
 * @author rgg
 * Clase persona
 */
public class Persona implements Comparable<Persona>{
	
	private String nombre;
	private String ciudad;
	private Coche coche;
	
	/**
	 * Contructor vacío de la clase
	 */
	public Persona() {
		
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
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
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

	/**
	 * Compara dos objetos coche en función de su antigüedad
	 */
	@Override
	public int compareTo(Persona o) {
		return coche.getAno().compareTo((o.getCoche().getAno()));
	}
	
}
