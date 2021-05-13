package com.rgg.dto;

/**
 * @author rgg
 * Clase coche
 */
public class Coche {
	
	private String marca;
	private Integer ano;
	
	/**
	 * @param marca
	 * @param año
	 */
	public Coche(String marca, Integer ano) {
		this.marca = marca;
		this.ano = ano;
	}

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return the año
	 */
	public Integer getAno() {
		return ano;
	}

	/**
	 * @param año the año to set
	 */
	public void setAño(Integer ano) {
		this.ano = ano;
	}
	
	
}
