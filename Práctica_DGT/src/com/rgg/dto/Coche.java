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
	 * @param a�o
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
	 * @return the a�o
	 */
	public Integer getAno() {
		return ano;
	}

	/**
	 * @param a�o the a�o to set
	 */
	public void setA�o(Integer ano) {
		this.ano = ano;
	}
	
	
}
