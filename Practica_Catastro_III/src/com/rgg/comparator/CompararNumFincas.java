package com.rgg.comparator;

import java.util.Comparator;

import com.rgg.dto.Propietario;


public class CompararNumFincas implements Comparator<Propietario>{

	@Override
	public int compare(Propietario p1, Propietario p2) {
			if(p1.getFincas().size() > p2.getFincas().size()) {
				return 1;
			}
			else if(p1.getFincas().size() < p2.getFincas().size()){
				return -1;
			}
			else return 0;
	}

}
