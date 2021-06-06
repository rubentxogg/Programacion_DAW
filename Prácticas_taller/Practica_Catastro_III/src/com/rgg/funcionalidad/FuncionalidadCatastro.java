package com.rgg.funcionalidad;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.rgg.comparator.CompararEdad;
import com.rgg.comparator.CompararNumFincas;
import com.rgg.dto.Finca;
import com.rgg.dto.Propietario;

/**
 * @author Rubentxo
 * Clase con métodos para leer los ficheros de propietarios y fincas, 
 * también crearán una lista de propietarios e introducirán las fincas que les pertenecen. 
 */
public class FuncionalidadCatastro {
	
	private List<Propietario> listaPropietarios = new ArrayList<>();
	
	/**
	 * Lee el fichero de propietarios pasado por parámetro y añade los propietarios a la lista
	 * @param ficheroPropietarios
	 * @throws IOException 
	 */
	public void leerFicheroPropietarios(String ficheroPropietarios) throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader(ficheroPropietarios, StandardCharsets.UTF_8));) {
			String linea;
			
			while((linea = br.readLine()) != null) {
				anadirPropietarios(linea);
			}
		}
	}
	
	/**
	 * Añade propietarios a la lista
	 * @param linea
	 */
	private void anadirPropietarios(String linea) {
		String[] arrayPropietarios = linea.split(";");
		Propietario propietario = new Propietario();
		
		propietario.setNombre(arrayPropietarios[0]);
		propietario.setEdad(Integer.parseInt(arrayPropietarios[1]));
		propietario.setLocalidad(arrayPropietarios[2]);
		listaPropietarios.add(propietario);
	}
	
	/**
	 * Lee el fichero de fincas y las añade un objeto Finca al propietario al cual pertenece
	 * @param ficheroFincas
	 * @throws IOException 
	 */
	public void leerFicheroFincas(String ficheroFincas) throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader(ficheroFincas, StandardCharsets.UTF_8));) {
			String linea;
			
			while((linea = br.readLine()) != null) {
				anadirFincas(linea);
			}
		}
	}
	
	/**
	 * Añade fincas a la lista de sus respectivos propietarios y suma la superficie total de sus fincas
	 * @param linea
	 */
	private void anadirFincas(String linea) {
		String[] arrayFincas = linea.split(";");
		Finca finca = new Finca();
		
		finca.setLocalidad(arrayFincas[0]);
		finca.setSuperficie(Integer.parseInt(arrayFincas[1]));
		
		for(Propietario p : listaPropietarios) {
			if(p.getNombre().equalsIgnoreCase(arrayFincas[2])) {
				p.getFincas().add(finca);
				p.setSuperficieTotal(finca.getSuperficie()+p.getSuperficieTotal());
			}
		}
	}
	
	/**
	 * Ordena la lista de propietarios en función del número de propiedades 
	 * que tengan y la imprime
	 */
	public void mostrarLista() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ordenar por: \n1.Superficie total\n2.Edad\n3.Nº Fincas");
		int opc = sc.nextInt();
		
		switch(opc) {
			case 1: Collections.sort(listaPropietarios);
					break;
			case 2: Collections.sort(listaPropietarios, new CompararEdad());
					break;
			case 3: Collections.sort(listaPropietarios, new CompararNumFincas());
					break;
			default: System.err.println("Opción incorrecta, terminando el programa.");
		}
		
		Iterator<Propietario> i = listaPropietarios.iterator();
		while(i.hasNext()) {
			Propietario propietario = i.next();
			System.out.println("Nombre: "+propietario.getNombre()+" | Localidad: "+propietario.getLocalidad()+" | Edad: "+propietario.getEdad()+" | Nº Fincas: "+propietario.getFincas().size()+" | Superficie total: "+propietario.getSuperficieTotal());
		}
	}
}
