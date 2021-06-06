package com.rgg.dto;

import com.rgg.enums.Colores;

public class Coche {

	private String marca;
	private Colores color;
	private Integer kilometros;
	
	/**
	 * @param marca
	 * @param color
	 * @param kilometros
	 */
	public Coche(String marca, Colores color, Integer kilometros) {
		this.marca = marca;
		this.color = color;
		this.kilometros = kilometros;
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
	 * @return the color
	 */
	public Colores getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(Colores color) {
		this.color = color;
	}
	/**
	 * @return the kilometros
	 */
	public Integer getKilometros() {
		return kilometros;
	}
	/**
	 * @param kilometros the kilometros to set
	 */
	public void setKilometros(Integer kilometros) {
		this.kilometros = kilometros;
	}
	
	@Override
	public String toString() {
		return "Coche [marca=" + marca + ", color=" + color + ", kilometros=" + kilometros + "]";
	}
	
}
