/**
 * 
 */
package com.rgg.notificaciones;

/**
 * @author rgg
 *
 */
public class NotificacionService {

	/**
	 * @param listaNotificaciones
	 */
	public void envioNotificaciones(NotificacionMailyWhatsapp[] listaNotificaciones) {
		for(NotificacionMailyWhatsapp n : listaNotificaciones) {
			
			if(n.getTipoEnvio().equals("mail")) {
				n.envioPorMail();
			}
			else {
				n.envioPorWhatsapp();
			}
			
		}
	}
}
