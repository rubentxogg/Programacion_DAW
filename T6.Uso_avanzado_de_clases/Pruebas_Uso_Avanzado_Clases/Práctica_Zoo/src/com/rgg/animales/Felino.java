/**
 * 
 */
package com.rgg.animales;

/**
 * @author 20207
 *
 */
public class Felino extends Animal{

	/**
	 * @param imagen
	 * @param hambre
	 * @param limites
	 * @param localizacion
	 */
	public Felino(String imagen, int hambre, int[][] limites, int[] localizacion) {
		super(imagen, hambre, limites, localizacion);
	}
	
	/**
	 * 
	 */
	public Felino() {
		super();
	}

	/**
	 *
	 */
	@Override
	public String vagabundea() {
		return "Son solitarios";
	}
}
