package com.rgg.classicmodels.dtos;

import java.util.Date;

/**
 * @author Rubentxo
 *
 */
public class PedidoDTO {
	
	private int numeroPedido;
	private Date fechaPedido;
	private Date fechaRequerida;
	private Date fechaEnvio;
	private String codigoProducto;
	private int cantidadPedida;
	
	/**
	 * @param numeroPedido
	 * @param fechaPedido
	 * @param fechaRequerida
	 * @param fechaEnvio
	 * @param codigoProducto
	 * @param cantidadPedida
	 */
	public PedidoDTO(int numeroPedido, Date fechaPedido, Date fechaRequerida, Date fechaEnvio, String codigoProducto,
			int cantidadPedida) {
		super();
		this.numeroPedido = numeroPedido;
		this.fechaPedido = fechaPedido;
		this.fechaRequerida = fechaRequerida;
		this.fechaEnvio = fechaEnvio;
		this.codigoProducto = codigoProducto;
		this.cantidadPedida = cantidadPedida;
	}

	/**
	 * @return the numeroPedido
	 */
	public int getNumeroPedido() {
		return numeroPedido;
	}

	/**
	 * @param numeroPedido the numeroPedido to set
	 */
	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	/**
	 * @return the fechaPedido
	 */
	public Date getFechaPedido() {
		return fechaPedido;
	}

	/**
	 * @param fechaPedido the fechaPedido to set
	 */
	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	/**
	 * @return the fechaRequerida
	 */
	public Date getFechaRequerida() {
		return fechaRequerida;
	}

	/**
	 * @param fechaRequerida the fechaRequerida to set
	 */
	public void setFechaRequerida(Date fechaRequerida) {
		this.fechaRequerida = fechaRequerida;
	}

	/**
	 * @return the fechaEnvio
	 */
	public Date getFechaEnvio() {
		return fechaEnvio;
	}

	/**
	 * @param fechaEnvio the fechaEnvio to set
	 */
	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
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
	 * @return the cantidadPedida
	 */
	public int getCantidadPedida() {
		return cantidadPedida;
	}

	/**
	 * @param cantidadPedida the cantidadPedida to set
	 */
	public void setCantidadPedida(int cantidadPedida) {
		this.cantidadPedida = cantidadPedida;
	}
	
}