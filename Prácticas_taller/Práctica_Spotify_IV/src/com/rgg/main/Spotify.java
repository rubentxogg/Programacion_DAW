package com.rgg.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author rgg
 *
 */
public class Spotify {
	
	static List<String> canciones = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\20207\\Desktop\\listacanciones.txt"));) {
			String linea;
			
			while((linea = br.readLine()) != null) {
				new Spotify().anadeCancion(linea);
			}
		}
		
		new Spotify().dale();
	}
	
	/**
	 * @param linea
	 */
	private void anadeCancion(String linea) {
		String[] arrayCanciones = linea.split("-");
		canciones.add(arrayCanciones[0]);
	}
	
	/**
	 * 
	 */
	private void dale() {
		Collections.sort(canciones);
		System.out.println(canciones);
	}
}
