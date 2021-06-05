package com.rgg.classicmodels.model;

import java.io.File;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rgg.classicmodels.utils.DBUtils;
import com.rgg.dto.LineaProductoDTO;

/**
 * @author Rubentxo
 *
 */
public class LineaProductoModelo {

	/**
	 * @param lineaProducto
	 * @param descripcion
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<LineaProductoDTO> buscarLineaProductoFiltraNombreyDescripcion(String nombre, String descripcion) throws ClassNotFoundException, SQLException{
		
		String query = "SELECT * FROM productlines where productLine LIKE ? AND textDescription LIKE ?";
		
		try(Connection conexionBD = DBUtils.conexionBBDD();
				PreparedStatement ps = conexionBD.prepareStatement(query);){
			
			ps.setString(1, "%"+nombre+"%");
			ps.setString(2, "%"+descripcion+"%");
			
			ResultSet lineaProductosRS = ps.executeQuery();
			List<LineaProductoDTO> listaLineaProductos = new ArrayList<>();
			
			while(lineaProductosRS.next()) {
				LineaProductoDTO lineaProducto = new LineaProductoDTO(lineaProductosRS.getString("productLine"), lineaProductosRS.getString("textDescription"));
				listaLineaProductos.add(lineaProducto);
			}
			return listaLineaProductos;
		}
	}
	
	/**
	 * @param nombre
	 * @param descripcion
	 * @param descripcionHTML
	 * @param imagen
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Integer insertarLineaProducto(String nombre, String descripcion, String descripcionHTML, File imagen) throws SQLException, ClassNotFoundException {
		
		String query = "INSERT INTO productlines(productLine, textDescription, htmlDescription, image)"
				+ " VALUES (?, ?, ? ,?)";
		
		try(Connection conexionBD = DBUtils.conexionBBDD();
				PreparedStatement ps = conexionBD.prepareStatement(query);){
			
			ps.setString(1, nombre);
			ps.setString(2, descripcion);
			ps.setString(3, descripcionHTML);
			ps.setBlob(4, (Blob) null);
			
			return ps.executeUpdate();
		}
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
		String query = "UPDATE productlines SET textDescription = CASE WHEN ? = '' THEN textDescription ELSE ? END,"
				+ "htmlDescription = CASE WHEN ? = '' THEN htmlDescription ELSE ? END,"
				+ "image = CASE WHEN ? = '' THEN image ELSE ? END "
				+ "WHERE productLine = ?";
		
		try(Connection conexionBD = DBUtils.conexionBBDD();
				PreparedStatement ps = conexionBD.prepareStatement(query);){
			
			ps.setString(1, descripcion);
			ps.setString(2, descripcion);
			
			ps.setString(3, descripcionHTML);
			ps.setString(4, descripcionHTML);
			
			ps.setBlob(5, (Blob) null);
			ps.setBlob(6, (Blob) null);
			
			ps.setString(7, nombre);
			
			return ps.executeUpdate();
		}
	}
}
