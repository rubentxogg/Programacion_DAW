/**
 * 
 */
package com.rgg.notificaciones;

/**
 * @author rgg
 *
 */
public class NotificacionWhatsapp implements INotificacion{

	/**
	 * @param nombreCliente
	 * @param contacto
	 * @param texto
	 */
	public NotificacionWhatsapp(String nombreCliente, String contacto, String texto) {
		this.nombreCliente = nombreCliente;
		this.contacto = contacto;
		this.texto = texto;
	}

	private String nombreCliente;
	private String contacto;
	private String texto;
	
	@Override
	public void envio() {
		System.out.println("Enviando whatsapp a: "+this.contacto+" con texto: "+this.texto);
	}

	/**
	 * @return the nombreCliente
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}

	/**
	 * @param nombreCliente the nombreCliente to set
	 */
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	/**
	 * @return the contacto
	 */
	public String getContacto() {
		return contacto;
	}

	/**
	 * @param contacto the contacto to set
	 */
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	/**
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * @param texto the texto to set
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}

}
