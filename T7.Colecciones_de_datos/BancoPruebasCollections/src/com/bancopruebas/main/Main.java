package com.bancopruebas.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.bancopruebas.constantes.Constantes;
import com.bancopruebas.genericos.Lista;
import com.bancopruebas.genericos.Sets;
import com.bancopruebas.tipos.Persona;

public class Main {

	//Creación de las colecciones
	List<Persona> listaPersonas = new ArrayList<>();
	Set<Persona> hashSetPersonas = new HashSet<>();
	Set<Persona> hashSetPersonas2 = new HashSet<>();
	Set<Persona> treeSetPersonas = new TreeSet<>();
	


	public static void main(String[] args) {

		Main m = new Main();
		//Construimos el objeto persona que vamos a buscar posteriormente
		//Será la última persona en la lista
		Persona personaABuscar = new Persona(Constantes.NUMERO_PERSONA_RECUPERAR, "Persona"+Constantes.NUMERO_PERSONA_RECUPERAR);
		//Creaciones de las Colecciones
		System.out.println("CREANDO COLECCIONES......");
		System.out.println("=========================");
		System.out.println("Creando LISTA de personas......");
		Lista.creaLista(m.listaPersonas);
		System.out.println("Creando HASHSET de personas......");
		Sets.creaHashSet(m.hashSetPersonas);
		System.out.println("Creando HASHSET partiendo de una lista de personas......");
		Sets.creaHashSetDesdeLista(m.listaPersonas, m.hashSetPersonas2);
		System.out.println("Creando TREESET de personas......");
		Sets.creaTreeSet(m.listaPersonas, m.treeSetPersonas);
		
		//Búsqueda en colecciones
		System.out.println("BUSCANDO PERSONA......"+ personaABuscar.toString());
		System.out.println("======================");
		Lista.obtenPersona(m.listaPersonas, personaABuscar);
		Sets.obtenPersonadeHashSet(m.hashSetPersonas, personaABuscar);
		Lista.obtenPersonaPosicion(m.listaPersonas, Constantes.NUMERO_PERSONA_RECUPERAR);
		
		

		
//		for (Persona p : m.listaPersonas) {
//			System.out.println(p.toString());
//		}

		
		
		
	}

}
