package com.rgg.flujo;

import java.io.IOException;

import com.rgg.constantes.Constantes;
import com.rgg.hospital.Hospital;

/**
 * @author rgg
 * Clase que marca el flujo del programa
 */
public class FlujoPrograma {
	
	/**
	 * Constructor de la clase
	 */
	public FlujoPrograma() {
		Hospital hospital = new Hospital();
		try {
			hospital.leerListaPacientes(Constantes.LISTA_PACIENTES);
		} catch (IOException e) {
			System.err.println("No se ha encontrado el fichero en esa ruta.");
		}
		
		hospital.mostrarListaPacientes();
	}
}
