package com.rgg.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.rgg.constantes.Constantes;
import com.rgg.dto.Coche;
import com.rgg.dto.Persona;

/**
 * @author rgg
 * Práctica DGT
 */
public class DGT{
	
	static List<Persona> listaPersonas = new ArrayList<>();
	
	// Método main
	public static void main(String[] args) throws IOException {
		new DGT().leerFicheroPersonas(Constantes.FICHERO_PERSONAS);
		new DGT().leerFicheroCoches(Constantes.FICHERO_COCHES);
		new DGT().mostrarLista();
	}
	
	/**
	 * Lee el fichero pasado por parámetro
	 * @param fichero
	 * @throws IOException
	 */
	public void leerFicheroPersonas(String fichero) throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader(fichero, StandardCharsets.UTF_8));){
			String linea;
			
			while((linea = br.readLine()) != null) {
				new DGT().anadirPersonas(linea);
			}
		}
	}
	
	/**
	 * Lee el fichero pasado por parámetro y añade los coches a la clase persona
	 * @param fichero
	 * @throws IOException
	 */
	public void leerFicheroCoches(String fichero) throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader(fichero, StandardCharsets.UTF_8));){
			String linea;
			
			while((linea = br.readLine()) != null) {
				new DGT().anadirCoches(linea);
			}
		}
	}
	
	/**
	 * Añade personas a la lista
	 * @param linea
	 */
	private void anadirPersonas(String linea) {
		String[] arrayPersonas = linea.split(";");
		Persona persona = new Persona();
		persona.setNombre(arrayPersonas[0]);
		persona.setCiudad(arrayPersonas[1]);
		listaPersonas.add(persona); 
	}
	
	/**
	 * Añade los coches correspondientes a los objetos Persona
	 * @param linea
	 */
	private void anadirCoches(String linea) {
		String[] arrayCoches = linea.split(";");
		Coche coche = new Coche(arrayCoches[0], Integer.parseInt(arrayCoches[2]));
		
		for(Persona p : listaPersonas) {
			if(p.getNombre().equalsIgnoreCase(arrayCoches[1])) {
				p.setCoche(coche);
			}
		}
		
	}
	
	/**
	 * Ordena la lista de personas y la imprime por pantalla
	 */
	public void mostrarLista() {
		Collections.sort(listaPersonas);
		
		Iterator<Persona> i = listaPersonas.iterator();
		while(i.hasNext()) {
			Persona p = i.next();
			System.out.print(p.getNombre()+" ");
			System.out.print(p.getCiudad()+" ");
			System.out.print(p.getCoche().getMarca()+" ");
			System.out.print(p.getCoche().getAno()+" "+"\n");
			
		}
	}
}
