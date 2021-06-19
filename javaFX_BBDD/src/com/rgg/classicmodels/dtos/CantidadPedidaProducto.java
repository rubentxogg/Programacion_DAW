package com.rgg.classicmodels.dtos;

public class CantidadPedidaProducto {

	private String productCode;
	private Integer quantityOrdered;
	
	/**
	 * @param productCode
	 * @param quantityOrdered
	 */
	public CantidadPedidaProducto(String productCode, Integer quantityOrdered) {
		this.productCode = productCode;
		this.quantityOrdered = quantityOrdered;
	}

	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * @return the quantityOrdered
	 */
	public Integer getQuantityOrdered() {
		return quantityOrdered;
	}

	/**
	 * @param quantityOrdered the quantityOrdered to set
	 */
	public void setQuantityOrdered(Integer quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}
	
}
