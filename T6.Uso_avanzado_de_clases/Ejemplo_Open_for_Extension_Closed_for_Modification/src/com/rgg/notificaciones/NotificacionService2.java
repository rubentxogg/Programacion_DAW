/**
 * 
 */
package com.rgg.notificaciones;

/**
 * @author rgg
 *
 */
public class NotificacionService2 {

	/**
	 * @param listaNotificaciones
	 */
	public void envioNotificaciones(INotificacion[] listaNotificaciones) {
		
		for(INotificacion n : listaNotificaciones) {
			n.envio();
		}
	}
}
