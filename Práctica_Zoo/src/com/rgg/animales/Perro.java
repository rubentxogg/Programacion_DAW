/**
 * 
 */
package com.rgg.animales;

/**
 * @author 20207
 *
 */
public class Perro extends Canino {

	/**
	 * @param imagen
	 * @param hambre
	 * @param limites
	 * @param localizacion
	 */
	public Perro(String imagen, int hambre, int[][] limites, int[] localizacion) {
		super(imagen, hambre, limites, localizacion);
	}
	
	/**
	 * 
	 */
	public Perro() {
		super();
	}
	
	/**
	 *
	 */
	@Override
	public String come() {
		return "El perro come wiskas";
	}
	
	/**
	 *
	 */
	@Override
	public String hazRuido() {
		return "El perro ladra";
	}
}
