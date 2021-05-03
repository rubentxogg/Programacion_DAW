package com.rgg.ataques;

import com.rgg.acciones.IMolestable;

public class Molestia {
	
	/* M�todo que se aprovechar� del polimorfismo y seguir� funcionando
	 *  sin necesidad de modificar aunque se a�adan m�s enemigos
	 */
	public void ataques(IMolestable[] enemigosMolestables) {
		
		for(IMolestable m : enemigosMolestables) {
			m.molestar();
		}
	}
}
