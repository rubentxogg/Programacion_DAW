/**
 * 
 */
package com.rgg.animales;

/**
 * @author 20207
 *
 */
public class Gato extends Felino {

	/**
	 * @param imagen
	 * @param hambre
	 * @param limites
	 * @param localizacion
	 */
	public Gato(String imagen, int hambre, int[][] limites, int[] localizacion) {
		super(imagen, hambre, limites, localizacion);
	}
	
	/**
	 * 
	 */
	public Gato() {
		super();
	}
	
	/**
	 *
	 */
	@Override
	public String come() {
		return "El gato come pienso";
	}
	
	/**
	 *
	 */
	@Override
	public String hazRuido() {
		return "El gato maulla";
	}
}
