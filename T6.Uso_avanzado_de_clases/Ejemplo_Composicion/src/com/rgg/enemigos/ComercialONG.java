package com.rgg.enemigos;

import com.rgg.acciones.IMolestable;

public class ComercialONG implements IMolestable{

	private String nombre;
	private IMolestable molestia;
	
	@Override
	public void molestar() {
		molestia.molestar();
	}
	
	public ComercialONG(String nombre, IMolestable molestia) {
		this.nombre = nombre;
		this.molestia = molestia;
	}

}
