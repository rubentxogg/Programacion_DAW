package com.rgg.animales;

/**
 * @author 20207
 *
 */
public class Leon extends Felino{
	
	/**
	 * @param imagen
	 * @param hambre
	 * @param limites
	 * @param localizacion
	 */
	public Leon(String imagen, int hambre, int[][] limites, int[] localizacion) {
		super(imagen, hambre, limites, localizacion);
	}

	/**
	 * 
	 */
	public Leon() {
		super();
	}
	
	/**
	 *
	 */
	@Override
	public String come() {
		return "El león come carne";
	}
	
	/**
	 *
	 */
	@Override
	public String hazRuido() {
		return "El león ruge";
	}
}
