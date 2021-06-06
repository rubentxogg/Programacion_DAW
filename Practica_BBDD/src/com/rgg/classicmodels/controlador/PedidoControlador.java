package com.rgg.classicmodels.controlador;

import java.sql.SQLException;
import java.util.List;

import com.rgg.classicmodels.model.PedidosModelo;
import com.rgg.dto.CantidadPedidaProducto;
import com.rgg.dto.PedidoDTO;

/**
 * @author Rubentxo
 *
 */
public class PedidoControlador {

	/**
	 * @param orderDate
	 * @param requiredDate
	 * @param status
	 * @param comments
	 * @param customerNumber
	 * @param listaProductos
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Integer crearPedido(String orderDate, String requiredDate, String status, String comments, int customerNumber, List<CantidadPedidaProducto> listaProductos) throws ClassNotFoundException, SQLException {
		PedidosModelo pm = new PedidosModelo();
		return pm.crearPedido(orderDate, requiredDate, status, comments, customerNumber, listaProductos);
	}
	
	/**
	 * @param numeroPedido
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<PedidoDTO> buscarPedidoPorNumeroPedido(int numeroPedido) throws ClassNotFoundException, SQLException{
		PedidosModelo pm = new PedidosModelo();
		return pm.buscarPedidoPorNumeroPedido(numeroPedido);
	}
}
