package com.rgg.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.rgg.cancion.Cancion;

/**
 * @author rgg
 *
 */
public class Spotify2 {
	
	static List<Cancion> canciones = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\20207\\Desktop\\listacanciones.txt"));) {
			String linea;
			
			while((linea = br.readLine()) != null) {
				new Spotify2().anadeCancion(linea);
			}
		}
		
		new Spotify2().dale();
	}
	
	/**
	 * @param linea
	 */
	private void anadeCancion(String linea) {
		String[] arrayCanciones = linea.split("-");
		Cancion cancion = new Cancion(arrayCanciones[0], arrayCanciones[1], arrayCanciones[2]);
		canciones.add(cancion);
	}
	
	/**
	 * 
	 */
	private void dale() {
//		Collections.sort();
		System.out.println(canciones);
	}
}