package com.rgg.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.PriorityQueue;
import java.util.Queue;

import com.rgg.constantes.Constantes;
import com.rgg.dto.Incidencia;

public class SistemaAI {

	private Queue<Incidencia> colaIncidencias = new PriorityQueue<>();
	
	// Método main
	public static void main(String[] args) throws IOException {
		SistemaAI system = new SistemaAI();
		
		leerFicheroIncidencias(system, Constantes.FICHERO_INCIDENCIAS);
		mostrarListaSinOrdenar(system);
		sacarIncidencias(system);
	}

	/**
	 * Saca las incidencias de la cola por orden de prioridad
	 * @param system
	 */
	private static void sacarIncidencias(SistemaAI system) {
		System.out.println("\n(!) Sacando incidencias por orden de prioridad");
		while(!system.getColaIncidencias().isEmpty()) {
			System.out.println(system.getColaIncidencias().poll());
			System.out.println("(!) Elemento vaciado\n");
		}
	}

	/**
	 * Muestra la lista de incidencias de la cola sin ordenar
	 * @param system
	 */
	private static void mostrarListaSinOrdenar(SistemaAI system) {
		System.out.println("(!) Mostrando lista sin ordenar");
		for(Incidencia i : system.getColaIncidencias()) {
			System.out.println(i.toString());
		}
	}

	/**
	 * Lee el fichero de incidencias y las añade a la cola
	 * @param system
	 * @param ficheroIncidencias
	 * @throws IOException
	 */
	private static void leerFicheroIncidencias(SistemaAI system, String ficheroIncidencias) throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader(ficheroIncidencias, StandardCharsets.UTF_8))){
			String linea;
			
			while((linea = br.readLine()) != null) {
				system.anadeIncidencia(linea);
			}
			System.out.println("(!) Se ha terminado de leer el fichero\n");
		}
	}
	
	/**
	 * Añade incidencias a la lista
	 * @param linea
	 */
	private void anadeIncidencia(String linea) {
		String[] arrayIncidencias = linea.split(";");
		Incidencia incidencia = new Incidencia(arrayIncidencias[0], arrayIncidencias[1], Integer.parseInt(arrayIncidencias[2].trim()));
		colaIncidencias.add(incidencia);
	}

	/**
	 * @return the colaIncidencias
	 */
	public Queue<Incidencia> getColaIncidencias() {
		return colaIncidencias;
	}

	/**
	 * @param colaIncidencias the colaIncidencias to set
	 */
	public void setColaIncidencias(Queue<Incidencia> colaIncidencias) {
		this.colaIncidencias = colaIncidencias;
	}

}
