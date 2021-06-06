package com.rgg.classicmodels.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.rgg.classicmodels.utils.DBUtils;
import com.rgg.dto.CantidadPedidaProducto;

public class PedidosModelo {

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
	public void crearPedido(String orderDate, String requiredDate, String status, String comments, int customerNumber, List<CantidadPedidaProducto> listaProductos) throws ClassNotFoundException, SQLException {
		
		String insertOrder = "INSERT INTO orders (orderDate, requiredDate, status, comments, customerNumber) "
				+ "VALUES (?, ?, ?, ?, ?)";
		
		String insertOrderDetails = "INSERT INTO orderDetails(orderNumber, productCode, quantityOrdered, orderLineNumber) "
				+ "VALUES (?, ?, ?, ?)";
		
		String actualizacionInventario = "UPDATE products SET quantityInStock = quantityInStock - ? "
				+ "WHERE productCode = ?";
		
		Connection connection = DBUtils.conexionBBDD();
		
		connection.setAutoCommit(false);
		
		PreparedStatement psInsertOrder = connection.prepareStatement(insertOrder, Statement.RETURN_GENERATED_KEYS);
		PreparedStatement psInsertOrderDetails = connection.prepareStatement(insertOrderDetails);
		PreparedStatement psActualizacionInventario = connection.prepareStatement(actualizacionInventario);
		
		psInsertOrder.setString(1, orderDate);
		psInsertOrder.setString(2, requiredDate);
		psInsertOrder.setString(3, status);
		psInsertOrder.setString(4, comments);
		psInsertOrder.setInt(5, customerNumber);
		
		psInsertOrder.executeUpdate();
		
		ResultSet rs = psInsertOrder.getGeneratedKeys();
		
		int orderNumber = 0;
		if(rs.next()) {
			orderNumber = rs.getInt(1);
		}
		
		int orderline = 1;
		for (CantidadPedidaProducto producto : listaProductos) {
			psInsertOrderDetails.setInt(1, orderNumber);
			psInsertOrderDetails.setString(2,  producto.getProductCode());
			psInsertOrderDetails.setInt(3, producto.getQuantityOrdered());
			psInsertOrderDetails.setInt(4, orderline);
			orderline++;
			psActualizacionInventario.setInt(1,  producto.getQuantityOrdered());
			psActualizacionInventario.setString(2, producto.getProductCode());
			
			psInsertOrderDetails.executeUpdate();
			psActualizacionInventario.executeUpdate();
		}
		
		connection.commit();
		connection.close();
	}
}
