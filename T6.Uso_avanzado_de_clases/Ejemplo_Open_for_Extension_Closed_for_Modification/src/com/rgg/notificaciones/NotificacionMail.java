/**
 * 
 */
package com.rgg.notificaciones;

/**
 * @author rgg
 *
 */
public class NotificacionMail implements INotificacion {
	
	private String nombreCliente;
	private String contacto;
	private String texto;
	
	/**
	 * @return the nombreCliente
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}

	/**
	 * @param nombreCliente
	 * @param contacto
	 * @param texto
	 */
	public NotificacionMail(String nombreCliente, String contacto, String texto) {
		this.nombreCliente = nombreCliente;
		this.contacto = contacto;
		this.texto = texto;
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

	@Override
	public void envio() {
		System.out.println("Enviando mail a: "+this.contacto+" con texto: "+this.texto);
	}

}
