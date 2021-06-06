package com.rgg.comparator;

import java.util.Comparator;

import com.rgg.cancion.Cancion;

public class CompararUsuario implements Comparator<Cancion> {

	@Override
	public int compare(Cancion c1, Cancion c2) {
		return c1.getUsuario().compareTo(c2.getUsuario());
	}

}
