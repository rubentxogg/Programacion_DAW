package com.rgg.animales;

/**
 * @author rgg
 *
 */
public class Animal {
	private String imagen;
	private int hambre;
	private int[][] limites;
	private int[] localizacion;
	
	/**
	 * @param imagen
	 * @param hambre
	 * @param limites
	 * @param localizacion
	 */
	public Animal(String imagen, int hambre, int[][] limites, int[] localizacion){
		this.imagen = imagen;
		this.hambre = hambre;
		this.limites = limites;
		this.localizacion = localizacion;
	}
	
	/**
	 * 
	 */
	public Animal() {
		
	}
	
	/**
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}
	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	/**
	 * @return the hambre
	 */
	public int getHambre() {
		return hambre;
	}
	/**
	 * @param hambre the hambre to set
	 */
	public void setHambre(int hambre) {
		this.hambre = hambre;
	}
	/**
	 * @return the limites
	 */
	public int[][] getLimites() {
		return limites;
	}
	/**
	 * @param limites the limites to set
	 */
	public void setLimites(int[][] limites) {
		this.limites = limites;
	}
	/**
	 * @return the localizacion
	 */
	public int[] getLocalizacion() {
		return localizacion;
	}
	/**
	 * @param localizacion the localizacion to set
	 */
	public void setLocalizacion(int[] localizacion) {
		this.localizacion = localizacion;
	}
	
	/**
	 * @param ruido
	 * @return
	 */
	public String hazRuido() {
		return "El animal hace ruido";
	}
	
	/**
	 * @param comida
	 * @return
	 */
	public String come() {
		return "El animal come comida";
	}
	
	/**
	 * @param duerme
	 * @return
	 */
	public String duerme() {
		return "El animal duerme";
	}
	
	/**
	 * @param comportamiento
	 * @return
	 */
	public String vagabundea() {
		return "El animal vagabundea";
	}
}
