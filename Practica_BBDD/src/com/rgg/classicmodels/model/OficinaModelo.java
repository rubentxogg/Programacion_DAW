package com.rgg.classicmodels.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rgg.classicmodels.utils.DBUtils;
import com.rgg.dto.OficinaDTO;

/**
 * @author Rubentxo
 *
 */
public class OficinaModelo {
	
	/**
	 * @param codigoOficina
	 * @param ciudad
	 * @param estado
	 * @param pais
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<OficinaDTO> buscarOficinaFiltraCodigoCiudadEstadoPais(String codigoOficina, String ciudad, String estado, String pais) throws SQLException, ClassNotFoundException{
		
		String query = "SELECT * FROM offices WHERE officeCode LIKE ? AND city LIKE ? AND state LIKE ? AND country LIKE ?";
		
		try(Connection conexionBD = DBUtils.conexionBBDD();
				PreparedStatement ps = conexionBD.prepareStatement(query);){
			
			ps.setString(1, "%"+codigoOficina+"%");
			ps.setString(2, "%"+ciudad+"%");
			ps.setString(3, "%"+estado+"%");
			ps.setString(4, "%"+pais+"%");
			
			ResultSet oficinasRS = ps.executeQuery();
			List<OficinaDTO> listaOficinas = new ArrayList();
			
			while(oficinasRS.next()) {
				OficinaDTO oficina = new OficinaDTO(oficinasRS.getString("officeCode"), oficinasRS.getString("city"), oficinasRS.getString("state"), oficinasRS.getString("country"));
				listaOficinas.add(oficina);
			}
			return listaOficinas;
		}
	}
	
	/**
	 * @param codigoOficina
	 * @param ciudad
	 * @param telefono
	 * @param direccion1
	 * @param direccion2
	 * @param estado
	 * @param pais
	 * @param codigoPostal
	 * @param territorio
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Integer insertarOficina(String codigoOficina, String ciudad, String telefono, String direccion1, String direccion2, String estado, String pais, String codigoPostal, String territorio) throws ClassNotFoundException, SQLException{
		
		String query = "INSERT INTO offices(officeCode, city, phone, addressLine1, addressLine2, state, country, postalCode, territory) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try(Connection conexionBD = DBUtils.conexionBBDD();
				PreparedStatement ps = conexionBD.prepareStatement(query);){
			
			ps.setString(1,codigoOficina);
			ps.setString(2, ciudad);
			ps.setString(3, telefono);
			ps.setString(4, direccion1);
			ps.setString(5, direccion2);
			ps.setString(6, estado);
			ps.setString(7, pais);
			ps.setString(8, codigoPostal);
			ps.setString(9, territorio);
		
			return ps.executeUpdate();
		}
	}
	
	/**
	 * @param codigoOficina
	 * @param ciudad
	 * @param telefono
	 * @param direccion1
	 * @param direccion2
	 * @param estado
	 * @param pais
	 * @param codigoPostal
	 * @param territorio
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Integer actualizarOficina(String codigoOficina, String ciudad, String telefono, String direccion1, String direccion2, String estado, String pais, String codigoPostal, String territorio) throws ClassNotFoundException, SQLException{
		
		String query = "UPDATE offices SET city = CASE WHEN ? = '' THEN city ELSE ? END,"
				+ "phone = CASE WHEN ? = '' THEN phone ELSE ? END,"
				+ "addressLine1 = CASE WHEN ? = '' THEN addressLine1 ELSE ? END,"
				+ "addressLine2 = CASE WHEN ? = '' THEN addressLine2 ELSE ? END,"
				+ "state = CASE WHEN ? = '' THEN state ELSE ? END,"
				+ "country = CASE WHEN ? = '' THEN country ELSE ? END,"
				+ "postalCode = CASE WHEN ? = '' THEN postalCode ELSE ? END,"
				+ "territory = CASE WHEN ? = '' THEN territory ELSE ? END "
				+ "WHERE officeCode = ?";
		
		try(Connection conexionBD = DBUtils.conexionBBDD();
				PreparedStatement ps = conexionBD.prepareStatement(query);){
			
			ps.setString(1, ciudad);
			ps.setString(2, ciudad);
			
			ps.setString(3, telefono);
			ps.setString(4, telefono);
			
			ps.setString(5, direccion1);
			ps.setString(6, direccion1);
			
			ps.setString(7, direccion2);
			ps.setString(8, direccion2);
			
			ps.setString(9, estado);
			ps.setString(10, estado);
			
			ps.setString(11, pais);
			ps.setString(12, pais);
			
			ps.setString(13, codigoPostal);
			ps.setString(14, codigoPostal);
			
			ps.setString(15, territorio);
			ps.setString(16, territorio);
			
			ps.setString(17,codigoOficina);
		
			return ps.executeUpdate();
		}
	}
}
