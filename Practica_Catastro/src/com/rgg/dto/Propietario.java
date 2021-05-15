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
	private Integer superficieTotal;
	
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
	 * Compara el tamaño de las listas de fincas de los propietarios y las ordena de menor a mayor
	 * @return -1 si la lista es mayor
	 * @return 0 si la lista es del mismo tamaño
	 * @return 1 si la lista es menor
	 */
	@Override
	public int compareTo(Propietario o) {
		if(fincas.size() > o.getFincas().size()) {
			return -1;
		}
		else if(fincas.size() == o.getFincas().size()) {
			return 0;
		}
		else {
			return 1;
		}
	}
	
}
