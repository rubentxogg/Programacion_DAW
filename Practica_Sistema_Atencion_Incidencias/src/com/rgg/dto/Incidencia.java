package com.rgg.dto;

/**
 * @author rgg
 *
 */
public class Incidencia implements Comparable<Incidencia>{
	
	private String asunto;
	private String descripcion;
	private Integer gravedad;
	
	/**
	 * @param asunto
	 * @param descripcion
	 * @param gravedad
	 */
	public Incidencia(String asunto, String descripcion, Integer gravedad) {
		this.asunto = asunto;
		this.descripcion = descripcion;
		this.gravedad = gravedad;
	}
	
	/**
	 * @return the asunto
	 */
	public String getAsunto() {
		return asunto;
	}
	/**
	 * @param asunto the asunto to set
	 */
	public void setAsunto(String asunto) {
		this.asunto = asunto;
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
	/**
	 * @return the gravedad
	 */
	public Integer getGravedad() {
		return gravedad;
	}
	/**
	 * @param gravedad the gravedad to set
	 */
	public void setGravedad(Integer gravedad) {
		this.gravedad = gravedad;
	}
	
	@Override
	public String toString() {
		return "Incidencia [asunto=" + asunto + ", descripcion=" + descripcion + ", gravedad=" + gravedad + "]";
	}
	
	@Override
	public int compareTo(Incidencia i) {
		return this.getGravedad().compareTo(i.getGravedad());
	}
}
