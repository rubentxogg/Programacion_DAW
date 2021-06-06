package com.rgg.funcionalidad;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.rgg.dto.Finca;
import com.rgg.dto.Propietario;

/**
 * @author Rubentxo
 * Clase con m�todos para leer los ficheros de propietarios y fincas, 
 * tambi�n crear�n una lista de propietarios e introducir�n las fincas que les pertenecen. 
 */
public class FuncionalidadCatastro {
	
	private List<Propietario> listaPropietarios = new ArrayList<>();
	
	/**
	 * Lee el fichero de propietarios pasado por par�metro y a�ade los propietarios a la lista
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
	 * A�ade propietarios a la lista
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
	 * Lee el fichero de fincas y las a�ade un objeto Finca al propietario al cual pertenece
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
	 * A�ade fincas a la lista de sus respectivos propietarios
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
			}
		}
	}
	
	/**
	 * Ordena la lista de propietarios en funci�n del n�mero de propiedades 
	 * que tengan y la imprime
	 */
	public void mostrarLista() {
		Collections.sort(listaPropietarios);
		
		Iterator<Propietario> i = listaPropietarios.iterator();
		while(i.hasNext()) {
			Propietario propietario = i.next();
			System.out.println("Nombre: "+propietario.getNombre()+" | Localidad: "+propietario.getLocalidad()+" | Edad: "+propietario.getEdad()+" | N� Fincas: "+propietario.getFincas().size());
		}
	}
}
