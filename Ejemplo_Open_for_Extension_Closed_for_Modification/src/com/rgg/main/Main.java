/**
 * 
 */
package com.rgg.main;

import com.rgg.notificaciones.INotificacion;
import com.rgg.notificaciones.NotificacionMail;
import com.rgg.notificaciones.NotificacionService2;
import com.rgg.notificaciones.NotificacionTelegram;
import com.rgg.notificaciones.NotificacionWhatsapp;

/**
 * @author 20207
 *
 */
public class Main {
	
	public static void main(String[] args) {
		String textoPromocion = "Camisas a 99,99, señoooooraaa.....";
		
		// Creamos notificaciones
		INotificacion n1 = new NotificacionWhatsapp("Jonan", "eljonnandebaraka@gmail.com", textoPromocion);
		INotificacion n2 = new NotificacionMail("Jessica", "lajessy@gmail.com", textoPromocion);
		INotificacion n3 = new NotificacionTelegram("Juany", "lajuani99@gmail.com", textoPromocion);
		INotificacion n4 = new NotificacionMail("Manolito", "manolito@gmail.com", textoPromocion);
		
		// Introducimos las notificaciones en un array de notificaciones
		INotificacion[] arrayDeNotificaciones = {n1, n2, n3, n4};

		// Envio de las notificaciones
		NotificacionService2 ns = new NotificacionService2();
		
		ns.envioNotificaciones(arrayDeNotificaciones);
	}
}
