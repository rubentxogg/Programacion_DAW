package com.rgg.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.rgg.cancion.Cancion;
import com.rgg.comparator.CompararArtista;
import com.rgg.comparator.CompararUsuario;

/**
 * @author rgg
 *
 */
public class Spotify2 {
	
	static List<Cancion> canciones = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\20207\\Desktop\\listacanciones.txt", StandardCharsets.UTF_8));) {
			String linea;
			
			while((linea = br.readLine()) != null) {
				new Spotify2().anadeCancion(linea);
			}
		}
		
//		new Spotify2().dale();
		
		// Añadimos HasSet
		HashSet<Cancion> cancionSet = new HashSet<>(canciones);
		
		// Otra opción:
		// HashSet<Cancion> cancionSet = new HashSet<Cancion>();
		// cancionSet.addAll(canciones);
	
		
		// Vemos que no nos elimina los duplicados
		for(Cancion c : cancionSet) {
			System.out.println(c.toString());
			System.out.println(c.hashCode());
			System.out.println();
		}
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
		Scanner sc = new Scanner(System.in);
		System.out.println("Ordenar por: \n1.Título\n2.Artista\n3.Usuario");
		int opc = sc.nextInt();
		
		switch(opc) {
			case 1: Collections.sort(canciones);
					break;
			case 2: Collections.sort(canciones, new CompararArtista());
					break;
			case 3: Collections.sort(canciones, new CompararUsuario());
					break;
		}
		
		Iterator<Cancion> i = canciones.iterator();
		while(i.hasNext()) {
			Cancion c = i.next();
			System.out.println("Canción: "+c.getTitulo()+" | Artista: "+c.getArtista()+" | Usuario: "+c.getUsuario());
		}
	}
}