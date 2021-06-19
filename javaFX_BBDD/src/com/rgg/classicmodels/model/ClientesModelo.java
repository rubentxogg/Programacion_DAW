package com.rgg.classicmodels.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rgg.classicmodels.dtos.ClienteDTO;
import com.rgg.classicmodels.utils.DBUtils;

public class ClientesModelo {
	
	/**
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<ClienteDTO> recuperaNombreTelefonoTodosClientes() throws ClassNotFoundException, SQLException{
		
		try(Connection conexionBD = DBUtils.conexionBBDD();
				Statement statement = conexionBD.createStatement();){
			ResultSet clientesRS = statement.executeQuery("SELECT * FROM customers");
			
			List<ClienteDTO> listaClientes = new ArrayList<>();
			
			while(clientesRS.next()) {
				ClienteDTO cliente = new ClienteDTO(clientesRS.getInt("customerNumber"), clientesRS.getString("customerName"), clientesRS.getString("phone"));
				listaClientes.add(cliente);
			}
			return listaClientes;
		}
	}
	
	/**
	 * @param nombre
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<ClienteDTO> recuperaNombreTelefonoFiltraporNombre(String nombre) throws ClassNotFoundException, SQLException{
		String query = "SELECT * FROM customers where customerName LIKE ?";
		
		try(Connection conexionBD = DBUtils.conexionBBDD();
				PreparedStatement ps = conexionBD.prepareStatement(query);){
			
			ps.setString(1, "%"+nombre+"%");
			ResultSet clientesRS = ps.executeQuery();
			List<ClienteDTO> listaClientes = new ArrayList<>();
			
			while(clientesRS.next()) {
				ClienteDTO cliente = new ClienteDTO(clientesRS.getInt("customerNumber"), clientesRS.getString("customerName"), clientesRS.getString("phone"));
				listaClientes.add(cliente);
			}
			return listaClientes;
		}
	}
	
	/**
	 * @param nombre
	 * @param tfno
	 * @param pais
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<ClienteDTO> recuperaNombreTelefonoFiltraporNombreTfnoPais(String nombre, String tfno, String pais) throws ClassNotFoundException, SQLException{
		String query = "SELECT * FROM customers where customerName LIKE ? AND phone LIKE ? AND country LIKE ?";
		
		try(Connection conexionBD = DBUtils.conexionBBDD();
				PreparedStatement ps = conexionBD.prepareStatement(query);){
			
			ps.setString(1, "%"+nombre+"%");
			ps.setString(2, "%"+tfno+"%");
			ps.setString(3, "%"+pais+"%");
			
			ResultSet clientesRS = ps.executeQuery();
			List<ClienteDTO> listaClientes = new ArrayList<>();
			
			while(clientesRS.next()) {
				ClienteDTO cliente = new ClienteDTO(clientesRS.getInt("customerNumber"), clientesRS.getString("customerName"), clientesRS.getString("phone"));
				listaClientes.add(cliente);
			}
			return listaClientes;
		}
	}
	
	/**
	 * @param numerocliente
	 * @param nombreCliente
	 * @param apellidoContacto
	 * @param nombreContacto
	 * @param telefono
	 * @param direccion1
	 * @param direccion2
	 * @param ciudad
	 * @param estado
	 * @param codigoPostal
	 * @param pais
	 * @param representante
	 * @param credito
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Integer insertarCliente(int numerocliente, String nombreCliente, String apellidoContacto, String nombreContacto,
			String telefono, String direccion1, String direccion2, String ciudad, String estado,
			String codigoPostal, String pais, int representante, Double credito) throws ClassNotFoundException, SQLException{
		
		String query = "INSERT INTO customers (customerNumber, customerName, contactLastName, contactFirstName, phone, addressline1,"
				+ " addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try(Connection conexionBD = DBUtils.conexionBBDD();
				PreparedStatement ps = conexionBD.prepareStatement(query);){
			
			ps.setInt(1, numerocliente);
			ps.setString(2, nombreCliente);
			ps.setString(3, apellidoContacto);
			ps.setString(4, nombreContacto);
			ps.setString(5, telefono);
			ps.setString(6, direccion1);
			ps.setString(7, direccion2);
			ps.setString(8, ciudad);
			ps.setString(9, estado);
			ps.setString(10, codigoPostal);
			ps.setString(11, pais);
			ps.setInt(12, representante);
			ps.setDouble(13, credito);
			
			return ps.executeUpdate();
		}
	}
	
	/**
	 * @param numerocliente
	 * @param nombreCliente
	 * @param apellidoContacto
	 * @param nombreContacto
	 * @param telefono
	 * @param direccion1
	 * @param direccion2
	 * @param ciudad
	 * @param estado
	 * @param codigoPostal
	 * @param pais
	 * @param representante
	 * @param credito
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Integer actualizarCliente(int numerocliente, String nombreCliente, String apellidoContacto, String nombreContacto,
			String telefono, String direccion1, String direccion2, String ciudad, String estado,
			String codigoPostal, String pais, int representante, Double credito) throws ClassNotFoundException, SQLException {
		
		String query = "UPDATE customers SET customerName = CASE WHEN ? = '' THEN customerName ELSE ? END,"
				+ "contactLastName = CASE WHEN ? = '' THEN contactLastName ELSE ? END,"
				+ "contactFirstName = CASE WHEN ? = '' THEN contactFirstName ELSE ? END,"
				+ "phone = CASE WHEN ? = '' THEN phone ELSE ? END,"
				+ "addressLine1 = CASE WHEN ? = '' THEN addressLine1 ELSE ? END,"
				+ "addressLine2 = CASE WHEN ? = '' THEN addressLine2 ELSE ? END,"
				+ "city = CASE WHEN ? = '' THEN city ELSE ? END,"
				+ "state = CASE WHEN ? = '' THEN state ELSE ? END,"
				+ "postalCode = CASE WHEN ? = '' THEN postalCode ELSE ? END,"
				+ "country = CASE WHEN ? = '' THEN country ELSE ? END,"
				+ "salesRepEmployeeNumber = CASE WHEN ? = '' THEN salesRepEmployeeNumber ELSE ? END,"
				+ "creditLimit = CASE WHEN ? = '' THEN creditLimit ELSE ? END "
				+ "WHERE customerNumber = ?";
		
		Integer resultado = null;
		
		try(Connection conexionBD = DBUtils.conexionBBDD();
				PreparedStatement ps = conexionBD.prepareStatement(query);){
			
			ps.setString(1, nombreCliente);
			ps.setString(2, nombreCliente);
			
			ps.setString(3, apellidoContacto);
			ps.setString(4, apellidoContacto);
			
			ps.setString(5, nombreContacto);
			ps.setString(6, nombreContacto);
			
			ps.setString(7, telefono);
			ps.setString(8, telefono);
			
			ps.setString(9, direccion1);
			ps.setString(10, direccion1);
			
			ps.setString(11, direccion2);
			ps.setString(12, direccion2);
			
			ps.setString(13, ciudad);
			ps.setString(14, ciudad);
			
			ps.setString(15, estado);
			ps.setString(16, estado);
			
			ps.setString(17, codigoPostal);
			ps.setString(18, codigoPostal);
			
			ps.setString(19, pais);
			ps.setString(20, pais);
			
			ps.setInt(21, representante);
			ps.setInt(22, representante);
			
			ps.setDouble(23, credito);
			ps.setDouble(24, credito);
			
			ps.setInt(25, numerocliente);
			
			resultado = ps.executeUpdate();
		}
		return resultado;
	}
	
	/**
	 * @param customerNumber
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Integer borrarCliente(int customerNumber) throws ClassNotFoundException, SQLException{
		String sql = "DELETE FROM customers WHERE customerNumber = ?";
		
		try(Connection conexionBD = DBUtils.conexionBBDD();
				PreparedStatement ps = conexionBD.prepareStatement(sql);){
			
			ps.setInt(1, customerNumber);
			
			Integer resultado = ps.executeUpdate();
			return resultado;
		}
	}
}
