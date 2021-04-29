package com.rgg.notificaciones;

/**
 * @author rgg
 *
 */
public class NotificacionMailyWhatsapp {
	private String nombreCliente;
	private String contacto;
	private String texto;
	private String tipoEnvio;
	
	/**
	 * @param string
	 * @param string2
	 * @param textoPromocion
	 */
	public NotificacionMailyWhatsapp(String nombreCliente, String contacto, String texto) {
		this.nombreCliente = nombreCliente;
		this.contacto = contacto;
		this.texto = texto;
	}
	
	
	/**
	 * @param nombreCliente
	 * @param contacto
	 * @param texto
	 * @param tipoEnvio
	 */
	public NotificacionMailyWhatsapp(String nombreCliente, String contacto, String texto, String tipoEnvio) {
		this.nombreCliente = nombreCliente;
		this.contacto = contacto;
		this.texto = texto;
		this.tipoEnvio = tipoEnvio;
	}

	/**
	 * @return the tipoEnvio
	 */
	public String getTipoEnvio() {
		return tipoEnvio;
	}


	/**
	 * @param tipoEnvio the tipoEnvio to set
	 */
	public void setTipoEnvio(String tipoEnvio) {
		this.tipoEnvio = tipoEnvio;
	}


	/**
	 * 
	 */
	public void envioPorMail() {
		System.out.println("Enviando mail a: "+this.contacto+" con texto: "+this.texto);
	}
	
	public void envioPorWhatsapp() {
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
