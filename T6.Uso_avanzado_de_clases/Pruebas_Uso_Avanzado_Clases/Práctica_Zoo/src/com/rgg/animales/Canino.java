package com.rgg.animales;

/**
 * @author 20207
 *
 */
public class Canino extends Animal{

	/**
	 * @param imagen
	 * @param hambre
	 * @param limites
	 * @param localizacion
	 */
	public Canino(String imagen, int hambre, int[][] limites, int[] localizacion) {
		super(imagen, hambre, limites, localizacion);
	}
	
	/**
	 * 
	 */
	public Canino() {
		super();
	}
	
	/**
	 *
	 */
	@Override
	public String vagabundea() {
		return "Tienden a ir en grupos";
	}
}
