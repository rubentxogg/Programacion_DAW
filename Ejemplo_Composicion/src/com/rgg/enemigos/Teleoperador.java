package com.rgg.enemigos;

import com.rgg.acciones.IMolestable;

public class Teleoperador implements IMolestable{
	private String nombre;
	
	// Composición
	private IMolestable molestia;
	
	// Constructor
	public Teleoperador(String nombre, IMolestable molestia) {
		this.nombre = nombre;
		this.molestia = molestia;
	}
	
	@Override
	public void molestar() {
		molestia.molestar();
	}

}
