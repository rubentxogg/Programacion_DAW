package com.rgg.dtos;

/**
 * @author Rubentxo
 *
 */
public class ProductoDTO {
	
	private String codigoProducto;
	private String nombreProducto;
	private String lineaProducto;
	private int cantidadEnStock;
	
	/**
	 * @param codigoProducto
	 * @param nombreProducto
	 * @param lineaProducto
	 * @param cantidadEnStock
	 */
	public ProductoDTO(String codigoProducto, String nombreProducto, String lineaProducto, int cantidadEnStock) {
		super();
		this.codigoProducto = codigoProducto;
		this.nombreProducto = nombreProducto;
		this.lineaProducto = lineaProducto;
		this.cantidadEnStock = cantidadEnStock;
	}
	
	/**
	 * @return the codigoProducto
	 */
	public String getCodigoProducto() {
		return codigoProducto;
	}
	/**
	 * @param codigoProducto the codigoProducto to set
	 */
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	/**
	 * @return the nombreProducto
	 */
	public String getNombreProducto() {
		return nombreProducto;
	}
	/**
	 * @param nombreProducto the nombreProducto to set
	 */
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	/**
	 * @return the lineaProducto
	 */
	public String getLineaProducto() {
		return lineaProducto;
	}
	/**
	 * @param lineaProducto the lineaProducto to set
	 */
	public void setLineaProducto(String lineaProducto) {
		this.lineaProducto = lineaProducto;
	}
	/**
	 * @return the cantidadEnStock
	 */
	public int getCantidadEnStock() {
		return cantidadEnStock;
	}
	/**
	 * @param cantidadEnStock the cantidadEnStock to set
	 */
	public void setCantidadEnStock(int cantidadEnStock) {
		this.cantidadEnStock = cantidadEnStock;
	}
	
}
