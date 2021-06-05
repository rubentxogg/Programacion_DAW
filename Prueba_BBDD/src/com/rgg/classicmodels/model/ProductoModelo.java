package com.rgg.classicmodels.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rgg.classicmodels.utils.DBUtils;
import com.rgg.dto.ProductoDTO;

public class ProductoModelo {
	
	/**
	 * @param lineaProducto
	 * @param descripcion
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<ProductoDTO> buscarProductoFiltraCodigoNombreLineaDescripcion(String codigoProducto, String nombreProducto, String lineaProducto, String descripcion) throws ClassNotFoundException, SQLException{
		
		String query = "SELECT * FROM products where productCode LIKE ? AND productName LIKE ? AND productLine LIKE ? AND productDescription LIKE ?";
		
		try(Connection conexionBD = DBUtils.conexionBBDD();
				PreparedStatement ps = conexionBD.prepareStatement(query);){
			
			ps.setString(1, "%"+codigoProducto+"%");
			ps.setString(2, "%"+nombreProducto+"%");
			ps.setString(3, "%"+lineaProducto+"%");
			ps.setString(4, "%"+descripcion+"%");
			
			ResultSet productosRS = ps.executeQuery();
			List<ProductoDTO> listaProductos = new ArrayList<>();
			
			while(productosRS.next()) {
				ProductoDTO producto = new ProductoDTO(productosRS.getString("productCode"), productosRS.getString("productName"), productosRS.getString("productLine"), productosRS.getInt("quantityInStock"));
				listaProductos.add(producto);
			}
			return listaProductos;
		}
	}
	
	/**
	 * @param codigoProducto
	 * @param nombreProducto
	 * @param lineaProducto
	 * @param escalaProducto
	 * @param vendedorProducto
	 * @param descripcionProducto
	 * @param cantidadEnStock
	 * @param precioCompra
	 * @param msrp
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Integer insertarProducto(String codigoProducto, String nombreProducto, String lineaProducto, String escalaProducto, String vendedorProducto,
			String descripcionProducto, int cantidadEnStock, double precioCompra, double msrp) throws ClassNotFoundException, SQLException {
		
		String query = "INSERT INTO products (productCode, productName, productLine, productScale, productVendor, productDescription, "
				+ "quantityInStock, buyPrice, MSRP) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try(Connection conexionBD = DBUtils.conexionBBDD();
				PreparedStatement ps = conexionBD.prepareStatement(query);){
			
			ps.setString(1, codigoProducto);
			ps.setString(2, nombreProducto);
			ps.setString(3, lineaProducto);
			ps.setString(4, escalaProducto);
			ps.setString(5, vendedorProducto);
			ps.setString(6, descripcionProducto);
			ps.setInt(7, cantidadEnStock);
			ps.setDouble(8, precioCompra);
			ps.setDouble(9, msrp);
			
			return ps.executeUpdate();
		}
	}
	
	/**
	 * @param codigoProducto
	 * @param nombreProducto
	 * @param lineaProducto
	 * @param escalaProducto
	 * @param vendedorProducto
	 * @param descripcionProducto
	 * @param cantidadEnStock
	 * @param precioCompra
	 * @param msrp
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Integer actualizarProducto(String codigoProducto, String nombreProducto, String lineaProducto, String escalaProducto, String vendedorProducto,
			String descripcionProducto, int cantidadEnStock, double precioCompra, double msrp) throws ClassNotFoundException, SQLException {
		String query = "UPDATE products SET productName = CASE WHEN ? = '' THEN productName ELSE ? END,"
				+ "productLine = CASE WHEN ? = '' THEN productLine ELSE ? END,"
				+ "productScale = CASE WHEN ? = '' THEN productScale ELSE ? END,"
				+ "productVendor = CASE WHEN ? = '' THEN productVendor ELSE ? END,"
				+ "productDescription = CASE WHEN ? = '' THEN productDescription ELSE ? END,"
				+ "quantityInStock = CASE WHEN ? = '' THEN quantityInStock ELSE ? END,"
				+ "buyPrice = CASE WHEN ? = '' THEN buyPrice ELSE ? END,"
				+ "MSRP = CASE WHEN ? = '' THEN MSRP ELSE ? END "
				+ "WHERE productCode = ?";
		
		Integer resultado = null;
		
		try(Connection conexionBD = DBUtils.conexionBBDD();
				PreparedStatement ps = conexionBD.prepareStatement(query);){
			
			ps.setString(1, nombreProducto);
			ps.setString(2, nombreProducto);
			
			ps.setString(3, lineaProducto);
			ps.setString(4, lineaProducto);
			
			ps.setString(5, escalaProducto);
			ps.setString(6, escalaProducto);
			
			ps.setString(7, vendedorProducto);
			ps.setString(8, vendedorProducto);
			
			ps.setString(9, descripcionProducto);
			ps.setString(10, descripcionProducto);
			
			ps.setInt(11, cantidadEnStock);
			ps.setInt(12, cantidadEnStock);
			
			ps.setDouble(13, precioCompra);
			ps.setDouble(14, precioCompra);
			
			ps.setDouble(15, msrp);
			ps.setDouble(16, msrp);
			
			ps.setString(17, codigoProducto);
			
			resultado = ps.executeUpdate();
		}
		return resultado;
	}
}
