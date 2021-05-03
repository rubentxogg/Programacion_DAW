package com.rgg.ataques;

import com.rgg.acciones.IMolestable;

public class Molestia {
	
	/* Método que se aprovechará del polimorfismo y seguirá funcionando
	 *  sin necesidad de modificar aunque se añadan más enemigos
	 */
	public void ataques(IMolestable[] enemigosMolestables) {
		
		for(IMolestable m : enemigosMolestables) {
			m.molestar();
		}
	}
}
