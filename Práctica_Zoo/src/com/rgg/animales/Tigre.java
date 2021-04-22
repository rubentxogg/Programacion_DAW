package com.rgg.animales;

/**
 * @author 20207
 *
 */
public class Tigre extends Felino {

	/**
	 * @param imagen
	 * @param hambre
	 * @param limites
	 * @param localizacion
	 */
	public Tigre(String imagen, int hambre, int[][] limites, int[] localizacion) {
		super(imagen, hambre, limites, localizacion);
	}
	
	/**
	 * 
	 */
	public Tigre() {
		super();
	}
	
	/**
	 *
	 */
	@Override
	public String come() {
		return "El tigre come carne";
	}
	
	/**
	 *
	 */
	@Override
	public String hazRuido() {
		return "El tigre ruge";
	}

}
