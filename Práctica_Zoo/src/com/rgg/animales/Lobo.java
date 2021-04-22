/**
 * 
 */
package com.rgg.animales;

/**
 * @author 20207
 *
 */
public class Lobo extends Canino {

	/**
	 * @param imagen
	 * @param hambre
	 * @param limites
	 * @param localizacion
	 */
	public Lobo(String imagen, int hambre, int[][] limites, int[] localizacion) {
		super(imagen, hambre, limites, localizacion);
	}
	
	/**
	 * 
	 */
	public Lobo() {
		super();
	}

	/**
	 *
	 */
	@Override
	public String come() {
		return "El lobo come carne";
	}
	
	/**
	 *
	 */
	@Override
	public String hazRuido() {
		return "El lobo aúlla";
	}
}
