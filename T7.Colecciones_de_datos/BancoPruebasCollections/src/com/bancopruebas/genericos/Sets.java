package com.bancopruebas.genericos;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;

import com.bancopruebas.constantes.Constantes;
import com.bancopruebas.tipos.Persona;
import com.github.javafaker.Faker;

public class Sets {

	/**
	 * Crea un HashSet usando un bucle añadiendo uno a uno con add()
	 * 
	 * @param setPersonas
	 * @return
	 */

	public static Set creaHashSet(Set<Persona> setPersonas) {
		Faker faker = new Faker(new Locale("es"));
		Long startTime = System.currentTimeMillis();
		for (int i = 0; i < Constantes.NUMERO_PERSONAS; i++) {
			setPersonas.add(new Persona( new Random().nextInt(Constantes.NUMERO_PERSONAS+1), faker.name().firstName()));
		}
		Long endTime = System.currentTimeMillis();
		System.out.println("HashSet - Tiempo en añadir: " + Constantes.NUMERO_PERSONAS + " registros "
				+ (endTime - startTime) + " ms.");
		return setPersonas;
	}

	/**
	 * Crea un hashSet desde una Lista con el método addAll
	 * 
	 * @param listaPersonas
	 * @param setPersonasVacio
	 * @return
	 */
	public static Set creaHashSetDesdeLista(List<Persona> listaPersonas, Set<Persona> setPersonasVacio) {

		Long startTime = System.currentTimeMillis();
		setPersonasVacio.addAll(listaPersonas);
		Long endTime = System.currentTimeMillis();
		System.out.println("HashSet - Tiempo en añadir con addAll: " + Constantes.NUMERO_PERSONAS + " registros "
				+ (endTime - startTime) + " ms.");
		return setPersonasVacio;
	}
	
	public static void obtenPersonadeHashSet(Set<Persona> hashSet, Persona p ) {
		Long startTime = System.currentTimeMillis();
		Long endTime = System.currentTimeMillis();
		System.out.println("HashSet - Tiempo en encontrar: " + p.toString() + " " + (endTime - startTime) + " ms.");

	}
	
	public static Set creaTreeSet(List<Persona> listaPersonas, Set<Persona> treeSet) {

		Long startTime = System.currentTimeMillis();
		//Recorremos la lista al revés para ir creando el treeSet desordenado
		for (int i = Constantes.NUMERO_PERSONAS; i < 0; i--) {
			treeSet.add(listaPersonas.get(i));
		}
		Long endTime = System.currentTimeMillis();
		System.out.println("TreeSet - Tiempo en añadir: " + Constantes.NUMERO_PERSONAS + " registros "
				+ (endTime - startTime) + " ms.");
		return treeSet;
	}

}
