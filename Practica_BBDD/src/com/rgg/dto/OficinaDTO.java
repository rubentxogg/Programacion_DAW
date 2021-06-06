package com.rgg.dto;

/**
 * @author Rubentxo
 *
 */
public class OficinaDTO {

	private String codigoOficina;
	private String ciudad;
	private String estado;
	private String pais;
	
	/**
	 * @param codigoOficina
	 * @param ciudad
	 * @param estado
	 * @param pais
	 */
	public OficinaDTO(String codigoOficina, String ciudad, String estado, String pais) {
		super();
		this.codigoOficina = codigoOficina;
		this.ciudad = ciudad;
		this.estado = estado;
		this.pais = pais;
	}

	/**
	 * @return the codigoOficina
	 */
	public String getCodigoOficina() {
		return codigoOficina;
	}

	/**
	 * @param codigoOficina the codigoOficina to set
	 */
	public void setCodigoOficina(String codigoOficina) {
		this.codigoOficina = codigoOficina;
	}

	/**
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}
	
}
