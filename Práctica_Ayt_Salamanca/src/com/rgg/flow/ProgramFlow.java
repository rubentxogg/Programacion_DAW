package com.rgg.flow;

import com.rgg.dto.Mascota;

public class ProgramFlow {

	/**
	 * Constructor de la clase que marca el flujo del programa
	 */
	public ProgramFlow() {
		Mascota m = new Mascota();
		m.solicitarDatosMascota();
		m.mostrarListaMascotas();
	}
}
