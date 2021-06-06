package com.rgg.flujo;

import java.io.IOException;

import com.rgg.constantes.Constantes;
import com.rgg.funcionalidad.FuncionalidadCatastro;

/**
 * @author Rubentxo
 * Clase que marca el flujo del programa
 */
public class FlujoPrograma {
	
	/**
	 * Constructor de la clase que marca el flujo del programa
	 * @throws IOException 
	 */
	public FlujoPrograma() throws IOException {
		FuncionalidadCatastro fc = new FuncionalidadCatastro();
		
		fc.leerFicheroPropietarios(Constantes.LISTA_PROPIETARIOS);
		fc.leerFicheroFincas(Constantes.LISTA_FINCAS);
		fc.mostrarLista();
	}
}
