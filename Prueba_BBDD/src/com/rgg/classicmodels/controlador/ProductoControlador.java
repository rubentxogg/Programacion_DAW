package com.rgg.classicmodels.controlador;

import java.sql.SQLException;
import java.util.List;

import com.rgg.classicmodels.model.ProductoModelo;
import com.rgg.dto.ProductoDTO;

public class ProductoControlador {

	/**
	 * @param lineaProducto
	 * @param descripcion
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<ProductoDTO> buscarProductoFiltraLineaProductoyDescripcion(String codigoProducto, String nombreProducto, String lineaProducto, String descripcion) throws ClassNotFoundException, SQLException{
		ProductoModelo pm = new ProductoModelo();
		return pm.buscarProductoFiltraCodigoNombreLineaDescripcion(codigoProducto, nombreProducto, lineaProducto, descripcion);
	}
	
	/**
	 * @param codigoProducto
	 * @param nombreProducto
	 * @param escalaProducto
	 * @param vendedorProducto
	 * @param descripcionProducto
	 * @param cantidadEnStock
	 * @param precioCompra
	 * @param msrp
	 * @param lineaProducto
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Integer insertarProducto(String codigoProducto, String nombreProducto, String lineaProducto, String escalaProducto, String vendedorProducto,
			String descripcionProducto, int cantidadEnStock, double precioCompra, double msrp) throws ClassNotFoundException, SQLException {
		ProductoModelo pm = new ProductoModelo();
		return pm.insertarProducto(codigoProducto, nombreProducto, lineaProducto, escalaProducto, vendedorProducto, descripcionProducto, cantidadEnStock, precioCompra, msrp);
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
		ProductoModelo pm = new ProductoModelo();
		return pm.actualizarProducto(codigoProducto, nombreProducto, lineaProducto, escalaProducto, vendedorProducto, descripcionProducto, cantidadEnStock, precioCompra, msrp);
	}
}
