package com.rgg.main;

import com.rgg.acciones.IMolestable;
import com.rgg.acciones.MolestiaTelefonica;
import com.rgg.acciones.MolestiaZumbona;
import com.rgg.ataques.Molestia;
import com.rgg.enemigos.ComercialONG;
import com.rgg.enemigos.Mosquito;
import com.rgg.enemigos.Teleoperador;

public class Main {
	
	public static void main (String[] args) {
		IMolestable mosquito1 = new Mosquito(1, new MolestiaZumbona());
		IMolestable mosquito2 = new Mosquito(2, new MolestiaZumbona());
		IMolestable to1 = new Teleoperador("pepe", new MolestiaTelefonica());
		IMolestable to2 = new Teleoperador("Gertrudis", new MolestiaTelefonica());
		IMolestable ong1 = new ComercialONG("manolo", new MolestiaTelefonica());
		
		IMolestable[] arraydeMolestables = {mosquito1, mosquito2, to1, to2, ong1};
		
		// Ejecución del ataque
		Molestia m = new Molestia();
		m.ataques(arraydeMolestables);
	}
}
