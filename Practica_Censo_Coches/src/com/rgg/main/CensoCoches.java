package com.rgg.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.rgg.constantes.Constantes;
import com.rgg.dto.Coche;

public class CensoCoches {
	
	static List<Coche> listaCoches = new ArrayList<>();
	
	// Método main
	public static void main(String[] args) throws IOException {
		leerFicheroCoches(Constantes.LISTA_COCHES);
		mostrarCochesSalamanca();
	}

	/**
	 * Muestra la lista de coches de Salamanca sin duplicados
	 */
	private static void mostrarCochesSalamanca() {
		HashSet<Coche> cocheSet = new HashSet<>(listaCoches);
		
		System.out.println("Coches existentes en la ciudad de Salamanca:\n");
		
		for(Coche c : cocheSet) {
			System.out.println(c.toString());
		}
	}

	/**
	 * Lee el fichero de coches y los añade a la lista
	 * @param URI del fichero de coches
	 * @throws IOException
	 */
	private static void leerFicheroCoches(String ficheroCoches) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(ficheroCoches, StandardCharsets.UTF_8));) {
			String linea;
			
			while((linea = br.readLine()) != null) {
				new CensoCoches().anadeCoche(linea);
			}
		}
	}
	
	/**
	 * Añade coches a la lista
	 * @param linea
	 */
	private void anadeCoche(String linea) {
		String[] arrayCoches = linea.split(";");
		Coche coche = new Coche(arrayCoches[0], arrayCoches[1], arrayCoches[2]);
		listaCoches.add(coche);
	}
}
