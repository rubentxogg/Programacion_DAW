package com.rgg.flujo;

import java.io.IOException;

import com.rgg.constantes.Constantes;
import com.rgg.hospital.Hospital;

/**
 * @author rgg
 *
 */
public class FlujoPrograma {
	
	public FlujoPrograma() {
		Hospital hospital = new Hospital();
		try {
			hospital.leerListaPacientes(Constantes.LISTA_PACIENTES);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		hospital.mostrarLista();
	}
}
