package com.rgg.comparator;

import java.util.Comparator;

import com.rgg.dto.Propietario;

public class CompararEdad implements Comparator<Propietario>{

	@Override
	public int compare(Propietario o1, Propietario o2) {
		return o1.getEdad().compareTo(o2.getEdad());
	}

}
