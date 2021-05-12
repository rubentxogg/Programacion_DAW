package com.rgg.hospital;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.rgg.dto.PacienteDTO;

/**
 * @author rgg
 *
 */
public class Hospital {
	
	static List<PacienteDTO> listaPacientes = new ArrayList<>();
	
	/**
	 * Lee el fichero de pacientes
	 * @param fichero
	 * @throws IOException
	 */
	public void leerListaPacientes(String fichero) throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader(fichero, StandardCharsets.UTF_8));){
			String linea;
			
			while((linea = br.readLine()) != null) {
				new Hospital().anadePaciente(linea);
			}
		}
	}
	
	/**
	 * Método que añade un paciente a la lista
	 * @param linea
	 */
	private void anadePaciente(String linea) {
		String[] arrayPacientes = linea.split(";");
		PacienteDTO paciente = new PacienteDTO(arrayPacientes[2], arrayPacientes[1], arrayPacientes[0], Integer.parseInt(arrayPacientes[3]));
		listaPacientes.add(paciente); 
	}
	
	/**
	 * Ordena la lista de pacientes y la imprime por pantalla
	 */
	public void mostrarListaPacientes() {
		Collections.sort(listaPacientes);
		
		Iterator<PacienteDTO> i = listaPacientes.iterator();
		while(i.hasNext()) {
			PacienteDTO p = i.next();
			System.out.print(p.getNombre()+" ");
			System.out.print(p.getApellido1()+" ");
			System.out.print(p.getApellido2()+" ");
			System.out.println(p.getEdad()+" ");
		}
	}
	
}
