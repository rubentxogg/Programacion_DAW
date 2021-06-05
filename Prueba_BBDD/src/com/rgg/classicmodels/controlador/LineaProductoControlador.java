package com.rgg.classicmodels.controlador;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import com.rgg.classicmodels.model.LineaProductoModelo;
import com.rgg.dto.LineaProductoDTO;

/**
 * @author Rubentxo
 *
 */
public class LineaProductoControlador {
	
	/**
	 * @param nombre
	 * @param descripcion
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<LineaProductoDTO> buscarLineaProductoFiltraNombreyDescripcion(String nombre, String descripcion) throws ClassNotFoundException, SQLException{
		LineaProductoModelo lpm = new LineaProductoModelo();
		return lpm.buscarLineaProductoFiltraNombreyDescripcion(nombre, descripcion);
	}
	
	/**
	 * @param nombre
	 * @param descripcion
	 * @param descripcionHTML
	 * @param imagen
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Integer insertarLineaProducto(String nombre, String descripcion, String descripcionHTML, File imagen) throws ClassNotFoundException, SQLException {
		LineaProductoModelo lpm = new LineaProductoModelo();
		return lpm.insertarLineaProducto(nombre, descripcion, descripcionHTML, imagen);
	}
	
	/**
	 * @param nombre
	 * @param descripcion
	 * @param descripcionHTML
	 * @param imagen
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Integer actualizarLineaProducto(String nombre, String descripcion, String descripcionHTML, File imagen) throws ClassNotFoundException, SQLException {
		LineaProductoModelo lpm = new LineaProductoModelo();
		return lpm.actualizarLineaProducto(nombre, descripcion, descripcionHTML, imagen);
	}
}
