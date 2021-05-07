package com.rgg.main;

import com.rgg.animales.*;

/**
 * @author 20207
 *
 */
public class Zoo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Animal animales[] = new Animal[5];
		
		animales[0] = new Perro();
		animales[1] = new Gato();
		animales[2] = new Leon();
		animales[3] = new Lobo();
		animales[4] = new Mono();
		
		for(int i=0; i<animales.length; i++) {
			System.out.println(animales[i].come()+"\n"+animales[i].vagabundea()+"\n");
		}
	}
}
