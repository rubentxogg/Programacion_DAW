package com.rgg.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rubentxo
 * Clase data transform object
 */
public class Propietario implements Comparable<Propietario>{
	
	private String nombre;
	private Integer edad;
	private String localidad;
	private List<Finca> fincas = new ArrayList<>();
	private Integer superficieTotal = 0;
	
	/**
	 * Constructor 
	 */
	public Propietario() {
		super();
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
	 * @return the fincas
	 */
	public List<Finca> getFincas() {
		return fincas;
	}
	/**
	 * @param fincas the fincas to set
	 */
	public void setFincas(List<Finca> fincas) {
		this.fincas = fincas;
	}
	
	/**
	 * @return the superficieTotal
	 */
	public Integer getSuperficieTotal() {
		return superficieTotal;
	}
	
	/**
	 * @param superficieTotal the superficieTotal to set
	 */
	public void setSuperficieTotal(Integer superficieTotal) {
		this.superficieTotal = superficieTotal;
	}
	
	/**
	 * Compara la superficie total de las fincas de los propietarios y las ordena de mayor a menor
	 * @return -1 si la superficie total es mayor
	 * @return 0 si la superficie total es del mismo tamaño
	 * @return 1 si la superficie total es menor
	 */
	@Override
	public int compareTo(Propietario o) {
		if(superficieTotal > o.getSuperficieTotal()) {
			return -1;
		}
		else if(superficieTotal.equals(o.getSuperficieTotal())) {
			return 0;
		}
		else {
			return 1;
		}
	}
	
}
