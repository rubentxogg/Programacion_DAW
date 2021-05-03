package com.rgg.enemigos;

import com.rgg.acciones.IMolestable;

public class Mosquito implements IMolestable{
	private Integer id;
	
	// Composición
	private IMolestable molestia;
	
	// Constructor
	public Mosquito(Integer id, IMolestable molestia) {
		this.id = id;
		this.molestia = molestia;
	}
	
	@Override
	public void molestar() {
		molestia.molestar();
	}

}
