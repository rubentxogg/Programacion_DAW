package com.rgg.comparators;

import java.util.Comparator;

import com.rgg.dto.Persona;

public class CompararColor implements Comparator<Persona> {

	@Override
	public int compare(Persona p1, Persona p2) {
		return p1.getCoche().getColor().compareTo(p2.getCoche().getColor());
	}

}
