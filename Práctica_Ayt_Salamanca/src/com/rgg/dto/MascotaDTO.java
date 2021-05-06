package com.rgg.dto;

/**
 * @author Rubentxo
 * Data transfer object
 */
public class MascotaDTO {
	
	// Datos mascota
	private String nombre;
	private int edad;
	private String especie;
	
	/**
	 * Constructor vacío de la clase
	 */
	public MascotaDTO() {
		
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
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return the especie
	 */
	public String getEspecie() {
		return especie;
	}

	/**
	 * @param especie the especie to set
	 */
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
}
