package com.rgg.animales;

/**
 * @author 20207
 *
 */
public class Mono extends Animal{

	/**
	 * @param imagen
	 * @param hambre
	 * @param limites
	 * @param localizacion
	 */
	public Mono(String imagen, int hambre, int[][] limites, int[] localizacion) {
		super(imagen, hambre, limites, localizacion);
	}
	
	/**
	 * 
	 */
	public Mono() {
		super();
	}
	
	/**
	 *
	 */
	@Override
	public String come() {
		return "El mono come plátanos";
	}
	
	/**
	 *
	 */
	@Override
	public String hazRuido() {
		return "El mono chilla";
	}
}
